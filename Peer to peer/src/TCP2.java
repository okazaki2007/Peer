//Different libraries exports
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//class name
public class TCP2 {

    public static void main(String[] args) {
        try {
            //Create Serversocket from a specified port
            Socket d = new Socket("Localhost", 1543);
            //Message when is connected
            System.out.println("Conectado");//status
            //actions to take if it's connected
            Scanner scanner = new Scanner(System.in);
            DataInputStream viene = new DataInputStream(d.getInputStream());
            //Create new output data
            DataOutputStream va = new DataOutputStream(d.getOutputStream());
            while (true) {
                //While condiction is true
                //Ouput on screen
                System.out.println("Valor producto:");
                String cim = scanner.nextLine();
                va.writeUTF(cim);


                //If input is "salir" the secuence will finish
                if (cim.equals("salir")) {
                    System.out.println("Saliendo");
                    viene.close();
                    va.close();
                    scanner.close();
                    d.close();
                    System.exit(0);
                }
                String smsg = viene.readUTF();
                //output on screen
                System.out.println("Porcentaje de impuesto:" + smsg);
                
                //Final secuence case 
                if (smsg.equals("salir")) {
                    System.out.println("Saliendo");
                    viene.close();
                    va.close();
                    scanner.close();
                    d.close();
                    System.exit(0);

                }

            }

        } catch (UnknownHostException e) {

        } catch (IOException e) {



        }
    }
}
