package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class ClientHandler extends Thread
{
  private ServerCore serverCore;
  private DataInputStream dis;
  private DataOutputStream dos;
  private static int clientsCount = 0;
  public String clientNeme = "Client";
  private String lm = "/w";
  public ClientHandler(Socket socket, ServerCore server)
  {
    try
    {
      clientsCount++;
      serverCore = server;
      clientNeme=clientNeme+clientsCount;
      InputStream inputStream = socket.getInputStream();
      OutputStream outputStream = socket.getOutputStream();
      dis = new DataInputStream(inputStream);
      dos = new DataOutputStream(outputStream);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

  }

  @Override
  public void run()
  {
    try
    {
      serverCore.sendMessageToAllClients("We have a new clients in our chat!");
      serverCore.sendMessageToAllClients("Clients count in chat = " + clientsCount);
      while (true)
      {
        String message = dis.readUTF();
        if (message.equalsIgnoreCase("EXIT"))
        {
          break;
        }

        System.out.println(clientNeme+" : "+message);

        if(message.startsWith(lm)){ // если начало сообщения /w  то
         String Name = message.substring(3,10); // вытаскиваем имя клиента
            message = message.substring(12); // вытаскиваем отдельно сообщение
          serverCore.sendMessageClient(Name, clientNeme+" : "+message); // отправляем личное сообщение
        }
        else
        serverCore.sendMessageToAllClients(clientNeme+" : "+message);
        Thread.sleep(100);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      close();
    }


  }

  private void close()
  {
    serverCore.removeClient(this);
    clientsCount--;
    serverCore.sendMessageToAllClients("Clients count in chat = " + clientsCount);
  }

  public void sendMessage(String message)
  {
    try
    {
      dos.writeUTF(message);
      dos.flush();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
