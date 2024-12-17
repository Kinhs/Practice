/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author trong
 */
public class TCP_DataStream {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2207);
        System.out.println(client);
        
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("B21DCCN473;naPqKIed");
        
        DataInputStream dis = new DataInputStream(client.getInputStream());
        
        int a = dis.readInt();
        int b = dis.readInt();
        
        int g = gcd(a, b);
        dos.writeInt(g);
        dos.writeInt(a * b / g);
        dos.writeInt(a + b);
        dos.writeInt(a * b);
        
        dos.close();
        dis.close();
        client.close();
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
