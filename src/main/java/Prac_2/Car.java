package Prac_2;

import java.io.Serializable;

public class Car implements Serializable {

    private String make;

    private String model;

    public Car(String make) {
        this.make = make;
        this.model = "unknown";
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}