package org.usfirst.frc27.Robot.subsystems;

import org.usfirst.frc27.Robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.ColorMode;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;
import com.ni.vision.NIVision.MeasurementType;
import com.ni.vision.NIVision.OverlayTextOptions;
import com.ni.vision.NIVision.Point;
import com.ni.vision.NIVision.RGBValue;
import com.ni.vision.NIVision.Rect;
import com.ni.vision.NIVision.ShapeMode;

/**
 * This is a demo program showing the use of the NIVision class to do vision processing. 
 * The image is acquired from the USB Webcam, then a circle is overlayed on it. 
 * The NIVision class supplies dozens of methods for different types of processing. 
 * The resulting image can then be sent to the FRC PC Dashboard with setImage()
 */
public class Vision extends Subsystem{
	int session;
    Image frame;
    Image binaryFrame;
    
    NIVision.RawData colorTable;
    CameraServer server;
    
	NIVision.Range HUE_RANGE = new NIVision.Range(140, 20);	
	NIVision.Range SAT_RANGE = new NIVision.Range(0, 0);	
	NIVision.Range VAL_RANGE = new NIVision.Range(251, 500);

	
	  private static String ATTR_VIDEO_MODE = "AcquisitionAttributes::VideoMode";
	  private static String ATTR_WB_MODE = "CameraAttributes::WhiteBalance::Mode";
	  private static String ATTR_WB_VALUE = "CameraAttributes::WhiteBalance::Value";
	  private static String ATTR_EX_MODE = "CameraAttributes::Exposure::Mode";
	  private static String ATTR_EX_VALUE = "CameraAttributes::Exposure::Value";
	  private static String ATTR_BR_MODE = "CameraAttributes::Brightness::Mode";
	  private static String ATTR_BR_VALUE = "CameraAttributes::Brightness::Value";
	  private static double minArea = 100;
	  private static double maxArea = 900;
	  private static double aspectRatioMin = 1.35;
	  private static double aspectRatioMax = 3;
	  private static double xMin = 0;
	  private static double xMax = 0;
	  private static double yMin = 0;
	  private static double yMax = 0;
	
