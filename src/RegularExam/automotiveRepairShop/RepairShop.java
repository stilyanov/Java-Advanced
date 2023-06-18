package RegularExam.automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < this.capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                this.vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return this.vehicles.stream().min(Comparator.comparingInt(Vehicle::getMileage)).orElse(null);
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vehicles in the preparatory:");
        this.vehicles.forEach(vehicle -> {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(vehicle);
        });
        return stringBuilder.toString();
    }
}
