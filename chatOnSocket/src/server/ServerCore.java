package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    clientHandler.sendMessage("disconnection");
    clients.remove(clientHandler);
  }
  public int timeClient()
  {
    int i=1;
  for (ClientHandler clienta : clients)
  {
    System.out.println(new Date().getTime() - clienta.startTime);
    if(((new Date().getTime() - clienta.startTime)>=(2*60*1000))&&(clienta.clientNeme=="")){
      clienta.close();
      System.out.println("di");
    i=0;}
  }
  return i;
  }


}
