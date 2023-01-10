package org.example.banheiro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Banheiro {

  private boolean estaSujo = true;

  private Lock lock = new ReentrantLock();

  public void fazNumero1(Banheiro banheiro) {

    synchronized (this) {

      Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Faxineira");

      String nome = Thread.currentThread().getName();

      System.out.println(nome + " batendo na porta!\n");

      System.out.println(nome + " entrando no banheiro");
      if (estaSujo) {
        esperaLaFora(nome);
        limpeza.start();
      }
      System.out.println(nome + " Fazendo coisa rapida");
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      this.estaSujo = true;
      System.out.println(nome + " dando descarga");
      System.out.println(nome + " lavando a mão");
      System.out.println(nome + " saindo do banheiro");

      limpeza.start();
    }
  }

  public void fazNumero2(Banheiro banheiro) {

    synchronized (this) {

      Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Faxineira");

      String nome = Thread.currentThread().getName();

      System.out.println("\n" + nome + " batendo na porta!");

      System.out.println(nome + " Entrando no banheiro");
      if (estaSujo) {
        esperaLaFora(nome);
        limpeza.start();
      }
      System.out.println(nome + " Fazendo coisa lenta");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      this.estaSujo = true;
      System.out.println(nome + " dando descarga");
      System.out.println(nome + " lavando a mão");
      System.out.println(nome + " saindo do banheiro");

      limpeza.start();

    }
  }

  private void esperaLaFora(String nome) {
    System.out.println(nome + ", eca, banheiro tá sujo");
    try {
      this.wait();
      this.estaSujo = false;
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void limpa(Banheiro banheiro) {

    String nome = Thread.currentThread().getName();

    System.out.println(nome + " batendo na porta!\n");

    synchronized (this) {
      System.out.println(nome + " Entrando no banheiro");
      if (!banheiro.estaSujo) {
        System.out.println(nome + " , não está sujo, vou sair");
        return;
      }
      System.out.println(nome + " limpando banheiro");
      banheiro.estaSujo = false;
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      this.notifyAll();

      System.out.println(nome + " saindo do banheiro");
    }

  }

}
