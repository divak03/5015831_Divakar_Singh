package AlgorthmsDataStructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ECommercePlatformSearchFunction {

    // Product class definition
    static class Product {
        private String productId;
        private String productName;
        private String category;

        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
        }
    }

    // Search class definition
    static class Search {
        public static Product linearSearch(Product[] products, String targetName) {
            for (Product product : products) {
                if (product.getProductName().equalsIgnoreCase(targetName)) {
                    return product;
                }
            }
            return null;
        }

        public static Product binarySearch(Product[] products, String targetName) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int result = targetName.compareToIgnoreCase(products[mid].getProductName());

                if (result == 0) {
                    return products[mid];
                } else if (result > 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null;
        }
    }

    // Main class definition
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Tablet", "Electronics"),
            new Product("P004", "Headphones", "Accessories"),
            new Product("P005", "Smartwatch", "Accessories")
        };

        // Sorting products array by product name for binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        Scanner scanner = new Scanner(System.in);
        boolean continueSearching = true;

        while (continueSearching) {
            System.out.println("\nE-commerce Platform Search Menu");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name to search: ");
                    String linearSearchTerm = scanner.nextLine();
                    Product linearResult = Search.linearSearch(products, linearSearchTerm);
                    System.out.println("Linear Search - Found Product: " + (linearResult != null ? linearResult : "Not Found"));
                    break;
                case 2:
                    System.out.print("Enter product name to search: ");
                    String binarySearchTerm = scanner.nextLine();
                    Product binaryResult = Search.binarySearch(products, binarySearchTerm);
                    System.out.println("Binary Search - Found Product: " + (binaryResult != null ? binaryResult : "Not Found"));
                    break;
                case 3:
                    continueSearching = false;
                    System.out.println("Exiting the search menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
