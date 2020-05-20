package com.codingviews.usertracking.model;

import com.codingviews.usertracking.enums.UserId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private final UserId userId;
    private final List<PreferredProduct> preferences;
    private final List<String> suggestions;

    public User(UserId userId, List<PreferredProduct> preferences, List<String> suggestions) {
        this.userId = userId;
        this.preferences = preferences;
        this.suggestions = suggestions;
    }

    public User(UserId userId) {
        this(userId, new ArrayList<>(), new ArrayList<>());
    }

    public UserId getUserId() {
        return userId;
    }

    public List<PreferredProduct> getPreferences() {
        return preferences;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(preferences, user.preferences) &&
                Objects.equals(suggestions, user.suggestions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, preferences, suggestions);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", preferences=" + preferences +
                ", suggestions=" + suggestions +
                '}';
    }
}
