/**
* ######################################## Summary of Class ###################################################################
* Framework - WK_UpToDate_ACDS
* Version - 1.0
* Creation Date - Jan, 2016
* Author - Supresh Bhujbal
* 
* Description:
 *This Script validate End to End flow of LogicNet
 *
* #################################### Functions Defined in this Class: #########################################################
* None
* ###############################################################################################################################
 **/

package WK.ACDS.LogicNets;

import org.testng.annotations.Test;
import java.io.File;
import org.openqa.selenium.WebDriver;
import WK.ACDS.POM.Utilities.General_GlobalVariables;

public class SampleScript {
  @Test
  public void EndToEndFlowACDS() 
  {
	  try{
		  
		  for(int i=1;i<=1;)
		  {
			  /****************** Step 1 - Open the Excel file **************************************************************/
			  File f1 = new File("LogicNet.xlsx");
			  String path = f1.getAbsolutePath();
			  WebDriver driver = null;
			  
			  /****************** Step 2 - Read Variables from Excel file ***************************************************/
			  WK.ACDS.POM.Utilities.General_ReadVariables.Read_Variables(path, "LogicNet", 1);
			  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
			  
			  /****************** Step 3 - Launch the Browser ***************************************************************/
			  driver = WK.ACDS.POM.ReusableFunctions.General_Functions.LaunchTheBrowser(driver, General_GlobalVariables.sLogicNet_URL);
			  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
			  
			  /****************** Step 4 - Login ***************************************************************************/
	   	   	  WK.ACDS.POM.ReusableFunctions.LogicNet_Designer.LogicNetDesigner_Login(driver, General_GlobalVariables.sLogicNet_UserName, General_GlobalVariables.sLogicNet_Password);
	   	   	  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
	   	   
	   	   	  /****************** Step 5 - Click on folder structure *******************************************************/ 
	   	   	  WK.ACDS.POM.ReusableFunctions.LogicNet_Designer.ClickOnFolderStructure(driver, General_GlobalVariables.strFolderStructure);
	   	   	  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
	   	   	  
	   	   	  /****************** Step 6 - Click on Test button *************************************************************/ 
	   	   	  WK.ACDS.POM.ReusableFunctions.LogicNet_DecisionEngine.ClickonTestButton(driver);
	   	   	  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
	   	   	  
	   	   	  /****************** Step 7 - Click on Patient row *************************************************************/ 
	   	   	  WK.ACDS.POM.ReusableFunctions.LogicNet_DecisionEngine.ClickonPatientRow(driver, General_GlobalVariables.sPatientID);
	   	   	  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
				
			  /****************** Step 8 - Click on ICG Name row ************************************************************/ 
			  WK.ACDS.POM.ReusableFunctions.LogicNet_DecisionEngine.ClickonPatientRow(driver, General_GlobalVariables.sICGName);
			  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
				
			  /****************** Step 9 - Click on Algorithm View button ***************************************************/ 
			  WK.ACDS.POM.ReusableFunctions.LogicNet_AlgorithmView.ClickOnAlgorithmButton(driver);
			  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
				
			  /****************** Step 10 - Select Node & answer them one by one ********************************************/ 
			  WK.ACDS.POM.ReusableFunctions.LogicNet_AlgorithmView.SelectAllNodeAndAnswerOneByOne(driver, General_GlobalVariables.strNode, General_GlobalVariables.strAnswerToNode);
			  if(WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution!="false")
				  break;
			  
			  Thread.sleep(5000);
			  
			  driver.quit();
		  }
	  }
	  catch(Exception E)
	  {
		  E.printStackTrace();
	  }
	  
  }
}
