/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import UDP.Customer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author trong
 */
public class UDP_Object {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        DatagramSocket client = new DatagramSocket();
        InetAddress server = InetAddress.getByName("203.162.10.109");
        
        byte[] msg = ";B21DCCN473;GepfqOjv".getBytes();
        client.send(new DatagramPacket(msg, msg.length, server, 2209));
        byte[] buff = new byte[1024];
        
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        client.receive(dp);
        String reqId = new String(buff, 0, 8);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(buff, 8, buff.length-8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        
        Customer customer = (Customer) ois.readObject();
        
        String fullName = customer.getName();
        customer.setName(formatName(fullName));
        
        String dob = customer.getDayOfBirth();
        customer.setDayOfBirth(formatDate(dob));
       
        String userName = generateUserName(fullName);  
        customer.setUserName(userName);
        
        System.out.println(customer);
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(customer);
        byte[] customerData = byteArrayOutputStream.toByteArray();

        
        byte[] requestIdBytes = reqId.getBytes();
        byte[] sendData = new byte[8 + customerData.length];
        System.arraycopy(requestIdBytes, 0, sendData, 0, 8);
        System.arraycopy(customerData, 0, sendData, 8, customerData.length); 

        
        client.send(new DatagramPacket(sendData, sendData.length, server, 2209));
        client.close();
    }
    
    public static String formatName(String fullName) {
        String[] nameParts = fullName.split(" ");
        String lastName = nameParts[nameParts.length - 1].toUpperCase();
        StringBuilder firstNames = new StringBuilder();
        for (int i = 0; i < nameParts.length - 1; i++) {
            firstNames.append(nameParts[i].substring(0, 1).toUpperCase())
                       .append(nameParts[i].substring(1).toLowerCase())
                       .append(" ");
        }
        return lastName + ", " + firstNames.toString().trim();
    }
    
    private static String formatDate(String date) {
        String[] parts = date.split("-");
        return parts[1] + "/" + parts[0] + "/" + parts[2];
    }
    
    private static String generateUserName(String fullName) {
        String[] nameParts = fullName.split(" ");
        String userName = "";
        for (String part : nameParts) {
            userName += part.substring(0, 1).toLowerCase();
        }
        userName += nameParts[nameParts.length - 1].substring(1).toLowerCase();
        return userName;
    }
}
