/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import RMI.ByteService;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author trong
 */
public class RMI_Byte {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        ByteService service = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        
        byte[] response = service.requestData("B21DCCN473", "WIJrUJQ6");
        
        Map<Byte, Integer> map = new HashMap<>();
        byte max = 0;
        int maxVal = 0;
        
        for (byte b : response) {
            map.put(b, map.getOrDefault(b, 0) + 1);
            if (map.get(b) > maxVal) {
                max = b;
                maxVal = map.get(b);
            }
        }
        
        byte[] sub = new byte[2];
        sub[0] = max;
        sub[1] = (byte) maxVal;
        service.submitData("B21DCCN473", "WIJrUJQ6", sub);
    }
}
