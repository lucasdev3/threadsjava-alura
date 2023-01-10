package org.example.socket.servidortarefas.cliente;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

  public static void main(String[] args) {
    
    System.out.println("--- Iniciando servidor clientes ---");
    try {
      Socket socket = new Socket("localhost", 12345);
      System.out.println("Conexão estabelecida!");
      OutputStream outputStream = socket.getOutputStream();
      PrintStream saidaPrintStream = new PrintStream(outputStream);
      saidaPrintStream.println("c1");
      Scanner tecladoScanner = new Scanner(System.in);
      tecladoScanner.nextLine();
      saidaPrintStream.close();
      tecladoScanner.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
