package DSA.exams.ex1.ex2;

import java.io.*;

/**
 * Created by kenshin on 2/10/15.
 */
public class Student {
    private String nombre;
    private Double nota;

    public void writeBinaryData(String filename) throws Exception{
        File ar = new File(filename);
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(ar));
        dos.writeUTF(this.nombre);
        dos.writeDouble(this.nota);
        dos.close();
    }


    public void writeTextData(String filename) throws Exception{
        File ar = new File(filename);
        BufferedWriter cervantes = new BufferedWriter(new FileWriter(ar));
        cervantes.write(this.nombre+"\t"+this.nota.toString());
        cervantes.close();
    }


    public void readBinaryData(String filename) throws Exception{
        File ar = new File(filename);
        DataInputStream dis = new DataInputStream(new FileInputStream(ar));
        this.nombre=dis.readUTF();
        this.nota=dis.readDouble();
        dis.close();
    }


    public void readTextData(String filename) throws Exception{
        File ar = new File(filename);
        BufferedReader buffersito = new BufferedReader(new FileReader(ar));
        String linea = buffersito.readLine();
        String [] saroto = linea.split("\t");
        this.nombre= saroto[0];
        this.nota= Double.parseDouble(saroto[1]);
        buffersito.close();
    }
}
