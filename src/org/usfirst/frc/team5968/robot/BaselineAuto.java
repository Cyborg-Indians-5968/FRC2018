package org.usfirst.frc.team5968.robot;

import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class BaselineAuto implements IRobotMode {
	
	StartingPoint startingPoint;
	Alliance alliance;

    public doBaseline(StartingPoint s, Alliance a) {
        startingPoint = s;
        alliance = a;
    }
    
    /*
	 * Execute the movements for auto mode: SCALE only
	 */
	public void autoBaseline() {
		
	}

}