    public Vision()
    {
    	//cam.openCamera();
    	
    	//cam.setExposureManual(30);
    	
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        binaryFrame = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
        
        // the camera name (ex "cam0") can be found through the roborio web interface
        SmartDashboard.putNumber("Cam Session", RobotMap.CAMERA_SESSION);
        session = RobotMap.CAMERA_SESSION;
        NIVision.IMAQdxConfigureGrab(session);
        NIVision.IMAQdxStartAcquisition(session);
  
        NIVision.IMAQdxConfigureGrab(session);
        
        colorTable = new NIVision.RawData();
        
        double brightness = 45;
        double exposure = 165;
        
		SmartDashboard.putNumber("Hue min", HUE_RANGE.minValue);
		SmartDashboard.putNumber("Hue max", HUE_RANGE.maxValue);
		SmartDashboard.putNumber("Sat min", SAT_RANGE.minValue);
		SmartDashboard.putNumber("Sat max", SAT_RANGE.maxValue);
		SmartDashboard.putNumber("Val min", VAL_RANGE.minValue);
		SmartDashboard.putNumber("Val max", VAL_RANGE.maxValue);
		SmartDashboard.putNumber("Area min", minArea);
		SmartDashboard.putNumber("Area max", maxArea);
		SmartDashboard.putNumber("Brightness", brightness);
		SmartDashboard.putNumber("Exposure", exposure);
        SmartDashboard.putNumber("Aspect Min", aspectRatioMin);
        SmartDashboard.putNumber("Aspect Max", aspectRatioMax);
		SmartDashboard.putNumber("X Min", xMin);
		SmartDashboard.putNumber("X Max", xMax);
		SmartDashboard.putNumber("Y Min", yMin);
		SmartDashboard.putNumber("Y Max", yMax);

    }

    
    public void saveImage() {

    	// Exposure
          NIVision.IMAQdxSetAttributeString(session, ATTR_EX_MODE, "Manual");
          SmartDashboard.putNumber("Exposure Min", NIVision.IMAQdxGetAttributeMinimumI64(session, ATTR_EX_VALUE));
          SmartDashboard.putNumber("Exposure Max", NIVision.IMAQdxGetAttributeMaximumI64(session, ATTR_EX_VALUE));
         
          NIVision.IMAQdxSetAttributeI64(session, ATTR_EX_VALUE, (long) SmartDashboard.getNumber("Exposure"));

        // Brightness
        NIVision.IMAQdxSetAttributeString(session, ATTR_BR_MODE, "Manual");
        SmartDashboard.putNumber("Bright Min", NIVision.IMAQdxGetAttributeMaximumI64(session, ATTR_BR_VALUE));
        SmartDashboard.putNumber("Bright Max", NIVision.IMAQdxGetAttributeMinimumI64(session, ATTR_BR_VALUE));
        
        NIVision.IMAQdxSetAttributeI64(session, ATTR_BR_VALUE, (long) SmartDashboard.getNumber("Brightness"));
    	   	
    	NIVision.IMAQdxStartAcquisition(session);

        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
        //NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

            NIVision.IMAQdxGrab(session, frame, 1);
            //NIVision.imaqWriteJPEGFile(frame, "/images/test.jpg", 200, colorTable);
           // NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                   // DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT , 0.0f);
            
			HUE_RANGE.minValue = (int)SmartDashboard.getNumber("Hue min", HUE_RANGE.minValue);
			HUE_RANGE.maxValue = (int)SmartDashboard.getNumber("Hue max", HUE_RANGE.maxValue);
			SAT_RANGE.minValue = (int)SmartDashboard.getNumber("Sat min", SAT_RANGE.minValue);
			SAT_RANGE.maxValue = (int)SmartDashboard.getNumber("Sat max", SAT_RANGE.maxValue);
			VAL_RANGE.minValue = (int)SmartDashboard.getNumber("Val min", VAL_RANGE.minValue);
			VAL_RANGE.maxValue = (int)SmartDashboard.getNumber("Val max", VAL_RANGE.maxValue);

			NIVision.imaqColorThreshold(binaryFrame, frame, 255, NIVision.ColorMode.HSV, HUE_RANGE, SAT_RANGE, VAL_RANGE);		
			
			minArea = SmartDashboard.getNumber("Area min");			
			maxArea = SmartDashboard.getNumber("Area max");
			aspectRatioMin = SmartDashboard.getNumber("Aspect Min");
			aspectRatioMax = SmartDashboard.getNumber("Aspect Max");
			xMin = SmartDashboard.getNumber("X Min");
			xMax = SmartDashboard.getNumber("X Max");
			yMin = SmartDashboard.getNumber("Y Min");
			yMax = SmartDashboard.getNumber("Y Max");
			int blobs = NIVision.imaqCountParticles(binaryFrame,1);

			int index=0;
			  for (int i=0; i < blobs; i++) {
			    //double area=NIVision.imaqMeasureParticle(binaryFrame, i, 0, MeasurementType.MT_AREA);
				  index=i;
			    double blobTop = NIVision.imaqMeasureParticle(binaryFrame, index, 0, MeasurementType.MT_BOUNDING_RECT_TOP);
			    double blobLeft = NIVision.imaqMeasureParticle(binaryFrame, index, 0, MeasurementType.MT_BOUNDING_RECT_LEFT);
			    double blobWidth = NIVision.imaqMeasureParticle(binaryFrame, index, 0, MeasurementType.MT_BOUNDING_RECT_WIDTH);
			    double blobHeight = NIVision.imaqMeasureParticle(binaryFrame, index, 0, MeasurementType.MT_BOUNDING_RECT_HEIGHT);
			    
			    double area = blobWidth * blobHeight;
			    
			    if (area >= minArea && area <= maxArea) {

			      
			      //double blobHCenter = NIVision.imaqMeasureParticle(binaryFrame, index, 0, MeasurementType. MT_CENTER_OF_MASS_X);
				  //double blobVCenter = NIVision.imaqMeasureParticle(binaryFrame, index, 0, MeasurementType. MT_CENTER_OF_MASS_Y);

			      if (blobWidth/blobHeight >= aspectRatioMin && blobWidth/blobHeight <= aspectRatioMax){
			    	  Rect blobRect = new Rect((int)blobTop, (int)blobLeft, (int)blobHeight, (int)blobWidth); 
					    
			  		  SmartDashboard.putNumber("blobTop", blobTop);
					  SmartDashboard.putNumber("blobLeft", blobLeft);
				  	  SmartDashboard.putNumber("blobWidth", blobWidth);
					  SmartDashboard.putNumber("blobHeight", blobHeight);
					  
					  SmartDashboard.putNumber("area", area);
					  SmartDashboard.putNumber("aspect ratio", blobWidth/blobHeight);
			    	  
					  NIVision.imaqDrawShapeOnImage(frame, frame, blobRect,
			                  DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT , 0.0f);
					  
			      }
			    }
			  }
			  SmartDashboard.putNumber("NumBlobs",blobs);
			 
            CameraServer.getInstance().setImage(frame);

            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
    }
    
       
    public void sendImage()
    {
    	NIVision.IMAQdxGrab(session, frame, 1);
    	CameraServer.getInstance().setImage(frame);

        /** robot code here! **/
        Timer.delay(0.005);		// wait for a motor update time
    }
    
    
    public void end() {
    }

    
    public void test() {
    }
    
    
    protected void initDefaultCommand() {
    }
    
}