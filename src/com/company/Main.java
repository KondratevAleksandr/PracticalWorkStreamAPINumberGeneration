package com.company;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        Map<String, Double> totalCostByProduct = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProduct,
                        Collectors.summingDouble(Order::getCost)));

        List<Map.Entry<String, Double>> sortedProducts = totalCostByProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed()).toList();

        List<Map.Entry<String, Double>> topThreeProducts = sortedProducts.stream()
                .limit(3).toList();

        System.out.println("The three most expensive products and their total cost");
        for (Map.Entry<String, Double> entry : topThreeProducts) {
            System.out.println("Product: " + entry.getKey() + ". Total cost: " + entry.getValue());
        }

    }
}
