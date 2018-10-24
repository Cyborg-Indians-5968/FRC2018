package org.usfirst.frc.team5968.robot;

public interface IGrabber {
    
    public void grab();
    public void shoot();
    public void deploy();
    
    /*
     * Called periodically to execute the actions stated above
     */
    public void periodic();
    void setSpeed(double speed);
    
}
