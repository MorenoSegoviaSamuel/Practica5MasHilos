package org.example.ejercicio2;

public class GestorCubiertos {
    boolean CubiertoLibre[];
    public GestorCubiertos(int numCubiertos){
        CubiertoLibre=new  boolean[numCubiertos];
        for (int i=0; i<numCubiertos; i++){
            CubiertoLibre[i]=true;
        } //Fin del for
    } //Fin del constructor
    public synchronized boolean
    intentarCogerCubiertos(int pos1, int pos2)
    {
        boolean seConsigue=false;
        if (
                (CubiertoLibre[pos1])
                        &&
                        (CubiertoLibre[pos2]) )
        {
            CubiertoLibre[pos1]=false;
            CubiertoLibre[pos2]=false;
            seConsigue=true;
        } //Fin del if
        return seConsigue;
    }

    public void liberarCubierto(int pos1, int pos2){
        CubiertoLibre[pos1]=true;
        CubiertoLibre[pos2]=true;
    }
}
