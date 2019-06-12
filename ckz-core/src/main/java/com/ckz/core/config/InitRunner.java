package com.ckz.core.config;

/**
 * @author: caikaizhen
 * @date: 2019/2/20 17:25
 * @Description:
 */

import com.ckz.core.utils.RsaKeyHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Map;


@Configuration
public class InitRunner implements CommandLineRunner {

    @Resource
    private JwtConfig jwtConfig;

    @Override
    public void run(String... args) throws Exception {
            Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(jwtConfig.getBase64Secret());
            jwtConfig.setUserPriKey(keyMap.get("pri"));
            jwtConfig.setUserPubKey(keyMap.get("pub"));
    }
}
