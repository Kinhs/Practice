/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vn.medianews.Order;

/**
 *
 * @author trong
 */
public class WS_ObjectService {
    
    public static void main(String[] args) {
        List<Order> orders = requestListOrder("B21DCCN473", "d0Ci3Ns0");
        
        String max = "";
        double maxVal = 0;
        
        Map<String, Double> map = new HashMap<>();
        
        for (Order order : orders) {
            map.put(order.getCustomerId(), map.getOrDefault(order.getCustomerId(), 0.0) + order.getAmount());
            if (map.get(order.getCustomerId()) > maxVal) {
                maxVal = map.get(order.getCustomerId());
                max = order.getCustomerId();
            }
        }
        
        List<Order> list = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId().equals(max)) 
                list.add(order);
        }
        submitListOrder("B21DCCN473", "d0Ci3Ns0", list);
    }

    private static java.util.List<vn.medianews.Order> requestListOrder(java.lang.String studentCode, java.lang.String qCode) {
        vn.medianews.ObjectService_Service service = new vn.medianews.ObjectService_Service();
        vn.medianews.ObjectService port = service.getObjectServicePort();
        return port.requestListOrder(studentCode, qCode);
    }

    private static void submitListOrder(java.lang.String studentCode, java.lang.String qCode, java.util.List<vn.medianews.Order> object) {
        vn.medianews.ObjectService_Service service = new vn.medianews.ObjectService_Service();
        vn.medianews.ObjectService port = service.getObjectServicePort();
        port.submitListOrder(studentCode, qCode, object);
    }
    
}
