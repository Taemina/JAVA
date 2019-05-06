package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-04-30
 */
public class ServerCore
{
  public static final int PORT = 8888;

  List<ClientHandler> clients = new ArrayList<>();

  public ServerCore()
  {
    Socket clientSocket = null;
    ServerSocket serverSocket = null;
    try
    {
      serverSocket = new ServerSocket(PORT);
      while (true)
      {
        clientSocket = serverSocket.accept();
        System.out.println("We have a new client....");
        ClientHandler client = new ClientHandler(clientSocket, this);
        client.start();
        clients.add(client);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        clientSocket.close();
        serverSocket.close();
        System.out.println("Server finished");
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }

  }

  //личные сообщения
  public void sendMessageClient (String Name,String message){
    for (ClientHandler client : clients)
    {
      if(client.clientNeme.equalsIgnoreCase(Name))
      client.sendMessage(message);
    }
  }
  public void sendMessageToAllClients(String message)
  {
    for (ClientHandler client : clients)
    {
      client.sendMessage(message);
    }
  }

  public void removeClient(ClientHandler clientHandler)
  {
    clients.remove(clientHandler);
  }

}
