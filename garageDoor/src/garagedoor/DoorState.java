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
    GarageDoor gd;
    public void closeDoor() { }
    
    public void openDoor() { }
    
    public void stopper() { }
}

class Open extends DoorState {
    Open(GarageDoor gd) {
        this.gd=gd;
    }
    @Override
    public void closeDoor() {
        gd.getMotor().downwards();
    }
}

class Closed extends DoorState {
    Closed(GarageDoor gd) {
        this.gd=gd;
    }
    @Override
    public void openDoor() {
        gd.getMotor().upwards();
    }
}

class Opening extends DoorState {
    Opening(GarageDoor gd) {
        this.gd=gd;
    }
    @Override
    public void stopper() {
        gd.getMotor().stop();
    }
    @Override
    public void closeDoor() {
        gd.getMotor().downwards();
    }
}

class Closing extends DoorState {
    Closing(GarageDoor gd) {
        this.gd=gd;
    }
    @Override
    public void stopper() {
        gd.getMotor().stop();
    }
    @Override
    public void openDoor() {
        gd.getMotor().upwards();
    }
}