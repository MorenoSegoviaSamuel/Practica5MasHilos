package org.example.ejercicio1;

import org.example.ejercicio1.BufferCircular;

import java.util.Random;

public class Productor implements Runnable {
    private BufferCircular buffer;
    private Random random;

    public Productor(BufferCircular buffer) {
        this.buffer = buffer;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(random.nextInt(2000)); // Espera aleatoria entre 0 y 2 segundos
                buffer.poner(i);
                System.out.println("Productor #" + Thread.currentThread().getId() + " produce: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}