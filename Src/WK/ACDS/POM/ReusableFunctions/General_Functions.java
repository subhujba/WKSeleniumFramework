/**
* ######################################## Summary of Class ###################################################################
* Framework - WK_UpToDate_ACDS
* Version - 1.0
* Creation Date - Jan 2016
* Author - Supresh Bhujbal
* 
* Description:
* This class defines all generic Functions
*
* ###################################### Functions Defined in this Class: #####################################################
#1. WaitforElement(WebDriver driver, int sSecond, String sBy, String sAttribute) - Wait for an Element for Specific amount of time
################################################################################################################################
 **/


package WK.ACDS.POM.ReusableFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General_Functions {
  
	 /*#############################################################.1.#################################################################*/ 	
	 /*** This function is used to launch the Web site in Mozilla browser <p/>
	  * 
	  * @param driver
	  * @param sURL - Provide URL here
	  * @return
	  */
	 public static WebDriver LaunchTheBrowser(WebDriver driver, String sURL) 
	  {
		 try
		 {
			 	//Launch the Web driver
				driver = new FirefoxDriver();
				
				//Navigate to the URL
				driver.get(sURL);
				
				//Implicit wait 
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				//Maximize the Window
				driver.manage().window().maximize();
				
				//Return Driver
				return driver;
		 }
		 catch(Exception E)
		 {
				//Log the Exception & Abort
				E.printStackTrace();
				WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
			 	return null;
		 }
		  
	  }	  
	
	  /*##############################################################.2.#################################################################*/ 	
	  /*** This function is used to wait for an specific object <p/>
	   * 
	   * @param driver 
	   * @param sSecond - No of seconds
	   * @param sBy - This can take id, name , xpath, ClassName  etc
	   * @param sAttribute - This will take exact ID or name of element
	   */
	  public static void WaitforElement(WebDriver driver, int sSecond, String sBy, String sAttribute) 
	  {
		  try
		  {
			 
			  @SuppressWarnings("unused")
			  WebElement sWait;
			  
			  //Wait using ID
			  if(sBy.contains("id"))
			  {
				  sWait = (new WebDriverWait(driver, sSecond))
				    .until(ExpectedConditions.presenceOfElementLocated(By.id(sAttribute)));
			  }
			  //wait using name
			  else if(sBy.contains("name"))
			  {
				  sWait = (new WebDriverWait(driver, sSecond))
				    .until(ExpectedConditions.presenceOfElementLocated(By.name(sAttribute)));
			  }
			  //wait using xpath
			  else if(sBy.contains("xpath"))
			  {
				  sWait = (new WebDriverWait(driver, sSecond))
				    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(sAttribute)));
			  }
		  }
		  catch(Exception E)
		  {
			  //Log the Exception & Abort
			  E.printStackTrace();
			  WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
		  }
	  	}
	  
	  
}
