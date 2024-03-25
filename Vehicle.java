package showroom;

public class Vehicle {
    private String manufacturer;
    private double price;
    private int made_year;
    private String color;

    private int tax;
    public Vehicle(String manufacturer, double price, int made_year, String color, int tax) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.made_year = made_year;
        this.color = color;
        this.tax = tax;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMade_year() {
        return made_year;
    }

    public void setMade_year(int made_year) {
        this.made_year = made_year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return  "manufacturer='" + manufacturer + "'" +
                ", price=" + price +
                ", made_year=" + made_year +
                ", color='" + color + "'" +
                ", tax=" + tax;

    }
}
