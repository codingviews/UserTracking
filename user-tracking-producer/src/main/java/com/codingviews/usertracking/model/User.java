package com.codingviews.usertracking.model;

import com.codingviews.usertracking.enums.UserId;

import java.util.Date;
import java.util.Objects;

public class User {
    private final UserId userId;
    private final String userName;
    private final Date dateOfBirth;

    public User(UserId userId, String userName, Date dateOfBirth) {
        this.userId = userId;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public static class Builder {
        private UserId userId;
        private String userName;
        private Date dateOfBirth;

        public Builder userId(UserId userId) {
            this.userId = userId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public User build() {
            return new User(this.userId, this.userName, this.dateOfBirth);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(dateOfBirth, user.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, dateOfBirth);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
