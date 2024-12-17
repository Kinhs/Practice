/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import TCP.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author trong
 */


public class TCP_ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("203.162.10.109", 2209);
        System.out.println(client);
        
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject("B21DCCN473;uYvyUiYf");
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        Student student = (Student)ois.readObject();
        System.out.println(student.getGpa());
        
        student.setGpaLetter(toLetter(student.getGpa()));
        oos.writeObject(student);
        ois.close();
        oos.close();
        client.close();
    }
    
    public static String toLetter(float f) {
        if (3.7 < f && f<= 4) {
            return "A";
        }
        
        if (3 < f && f <= 3.7) {
            return "B";
        }
        
        if (2 < f && f <= 3) {
            return "C";
        }
        
        if (1 < f && f <= 2) {
            return "D";
        }
        
        return "F";
    }
}
