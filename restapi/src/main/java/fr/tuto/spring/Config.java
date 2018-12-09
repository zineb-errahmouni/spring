package fr.tuto.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"fr.tuto.spring"})
public class Config {

    @Autowired
    private ServletContext ctx;
}
