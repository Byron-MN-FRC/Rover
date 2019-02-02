package org.usfirst.frc4859.Rover.utility;
import java.io.BufferedReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;

public class Duallidar {
    public static void main(String[] args) throws Exception {
        Pattern pattern = Pattern.compile("\\[\\[\\[(\\d+),(\\d+),(\\d+\\.\\d+)\\]\\]\\]");
        Matcher matcher;
        URL lidarURL = new URL("http://10.48.59.17/");
        String inputLine;
        try {
            BufferedReader in = new BufferedReader( new InputStreamReader(lidarURL.openStream()));
            while ((inputLine = in.readLine()) != null) {
                //System.out.println(inputLine);
                matcher = pattern.matcher(inputLine);
                while(matcher.find()) {
                     System.out.println(matcher.group(1));
                     System.out.println(matcher.group(2));
                     System.out.println(matcher.group(3));
                }
            }
            in.close();
         } catch (Exception ex) {
               System.out.println(ex.getMessage());
         }
     }
     
}