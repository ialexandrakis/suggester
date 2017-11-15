package org.fuzzypattern.suggester;

import org.fuzzypattern.suggester.domain.model.VisitAction;
import org.fuzzypattern.suggester.repository.VisitActionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuggesterApplicationTests {

	@Autowired
    Loader loader;

	@Autowired
    VisitActionRepository visitActionRepository;

	@Test
	public void contextLoads() {
	    loader.persist(
	            Collections.singletonList(
	                    new VisitAction("uid", LocalDateTime.of(2017, 12, 31, 23, 59))
                            .setReferrer("refer")
                )
        );
		Collection<VisitAction> visitActions = visitActionRepository.findByKey("referrer", "refer");

        assert visitActions.size() == 1;
        assert visitActions.iterator().next().getReferrer().equalsIgnoreCase("refer");
	}

}
