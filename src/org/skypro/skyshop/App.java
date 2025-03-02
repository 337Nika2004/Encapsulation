package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

public class App {
    public static void main(String[] args) {
        try {
            // Создаем продукты с некорректными данными для проверки исключений
            Product invalidProduct = new SimpleProduct("", 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product invalidDiscounted = new DiscountedProduct("Молоко", 0, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        // Создаем несколько корректных продуктов
        Product product1 = new SimpleProduct("Яблоки", 100);
        Product product2 = new SimpleProduct("Хлеб", 50);
        Product product3 = new DiscountedProduct("Молоко", 80, 20);
        Product product4 = new DiscountedProduct("Мясо", 300, 10);
        Product product5 = new FixPriceProduct("Рыба");
        Product product6 = new FixPriceProduct("Сок");

        // Создаем статьи
        Article article1 = new Article("Полезные свойства яблок", "Яблоки содержат много витаминов.");
        Article article2 = new Article("Почему стоит есть хлеб", "Хлеб является источником углеводов.");

        // Создаем движок поиска и добавляем объекты
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Тестируем новый метод поиска
        try {
            Searchable bestMatch = searchEngine.findBestMatch("яблоки");
            System.out.println("Лучший результат поиска: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}
