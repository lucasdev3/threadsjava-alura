package org.example.lista;

import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TarefaListarElemento implements Runnable {

  List<String> list;

  @Override
  public void run() {
    list.sort(Comparator.comparing(String::toString));
    for (String item : list) {
      System.out.println(item);
    }
  }
}
