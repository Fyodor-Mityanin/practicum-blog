package ru.yandex.practicum;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableSpringDataWebSupport
@EnableWebMvc
@ComponentScan(basePackages = "ru.yandex.practicum")
public class WebConfiguration {}
