/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import RMI.CharacterService;
import java.net.MalformedURLException;
import java.rmi.*;
/**
 *
 * @author trong
 */
public class RMI_Character {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        CharacterService service = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        
        String respone = service.requestCharacter("B21DCCN473", "jirrBXPC");
        System.out.println(respone);
        
        String[] str = respone.split(";");
        
        String encoded = xorEncode(str[1], str[0]);
        
        System.out.println(encoded);
        
        service.submitCharacter("B21DCCN473", "jirrBXPC", encoded);
        
    }
    
    public static String xorEncode(String input, String key) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char keyChar = key.charAt(i % key.length());
            encoded.append((char) (inputChar ^ keyChar));
        }
        return encoded.toString();
    }
}
