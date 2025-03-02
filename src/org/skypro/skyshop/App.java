package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        Product product1 = new SimpleProduct("Яблоки", 100);
        Product product2 = new SimpleProduct("Хлеб", 50);
        Product product3 = new DiscountedProduct("Молоко", 80, 20);
        Product product4 = new DiscountedProduct("Мясо", 300, 10);
        Product product5 = new FixPriceProduct("Рыба");
        Product product6 = new FixPriceProduct("Сок");

        // Создаем статьи
        Article article1 = new Article("Как выбрать свежие яблоки", "Свежие яблоки должны быть твердыми и без повреждений.");
        Article article2 = new Article("Полезные свойства молока", "Молоко содержит кальций, который полезен для костей.");

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        // Попытка добавить продукт в заполненную корзину
        basket.addProduct(product6);

        // Печать содержимого корзины
        basket.printBasket();

        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Демонстрация поиска
        System.out.println("Результаты поиска по слову 'Молоко':");
        for (Searchable result : searchEngine.search("Молоко")) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
}