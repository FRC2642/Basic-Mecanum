
package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Timer;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	RobotDrive drive;
    Joystick joystick1;
    
    final int frontLeftChannel	= 2;
    final int rearLeftChannel	= 3;
    final int frontRightChannel	= 1;
    final int rearRightChannel	= 0;
    final int joystick1Channel = 0;
    
    public void robotInit() {
    	drive.setExpiration(0.1);
    	drive = new RobotDrive(frontLeftChannel, rearLeftChannel, frontRightChannel, rearRightChannel);
    	drive.setInvertedMotor(MotorType.kFrontLeft, true);	// invert the left side motors
    	drive.setInvertedMotor(MotorType.kRearLeft, true);	
    	joystick1 = new Joystick(joystick1Channel);
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	drive.setSafetyEnabled(false);
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        while(isOperatorControl() && isEnabled()){
        	drive.setSafetyEnabled(true);
        	drive.mecanumDrive_Cartesian(joystick1.getX(), joystick1.getY(), joystick1.getZ(), 0);
        }
        Timer.delay(0.005);	
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
