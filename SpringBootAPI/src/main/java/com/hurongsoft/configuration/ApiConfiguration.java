package com.hurongsoft.configuration;

import com.hurongsoft.configuration.properties.AnbangProperties;
import com.hurongsoft.configuration.properties.QianruiProperties;
import com.hurongsoft.configuration.properties.ShortUrlProperties;
import com.hurongsoft.configuration.properties.YanyouProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableConfigurationProperties(value = {QianruiProperties.class,
        AnbangProperties.class, YanyouProperties.class, ShortUrlProperties.class})
public class ApiConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 设置默认首页
     *
     * @param registry viewControllerRegistry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
