/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author trong
 */
public class TCP_CharacterStream {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2208);
        System.out.println(client);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        
        bw.write("B21DCCN473;bg2qAzIg");
        bw.newLine();
        bw.flush();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s = br.readLine();
        
        System.out.println(s);
        
        char[] arr = s.toCharArray();
        Map<Character, Integer> m = new LinkedHashMap<>();
        for (char c : arr) {
            if (c == ' ') continue;
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : m.keySet()) {
            if (m.get(c) > 1) {
                sb.append(c);
                sb.append(':');
                sb.append(m.get(c));
                sb.append(',');
            }
        }
        System.out.println(sb);
        bw.write(sb.toString());
        bw.close();
        br.close();
        client.close();
    }
}
