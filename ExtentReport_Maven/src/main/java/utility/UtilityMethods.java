package utility;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityMethods {
	
	public static WebDriver driver;
	
	public String captureScreenShot(String stepName) {
		String destpath = null;
		try{	
			
				TakesScreenshot scrshot=((TakesScreenshot)driver);
				
				File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
				destpath = "./SnapShots/"+stepName+"_"+".png";
				File dest=new File(destpath);
				FileHandler.copy(srcFile, dest);
				
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		return "."+destpath;
	}

}
