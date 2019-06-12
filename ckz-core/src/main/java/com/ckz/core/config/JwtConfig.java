package com.ckz.core.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * @author: caikaizhen
 * @date: 2019/2/19 9:58
 * @Description:
 */
@Data
@Validated
@NoArgsConstructor
@ConfigurationProperties(JwtConfig.PREFIX)
@Component
public class JwtConfig {
    public static final String PREFIX = "jwtconfig";

    @NotNull
    private String base64Secret;
    @NotNull
    private Integer expiresSecond;
    @NotNull
    private String tokenHeader;

//    用户公钥
    private byte[] userPubKey;
//    用户私钥
    private byte[] userPriKey;


    public String getToken(HttpServletRequest request){
        return request.getHeader(this.getTokenHeader());
    }

}
