package org.fuzzypattern.suggester;

import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.fuzzypattern.suggester.domain.model.User;
import org.fuzzypattern.suggester.repository.UserRepository;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb.InMemoryMongoRuleBuilder.newInMemoryMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbConfigurationBuilder.mongoDb;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
    @ClassRule
    public static final InMemoryMongoDb IN_MEMORY_MONGO_DB = newInMemoryMongoDbRule().build();

    @Rule
    public MongoDbRule remoteMongoDbRule = new MongoDbRule(mongoDb().databaseName(MongoConfig.DB_NAME).build());

    @Autowired
    Loader loader;

    @Autowired
    UserRepository userRepository;

    @Test
    @UsingDataSet(locations = "/initialData.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    @ShouldMatchDataSet(location = "/expectedData.json")
    public void contextLoads() {
        User u = userRepository.findOne("uuid").setCountry("country");
        userRepository.save(u);
    }
}
