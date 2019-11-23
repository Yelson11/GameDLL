/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

/**
 *
 * @author Administrator
 */
public interface IObservable {
    
    public void addObserver(String attribute, IObserver pIObserver);       
    public void removeObserver(String attribute, IObserver pIObserver);       
    //public void notify(IObserver observer);
    public void notifyAllObservers(String attribute);
    
}
