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
    
    private String name;
    private HashMap<String, Integer> affectAttributeList;
    private HashMap<String, Integer> needAttributeList;
    private HashMap<String, String> cure;
    private int days;
    
    public Disease(String pName, HashMap<String, Integer> pAffectAttributeList, 
            HashMap<String, Integer> pNeedAttributeList, HashMap<String, String> pCure){
        this.name = pName;
        this.affectAttributeList = pAffectAttributeList;
        this.needAttributeList = pNeedAttributeList;
        this.cure = pCure;
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

    public HashMap<String, String> getPills() {
        return cure;
    }

    public void setPills(HashMap<String, String> pCure) {
        this.cure = pCure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getCure() {
        return cure;
    }

    public void setCure(HashMap<String, String> cure) {
        this.cure = cure;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    
}
