package org.example.banheiro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaNumero2 implements Runnable {

  private Banheiro banheiro;

  @Override
  public void run() {
    banheiro.fazNumero2(banheiro);
  }
}
