package org.fuzzypattern.suggester;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = "org.fuzzypattern.suggester.repository")
public class MongoConfig extends AbstractMongoConfiguration {
    static final String DB_NAME = "suggester";
    private final List<Converter<?, ?>> converters = new ArrayList<>();

    @Bean
    public MongoClient mongoClient() throws Exception {
        return new MongoClient("localhost");
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTypeMapper typeMapper = new DefaultMongoTypeMapper(null);
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), new MongoMappingContext());
        converter.setTypeMapper(typeMapper);
        converter.setCustomConversions(customConversions());
        converter.afterPropertiesSet(); // needed to register the custom converters

        return new MongoTemplate(mongoDbFactory(), converter);
    }

    @Override
    protected String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return mongoClient();
    }

    @Override
    public CustomConversions customConversions() {
        converters.addAll(Jsr310Converters.getConvertersToRegister());
        return new CustomConversions(converters);
    }
}
