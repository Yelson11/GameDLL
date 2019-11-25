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
public abstract class AbstractItem implements ICure {
    
    private String name;
    private HashMap<Disease, Integer> list;
    
}
