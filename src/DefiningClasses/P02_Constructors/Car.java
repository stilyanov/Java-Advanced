package DefiningClasses.P01_CarInfo;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int horsepower;
    private List<String> parts;

    public List<String> getParts() {
        return parts;
    }

    public Car() {
        this.parts = new ArrayList<>();
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brand, String model, int horsepower) {
        this(brand);
        this.model = model;
        this.horsepower = horsepower;

        this.parts = new ArrayList<>();
    }


    public String carInfo(){
        return this.toString();
    }
    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.brand, this.model, this.horsepower);
    }
}
