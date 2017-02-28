package com.khimin.shop;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Created by nazar on 07.02.17.
 */
@Configuration
@EnableSpringDataWebSupport
@EnableMongoRepositories
class ApplicationConfig extends AbstractMongoConfiguration {

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}

	@Override
	protected String getDatabaseName() {
		return "mongo-shop";
	}
}