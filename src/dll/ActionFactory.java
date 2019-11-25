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
public class ActionFactory {
    
    private HashMap<String, IStrategy> actionList;

    public ActionFactory(HashMap<String, IStrategy> pActionList){
        this.actionList = pActionList;
    }
    
    public HashMap<String, IStrategy> getActionList() {
        return actionList;
    }

    public void setActionList(HashMap<String, IStrategy> actionList) {
        this.actionList = actionList;
    }
    
}
