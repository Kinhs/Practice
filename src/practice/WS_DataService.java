/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.util.List;

/**
 *
 * @author trong
 */
public class WS_DataService {
    public static void main(String[] args) {
        List<Integer> list = getData("B21DCCN473", "duUlZbWP");
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
        submitDataInt("B21DCCN473", "duUlZbWP", sum);
    }

    private static java.util.List<java.lang.Integer> getData(java.lang.String studentCode, java.lang.String qCode) {
        vn.medianews.DataService_Service service = new vn.medianews.DataService_Service();
        vn.medianews.DataService port = service.getDataServicePort();
        return port.getData(studentCode, qCode);
    }

    private static void submitDataInt(java.lang.String studentCode, java.lang.String qCode, int data) {
        vn.medianews.DataService_Service service = new vn.medianews.DataService_Service();
        vn.medianews.DataService port = service.getDataServicePort();
        port.submitDataInt(studentCode, qCode, data);
    }
    
    
}
