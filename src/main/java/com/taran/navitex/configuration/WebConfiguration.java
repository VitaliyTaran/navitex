package com.taran.navitex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.taran.navitex.controller")
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setExposeRequestAttributes(true);
        freeMarkerViewResolver.setExposeSessionAttributes(true);
        freeMarkerViewResolver.setOrder(1);
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setPrefix("");
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "/WEB-INF/view");
        return freeMarkerConfigurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setBasename("classpath:locale/locale");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        return bundleMessageSource;
    }

    @Bean
    public LocaleChangeInterceptor localeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setCookieName("locale-cookie");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
    }

}
