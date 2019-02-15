package org.usfirst.frc4859.Rover.utility;
import java.io.BufferedReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;

public class Duallidar {
    public static int leftDistmm;
    public static int rightDistmm;
    public static double turnAngle;
    public static boolean readSuccess;

    public static boolean RefreshTrackingData(){ 
        boolean success = false;  
        Pattern pattern = Pattern.compile("\\[\\[\\[(\\d+),(\\d+),([-+]?\\d+\\.\\d+)\\]\\]\\]");
        Matcher matcher;
        int leftDist = -9999;
        int rightDist = -9999;
        double angle = -9999.0;
        try {
            URL lidarURL = new URL("http://10.48.59.17/");
            String inputLine;
            BufferedReader in = new BufferedReader( new InputStreamReader(lidarURL.openStream()));
            while ((inputLine = in.readLine()) != null) {
                //System.out.println(inputLine);
                matcher = pattern.matcher(inputLine);
                if (matcher.find()) {    
                    leftDist = Integer.parseInt(matcher.group(1));
                    rightDist = Integer.parseInt(matcher.group(2));
                    angle = Double.parseDouble(matcher.group(3));
                    if ((leftDist  < 0) || (leftDist  > 8100)) { leftDist  = -9999; turnAngle = -9999.0; }
                    if ((rightDist < 0) || (rightDist > 8100)) { rightDist = -9999; turnAngle = -9999.0; }
                    success = true;
                }
            }
            in.close();
        }
         
         catch (Exception e) {
                System.out.println(e.getMessage());
                success = false;
        }
        
        // the right, left, and turn will be set to the value from the sensor or -9999 if not able to read.
        rightDistmm = rightDist;
        leftDistmm  = leftDist;
        turnAngle   = angle;
        return success;
    }

     
    public static boolean Reset() {
        try {
            URL lidarURL = new URL("http://10.48.59.17?reset");
            String inputLine;
            BufferedReader in = new BufferedReader( new InputStreamReader(lidarURL.openStream()));
            while ((inputLine = in.readLine()) != null) {
            }
            in.close();
        }
         
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
         
        return true;
        }
}