package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> searchableItems = new ArrayList<>();

    // Добавление объекта для поиска
    public void add(Searchable searchable) {
        searchableItems.add(searchable);
    }

    // Поиск и возвращение отсортированной мапы
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> resultMap = new TreeMap<>(); // TreeMap для сортировки по имени

        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                resultMap.put(item.getName(), item);
                if (resultMap.size() >= 5) break; // Максимум 5 результатов
            }
        }

        return resultMap;
    }
}