package org.example.socket.servidortarefas.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

  public static void main(String[] args) {
    ServerSocket servidor = null;
    try {
      System.out.println("--- Iniciando Servidor ---");
      servidor = new ServerSocket(12345);
//      ExecutorService threadPoll = Executors.newFixedThreadPool(2);
      ExecutorService cachedThreadPoll = Executors.newCachedThreadPool();
      while(true) {
        Socket socket = servidor.accept();
        System.out.println("Aceitando novo cliente na porta " + socket.getPort());
//        Runnable distribuirTarefas = new DistribuirTarefas(socket);
//        Thread threadCliente = new Thread(distribuirTarefas);
//        threadCliente.setName("THREAD-SOCKET");
//        threadCliente.start();
        
        cachedThreadPoll.execute(new DistribuirTarefas(socket));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
