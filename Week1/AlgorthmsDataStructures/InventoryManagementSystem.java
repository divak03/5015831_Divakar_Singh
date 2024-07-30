package AlgorthmsDataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName +
               ", quantity=" + quantity + ", price=" + price + "]";
    }
}

public class InventoryManagementSystem {
    private static Map<String, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        Product product = new Product(productId, productName, quantity, price);
        inventory.put(productId, product);
        System.out.println("Product added successfully.");
    }

    public static void updateProduct(Scanner scanner) {
        System.out.print("Enter Product ID to update: ");
        String productId = scanner.nextLine();

        Product product = inventory.get(productId);
        if (product != null) {
            System.out.print("Enter new Product Name (leave blank to keep current): ");
            String productName = scanner.nextLine();
            if (!productName.isBlank()) {
                product.setProductName(productName);
            }

            System.out.print("Enter new Quantity (leave blank to keep current): ");
            String quantityStr = scanner.nextLine();
            if (!quantityStr.isBlank()) {
                int quantity = Integer.parseInt(quantityStr);
                product.setQuantity(quantity);
            }

            System.out.print("Enter new Price (leave blank to keep current): ");
            String priceStr = scanner.nextLine();
            if (!priceStr.isBlank()) {
                double price = Double.parseDouble(priceStr);
                product.setPrice(price);
            }

            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.print("Enter Product ID to delete: ");
        String productId = scanner.nextLine();
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void viewAllProducts() {
        System.out.println("\nAll Products:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}
