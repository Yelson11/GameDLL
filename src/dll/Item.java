/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Item implements IItem{
    
    private String name;
    private HashMap<String, Integer> attributlist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setList(HashMap<String, Integer> pAttributlist) {
        this.attributlist = pAttributlist;
    }

    @Override
    public HashMap<String, Integer> getAttributList() {
        return attributlist;
    }
    
}
