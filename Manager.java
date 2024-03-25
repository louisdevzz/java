package showroom;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employee{
    private Date pomotion_date;
    private ArrayList<Saler> list_of_salers;

    private double position_salary;
    public Manager(String id, String name, Date start_date, double based_salary, Date pomotion_date, ArrayList<Saler> list_of_salers) {
        super(id, name, start_date, based_salary);
        this.pomotion_date = pomotion_date;
        this.list_of_salers = list_of_salers;
    }

    public Date getPomotion_date() {
        return pomotion_date;
    }

    public void setPomotion_date(Date pomotion_date) {
        this.pomotion_date = pomotion_date;
    }

    public ArrayList<Saler> getList_of_salers() {
        return list_of_salers;
    }

    public void setList_of_salers(ArrayList<Saler> list_of_salers) {
        this.list_of_salers = list_of_salers;
    }

    public double getPosition_salary() {
        return position_salary;
    }

    public void setPosition_salary(double position_salary) {
        this.position_salary = position_salary;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                "pomotion_date=" + pomotion_date +
                ", list_of_salers=" + list_of_salers +
                ", position_salary=" + position_salary +
                '}';
    }

    public double getSalary(){
        return super.getBased_salary() + position_salary;
    }

    public double getSalary(double bonus){
        return this.getSalary() + bonus;
    }
}
