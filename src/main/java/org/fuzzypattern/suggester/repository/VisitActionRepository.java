package org.fuzzypattern.suggester.repository;

import org.fuzzypattern.suggester.domain.model.VisitAction;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface VisitActionRepository extends CrudRepository<VisitAction, String> {
    @Query("{ ?0 : ?1 }")
    Collection<VisitAction> findByKey(String key, String value);
}
