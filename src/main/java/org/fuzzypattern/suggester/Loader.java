package org.fuzzypattern.suggester;

import org.fuzzypattern.suggester.domain.model.VisitAction;
import org.fuzzypattern.suggester.repository.VisitActionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Loader {
    private static final Logger LOG = LoggerFactory.getLogger(Loader.class);

    private final VisitActionRepository actionRepository;

    @Autowired
    public Loader(VisitActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    void persist(Collection<VisitAction> archiveActions) {
        final long start = System.currentTimeMillis();
        actionRepository.save(archiveActions);
        LOG.info("archive complete. Time: {} ms", (System.currentTimeMillis() - start));
    }
}
