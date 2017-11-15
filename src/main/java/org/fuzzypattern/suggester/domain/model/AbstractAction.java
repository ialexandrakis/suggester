package org.fuzzypattern.suggester.domain.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@EqualsAndHashCode
@ToString
public abstract class AbstractAction {
    @Id
    private ObjectId id;

    @Indexed
    private final String uid;

    private final LocalDateTime actionDate;

    AbstractAction(String uid, LocalDateTime actionDate) {
        this.uid = uid;
        this.actionDate = actionDate;
    }

    public AbstractAction setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public ObjectId getId() {

        return id;
    }

    public String getUid() {
        return uid;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }
}
