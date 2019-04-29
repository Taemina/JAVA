import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{
    public static void main(String[] args)
    {
        int port = 8888;
        try
        {
            InetAddress inetAddress = InetAddress.getLocalHost(); //127.0.0.1
            Socket socket = new Socket(inetAddress, port);
            System.out.println("We have the connection...");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(inputStream);
            DataOutputStream dos = new DataOutputStream(outputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("We are beginning.... ");
            String msg="s";
            while (true) {

                if(!msg.equalsIgnoreCase("")){
                    System.out.println("Put please a new message");
                    msg = keyboard.readLine();
                    if (msg.equalsIgnoreCase("end")) {
                        dos.writeUTF(msg);
                        break;
                    }

                    dos.writeUTF(msg);
                    dos.flush();

                } else {
                    String msgFromServer = dis.readUTF();
                    if (!msgFromServer.equalsIgnoreCase("")){
                        System.out.println("We received message from server = " + msgFromServer);
                        if (msgFromServer.equalsIgnoreCase("disconnect")) {
                            break;
                        }
                    }else{

                        msg="s";
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
