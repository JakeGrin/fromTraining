package com.training.sgorodecki.homework.homework21.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan({"com.training.sgorodecki.homework.homework21.controllers",
        "com.training.sgorodecki.homework.homework21.exceptionhandlers"})
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    private static final String WEB_INF_TEMPLATES = "/WEB-INF/templates/";
    private static final String HTML = ".html";
    private static final String HTML_5 = "HTML5";
    private static final String ERROR_PATH = "/error";
    private static final String ERROR = "error";

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix(WEB_INF_TEMPLATES);
        templateResolver.setSuffix(HTML);
        templateResolver.setTemplateMode(HTML_5);

        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(ERROR_PATH).setViewName(ERROR);
    }
}