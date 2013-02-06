/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package garagedoor;

/**
 *
 * @author jan
 */
public abstract class DoorState {
    
    public void closeDoor() { }
    
    public void openDoor() { }
    
    public void stopper() { }
}

class Open extends DoorState {
    @Override
    public void closeDoor() {
        
    }
}

class Closed extends DoorState {
    
}

class Opening extends DoorState {
    
}

class Closing extends DoorState {
    
}