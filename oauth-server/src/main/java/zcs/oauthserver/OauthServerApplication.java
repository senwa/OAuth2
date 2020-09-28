package zcs.oauthserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@MapperScan("zcs.oauthserver.mapper")
public class OauthServerApplication {
//
    //https://blog.csdn.net/qq_30299977/article/details/102506018
    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class, args);
    }

}
