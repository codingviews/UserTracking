package com.codingviews.usertracking;

import com.codingviews.usertracking.enums.Color;
import com.codingviews.usertracking.enums.DesignType;
import com.codingviews.usertracking.enums.ProductType;
import com.codingviews.usertracking.enums.UserId;
import com.codingviews.usertracking.model.Event;
import com.codingviews.usertracking.model.Product;
import com.codingviews.usertracking.model.User;
import com.github.javafaker.Faker;

public class EventGenerator {
    private final Faker faker = new Faker();

    public Event generateEvent() {
        return new Event.Builder()
                .user(generateRandomUser())
                .product(generateRandomProduct())
                .build();
    }

    private User generateRandomUser() {
        return new User.Builder()
                .userId(faker.options().option(UserId.class))
                .userName(faker.name().lastName())
                .dateOfBirth(faker.date().birthday())
                .build();
    }

    private Product generateRandomProduct() {
        return new Product.Builder()
                .color(faker.options().option(Color.class))
                .productType(faker.options().option(ProductType.class))
                .designType(faker.options().option(DesignType.class))
                .build();
    }
}
