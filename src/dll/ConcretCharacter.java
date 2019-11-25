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
public class ConcretCharacter extends Character implements IObservable, ICharacter {

    private ArrayList<Skill> skillList;
    private HashMap<String, ArrayList<IObserver>> observerHash;
    private IStrategy strategy;

    public ConcretCharacter(String pName, ArrayList<String> pImages, HashMap<String, Integer> pAttributeList, ArrayList<Weapon> 
        pUsedWeapons, Weapon pCurrentWeapon, ArrayList<Skill> pSkillList, HashMap<String, ArrayList<IObserver>> pIObserverHash){
        super(pName, pImages, pAttributeList, pUsedWeapons, pCurrentWeapon);
        this.skillList = pSkillList;
        this.observerHash = pIObserverHash;
    }

    @Override
    public void addObserver(String attribute, IObserver pIObserver) {
        if (this.observerHash.containsKey(attribute)){
            this.observerHash.get(attribute).add(pIObserver);
        }
        else{
            ArrayList<IObserver> observerList = new ArrayList<>();
            observerList.add(pIObserver);
            this.observerHash.put(attribute, observerList);
        }
    }

    @Override
    public void removeObserver(String attribute, IObserver pIObserver) {
        if (this.observerHash.containsKey(attribute)){
            this.observerHash.get(attribute).remove(pIObserver);
        }
    }
    
    @Override
    public void notifyAllObservers(String attribute) {
        if (this.observerHash.containsKey(attribute)){
            observerHash.get(attribute).forEach((observer) -> {               
                observer.notifyObserver(this);
            });
        }
    }
    
    //Aqui debe ir un mensaje para que el usuario acepte la enfermedad 
    @Override
    public void accept( IVisitor visitor ){
        visitor.visit(this);
    }
    
    public static class ConcretCharacterBuilder implements IBuilder<Character>{
         
        private ArrayList<Skill> skillList;
        private HashMap<String, ArrayList<IObserver>> observerHash;
        
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
        
        public ConcretCharacterBuilder addObserver(String attribute, IObserver pIObserver) {
            if (this.observerHash.containsKey(attribute)){
                this.observerHash.get(attribute).add(pIObserver);
            }
            else{
                ArrayList<IObserver> observerList = new ArrayList<>();
                observerList.add(pIObserver);
                this.observerHash.put(attribute, observerList);
            }
            return this;
        }
        
        public ConcretCharacterBuilder setSkillList(ArrayList<Skill> pSkillList) {
            this.skillList = pSkillList;
            return this;
        }

        public ConcretCharacterBuilder setObserverHash(HashMap<String, ArrayList<IObserver>> pObserverHash) {
            this.observerHash = pObserverHash;
            return this;
        }
  
        @Override
        public ConcretCharacter build() {
            return new ConcretCharacter(name, images, attributeList, usedWeapons, currentWeapon, skillList, observerHash);
        }
         
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }

    public HashMap<String, ArrayList<IObserver>> getObserverHash() {
        return observerHash;
    }

    public void setObserverHash(HashMap<String, ArrayList<IObserver>> observerHash) {
        this.observerHash = observerHash;
    }

    public IStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
    
}
