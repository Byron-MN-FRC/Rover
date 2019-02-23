/**
 * Simple class containing constants used throughout project
 */

package org.usfirst.frc4859.Rover;

import java.util.HashMap;
import java.util.Map;

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
	
	// Speeds for catapult & aquisition
	public static final double kUpSpeed = .7;
	public static final double kUpTime = .45;
	public static final double kDownTime = .5;
	public static final double kDownSpeed = .15; 
	public static final double kBallAquireSpeed = -.75;

	// Lift
	public static final Map<String, Integer > liftPosition = new HashMap<String, Integer> () {

		{
		   put("normal", new Integer(0));
		   put("cargo", new Integer(100));
		   put("rocket", new Integer (60));
	}};	

	  // Catapult Speed and Time
	  public static final Map<String, double[]> catapultVariables = new HashMap<String, double[]> () {

		private static final long serialVersionUID = 1L;
	
		{	   //name                              UpSpeed   UpTime   DownSpeed  DownTime 
			put("CargoBall",         new double[]  { .45	, .45    , .45    , .45 	,  2920} );
			put("CargoHatch",  	     new double[]  { .55	, .55    , .55    , .55  	,  0} );
			put("LowRocketBall",     new double[]  { .65    , .65    , .65    , .65  	,  0} );
			put("LowRocketHatch",    new double[]  { .35    , .35    , .35    , .35     ,  0} );
			put("MidRocketBall",     new double[]  { .65    , .65    , .65    , .65  	,  6813} );
			put("MidRocketHatch",    new double[]  { .35    , .35    , .35    , .35     ,  6813} )
		}};
}

