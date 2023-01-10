package org.example.contador;

public class Main {

  public static void main(String[] args) {
    Thread contador = new Thread(new Contador());
    Thread contador2 = new Thread(new Contador());
    contador.start();
    contador2.start();
  }

}
