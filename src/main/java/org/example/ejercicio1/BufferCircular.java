package org.example.ejercicio1;

public class BufferCircular {
    private int[] buffer;
    private int size;
    private int count;
    private int in;
    private int out;

    public BufferCircular(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.count = 0;
        this.in = 0;
        this.out = 0;
    }

    public synchronized void poner(int data) throws InterruptedException {
        while (count == size) {
            wait(); // Espera si el buffer está lleno
        }
        buffer[in] = data;
        in = (in + 1) % size;
        count++;
        notifyAll(); // Notifica a los consumidores que hay datos disponibles
    }

    public synchronized int sacar() throws InterruptedException {
        while (count == 0) {
            wait(); // Espera si el buffer está vacío
        }
        int data = buffer[out];
        out = (out + 1) % size;
        count--;
        notifyAll(); // Notifica a los productores que hay espacio disponible en el buffer
        return data;
    }
}
