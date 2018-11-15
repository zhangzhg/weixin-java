package com.hsm;

import com.WebMvcConfig;
import com.hsm.web.swaggerui.SwaggerConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@ImportResource({"classpath:/spring/app-config.xml"})
@Import({WebMvcConfig.class, SwaggerConfiguration.class})
//@PropertySource(value="file:${INNO_DE_CONFIG_PATH}/application.properties", ignoreResourceNotFound = true)
public class Application extends SpringBootServletInitializer {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .sources(WebMvcConfig.class)
                .run(args);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.sources(WebMvcConfig.class, SwaggerConfiguration.class);
        return application;
    }

    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }


    /**
     * URL 直接增加后缀 .app
     */
//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
//        registration.getUrlMappings().clear();
//        registration.addUrlMappings("*.app");
//        return registration;
//    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }

}