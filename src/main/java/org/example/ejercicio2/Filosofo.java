package org.example.ejercicio2;

import java.util.Random;

public class Filosofo implements Runnable{
    GestorCubiertos gestorCubiertos;
    int posCubiertoIzq, posCubiertoDer;
    public Filosofo(GestorCubiertos g, int pIzq, int pDer){
        this.gestorCubiertos =g;
        this.posCubiertoDer =pDer;
        this.posCubiertoIzq =pIzq;
    }
    public void run() {
        while (true){
            boolean cubiertosCogidos;
            cubiertosCogidos=
                    this.gestorCubiertos.intentarCogerCubiertos(
                            posCubiertoIzq, posCubiertoDer);
            if (cubiertosCogidos){
                comer();
                this.gestorCubiertos.liberarCubierto(
                        posCubiertoIzq,
                        posCubiertoDer);
                dormir();
            } //Fin del if
        } //Fin del while true
    } //Fin del run()

    private void comer() {
        System.out.println("Filosofo "+
                Thread.currentThread().getName()+
                " comiendo");
        esperarTiempoAzar();
    }
    private void esperarTiempoAzar() {
        Random generador=new Random();
        int msAzar=generador.nextInt(4000)+1000;
        try {
            Thread.sleep(msAzar);
        } catch (InterruptedException ex) {
            System.out.println("Fallo la espera");
        }
    }
    private void dormir(){
        System.out.println("Filosofo "+
                Thread.currentThread().getName()+
                " esta pensando...");
        esperarTiempoAzar();
    }
}