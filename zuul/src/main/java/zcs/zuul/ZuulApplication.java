package zcs.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
//    @Bean
//    public AccessFilter accessFilter() {
//        return new AccessFilter();
//    }

    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

  /*  @Bean
    protected JwtAccessTokenConverter jwtTokenConverter(){

        Resource resource = new ClassPathResource("public.txt");
        String publicKey;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JwtAccessTokenConverter converter = new CustomJwtAccessTokenConverter();
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtTokenConverter());
    }*/
}
