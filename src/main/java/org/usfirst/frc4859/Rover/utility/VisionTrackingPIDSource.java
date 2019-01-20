package org.usfirst.frc4859.Rover.utility;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class VisionTrackingPIDSource implements PIDSource {
    public enum DataSource {
        TargetHorizontalOffset, 
        TargetVerticalOffset, 
        TargetAreaPercentage, 
        TargetSkew,
        TargetSideLengthShortest,
        TargetSideLenghtLongest,
        TargetHorizSideLengthRoughBox,
        TargetVertSideLengthRoughbox;
    }

    private DataSource visionTrackingSource;
    
    private PIDSourceType pidSrcType = PIDSourceType.kDisplacement;

    public VisionTrackingPIDSource(DataSource source){
        visionTrackingSource = source;
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
      double value;
      LimelightUtility.RefreshTrackingData();

      switch(visionTrackingSource) {
        case TargetSkew: 
            value = LimelightUtility.TargetSkew;
            break;
        case TargetHorizontalOffset: 
            value = LimelightUtility.TargetHorizontalOffset;
            break;
        case TargetVerticalOffset: value = 
            LimelightUtility.TargetVerticalOffset;
            break;
        case TargetAreaPercentage: value = 
            LimelightUtility.TargetAreaPercentage;
            break;
        case TargetSideLengthShortest: value = 
            LimelightUtility.TargetSideLengthShortest;
            break;
        case TargetSideLenghtLongest: value = 
            LimelightUtility.TargetSideLenghtLongest;
            break;
        case TargetHorizSideLengthRoughBox: value = 
            LimelightUtility.TargetHorizSideLengthRoughBox;
            break;
        case TargetVertSideLengthRoughbox: value = 
            LimelightUtility.TargetVertSideLengthRoughbox;
            break;
        default: value = 0.0;
      }
      
      return value;
  }
}
