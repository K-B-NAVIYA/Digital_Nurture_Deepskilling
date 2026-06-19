import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static Product linearSearch(Product[] products, int id) {

        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            }

            else if (products[mid].productId < id) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Mobile", "Electronics"),
                new Product(3, "Shoes", "Fashion"),
                new Product(4, "Watch", "Accessories"),
                new Product(5, "Book", "Education")
        };

        System.out.println("Linear Search Result:");

        Product result1 = linearSearch(products, 3);

        if (result1 != null) {
            result1.display();
        }

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\nBinary Search Result:");

        Product result2 = binarySearch(products, 4);

        if (result2 != null) {
            result2.display();
        }
    }
}