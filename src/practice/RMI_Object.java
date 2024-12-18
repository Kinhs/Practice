/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import RMI.ObjectService;
import RMI.Product;
import java.net.MalformedURLException;
import java.rmi.*;
/**
 *
 * @author trong
 */
public class RMI_Object {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        
        ObjectService service = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        
        Product product = (Product) service.requestObject("B21DCCN473", "nNu8ywoW");
        
        System.out.println(product.getCode());
        
        product.setCode(product.getCode().toUpperCase());
        product.setExportPrice(product.getImportPrice() * 1.2);
        
        service.submitObject("B21DCCN473", "nNu8ywoW", product);
        
    }
}
