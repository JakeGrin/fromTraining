package com.training.sgorodecki.homework.homework20.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.training.sgorodecki.homework.homework20.config",
        "com.training.sgorodecki.homework.homework20.dao",
        "com.training.sgorodecki.homework.homework20.services",
        "com.training.sgorodecki.homework.homework20.util"})
public class AppConfiguration {
}
