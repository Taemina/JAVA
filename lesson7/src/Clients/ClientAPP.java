package Clients;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
public class ClientAPP {

    public static void main(String[] args) throws IOException
    {
        int port = 8888;

        InetAddress inetAddress = InetAddress.getLocalHost(); //127.0.0.1
        Socket socket = new Socket(inetAddress, port);
        System.out.println("We have the connection...");
        InputStream inputStream = socket.getInputStream(); // входящие сообщения
        OutputStream outputStream = socket.getOutputStream(); //исходящие сообщения

        DataInputStream dis = new DataInputStream(inputStream);
        DataOutputStream dos = new DataOutputStream(outputStream);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        Thread recieve = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        System.out.println( dis.readUTF());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        dos.writeUTF(br.readLine());
                        dos.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        recieve.start();
        send.start();

    }
}
