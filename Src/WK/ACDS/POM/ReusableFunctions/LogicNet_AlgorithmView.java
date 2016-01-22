/**
* ######################################## Summary of Class ###################################################################
* Framework - WK_UpToDate_ACDS
* Version - 1.0
* Creation Date - Jan 2016
* Author - Supresh Bhujbal
* 
* Description:
* This class defines all methods for Algorithm View
*
* ###################################### Functions Defined in this Class: #####################################################
#1. ClickOnAlgorithmButton(WebDriver driver) - Click on Algorithm view button
#2. SelectAllNodeAndAnswerOneByOne(WebDriver driver, ArrayList<String> strNode, ArrayList<String> strAnswer) - Select all node one by one
#3. ClickOnNodeAndAnswer(WebDriver driver, String sNode, String sAnswer) - Select one node at a time
################################################################################################################################
 **/


package WK.ACDS.POM.ReusableFunctions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogicNet_AlgorithmView {
	
	 /*###############################################################.1.#################################################################*/ 	
	 /*** This function is used to Click on Algorithm button on Overview panel </br>
	  * 
	  * @param driver
	  */
	public static void ClickOnAlgorithmButton(WebDriver driver) 
	  {
		 try
		  {
			 driver.findElement(By.className("algoview-button")).click();
			 Thread.sleep(5000);
		  }
		 catch(Exception E)
     	 {
			//Log the Exception & Abort
			E.printStackTrace();
			WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
     	 }
	  }	
	
	 /*###############################################################.2.################################################################*/ 	
	 /*** This function is used to Select all node one by one & Answer them </br>
	  * 
	  * @param driver
	  * @param strNode - Provide the list of array that contains node info
	  * @param strAnswer - Provide the list of array that contains answer to each node
	  */
	 public static void SelectAllNodeAndAnswerOneByOne(WebDriver driver, ArrayList<String> strNode, ArrayList<String> strAnswer) 
	  {
		 try
		  {
			 //Assign new Array
			 String[] strNodeElt =  new String[15];
			 String[] strNodeAnswerElt =  new String[15];
			 
			 //Convert Array list to Array
			 strNode.toArray(strNodeElt);
			 strAnswer.toArray(strNodeAnswerElt);

			 //For Loop to click on all nodes
			 for(int i=0;i<strNodeElt.length;i++)
			 {
				 if(strNodeElt[i]!=null)
				 {
					//Drag the Algorithm
					WebElement draggable = driver.findElement(By.id("svg"));
					new Actions(driver).dragAndDropBy(draggable, -10, 10).build().perform();
					
					//Answer the Node
					ClickOnNodeAndAnswer(driver, strNodeElt[i], strNodeAnswerElt[i]);
				 }	
			 }	 
		  }
		 catch(Exception E)
     	 {
			//Log the Exception & Abort
			E.printStackTrace();
			WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
     	 }
	  }	
  
	 /*#############################################################.3.##################################################################*/ 	
	 /*** This function is used to Select all node one by one & Answer them </br>
	  * 
	  * @param driver
	  * @param sNode - One node
	  * @param sAnswer - Answer to that node
	  */
	  public static void ClickOnNodeAndAnswer(WebDriver driver, String sNode, String sAnswer) 
	  {
		  try
		  {
		  	//Find all the element with tag <span>
			List<WebElement> elts = driver.findElements(By.tagName("text"));
			  
			 //Print the size
			System.out.println(elts.size());
			 
			 //Loop thro' the Element
	     	for (WebElement elt : elts) 
		     	{
		     		String sText = "";
		     		
			     		//Find all the element with tag <span>
						 List<WebElement> subelts = elt.findElements(By.tagName("tspan"));
						 System.out.println(subelts.size());
					 
					 	//Loop thro' the Element
				     	for (WebElement SubElt : subelts) 
				     	{
				     		sText = sText + SubElt.getText() + " ";
				     	}
				     	System.out.println(sText);
				     	
				     	//Answer the Node
				     	if(sText.trim().equalsIgnoreCase(sNode))
				     	{
				     		elt.click();
				     		Thread.sleep(1500);
				     		driver.findElement(By.xpath("//label[text()='"+ sAnswer +"']")).click();
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
}