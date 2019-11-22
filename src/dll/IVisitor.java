/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IVisitor {
    
    public void visit(ICharacter pICharacter);
    public void visit( List<ICharacter> elementList );
}
