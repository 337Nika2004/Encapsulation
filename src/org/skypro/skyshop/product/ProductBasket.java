package org.skypro.skyshop.product;


import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    // Добавление продукта в корзину
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    // Удаление продукта по имени
    public void removeProduct(String productName) {
        products.remove(productName);
    }

    // Получение списка продуктов по имени
    public List<Product> getProductsByName(String productName) {
        return products.getOrDefault(productName, Collections.emptyList());
    }

    // Вывод содержимого корзины
    public void printBasket() {
        int specialCount = 0;
        double total = 0;

        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product);
                total += product.getPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }
}