/**
* ######################################## Summary of Class ###################################################################
* Framework - WK_UpToDate_ACDS
* Version - 1.0
* Creation Date - Jan, 2016
* Author - Supresh Bhujbal
* 
* Description:
* All Global variables are defined here
*
* #################################### Functions Defined in this Class: #########################################################
* 
* ###############################################################################################################################
 **/

package WK.ACDS.POM.Utilities;

import java.util.ArrayList;

public class General_GlobalVariables {
  
	//Global Variables for LogicNet
	public static String sAbortExecution = "false";
	public static String sTestCaseID; //Test case ID
	public static String sLogicNet_URL; // LogicNet URL
	public static String sLogicNet_UserName; //LogicNet user name
	public static String sLogicNet_Password; //LogicNet password
	public static String OriginalwinHandleBefore; //VAriable to store original window handle
	public static String sFolderStructure; // LogicNet folder structure
	public static String sPatientID; // Patient ID
	public static String sICGName; // ICG
	public static String sICGNodeAnswer; // Answer to ICG node
	
	public static ArrayList<String> strFolderStructure = new ArrayList<String>();
	public static ArrayList<String> strNode = new ArrayList<String>();
	public static ArrayList<String> strAnswerToNode = new ArrayList<String>();
}
