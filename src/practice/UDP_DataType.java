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

/**
 *
 * @author trong
 */
public class UDP_DataType {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        
        byte[] msg = new byte[1024];
        msg = ";B21DCCN473;BOuj62tM".getBytes();
        
        client.send(new DatagramPacket(msg, msg.length, InetAddress.getByName("203.162.10.109"), 2207));
        
        byte[] buff = new byte[1024];
        DatagramPacket dpRec = new DatagramPacket(buff, buff.length);
        
        client.receive(dpRec);
        
        String receivedstr = new String(dpRec.getData()).trim();
        
        System.out.println(receivedstr);
        
        String[] str = receivedstr.split(";");
        int sum = 0;
        
        for (char c : str[1].toCharArray()) {
            sum += c - '0';
        }
        System.out.println(sum);
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]);
        sb.append(';');
        sb.append(sum);
        
        msg = sb.toString().getBytes();
        client.send(new DatagramPacket(msg, msg.length, InetAddress.getByName("203.162.10.109"), 2207));
        client.close();
    }
}
