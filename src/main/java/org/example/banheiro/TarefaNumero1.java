package org.example.banheiro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaNumero1 implements Runnable {

  private Banheiro banheiro;

  @Override
  public void run() {
    banheiro.fazNumero1(banheiro);
  }
}
