package AlgorthmsDataStructures;

import java.util.Arrays;
import java.util.Scanner;

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order [ID=" + orderId + ", Customer=" + customerName + ", Total Price=" + totalPrice + "]";
    }
}

class Sorting {
    // Bubble Sort Implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Quick Sort Implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}

public class SortingCustomerOrders {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.00),
            new Order("O003", "Charlie", 300.75),
            new Order("O004", "David", 120.20),
            new Order("O005", "Eve", 500.00)
        };

        Scanner scanner = new Scanner(System.in);
        boolean continueSorting = true;

        while (continueSorting) {
            System.out.println("\nOrder Sorting Menu");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Bubble Sort
                    Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
                    Sorting.bubbleSort(bubbleSortedOrders);
                    System.out.println("Bubble Sorted Orders:");
                    for (Order order : bubbleSortedOrders) {
                        System.out.println(order);
                    }
                    break;
                case 2:
                    // Quick Sort
                    Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
                    Sorting.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
                    System.out.println("Quick Sorted Orders:");
                    for (Order order : quickSortedOrders) {
                        System.out.println(order);
                    }
                    break;
                case 3:
                    continueSorting = false;
                    System.out.println("Exiting the sorting menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
