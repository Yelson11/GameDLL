/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Storage {
    
    private ArrayList<Item> itemList;
    
    public Storage(ArrayList<Item> pItemList){
        this.itemList = pItemList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
   
}
