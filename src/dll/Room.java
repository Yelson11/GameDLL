/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

/**
 *
 * @author Yelson
 */
public class Room {
    
    private String name;
    private String image;

    public Room(String pName, String pImage){
        this.name = pName;
        this.image = pImage;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
