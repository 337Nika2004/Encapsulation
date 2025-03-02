package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int productCount;

    // Конструктор
    public ProductBasket() {
        this.products = new Product[5];
        this.productCount = 0;
    }

    // Метод добавления товара в корзину
    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        } else {
            System.out.println("Невозможно добавить продукт, корзина заполнена.");
        }
    }

    // Метод получения общей стоимости корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < productCount; i++) {
            totalCost += products[i].getPrice();
        }
        return totalCost;
    }

    // Метод для печати содержимого корзины
    public void printBasket() {
        int specialCount = 0;
        if (productCount == 0) {
            System.out.println("В корзине пусто.");
        } else {
            for (int i = 0; i < productCount; i++) {
                Product product = products[i];
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    // Метод для проверки наличия товара в корзине по имени
    public boolean containsProduct(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    // Метод для очистки корзины
    public void clearBasket() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null;
        }
        productCount = 0;
    }
}