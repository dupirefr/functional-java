package com.fdpro.talks.functionaljava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BehaviourParameterization {
    private static List<Vehicle> createVehicles() {
        // tag:vehicles-list
        return List.of(
          new Car("BMW", "X1"),
          new MotorCycle("Yamaha", ""),
          new MotorCycle("Hyundai", ""),
          new BiCycle("BMX", ""),
          new Car("Hyundai", "")
        );
        // end:vehicles-list
    }

    @Nested
    class BeforeJava8 {
        @Test
        void givenVehicles_whenGetTwoWheels_thenOnlyBicyclesAndMotorcycles() {
            List<Vehicle> vehicles = createVehicles();

            List<Vehicle> twoWheelsVehicles = filterVehicles(vehicles, new VehicleFilter() {
                @Override
                boolean verifyFilter(Vehicle vehicle) {
                    return vehicle.wheelsCount() == 2;
                }
            });

            assertThat(twoWheelsVehicles)
              .hasSize(3)
              .doesNotHaveAnyElementsOfTypes(Car.class);
        }

        private List<Vehicle> filterVehicles(List<Vehicle> vehicles, VehicleFilter vehicleFilter) {
            List<Vehicle> result = new ArrayList<>();

            for (Vehicle vehicle : vehicles) {
                if (vehicleFilter.verifyFilter(vehicle)) {
                    result.add(vehicle);
                }
            }

            return result;
        }
    }
}
