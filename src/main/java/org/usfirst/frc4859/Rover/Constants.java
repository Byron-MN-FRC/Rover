/**
 * Simple class containing constants used throughout project
 */

package org.usfirst.frc4859.Rover;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

//import org.usfirst.frc4859.Rover.Gains;

public class Constants {
	/**
	 * Which PID slot to pull gains from. Starting 2018, you can choose from
	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
	 * configuration.
	 */
	public static final int kSlotIdx = 0;

	/**
	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
	 * now we just want the primary one.
	 */
	public static final int kPIDLoopIdx = 0;

	/**
	 * set to zero to skip waiting for confirmation, set to nonzero to wait and
	 * report to DS if action fails.
	 */
	public static final int kTimeoutMs = 30;

	/**
	 * Gains used in Motion Magic, to be adjusted accordingly
     * Gains(kp, ki, kd, kf, izone, peak output);
     */
	public static final Gains kGains = new Gains(0.2, 0.0, 0.0, 0.2, 0, 1.0);
	
	public static TalonSRX kFeetMotor;

	public static DoubleSolenoid kGravityShifterSolenoid;
	//speeds for catapult
	public static final double kUpSpeed = .45;
	public static final double kUpTime = .45;
	public static final double kDownTime = .5;
	public static final double kDownSpeed = .15; 
	public static final double kBallAquireSpeed = .2;
	public static String kLiftHeight = "normal";
}