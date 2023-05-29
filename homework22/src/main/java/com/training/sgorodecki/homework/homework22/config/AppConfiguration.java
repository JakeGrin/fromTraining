package com.training.sgorodecki.homework.homework22.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.training.sgorodecki.homework.homework22.config",
        "com.training.sgorodecki.homework.homework22.dao",
        "com.training.sgorodecki.homework.homework22.services",
        "com.training.sgorodecki.homework.homework22.converters"
})
public class AppConfiguration {
}
