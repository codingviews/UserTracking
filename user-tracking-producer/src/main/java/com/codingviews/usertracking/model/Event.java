package com.codingviews.usertracking.model;

import java.util.Objects;

public class Event {
    private final User user;
    private final Product product;

    public Event(Builder builder) {
        this.user = builder.user;
        this.product = builder.product;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public static class Builder {
        private User user;
        private Product product;

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder product(Product product) {
            this.product = product;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(user, event.user) &&
                Objects.equals(product, event.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, product);
    }

    @Override
    public String toString() {
        return "Product{" +
                "user=" + user +
                ", product=" + product +
                '}';
    }
}
