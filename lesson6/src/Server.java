import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{
    public static void main(String[] args) throws IOException
    {
        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("We are waiting a new client");
        Socket clientSocket = serverSocket.accept();
        System.out.println("We have a new client");

        InputStream inputStream = clientSocket.getInputStream(); // входящие сообщения
        OutputStream outputStream = clientSocket.getOutputStream(); //исходящие сообщения

        DataInputStream dis = new DataInputStream(inputStream);
        DataOutputStream dos = new DataOutputStream(outputStream);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String msg ="";
        String msgForClients= "";
        try {

            while (true) {


                if(!msgForClients.equalsIgnoreCase("")){
                    System.out.println("Put please a new message");
                    msgForClients = keyboard.readLine();

                    dos.writeUTF(msgForClients);
                    dos.flush();
                } else {
                    msg = dis.readUTF();
                    if (msg.equalsIgnoreCase("end")) {
                        break;
                    }
                    if (!msg.equalsIgnoreCase("")){
                        System.out.println("Client sent message. Message equals  = " + msg);

                    }else{
                        msgForClients="s";
                    }
                }



            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("disconnect");

        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
