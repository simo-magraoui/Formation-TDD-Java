package org.example.model;
import org.example.repository.Engine;
public class GasEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Car avec moteur à essence started");// Logique de démarrage pour un moteur à essence
    }
}
