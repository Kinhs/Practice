/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import RMI.DataService;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author trong
 */
public class RMI_Data {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        DataService service = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        
        String data = (String) service.requestData("B21DCCN473", "UKR8rv87");
        
        System.out.println(data);
        
        String[] str = data.split("; ");
        int k = Integer.parseInt(str[1]);
        
        String[] num = str[0].split(", ");
        int[] arr = new int[num.length];
        
        for (int i = 0; i < num.length; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }
        
        List<List<Integer>> combination = getCombinations(arr, k);
        
        service.submitData("B21DCCN473", "UKR8rv87", combination);
    }
    
    public static void generateCombinations(int[] arr, int k, int startIndex, List<Integer> currentCombination, List<List<Integer>> result) {
        // Nếu tổ hợp đủ k phần tử, thêm vào danh sách kết quả
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Duyệt các phần tử từ startIndex
        for (int i = startIndex; i < arr.length; i++) {
            currentCombination.add(arr[i]); // Thêm phần tử vào tổ hợp
            generateCombinations(arr, k, i + 1, currentCombination, result); // Gọi đệ quy
            currentCombination.remove(currentCombination.size() - 1); // Loại bỏ phần tử cuối để thử các khả năng khác
        }
    }

    public static List<List<Integer>> getCombinations(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(arr, k, 0, new ArrayList<>(), result);
        return result;
    }
}
