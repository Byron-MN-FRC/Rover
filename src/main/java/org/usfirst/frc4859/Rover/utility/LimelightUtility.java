package org.usfirst.frc4859.Rover.utility;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightUtility {

    static private double tv;      //Whether the limelight has any valid targets (0 or 1)
    static private double tx;	    //Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees)
    static private double ty;	    //Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
    static private double ta;	    //Target Area (0% of image to 100% of image)
    static private double ts;	    //Skew or rotation (-90 degrees to 0 degrees)
    static private double tl;	    //The pipeline’s latency contribution (ms) Add at least 11ms for image capture latency.
    static private double tshort;	//Sidelength of shortest side of the fitted bounding box (pixels)
    static private double tlong;	//Sidelength of longest side of the fitted bounding box (pixels)
    static private double thoriz;	//Horizontal sidelength of the rough bounding box (0 - 320 pixels)
    static private double tvert;	//Vertical sidelength of the rough bounding box (0 - 320 pixels)

    static public boolean ValidTargetFound() { return tv != 0.0; }     //Whether the limelight has any valid targets (0 or 1)
    static public double HorizontalOffset;                             //Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees)
    static public double VerticalOffset;                               //Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
    static public double TargetAreaPercentage;                         //Target Area (0% of image to 100% of image)
    static public double Skew;                                         //Skew or rotation (-90 degrees to 0 degrees)
    static public double PipelineLatency;                              //The pipeline’s latency contribution (ms) Add at least 11ms for image capture latency.
    static public double TargetSideLenghtShortest;                     //Sidelength of shortest side of the fitted bounding box (pixels)
    static public double TargetSideLenghtLongest;                      //Sidelength of longest side of the fitted bounding box (pixels)
    static public double TargetHorizSideLengthRoughBox;                //Horizontal sidelength of the rough bounding box (0 - 320 pixels)
    static public double TargetVertSideLengthRoughbox;                 //Vertical sidelength of the rough bounding box (0 - 320 pixels)

    static public void RefreshTrackingData() {
        tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
        ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
        ts = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
        tl = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tl").getDouble(0);
        tshort = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(0);
        tlong  = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(0);
        thoriz = NetworkTableInstance.getDefault().getTable("limelight").getEntry("thoriz").getDouble(0);
        tvert  = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tvert").getDouble(0);

        HorizontalOffset                = tv;
        VerticalOffset                  = tx;
        TargetAreaPercentage            = ty;
        Skew                            = ts;
        PipelineLatency                 = tl;
        TargetSideLenghtShortest        = tshort;
        TargetSideLenghtLongest         = tlong;
        TargetHorizSideLengthRoughBox   = thoriz; 
        TargetVertSideLengthRoughbox    = tvert;
    }
}