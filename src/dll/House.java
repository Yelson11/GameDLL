/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import java.util.HashMap;
/**
 *
 * @author Yelson
 */
public class House {
    
    private HashMap<String, Room> roomList;
    private Storage storage;
    
    public House(HashMap<String, Room> pRoomList, Storage pStorage){
        this.roomList = pRoomList;
        this.storage = pStorage;
    }

    public HashMap<String, Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(HashMap<String, Room> roomList) {
        this.roomList = roomList;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    
}
