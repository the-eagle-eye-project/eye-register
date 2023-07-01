package com.theeagleeyeproject.eyeregister.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * {@code EyeRegisterApplicationConfig} this configuration class is used to load all the application properties necessary
 * to ensure the application's boot up process.
 *
 * @author John Robert Martinez Ponce
 */
@Configuration
@Import(ApplicationObjectMapper.class)
@ComponentScan(basePackages = "com.theeagleeyeproject.eyeregister")
public class EyeRegisterApplicationConfig {

    // Look at Spring profiles so that we can use some configuration while testing in local the code. However, when a
    // consumer is using the application, they should provide their own property file. The property file can be loaded
    // on app startup, or it can be package when the jar gets created, using some kind of interface.
}
