/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author trong
 */
public class WS_CharacterService {
    public static void main(String[] args) {
        List<Integer> list = requestCharacter("B21DCCN473", "wjlBocxc");
        
        Collections.sort(list);
        
        submitCharacterCharArray("B21DCCN473", "wjlBocxc", list);
    }

    private static java.util.List<java.lang.Integer> requestCharacter(java.lang.String studentCode, java.lang.String qCode) {
        vn.medianews.CharacterService_Service service = new vn.medianews.CharacterService_Service();
        vn.medianews.CharacterService port = service.getCharacterServicePort();
        return port.requestCharacter(studentCode, qCode);
    }

    private static void submitCharacterCharArray(java.lang.String studentCode, java.lang.String qCode, java.util.List<java.lang.Integer> data) {
        vn.medianews.CharacterService_Service service = new vn.medianews.CharacterService_Service();
        vn.medianews.CharacterService port = service.getCharacterServicePort();
        port.submitCharacterCharArray(studentCode, qCode, data);
    }
}
