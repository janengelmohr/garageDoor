/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package garagedoor;

/**
 *
 * @author jan
 */
public class GarageDoor {

    private DoorState state;
    private Motor myMotor;
    
    public GarageDoor() {
        state=new Closed();
        myMotor=new Motor(this);
    }
    
    
    public void closeDoor() {
        state.closeDoor();
    }
    
    public void openDoor() {
        state.openDoor();
    }
    
    public void stopper() {
        state.stopper();
    }
    
    public Motor getMotor() {
        return myMotor;
    }
    
    public DoorState currentState() {
        return state;
    }
}
