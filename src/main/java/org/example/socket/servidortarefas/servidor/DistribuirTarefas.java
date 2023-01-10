package org.example.socket.servidortarefas.servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DistribuirTarefas implements Runnable{

  
  private Socket socket;
  
  @Override
  public void run() {
    try {
      System.out.println("Distribuindo tarefas para " + socket);
      Scanner scanner = new Scanner(socket.getInputStream());
      while(scanner.hasNextLine()) {
        String comandoString = scanner.nextLine();
        System.out.println(comandoString);
      }
      socket.close();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
  }
  
  

}
