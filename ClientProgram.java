package showroom;

import java.util.ArrayList;

public class ClientProgram {
    public static void main(String[] args){
        DataManager dataManager = new DataManager();
        dataManager.load("data");
        dataManager.save("data");

    }
}
