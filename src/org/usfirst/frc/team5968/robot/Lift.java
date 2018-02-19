package org.usfirst.frc.team5968.robot;

import edu.wpi.first.wpilibj.DigitalInput;

<<<<<<< HEAD
import java.util.function.Consumer;

=======
>>>>>>> dbf063a37b8d18e22be1d013e8945e43c570c46f
import org.usfirst.frc.team5968.robot.PortMap.CAN;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

<<<<<<< HEAD
public class Lift implements ILift {

    private LiftHeight desiredHeight;
    private LiftHeight currentHeight;
    
    private DigitalInput groundLimit;
    private DigitalInput switchLimit;
    private DigitalInput scaleLimit;
    private DigitalInput topLimit;
    
    private TalonSRX liftMotor;
    
    private static double motorSpeed;
    
    private Drive drive;
    
    public Lift(IDrive drive) {
        liftMotor = new TalonSRX(PortMap.portOf(CAN.LIFT_MOTOR_CONTROLLER));
        motorSpeed = 0.2;
        drive = this.drive;
=======
public class Lift implements ILift{

    private LiftHeight desiredHeight;
    
    private LiftHeight currentHeight;
    
    DigitalInput groundLimit;
    
    DigitalInput switchLimit;
    
    DigitalInput scaleLimit;
    
    DigitalInput topLimit;
    
    TalonSRX liftMotor;
    
    double motorSpeed;
    
    public Lift() {
        liftMotor = new TalonSRX(PortMap.portOf(CAN.LIFT_MOTOR_CONTROLLER));
        motorSpeed = 0.2;
>>>>>>> dbf063a37b8d18e22be1d013e8945e43c570c46f
    }
    
    private void goTo (LiftHeight desiredHt) {
        desiredHeight = desiredHt;
    }
    
    public void goToGroundHeight() {
        goTo(LiftHeight.GROUND);
    }
    
    public void goToSwitchHeight() {
        goTo(LiftHeight.SWITCH);
    }
    
    public void goToScaleHeight() {
        goTo(LiftHeight.SCALE);
    }
    
   
    public void goToCurrentHeight() {
        
        // if x limit switch is triggered, go to that switch's height
        // else go to ground height
        
        if (groundLimit.get()) {
            goTo(LiftHeight.GROUND);
        } else {
            goTo(LiftHeight.GROUND);
        }
        
        if (switchLimit.get()) {
            goTo(LiftHeight.SWITCH);
        } else {
            goTo(LiftHeight.GROUND);
        }
        
        if (scaleLimit.get()) {
            goTo(LiftHeight.SCALE);
        } else {
            goTo(LiftHeight.GROUND);
        }
        
        if (topLimit.get()) {
            goTo(LiftHeight.TOP);
        } else {
            goTo(LiftHeight.GROUND);
        }
    }
    
<<<<<<< HEAD
    public static boolean moving() {
        if (motorSpeed > 0) {
            return true; 
        } else {
            return false;
        }
    }
=======
>>>>>>> dbf063a37b8d18e22be1d013e8945e43c570c46f
    public void periodic() {
        
        if (desiredHeight == LiftHeight.SCALE) {
            if (currentHeight == LiftHeight.GROUND || currentHeight ==  LiftHeight.SWITCH) {
                liftMotor.set(ControlMode.PercentOutput,motorSpeed);
            } else if (currentHeight == LiftHeight.TOP) {
                liftMotor.set(ControlMode.PercentOutput, -motorSpeed);
            }
        }
        
        else if (desiredHeight == LiftHeight.SWITCH) {
            if (currentHeight == LiftHeight.GROUND || currentHeight == LiftHeight.SCALE) {
                liftMotor.set(ControlMode.PercentOutput, motorSpeed);
            } else if (currentHeight == LiftHeight.TOP) {
                liftMotor.set(ControlMode.PercentOutput, -motorSpeed);
            }
        
    }
        
        else if (desiredHeight == LiftHeight.GROUND) {
            if (currentHeight == LiftHeight.SCALE ||currentHeight == LiftHeight.SWITCH) {
                liftMotor.set(ControlMode.PercentOutput, motorSpeed);
            } else if (currentHeight == LiftHeight.TOP) {
                liftMotor.set(ControlMode.PercentOutput, -motorSpeed);
            }
            
        }
    }
<<<<<<< HEAD

    @Override
    public void goToSwitchHeight(Consumer<IDrive> completionRoutine) {
        goToSwitchHeight();
        completionRoutine.accept(drive);
    }

    @Override
    public void goToScaleHeight(Consumer<IDrive> completionRoutine) {
        goToScaleHeight();
        completionRoutine.accept(drive);
        
    }

    @Override
    public void goToGroundHeight(Consumer<IDrive> completionRoutine) {
        goToGroundHeight();
        completionRoutine.accept(drive);
        
    }
    
=======
>>>>>>> dbf063a37b8d18e22be1d013e8945e43c570c46f
}
        
 
    
        
  