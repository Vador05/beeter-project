package DSA.exams.ex1.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by kenshin on 2/10/15.
 */
public class DNSClient {
    public static void main(String[] args) throws IOException {
        //Condiderem que pasem la IP, el port i el missatge com a arguments del main
        String IP = args[0];/**Agafem la IP dels arguments*/
        int port = Integer.parseInt(args[1]);/**agafem el port dels arguments que hem passat*/
        Socket con = new Socket(IP, port);/**creem una nova conn*/

        PrintWriter writer = new PrintWriter(con.getOutputStream());/**Creem l'escriptor*/
        writer.println(args[2]);/**Obtenim el missatge a enviar*/
        writer.flush();/**Ho enviem per la connexió*/
        //ESPEREM RESPOSTA
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String rebut = reader.readLine();/** llegim el que ens arribe*/
        System.out.println(rebut);/**Ho mostrem per pantalla*/
    }
}
