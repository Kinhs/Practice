/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author trong
 */
public class TCP_ByteStream {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2206);
        System.out.println(client);
        
        OutputStream os = client.getOutputStream();
        os.write("B21DCCN473;Khuduan5".getBytes());
        
        InputStream is = new BufferedInputStream(client.getInputStream());
        byte[] buffer = new byte[1024];
        
        int numbyte = is.read(buffer);
        
        String s = new String(buffer, 0, numbyte);
        System.out.println(s);
        
        int sum = 0;
        for (String i: s.split("\\|")) {
            sum += Integer.parseInt(i);
        }
        
        System.out.println(sum);
        
        os.write(Integer.toString(sum).getBytes());
        os.close();
        is.close();
        client.close();
    }
}
