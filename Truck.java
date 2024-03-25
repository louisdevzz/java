package showroom;

public class Truck extends Vehicle{
    private double weight;
    private int valid_year;
    public Truck(String manufacturer, double price, int made_year,
                 String color, double wieght, int valid_year) {
        super(manufacturer, price, made_year, color, 5);
        this.weight = wieght;
        this.valid_year = valid_year;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getValid_year() {
        return valid_year;
    }

    public void setValid_year(int valid_year) {
        this.valid_year = valid_year;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                ", weight=" + weight +
                ", valid_year=" + valid_year +
                '}';
    }
}
