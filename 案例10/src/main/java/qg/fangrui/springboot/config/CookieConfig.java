package qg.fangrui.springboot.config;

import org.apache.catalina.Context;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zggdczfr on 2017/3/5.
 */
@Configuration
public class CookieConfig {

    @Bean
    public EmbeddedServletContainerCustomizer customizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
                tomcat.addContextCustomizers(
                        new TomcatContextCustomizer() {
                            @Override
                            public void customize(Context context) {
                                context.setCookieProcessor(new LegacyCookieProcessor());
                            }
                        });
            }
        };
    }
}
