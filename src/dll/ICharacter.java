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
public interface ICharacter {
    
    public void accept( IVisitor visitor );
    
}
