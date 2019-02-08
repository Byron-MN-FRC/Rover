package org.usfirst.frc4859.Rover.utility;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class DualLidarTrackingPIDSource implements PIDSource {

    
    private PIDSourceType pidSrcType = PIDSourceType.kDisplacement;

    public DualLidarTrackingPIDSource(){
    }
  /**
   * Set which parameter of the device you are using as a process control variable.
   *
   * @param pidSource An enum to select the parameter.
   */
  public void setPIDSourceType(PIDSourceType pidSource){
    pidSrcType = pidSource;
  }

  /**
   * Get which parameter of the device you are using as a process control variable.
   *
   * @return the currently selected PID source parameter
   */
  public PIDSourceType getPIDSourceType(){
    return pidSrcType;
  }

  /**
   * Get the result to use in PIDController.
   *
   * @return the result to use in PIDController
   */
  public double pidGet(){
      double angle = 0;
      if (Duallidar.RefreshTrackingData()){
        // the PID is set up to expect an angle between -60 and 60 degrees
        // if the tracking data is only reporting one distance and no angle,
        // generate a positive or negative angle proportional to 
        // that distance.
        // If we are getting an angle, simply return it
        int left = Duallidar.leftDistmm;
        int right = Duallidar.rightDistmm;
        angle = Duallidar.turnAngle;

        if (angle == -9999.0) {
            if (left != 9999)  { angle = -45.0; }  // slide to the right
            if (right != 9999) { angle =  45.0; }  // slide to the left
        }
      }  
      return angle;
  }
}
