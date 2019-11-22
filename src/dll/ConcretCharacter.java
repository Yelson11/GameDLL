/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import java.util.ArrayList;
import java.util.HashMap;
import library.Character;
import library.*;
/**
 *
 * @author Yelson
 */
public class ConcretCharacter extends Character implements IObserver {

    private ArrayList<Skill> skillList;
    private ArrayList<IObserver> observerList;

    public ConcretCharacter(String pName, ArrayList<String> pImages, HashMap<String, Integer> pAttributeList, ArrayList<Weapon> 
           pUsedWeapons, Weapon pCurrentWeapon, ArrayList<Skill> pSkillList, ArrayList<IObserver> pIObserverList){
        super(pName, pImages, pAttributeList, pUsedWeapons, pCurrentWeapon);
        this.skillList = pSkillList;
        this.observerList = pIObserverList;
    }

    @Override
    public void notifyObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static class ConcretCharacterBuilder implements IBuilder<Character>{
         
        private ArrayList<Skill> skillList;
        private ArrayList<IObserver> observerList;
        
        private String name;
        private ArrayList<String> images;
        private HashMap<String, Integer> attributeList;
        private ArrayList<Weapon> usedWeapons;
        private Weapon currentWeapon;
        
        public ConcretCharacterBuilder(){
            //Atributos por default
            this.name = "Character";
            this.images = new ArrayList<>();
            this.attributeList = new HashMap<>();
            this.usedWeapons = new ArrayList<>();
            this.currentWeapon=null;
        }
        
        public ConcretCharacterBuilder setCharacter(Character pCharacter){
            this.name = pCharacter.getName();
            this.images = pCharacter.getImages();
            this.attributeList = pCharacter.getAttributeList();
            this.usedWeapons = pCharacter.getUsedWeapons();
            this.currentWeapon = pCharacter.getCurrentWeapon();
            return this;
        }
        
        public ConcretCharacterBuilder addName(String pName){
            this.name = pName;
            return this;
        }
        
        public ConcretCharacterBuilder addImage(String pImage){
            this.images.add(pImage);
            return this;
        }
        
        public ConcretCharacterBuilder addAttribute(String pAttribute, int pValue){
            this.attributeList.put(pAttribute, pValue);
            return this;
        }
        
        public ConcretCharacterBuilder addAttribute(String pAttribute){
            this.attributeList.put(pAttribute, 0);
            return this;
        }
        
        public ConcretCharacterBuilder addUsedWeapon(Weapon pWeapon){
            this.usedWeapons.add(pWeapon);
            return this;
        }
        
        public ConcretCharacterBuilder addCurrentWeapon(Weapon pCurrentWeapon) {
            this.currentWeapon = pCurrentWeapon;
            return this;
        }
        
        public ConcretCharacterBuilder addSkill(Skill pSkill) {
            this.skillList.add(pSkill);
            return this;
        }
        
        public ConcretCharacterBuilder addObserver(IObserver pIObserver) {
            this.observerList.add(pIObserver);
            return this;
        }
        
        public ConcretCharacterBuilder setSkillList(ArrayList<Skill> pSkillList) {
            this.skillList = pSkillList;
            return this;
        }

        public ConcretCharacterBuilder setObserverList(ArrayList<IObserver> pObserverList) {
            this.observerList = pObserverList;
            return this;
        }
  
        @Override
        public ConcretCharacter build() {
            return new ConcretCharacter(name, images, attributeList, usedWeapons, currentWeapon, skillList, observerList);
        }
         
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }

    public ArrayList<IObserver> getObserverList() {
        return observerList;
    }

    public void setObserverList(ArrayList<IObserver> observerList) {
        this.observerList = observerList;
    }
    
    
    
}
