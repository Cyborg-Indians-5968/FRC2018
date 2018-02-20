package org.usfirst.frc.team5968.robot;

public class ScaleAuto {
	
	private StartingPoint startingPoint;
    private IDrive drive; 
    private IGrabber grabber;
    private ILift lift;
    private double rotationSpeed = 0.2;
    private double driveSpeed = 0.2;

    public ScaleAuto(StartingPoint s) {
        startingPoint = s;
        drive = new Drive();
        //grabber = new Grabber();
        //grabber.grab();
        //lift = new Lift(drive);
        goStraightLong();
    }
    
    /*
	 * FIRST STEP: go straight 324 inches
	 */	
	public void goStraightLong() {
		drive.driveDistance(324.0, 0.4, lift -> liftGrabber());
	}
	
	/*
	 * SECOND STEP: lift the grabber to the highest preset
	 */	
	public void liftGrabber() {
		if (startingPoint == StartingPoint.LEFT) {
			//lift.goToScaleHeight(drive -> turnRight());
		    turnRight();
		} else if (startingPoint==StartingPoint.RIGHT) {
			//lift.goToScaleHeight(drive -> turnLeft());
		    turnLeft();
		}
	}
	
	/*
	 * THIRD STEP A: turn right towards scale
	 */	
	public void turnRight() {
		//drive.rotateDegrees(90.0, drive -> goStraightShort(drive));
		drive.rotateDegrees(90.0, rotationSpeed/*, drive -> openGrabber()*/);
	}
	
	/*
	 * THIRD STEP B: turn left towards scale
	 */	
	public void turnLeft() {
		//drive.rotateDegrees(-90.0, drive -> goStraightShort(drive));
		drive.rotateDegrees(-90.0, rotationSpeed/*, grabber -> openGrabber()*/);
	}

	/*
	 * FOURTH STEP: go straight a small amount of inches 
	 * PROBABLY UNNECESSARY AS OF NOW
	public void goStraightShort(IDrive drive) {
		drive.driveDistance(0.5, 30.0, drive -> openGrabber(drive));
	}
	*/	
	
	/*
	 * FIFTH STEP: open the grabber
	 */	
	public void openGrabber() {
		grabber.release();
	}
	
}
