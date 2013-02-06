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
    private DoorState myDoorState;
    private final Motor myMotor;    
    /*initialize all states*/
    private final DoorState opn = new Open();
    private final DoorState clsd = new Closed();
    private final DoorState opng = new Opening();
    private final DoorState clsg = new Closing();
    
    /**
     * this is the constructor which sets a new motor and
     * the sets door state to closed
     */
    public GarageDoor() {
        myMotor=new Motor(this);
        myDoorState = clsd;
    }
    
    
    public void closeDoor() {
        myDoorState.closeDoor();
    }
    
    public void openDoor() {
        myDoorState.openDoor();
    }
    
    public void stopper() {
        myDoorState.stopper();
    }
    /**
     * getter for our motor
     * @return Motor mymotor
     */
    public Motor getMotor() {
        return myMotor;
    }
    /**
     * 
     * @return DoorState myDoorState
     */
    public DoorState currentState() {
        return myDoorState;
    }
    /**
     * inner class 
     */
    public abstract class DoorState {
    public void closeDoor() { }
    
    public void openDoor() { }
    
    public void stopper() { }
    }

    /*
     * each class below this comment is a state in which the garage gate can be in
     */

class Open extends DoorState {
    Open() { }
    @Override
    public void closeDoor() {
        myMotor.downwards();
        myDoorState=clsg;
    }
    @Override
    public void openDoor() {}
    @Override
    public void stopper() {}
}

 class Closed extends DoorState {
    Closed() {    }
    @Override
    public void openDoor() {
       myMotor.upwards();
       myDoorState=opng;
    }
    @Override
    public void closeDoor() {}
    @Override
    public void stopper() {}
}

 class Opening extends DoorState {
    Opening() {    }
    @Override
    public void stopper() {
        myMotor.stop();
        myDoorState=opn;
    }
    @Override
    public void closeDoor() {
        myMotor.downwards();
        myDoorState=clsg;
    }
    @Override
    public void openDoor() {}
}

 class Closing extends DoorState {
    Closing() {    }
    @Override
    public void stopper() {
        myMotor.stop();
        myDoorState=clsd;
        
    }
    @Override
    public void openDoor() {
        myMotor.upwards();
        myDoorState=opng;
    }
    @Override
    public void closeDoor() {}
}

  
  
}
    
