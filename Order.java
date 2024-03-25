package showroom;

import java.util.Date;

public class Order {
    private static enum OrderStatus {PENDING, READY, COMPLETED}
    private Customer customer;
    private Saler saler;
    private Manager manager;
    private Vehicle vehicle;
    private Date sell_date;

    private double real_price;

    private OrderStatus status;

    public Order(Customer customer, Saler saler, Manager manager, Vehicle vehicle, Date sell_date, double real_price) {
        this.customer = customer;
        this.saler = saler;
        this.manager = manager;
        this.vehicle = vehicle;
        this.sell_date = sell_date;
        this.real_price = real_price;
        this.status = OrderStatus.PENDING;
    }

    public void approve(Manager m){
        manager = m;
        status = OrderStatus.READY;
    }

    public void delivery(Customer c){
        customer = c;
        status = OrderStatus.COMPLETED;
    }

    public void approve() throws Exception{
        if (manager == null)
            throw new Exception("Please specify who is approving!");
        status = OrderStatus.READY;
    }

    public void delivery() throws Exception{
        if (customer == null)
            throw new Exception("PLease specify who is buying!");
        status = OrderStatus.COMPLETED;
    }

}
