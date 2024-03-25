package showroom;

public class Car extends Vehicle{
    public static enum CarType {Van, Sedan, SUV}
    private int seat_number;
    private CarType type;

    public Car(String manufacturer, double price, int made_year, String color,
               int seat_number, CarType type) {
        super(manufacturer, price, made_year, color, 10);
        this.seat_number = seat_number;
        this.type = type;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                ", seat_number=" + seat_number +
                ", type=" + type +
                '}';
    }
}
