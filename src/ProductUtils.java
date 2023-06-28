import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductUtils {

    public List<Product> getBookProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public List<Product> getDiscountedBookProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.isDiscountAbility())
                .map(p -> {
                    p.setPrice(p.getPrice() * 0.9);
                    return p;
                })
                .collect(Collectors.toList());
    }

    public Product getCheapestBookProduct(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Продукт [категорія: Book] не знайдено"));
    }

    public List<Product> getLatestAddedProducts(List<Product> products, int count) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getAddTime).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public double calculateTotalCost(List<Product> products) {
        int currentYear = LocalDate.now().getYear();

        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() <= 75)
                .filter(p -> {
                    LocalDate creationDate = LocalDate.parse(p.getAddTime());
                    return creationDate.getYear() == currentYear;
                })
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

}
