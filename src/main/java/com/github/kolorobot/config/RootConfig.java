package com.github.kolorobot.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = { "com.github.kolorobot.domain" })
@Import({ PersistenceConfig.class, SecurityConfig.class })
public class RootConfig {}