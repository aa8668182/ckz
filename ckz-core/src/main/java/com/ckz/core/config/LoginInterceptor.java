package com.ckz.core.config;

import com.ckz.core.annotation.IgnoreUserToken;
import com.ckz.core.exception.TokenNullException;
import com.ckz.core.utils.BaseContextHandler;
import com.ckz.core.utils.IJWTInfo;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: caikaizhen
 * @date: 2019/2/18 17:06
 * @Description:
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private JwtConfig jwtConfig;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 配置该注解，说明不进行用户拦截
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        IgnoreUserToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
        if (annotation == null) {
            annotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
        }
        if(annotation != null) {
            return super.preHandle(request, response, handler);
        }
        String token = request.getHeader(jwtConfig.getTokenHeader());
        if(StringUtils.isBlank(token)){
            throw new TokenNullException();
        }
        IJWTInfo infoFromToken = null;
        try {
            infoFromToken = jwtTokenUtil.getInfoFromToken(token);
        } catch (ExpiredJwtException e) {
            throw new TokenNullException();
        }
        BaseContextHandler.setLoginAccount(infoFromToken.getUniqueName());
        BaseContextHandler.setLoginName(infoFromToken.getName());
        BaseContextHandler.setToken(token);
        BaseContextHandler.setAppId(infoFromToken.getAppId());
        BaseContextHandler.setUserID(infoFromToken.getId());
        return super.preHandle(request, response, handler);
        }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }


}

