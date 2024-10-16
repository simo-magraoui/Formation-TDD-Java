package org.example.service;

import static org.mockito.Mockito.*;

import org.example.model.Car;
import org.example.model.ElectricEngine;
import org.example.model.GasEngine;
import org.example.repository.Engine;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void testCarStart() {
        Engine mockEngine = mock(Engine.class);
        Car car = new Car(mockEngine);

        car.start();
        verify(mockEngine).start();
    }

    @Test
    public void testElectricCarStart() {
        ElectricEngine mockElectricEngine = mock(ElectricEngine.class);
        Car car = new Car(mockElectricEngine);

        car.start();
        verify(mockElectricEngine).start();
    }

    @Test
    public void testGasCarStart() {
        GasEngine mockGasEngine = mock(GasEngine.class);
        Car car = new Car(mockGasEngine);

        car.start();
        verify(mockGasEngine).start();
    }
}