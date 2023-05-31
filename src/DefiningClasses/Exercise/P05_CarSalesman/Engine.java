package DefiningClasses.Exercise.P05_CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    //Constructor

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model = model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
