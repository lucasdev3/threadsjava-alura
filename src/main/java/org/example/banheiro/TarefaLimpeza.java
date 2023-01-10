package org.example.banheiro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TarefaLimpeza implements Runnable {

  private Banheiro banheiro;

  @Override
  public void run() {
    this.banheiro.limpa(banheiro);
  }
}
