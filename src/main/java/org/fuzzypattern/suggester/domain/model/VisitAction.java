package org.fuzzypattern.suggester.domain.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VisitAction extends AbstractAction {
    private String referrer;

    public VisitAction(String uid, LocalDateTime actionDate) {
        super(uid, actionDate);
    }

    public String getReferrer() {
        return referrer;
    }

    public VisitAction setReferrer(String referrer) {
        this.referrer = referrer;
        return this;
    }
}
