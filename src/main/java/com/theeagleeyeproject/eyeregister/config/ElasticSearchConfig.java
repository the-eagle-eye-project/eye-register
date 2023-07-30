package com.theeagleeyeproject.eyeregister.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchAuditing
@EnableElasticsearchRepositories(basePackages = "com.theeagleeyeproject.eyeregister")
public class ElasticSearchConfig {

}
