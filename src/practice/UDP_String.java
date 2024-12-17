/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;

/**
 *
 * @author trong
 */
public class UDP_String {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        
        byte[] msg = new byte[1024];
        msg = ";B21DCCN473;zDY8UG8W".getBytes();
        
        client.send(new DatagramPacket(msg, msg.length, InetAddress.getByName("203.162.10.109"), 2208));
        
        byte[] buff = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        
        client.receive(dp);
        String rec = new String(dp.getData()).trim();
        
        System.out.println(rec);
        String[] str = rec.split(";");
        
        HashSet<Character> set = new HashSet<>();
        for (char c : str[2].toCharArray()) {
            set.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(str[0]);
        sb.append(';');
        
        for (char c : str[1].toCharArray()) {
            if (!set.contains(c))
                sb.append(c);
        }
        
        String sen = sb.toString();
        System.out.println(sen);
        
        msg = sen.getBytes();
        client.send(new DatagramPacket(msg, msg.length, InetAddress.getByName("203.162.10.109"), 2208));
        
        client.close();
    }
}
