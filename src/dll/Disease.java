/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Yelson
 */
public class Disease implements IVisitor, IObserver{
    
    private HashMap<String, Integer> affectAttributeList;
    private HashMap<String, Integer> needAttributeList;
    private ArrayList<String> pills;
    
    public Disease(HashMap<String, Integer> pAffectAttributeList, 
            HashMap<String, Integer> pNeedAttributeList, ArrayList<String> pPills){
        this.affectAttributeList = pAffectAttributeList;
        this.needAttributeList = pNeedAttributeList;
        this.pills = pPills;
    }

    @Override
    public void notifyObserver(Object source) {
        boolean state = true;
        ConcretCharacter character = (ConcretCharacter)source;
        for (HashMap.Entry<String, Integer> entry : needAttributeList.entrySet()) {
            if (character.getAttributeList().get(entry.getKey()) < entry.getValue() ){
                state = false;
                break;
            }
        }
        if (state){
            character.accept(this);
        }
    }
    
    @Override
    public void visit(ConcretCharacter pConcretCharacter) {
        //Aqui hay que poner que hace quita la enfermedad
        for (HashMap.Entry<String, Integer> entry : affectAttributeList.entrySet()) {
            int value = pConcretCharacter.getAttributeList().get(entry.getKey());
            value = value - entry.getValue(); //aqui hay que preguntar que no sea negativo
            pConcretCharacter.getAttributeList().replace(entry.getKey(), value);
        }
    }

    //no se usa
    @Override
    public void visit(List<ICharacter> pICharacterList) {
        pICharacterList.forEach((character) -> {
            character.accept(this);
        });
    }

    public HashMap<String, Integer> getAffectAttributeList() {
        return affectAttributeList;
    }

    public void setAffectAttributeList(HashMap<String, Integer> affectAttributeList) {
        this.affectAttributeList = affectAttributeList;
    }

    public HashMap<String, Integer> getNeedAttributeList() {
        return needAttributeList;
    }

    public void setNeedAttributeList(HashMap<String, Integer> needAttributeList) {
        this.needAttributeList = needAttributeList;
    }

    public ArrayList<String> getPills() {
        return pills;
    }

    public void setPills(ArrayList<String> pills) {
        this.pills = pills;
    }
    
}
