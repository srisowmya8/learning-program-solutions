import java.util.Arrays;

public class SearchEngine {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) return products[mid];
            if (products[mid].productId < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(203, "Shampoo", "Personal Care"),
            new Product(150, "Desk", "Furniture"),
            new Product(175, "Mouse", "Electronics"),
            new Product(120, "Fan", "Appliances")
        };

        System.out.println("=== Product List ===");
        for (Product p : products) {
            System.out.println(p);
        }

        int targetId = 203;
        System.out.println("\nTarget Product ID: " + targetId);

        // Linear Search
        long startLinear = System.nanoTime();
        Product resultLinear = linearSearch(products, targetId);
        long endLinear = System.nanoTime();
        long timeLinear = endLinear - startLinear;

        System.out.println("\n=== Linear Search Result ===");
        if (resultLinear != null) {
            System.out.println("Found: " + resultLinear);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Time Taken: " + timeLinear + " ns (" + timeLinear / 1_000_000.0 + " ms)");

        // Binary Search (requires sorted array)
        Arrays.sort(products);

        long startBinary = System.nanoTime();
        Product resultBinary = binarySearch(products, targetId);
        long endBinary = System.nanoTime();
        long timeBinary = endBinary - startBinary;

        System.out.println("\n=== Binary Search Result ===");
        if (resultBinary != null) {
            System.out.println("Found: " + resultBinary);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Time Taken: " + timeBinary + " ns (" + timeBinary / 1_000_000.0 + " ms)");
    }
}
