package DSA.exams.ex1.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;

/**
 * Created by kenshin on 2/10/15.
 */
public class DNSThread implements Runnable {
    Socket socket;
    BufferedReader reader;
    PrintWriter writer;
    SimpleDateFormat sdf;

    public DNSThread(socket) throws IOException{
        this.socket = socket;
        sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");/**Definim el format de la hora*/
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));/**Creem el buffer de lectura*/
        writer = new PrintWriter(socket.getOutputStream());/**Creem l'escriptor*/

    }

    @Override
    public void run()throws IOException{
        String rebut = reader.readLine();/** llegim el que ens arribe*/
        if (rebut.equals("NAME"))
            enviarNOM();
        else if(rebut.equals("ID"))
            enviarID();
        else
            enviarERROR();

        socket.close();

    }

    public void  enviarNOM() {
        writer.println(getNAME()+" "+sdf.format(System.currentTimeMillis()));/**Creem el missatge a enviar*/
        writer.flush();/**Ho enviem per la connexió*/
    }

    public void enviarID() {
        writer.println(getID()+" "+sdf.format(System.currentTimeMillis()));/**Creem el missatge a enviar*/
        writer.flush();/**Ho enviem per la connexió*/
    }
    public void enviarERROR() {
        writer.println("NO ES POT RESOLDRE LA CONSULTA, LA CONSULTA NO ES CORRESPON AMB LES ADMESES PEL SERVIDOR");/**Obtenim la hora del sistema*/
        writer.flush();/**Ho enviem per la connexió*/
    }

}
