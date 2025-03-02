package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;

public class App {
    public static void main(String[] args) {
        try {
            Product product1 = new SimpleProduct("Laptop", 1000);
            Product product2 = new DiscountedProduct("Smartphone", 800, 20);
            Product product3 = new FixPriceProduct("Headphones");

            Article article1 = new Article("Tech Innovations", "The latest trends in technology.");
            Article article2 = new Article("Gadget Reviews", "Honest reviews of the newest gadgets.");

            SearchEngine searchEngine = new SearchEngine(10);
            searchEngine.add(product1);
            searchEngine.add(product2);
            searchEngine.add(product3);
            searchEngine.add(article1);
            searchEngine.add(article2);

            System.out.println("Search results for 'tech':");
            for (var result : searchEngine.search("tech")) {
                if (result != null) {
                    System.out.println(result.getStringRepresentation());
                }
            }

            try {
                System.out.println("Best match for 'gadget':");
                System.out.println(searchEngine.findBestMatch("gadget").getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Testing exception handling for invalid product data
            try {
                Product invalidProduct = new SimpleProduct(" ", -100);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid product: " + e.getMessage());
            }

            try {
                Product invalidDiscountedProduct = new DiscountedProduct("Tablet", 500, 150);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid discounted product: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
