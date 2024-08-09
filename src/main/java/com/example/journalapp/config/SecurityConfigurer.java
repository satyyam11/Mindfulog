package com.example.journalapp.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface SecurityConfigurer<T> {
    abstract void configure(HttpSecurity http) throws Exception;
}
