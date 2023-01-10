package org.example.lista;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Vector;

public class Main {

  public static void main(String[] args) {

//    List<String> list = Collections.synchronizedList(new ArrayList<>());

    List<String> list = new Vector<>();

    for (int i = 0; i < 100; i++) {
      Thread thread = new Thread(new TarefaAdicionarElemento(list, i));
      thread.start();
    }
    
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println("INICIANDO LISTAGEM...");
    new Thread(new TarefaListarElemento(list)).start();
    System.out.println("Total de registros: " + list.size());

  }
  
  public static void getCurrentDate() {
    LocalDateTime now = LocalDateTime.now();
    int year = now.getYear();
    int month = now.getMonthValue();
    int day = now.getDayOfMonth();
    int hour = now.getHour();
    int minute = now.getMinute();
    int second = now.getSecond();
    int millis = now.get(ChronoField.MILLI_OF_SECOND); // Note: no direct getter available.

    System.out.printf("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month, day, hour, minute, second, millis);
  }

}
