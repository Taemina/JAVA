package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ClientHandler extends Thread
{
  private ServerCore serverCore;
  private DataInputStream dis;
  private DataOutputStream dos;
  private static int clientsCount = 0;
  public long startTime = 1000000000L;
  public String clientNeme = "";
  private String lm = "/w";
  public ClientHandler(Socket socket, ServerCore server)
  {
    try
    {
      clientsCount++;
      serverCore = server;
      InputStream inputStream = socket.getInputStream();
      OutputStream outputStream = socket.getOutputStream();
      startTime = System.currentTimeMillis();
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
        int i=serverCore.timeClient();

        String message = dis.readUTF();
        if ((message.equalsIgnoreCase("EXIT"))||i==0)
        {
          System.out.println("разрыв");
          close();
          break;
        }




            if(clientNeme!="") {
              if (message.startsWith(lm)) { // если начало сообщения /w  то
                String Name = message.substring(3, 10); // вытаскиваем имя клиента
                message = message.substring(12); // вытаскиваем отдельно сообщение
                serverCore.sendMessageClient(Name, clientNeme + " : " + message); // отправляем личное сообщение
              } else
                serverCore.sendMessageToAllClients(clientNeme + " : " + message);
            }
        if(message.startsWith("/nik")){ // если начало сообщения /nik  то
          clientNeme = message.substring(4); // Устанавливаем имя клиента
          System.out.println(clientNeme+" : ");
        }

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

  public void close()
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
