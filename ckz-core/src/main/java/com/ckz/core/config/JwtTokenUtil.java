package com.ckz.core.config;

import com.ckz.core.utils.IJWTInfo;
import com.ckz.core.utils.JWTHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JwtTokenUtil {

    @Resource
    private JwtConfig jwtConfig;

    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, jwtConfig.getUserPriKey(),jwtConfig.getExpiresSecond());
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, jwtConfig.getUserPubKey());
    }
}
