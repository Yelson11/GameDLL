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
    
    private ArrayList<AbstractItem> itemList;
    
    public Storage(ArrayList<AbstractItem> pItemList){
        this.itemList = pItemList;
    }

    public ArrayList<AbstractItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<AbstractItem> itemList) {
        this.itemList = itemList;
    }
   
}
