package org.fuzzypattern.suggester.domain.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@EqualsAndHashCode
@ToString
public class User {

    @Id
    private final String uuid;
    private final LocalDateTime joinDate;
    private String country;
    private String language;

    public User(String uuid, LocalDateTime joinDate) {
        Assert.hasText(uuid, "user identifier must not be null");

        this.uuid = uuid;
        this.joinDate = joinDate;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public User setLanguage(String language) {
        this.language = language;
        return this;
    }
}
