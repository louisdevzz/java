package showroom;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DataManager {
    private final String SEP = ";";
    private final String vehicles_file_name = "vehicles.txt";
    private final String salers_file_name = "salers.txt";
    private final String managers_file_name = "managers.txt";
    private final String customers_file_name = "customers.txt";
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Customer> customers;
    private ArrayList<Saler> salers;
    private ArrayList<Manager> managers;

    public DataManager() {
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.salers = new ArrayList<>();
    }

    public void load(String folder_name){
        vehicles = this.loadVehicle(folder_name +"/"+ vehicles_file_name);
        customers = this.loadCustomer(folder_name +"/"+ customers_file_name);
        salers = this.loadSaler(folder_name +"/"+ salers_file_name);
        managers = this.loadManager(folder_name +"/"+ managers_file_name, salers);
    }

    public void save(String folder_name){
//        if folder exists, override all files
//        else: create new folder

    }


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicles(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public ArrayList<Saler> getSalers() {
        return salers;
    }

    public void addSalers(Saler saler) {
        this.salers.add(saler);
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public void addManagers(Manager manager) {
        this.managers.add(manager);
    }

    private ArrayList<Vehicle> loadVehicle(String fname){
        ArrayList<Vehicle> items = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (!line.isEmpty())
                    items.add(loadFromString(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    private ArrayList<Saler> loadSaler(String fname){
        ArrayList<Saler> items = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(!line.isEmpty()){
                    items.add(loadSalerString(line));
                }
            }
        }catch (FileNotFoundException e){
            throw  new RuntimeException(e);
        }
        return items;
    }

    private ArrayList<Customer> loadCustomer(String fname){
        ArrayList<Customer> items = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(!line.isEmpty()){
                    items.add(loadCusString(line));
                }
            }
        }catch (FileNotFoundException e){
            throw  new RuntimeException(e);
        }
        return items;
    }

    private ArrayList<Manager> loadManager(String fname, ArrayList<Saler> all_salers){
        ArrayList<Manager> items = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(!line.isEmpty()){
                    items.add(loadMnString(line,all_salers));
                }
            }
        }catch (FileNotFoundException e){
            throw  new RuntimeException(e);
        }
        return items;
    }

    private boolean saveVehicle(String fname){
        Vehicle vehicle = new Vehicle()
        return true;
    }

    //    SUPPORT TO SAVE/LOAD FILE
    public Vehicle loadFromString(String content){
        String[] tokenizers = content.split(SEP);
        Vehicle v = null;
        if (tokenizers.length == 8){
            String objType = tokenizers[0];
            if (objType.equals("TRUCK")){
                v = new Truck(tokenizers[1],
                        Double.parseDouble(tokenizers[2]),
                        Integer.parseInt(tokenizers[3]),
                        tokenizers[4],
                        Double.parseDouble(tokenizers[6]),
                        Integer.parseInt(tokenizers[7]));
            }else {
                v = new Car(tokenizers[1],
                        Double.parseDouble(tokenizers[2]),
                        Integer.parseInt(tokenizers[3]),
                        tokenizers[4],
                        Integer.parseInt(tokenizers[6]),
                        Car.CarType.valueOf(tokenizers[7]));
            }

        }
        return v;
    }
    public Saler loadSalerString(String content){
        String[] tokenizers = content.split(SEP);
        Saler s = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pp1 = new ParsePosition(0);
        if (tokenizers.length == 6){
            s = new Saler(tokenizers[0],
                    tokenizers[1],
                    df.parse(tokenizers[2],pp1),
                    Double.parseDouble(tokenizers[3]),
                    Double.parseDouble(tokenizers[4]),
                    Double.parseDouble(tokenizers[5]));

        }
        return s;
    }
    public Customer loadCusString(String content){
        String[] tokenizers = content.split(SEP);
        Customer c = null;
        if (tokenizers.length == 5){
            c = new Customer(tokenizers[0],
                    Customer.IdentityType.valueOf(tokenizers[1]),
                    tokenizers[2],
                    tokenizers[3],
                    tokenizers[4]);

        }
        return c;
    }
    public Manager loadMnString(String content, ArrayList<Saler> all_saler){
        String[] tokenizers = content.split(SEP);
        Manager m = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pp1 = new ParsePosition(0);
        if (tokenizers.length == 5){
            m = new Manager(tokenizers[0],
                    tokenizers[1],
                    df.parse(tokenizers[2],pp1),
                    Double.parseDouble(tokenizers[3]),
                    df.parse(tokenizers[4],pp1),
                    all_saler
            );

        }
        return m;
    }
}
