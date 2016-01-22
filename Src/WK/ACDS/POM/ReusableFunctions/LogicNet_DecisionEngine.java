/**
* ######################################## Summary of Class ###################################################################
* Framework - WK_UpToDate_ACDS
* Version - 1.0
* Creation Date - Jan 2016
* Author - Supresh Bhujbal
* 
* Description:
* This class defines all functions required for LogicNet Decision Engine Page
*
* ###################################### Functions Defined in this Class: #####################################################
#1. ClickonPatientRow(WebDriver driver , String sPatientID) - To click on Patient Row
#2. ClickonTestButton(WebDriver driver) - Click on Test button
################################################################################################################################
 **/

package WK.ACDS.POM.ReusableFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogicNet_DecisionEngine {
  
	  /*###################################################.1.############################################################################*/ 	
	  /*********************** Function :- Click on Patient Row on Decision Engine page <p />
	   *  
	   * @param driver
	   * @param sPatientID - Provide patient ID here E.g. 658974 etc
	   */
	  public static void ClickonPatientRow(WebDriver driver , String sPatientID) 
	  {
		  		try{
		  			 
		  			 //Find all the element with tag <span>
					 List<WebElement> cols = driver.findElements(By.tagName("span"));
					 
					 //Print the size
					 System.out.println(cols.size());
					 
					 //Loop thro' the Element
				     	for (WebElement col : cols) 
				     	{
				     		System.out.println(col.getText());
				     		if(col.getText().contains(sPatientID))
				     		{
				     			//Click on Element
				     			col.click();
				     			Thread.sleep(2500);
				     			break;
				     		}
				     	} 
				 
				  }catch(Exception E)
				  {
					  	//Log the Exception & Abort
						E.printStackTrace();
						WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
				  }
	  }
  
	  /*###################################################.2.###########################################################################*/ 
	  /*********************** Function :- Click on Test button <p />
	   * 
	   * @param driver
	   */
	  public static void ClickonTestButton(WebDriver driver) 
	  {	
		  try{
			  //Switch to main frame
			    driver.switchTo().frame(driver.findElement(By.id("main")));
				
			  //wait
			    Thread.sleep(1000);
			  
			  // Store the current window handle
			     WK.ACDS.POM.Utilities.General_GlobalVariables.OriginalwinHandleBefore = driver.getWindowHandle();
			  
			  //Click on test button
			     driver.findElement(By.xpath(".//a[@title='test']")).click();
	
			  // Switch to new window opened
			  for(String winHandle : driver.getWindowHandles()){
				  driver.switchTo().window(winHandle);
				  
			  //Maximize the Window
				  driver.manage().window().maximize();	  
			  }
		  }catch(Exception E)
		  {
			  //Catch the Exception
			  WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
			  E.printStackTrace();
		  }
	  	}	  
	  
}
