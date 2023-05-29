package com.training.sgorodecki.homework.homework23.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.training.sgorodecki.homework.homework23.config",
        "com.training.sgorodecki.homework.homework23.dao",
        "com.training.sgorodecki.homework.homework23.services",
        "com.training.sgorodecki.homework.homework23.converters"
})
public class AppConfiguration {
}
