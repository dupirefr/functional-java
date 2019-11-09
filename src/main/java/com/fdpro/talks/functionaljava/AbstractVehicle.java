package com.fdpro.talks.functionaljava;

abstract class AbstractVehicle implements Vehicle {
    private String brand;
    private String model;
    private int wheelsCount;

    public AbstractVehicle(String brand, String model, int wheelsCount) {
        this.brand = brand;
        this.model = model;
        this.wheelsCount = wheelsCount;
    }

    @Override
    public final String brand() {
        return brand;
    }

    @Override
    public final String model() {
        return model;
    }

    @Override
    public final int wheelsCount() {
        return wheelsCount;
    }
}
