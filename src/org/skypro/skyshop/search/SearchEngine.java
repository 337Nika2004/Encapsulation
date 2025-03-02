package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int size = 0;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size >= items.length) {
            System.out.println("Невозможно добавить элемент, массив заполнен");
            return;
        }
        items[size++] = item;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getSearchTerm().contains(query)) {
                results[count++] = items[i];
                if (count == 5) break;
            }
        }
        return results;
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;
        for (int i = 0; i < size; i++) {
            int occurrences = items[i].getSearchTerm().split(query, -1).length - 1;
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = items[i];
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найден лучший результат для запроса: " + query);
        }
        return bestMatch;
    }
}