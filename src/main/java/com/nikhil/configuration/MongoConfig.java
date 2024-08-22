package com.nikhil.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories("com.nikhil")
public class MongoConfig extends AbstractReactiveMongoConfiguration {
    @Value("${mongo.databaseName}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Bean
    public MongoClient getMongoClient(@Value("${mongo.connectionUrl}") String mongoConnectionUrl) {
        return MongoClients.create(mongoConnectionUrl);
    }

    @Bean
    public ReactiveMongoTemplate getReactiveMongoTemplate(MongoClient mongoClient) {
        return new ReactiveMongoTemplate(mongoClient, databaseName);
    }
}
