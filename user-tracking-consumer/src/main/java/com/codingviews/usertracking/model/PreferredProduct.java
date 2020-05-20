package com.codingviews.usertracking.model;

import java.util.Objects;

public class PreferredProduct {
    private final String color;
    private final String productType;
    private final String designType;

    public PreferredProduct(String color, String productType, String designType) {
        this.color = color;
        this.productType = productType;
        this.designType = designType;
    }

    public String getColor() {
        return color;
    }

    public String getProductType() {
        return productType;
    }

    public String getDesignType() {
        return designType;
    }

    public static class Builder {
        private String color;
        private String productType;
        private String designType;

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder designType(String designType) {
            this.designType = designType;
            return this;
        }

        public PreferredProduct build() {
            return new PreferredProduct(this.color, this.productType, this.designType);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreferredProduct that = (PreferredProduct) o;
        return Objects.equals(color, that.color) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(designType, that.designType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, productType, designType);
    }

    @Override
    public String toString() {
        return "PreferredProduct{" +
                "color='" + color + '\'' +
                ", productType='" + productType + '\'' +
                ", designType='" + designType + '\'' +
                '}';
    }
}
