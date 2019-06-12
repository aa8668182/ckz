package com.ningpai.common.util.wxap.util;


import com.ningpai.common.util.wxap.WxConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wj on 2016/7/25.
 */
@Slf4j
public class Wxtixian {
    public static Map getresultMap(String url,String xmlParam) throws Exception{
        //CA证书
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
//        String filepath= PathUtil.getClasspath()+"certificate/apiclient_cert.p12";
        //生产
        String filepath= "/data/certs/wechat/apiclient_cert.p12";
        //测试
//        String filepath= "F:\\testcert\\yigou\\apiclient_cert.p12";
        FileInputStream instream = new FileInputStream(new File(filepath));
        try {
            keyStore.load(instream, WxConfig.mchid.toCharArray());
        } finally {
            instream.close();
        }

        SSLContext sslcontext= SSLContexts.custom().loadKeyMaterial(keyStore,WxConfig.mchid.toCharArray()).build();
        SSLConnectionSocketFactory sslsf=new SSLConnectionSocketFactory(sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

            CloseableHttpClient httpclient= HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try{
            HttpPost httpost= new HttpPost(url);
            httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
            HttpResponse response = httpclient.execute(httpost);
            String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");

            if(jsonStr.indexOf("FAIL")!=-1){
                log.info("提现返回的结果------" + jsonStr);
                return null;
            }
            Map map = doXMLParse(jsonStr);
            return  map;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error("1、解析出错？ ----"+e.getMessage());
            return null;
        }finally {
            httpclient.close();
        }
    }
    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     * @param strxml
     * @return
     * @throws Exception
     */
    public static Map doXMLParse(String strxml) throws Exception {
        if(null == strxml || "".equals(strxml)) {
            return null;
        }

        Map m = new HashMap();
        InputStream in = String2Inputstream(strxml);
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if(children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = getChildrenText(children);
            }

            m.put(k, v);
        }

        //关闭流
        in.close();

        return m;
    }
    /**
     * 获取子结点的xml
     * @param children
     * @return String
     */
    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()) {
            Iterator it = children.iterator();
            while(it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }
    public static InputStream String2Inputstream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }
}
