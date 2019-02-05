package org.usfirst.frc4859.rover.utility;
import java.io.BufferedReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;

public class Duallidar {
    public int leftDistmm;
    public int rightDistmm;
    public double turnAngle;
    public boolean readSuccess;

    public boolean ReadMeasurements(){   
        Pattern pattern = Pattern.compile("\\[\\[\\[(\\d+),(\\d+),(\\d+\\.\\d+)\\]\\]\\]");
        Matcher matcher;
        try {
            URL lidarURL = new URL("http://10.48.59.17/");
            String inputLine;
            BufferedReader in = new BufferedReader( new InputStreamReader(lidarURL.openStream()));
            while ((inputLine = in.readLine()) != null) {
                //System.out.println(inputLine);
                matcher = pattern.matcher(inputLine);
                while(matcher.find()) {    
                    leftDistmm = Integer.parseInt(matcher.group(1));
                    rightDistmm = Integer.parseInt(matcher.group(2));
                    turnAngle = Double.parseDouble(matcher.group(3));
                }
            }
            in.close();
        }
         
         catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
        }
         
        return true;
    }

     
    public boolean Reset() {
        Pattern pattern = Pattern.compile("\\[\\[\\[(\\d+),(\\d+),(\\d+\\.\\d+)\\]\\]\\]");
        Matcher matcher;
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
    
    
    public void Duallidar() {

    }

}