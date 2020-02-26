/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.Enterprise.Enterprise;
import Business.Enterprise.MunicipalEnterprise;
import java.util.ArrayList;

/**
 *
 * @author pranav
 */
public class InventoryDirectory {
    
    private ArrayList<InventoryItem> inventoryList;
    
    public InventoryDirectory() {
        inventoryList = new ArrayList<InventoryItem>();
    }
    
    /*
    Add InventoryItem to the list
    */
    public InventoryItem createItem(Enterprise enterprise, String name, String type, int quantity,  int price){
            
        InventoryItem newItem = new InventoryItem();
        
            System.out.println("Item Doesn't Exist so adding to the list");
            newItem.setItemName(name);
            newItem.setQuantity(quantity);
            newItem.setItemType(type);
            newItem.setPrice(price);
            
            //inventoryList.add(newItem);
            //System.out.println("size inside is "+ inventoryList.size());
            
        
        return newItem;
    }
    
    
    /*
    Getters and Setters
    */
    public ArrayList<InventoryItem> getInventoryList() {
     
        return inventoryList;
    }

    public void setInventoryList(ArrayList<InventoryItem> inventoryList) {
        this.inventoryList = inventoryList;
    }
    
}
