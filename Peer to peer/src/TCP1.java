//Different libraries exports
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
// Class name
public class TCP1 {

    public static void main(String[] args) {
        try {
            //Create Serversocket from a specified port
            ServerSocket ss = new ServerSocket(1543);
            //First step before conneting
            System.out.println("Conectando......");
            Socket s = ss.accept();
            //Produce value from input
            Scanner scanner = new Scanner(System.in);
            DataInputStream viene = new DataInputStream(s.getInputStream());
            //Create new output data
            DataOutputStream va = new DataOutputStream(s.getOutputStream());
            while (true) {
                //While condiction is true
                String cim = viene.readUTF();
                //Ouput on screen
                System.out.println("Valor producto:" + cim);
                scanner.nextLine();

                //If input is "exit" the secuence will finish
                if (cim.equals("salir")) {
                    System.out.println("Saliendo");
                    viene.close();
                    va.close();
                    scanner.close();
                    s.close();
                    ss.close();
                    System.exit(0);
                }
                System.out.println("Porcentaje impuesto");
                String smsg = scanner.nextLine();
                va.writeUTF(smsg);


                //If input is "exit" the secuence will finish
                if (smsg.equals("salir")) {
                    System.out.println("Saliendo");
                    viene.close();
                    va.close();
                    scanner.close();
                    s.close();
                    ss.close();
                    System.exit(0);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


