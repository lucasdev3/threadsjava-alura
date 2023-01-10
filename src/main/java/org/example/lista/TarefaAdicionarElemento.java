package org.example.lista;

import java.util.List;
import java.util.Vector;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TarefaAdicionarElemento implements Runnable {

  private List<String> lista = new Vector<>();

  int numeroDoThread;

  public TarefaAdicionarElemento(List<String> lista, int numeroDoThread) {
    this.lista = lista;
    this.numeroDoThread = numeroDoThread;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      lista.add("Thread " + numeroDoThread + " - " + i);
    }
  }
}
