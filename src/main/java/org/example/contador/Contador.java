package org.example.contador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Contador implements Runnable {

  @Override
  public void run() {
    try {

      Thread currentThread = Thread.currentThread();
      for (int i = 0; i <= 1000; i++) {
        System.out.println("Id da thread: " + currentThread.getId() + " Contador: " + i);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
