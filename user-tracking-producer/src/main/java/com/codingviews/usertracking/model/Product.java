package com.codingviews.usertracking.model;

import com.codingviews.usertracking.enums.Color;
import com.codingviews.usertracking.enums.DesignType;
import com.codingviews.usertracking.enums.ProductType;

import java.util.Objects;

public class Product {
    private final Color color;
    private final ProductType productType;
    private final DesignType designType;

    public Product(Color color, ProductType productType, DesignType designType) {
        this.color = color;
        this.productType = productType;
        this.designType = designType;
    }

    public Color getColor() {
        return color;
    }

    public ProductType getProductType() {
        return productType;
    }

    public DesignType getDesignType() {
        return designType;
    }

    public static class Builder {
        private Color color;
        private ProductType productType;
        private DesignType designType;

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Builder productType(ProductType productType) {
            this.productType = productType;
            return this;
        }

        public Builder designType(DesignType designType) {
            this.designType = designType;
            return this;
        }

        public Product build() {
            return new Product(this.color, this.productType, this.designType);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return color == product.color &&
                productType == product.productType &&
                designType == product.designType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, productType, designType);
    }

    @Override
    public String toString() {
        return "Product{" +
                "color=" + color +
                ", productType=" + productType +
                ", designType=" + designType +
                '}';
    }
}
