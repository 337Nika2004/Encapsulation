package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        Product product1 = new Product("Яблоки", 100);
        Product product2 = new Product("Хлеб", 50);
        Product product3 = new Product("Молоко", 80);
        Product product4 = new Product("Мясо", 300);
        Product product5 = new Product("Рыба", 250);
        Product product6 = new Product("Сок", 120);

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

        // Получение стоимости корзины
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        // Поиск товара в корзине
        System.out.println("Есть ли 'Молоко' в корзине? " + basket.containsProduct("Молоко"));
        System.out.println("Есть ли 'Чай' в корзине? " + basket.containsProduct("Чай"));

        // Очистка корзины
        basket.clearBasket();

        // Печать пустой корзины
        basket.printBasket();
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalPrice());
        System.out.println("Есть ли 'Молоко' в пустой корзине? " + basket.containsProduct("Молоко"));
    }
}