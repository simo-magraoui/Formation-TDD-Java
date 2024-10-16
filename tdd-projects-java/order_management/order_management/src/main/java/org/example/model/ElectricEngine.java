package org.example.model;
import org.example.repository.Engine;
public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Car avec moteur électrique started");// Logique de démarrage pour un moteur électrique
    }
}
