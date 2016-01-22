/**
* ######################################## Summary of Class ###################################################################
* Framework - WK_UpToDate_ACDS
* Version - 1.0
* Creation Date - Jan 2016
* Author - Supresh Bhujbal
* 
* Description:
* This class defines all functions required for LogicNet Designer page
*
* ###################################### Functions Defined in this Class: #####################################################
#1. LogicNetDesigner_Login(WebDriver driver , String sUserName , String sPassword) - Login into LogicNet designer
#2. DoubleClickOnFolder(WebDriver driver , String sFolderName)  - To double click on Folder 
#3. ClickOnFolderStructure(WebDriver driver , ArrayList<String> strFolderStructure)  - Click & Navigate via Folder structure
################################################################################################################################
 **/

package WK.ACDS.POM.ReusableFunctions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogicNet_Designer {
	
	/*###########################################################.1.####################################################################*/ 	
	/***** Log in into LogicNet DEsigner <br/>
	 * 
	 * @param driver
	 * @param sUserName - Provide User name 
	 * @param sPassword - Provide Password
	 */
	public static void LogicNetDesigner_Login(WebDriver driver , String sUserName , String sPassword) 
	  {
		 try{
			 
			 	//Enter User name & Password
				driver.findElement(By.name("username")).sendKeys(sUserName);
				driver.findElement(By.name("password")).sendKeys(sPassword);
				
				//Click on Login Button
				driver.findElement(By.name("Login")).click();
				
				//Check if Login is successful
				if(driver.findElements(By.id("navtree")).size()>0)
				{
					//Successful
					System.out.println("Login Successful");
				}
				else
				{
					//Failed
					System.out.println("Login failed");
					WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
				}
		 }
		 catch(Exception E)
		 {
			 //Log the Exception & Abort
			 E.printStackTrace();
			 WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
		 }
		 
	  }
	
	  /*########################################################.2.#######################################################################*/ 	
	 /**** Double click on Folder <p/>
	  * 	
	  * @param driver
	  * @param sFolderName - Provide Folder name here
	  */
	 public static void DoubleClickOnFolder(WebDriver driver , String sFolderName) 
	  {
		 try{
			 
			//Switch to Frame
			driver.switchTo().frame(driver.findElement(By.id("navtree")));
			 
			//Find all the element with tag <span>
			 List<WebElement> cols = driver.findElements(By.tagName("span"));
			 
			 //Print size of array
			 System.out.println(cols.size());
			 
			 //Loop thro' the Elements
	     	 for (WebElement col : cols) 
	     	 {
	     		//Print the Element 
	     	    System.out.println(col.getText());
	     		
	     	    if(col.getText().contains(sFolderName))
	     		{
	     			//Double click on the Element
	     			Actions action = new Actions(driver);
	     			action.doubleClick(col).perform();
	     		}
	     	} 
		 
	     	Thread.sleep(1500);
	     	 
	     	//Switch back to Default Content
			driver.switchTo().defaultContent();
				 
		  }catch(Exception E)
		  {
			  //Log the Exception & Abort
			  E.printStackTrace();
			  WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
		  }
	  }
 
	 
	 /*##############################################################.3.#################################################################*/ 	
	 /**** Double click on Folder <p/>
	  * 
	  * @param driver
	  * @param strFolderStructure
	  */
	 public static void ClickOnFolderStructure(WebDriver driver , ArrayList<String> strFolderStructure) 
	  {
		 try{
			 String[] strFolderStructureElt =  new String[10];
			 
			 strFolderStructure.toArray(strFolderStructureElt);

			 
			 for(int i=0;i<strFolderStructureElt.length;i++)
			 {
				 if(strFolderStructureElt[i]!=null)
				 WK.ACDS.POM.ReusableFunctions.LogicNet_Designer.DoubleClickOnFolder(driver, strFolderStructureElt[i]);
			 }
		  }catch(Exception E)
		  {
			  //Log the Exception & Abort
			  E.printStackTrace();
			  WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
		  }
	  }
}