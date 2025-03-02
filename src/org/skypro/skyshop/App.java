package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Создание корзины и добавление товаров
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Хлеб", 50));
        basket.addProduct(new DiscountedProduct("Молоко", 80, 10));
        basket.addProduct(new FixPriceProduct("Йогурт"));

        System.out.println("\n Содержимое корзины:");
        basket.printBasket();

        // Создание поискового движка
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new SimpleProduct("Хлеб", 50));
        searchEngine.add(new DiscountedProduct("Молоко", 80, 10));
        searchEngine.add(new FixPriceProduct("Йогурт"));
        searchEngine.add(new Article("Как выбрать хлеб", "Лучший хлеб – это..."));
        searchEngine.add(new Article("Польза молока", "Молоко укрепляет кости."));

        // Поиск
        System.out.println("\n Результаты поиска по запросу 'молоко':");
        Map<String, Searchable> searchResults = searchEngine.search("молоко");

        for (Map.Entry<String, Searchable> entry : searchResults.entrySet()) {
            System.out.println(entry.getValue().getStringRepresentation());
        }
    }
}
