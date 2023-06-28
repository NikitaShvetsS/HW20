
public class Product {

    private String type;
    private double price;
    private boolean discountAbility;
    private String addTime;

    public Product(String type, double price, boolean discountAbility, String addTime) {
        this.type = type;
        this.price = price;
        this.discountAbility = discountAbility;
        this.addTime = addTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountAbility(boolean discountAbility) {
        this.discountAbility = discountAbility;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountAbility() {
        return discountAbility;
    }

    public String getAddTime() {
        return addTime;
    }
}
