package org.usfirst.frc4859.Rover.utility;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class VisionTrackingPIDSource implements PIDSource {
    private double _lastValidValue = 0; 
    private boolean _initialRead = true;
    private double _percentTollerance;
    private double _range;
    private double _setPoint; 

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

    public VisionTrackingPIDSource(DataSource source, double percentTollerance, double setPoint){
        _setPoint = setPoint;
        _percentTollerance = percentTollerance;
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
            _range = 90;
            break;
        case TargetHorizontalOffset: 
            value = LimelightUtility.TargetHorizontalOffset;
            _range = 54; // -27 to 27
            break;
        case TargetVerticalOffset: 
            value = LimelightUtility.TargetVerticalOffset;
            _range = 41; // -20.5 to 20.5
            break;
        case TargetAreaPercentage: value = 
            LimelightUtility.TargetAreaPercentage;
            _range = 100;
            break;
        case TargetSideLengthShortest: value = 
            LimelightUtility.TargetSideLengthShortest;
            _range = 320;
            break;
        case TargetSideLenghtLongest: value = 
            LimelightUtility.TargetSideLenghtLongest;
            _range = 320;
            break;
        case TargetHorizSideLengthRoughBox: 
            value = LimelightUtility.TargetHorizSideLengthRoughBox;
            _range = 320;
            break;
        case TargetVertSideLengthRoughbox: 
            value = LimelightUtility.TargetVertSideLengthRoughbox;
            _range = 320;
            break;
        default: 
            value = 0.0;
            _range = 100;
      }

      // lets now compare this value to the previous value
      if (!_initialRead)
      {
        double diff = Math.abs(value - _lastValidValue);
        double percentDif = diff / _range; //
        if (percentDif <= _percentTollerance) {
            _lastValidValue = value;
        } else {
            // we have aquired another target, best to ignore and return the requested set point
            value = _setPoint;
        }
      } else {
          // The first time in, simply use the value returned by limelight. 
          _lastValidValue = value;
          _initialRead = false;
      }
      return value;
  }
}
