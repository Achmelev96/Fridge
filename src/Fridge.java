import java.util.*;

public class Fridge {
    private Map<String, Integer> products = new HashMap<>();

    public void addProduct(String product, int weight) {
        if (products.containsKey(product)) {
            int currentWeight = products.get(product);
            products.put(product, currentWeight + weight);
        } else {
            products.put(product, weight);
        }
    }

    public void takeProduct(String product, int weight) {
        if (!products.containsKey(product)) {
            System.out.println("Такого продукта нет в холодильнике");
            return;
        }

        if (products.get(product) > weight) {
            System.out.println("Было: " + product + " - " + products.get(product));
            products.put(product, products.get(product) - weight);
            System.out.println("Стало: " + product + " - " + products.get(product));
        } else if (products.get(product) == weight){
            System.out.println("Взял " + product + " - " + products.get(product) + " и он закончился");
            products.remove(product);
        } else {
            System.out.println("Я смог взять только " + product + " - " + products.get(product) + ". Больше не было");
            products.remove(product);
        }
    }

    public void printAllProductsByNameFromZtoA() {
        Set<String> productsNames = new TreeSet<>(Comparator.reverseOrder());
        productsNames.addAll(products.keySet());
        productsNames.forEach(productName -> {
            System.out.println(productName + " - " + products.get(productName));
        });
    }

    public void printAllProductsByWightFromMaxToMin() {
        List<Map.Entry<String, Integer>> productsList = new ArrayList<>(products.entrySet());
        productsList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : productsList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void printTotalWeight() {
        int totalWeight = 0;
        for (String product : products.keySet()) {
            totalWeight += products.get(product);
        }
        System.out.println("Общий вес продуктов в холодильнике - " + totalWeight);
    }

    public void printWight(String productName) {
        if (products.containsKey(productName)) {
            System.out.println(productName + " - " + products.get(productName));
        } else {
            System.out.println("Такого в холодильнике нет");
        }
    }

    public String printProductWithMinWeight() {
        int minWeight = Integer.MAX_VALUE;
        String productName = "";

        if  (products.isEmpty()) {
            return "Пусто";
        }

        for (String product : products.keySet()) {
            if  (products.get(product) < minWeight) {
                minWeight = products.get(product);
                productName = product;
            }
        }
        return productName;
    }

    public String printProductWithMaxWeight() {
        int maxWeight = Integer.MIN_VALUE;
        String productName = "";

        if  (products.isEmpty()) {
            return "Пусто";
        }

        for (String product : products.keySet()) {
            if  (products.get(product) > maxWeight) {
                maxWeight = products.get(product);
                productName = product;
            }
        }
        return productName;
    }
}
