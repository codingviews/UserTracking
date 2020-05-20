package com.codingviews.usertracking;

import com.codingviews.usertracking.model.PreferredProduct;
import com.codingviews.usertracking.model.User;
import com.codingviews.usertracking.service.UserDB;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class SuggestionEngine {
    private static final Logger log = LoggerFactory.getLogger(SuggestionEngine.class);

    private final UserDB userDB = new UserDB();

    public void processSuggestions(String userId, String product) {
        String[] valueSplit = product.split(",");
        String productType = valueSplit[0];
        String productColor = valueSplit[1];
        String productDesign = valueSplit[2];

        log.info("User with ID: " + userId +
                " showed interest over " + productType + " " +
                "of color " + productColor + " and design " + productDesign);

        // Retrieve preferences from Database
        User user = userDB.findByID(userId);

        // Update user preferences
        List<PreferredProduct> preferredProducts = user.getPreferences();
        preferredProducts.add(new PreferredProduct(productColor, productType, productDesign));

        // Generate list of suggestions
        List<String> suggestions = generateSugestions(preferredProducts);

        // Store the suggestions in the database / send them to a kafka topic
        User userToSave = new User(user.getUserId(), preferredProducts, suggestions);
        userDB.save(userToSave);
    }

    /**
     * @return hardcoded suggestions
     */
    private List<String> generateSugestions(List<PreferredProduct> preferences) {
        return Arrays.asList("TSHIRT,BLUE",
                "DESIGN,ORANGE,ROCKET",
                "TSHIRT,PURPLE,CAR");
    }
}
