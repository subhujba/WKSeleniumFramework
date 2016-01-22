package WK.ACDS.POM.Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class General_ReadVariables{
	
	  public static int j = 1 ;
      public static XSSFSheet ExcelWSheet;
      public static XSSFWorkbook ExcelWBook;
	 
      /*#####################################################.1.##########################################################################*/ 
      /***** Parameterization -  This method is to set the variable value as STRING from Excel sheet </br>
       * 
       * @param sVariable_Desc - Description of variable
       * @param sPath - Path of File
       * @param sSheet - Sheet name
       * @param sStringorInt - Pass "0" here if the expected variable STRING or "1" if the expected variable is INT
       * @param x - Row number
       * @param y - Column Number
       * @return
       */
       public static Object Func_ReadVariable(String sVariable_Desc, String sPath, String sSheet, int sStringorInt, int x, int y)
                {
                String sVariable = null;
                int sintVariable = 0;
                                try {
                                     			//Get the Cell data as String
                                				String str_ = General_ExcelUtilies.getCellData(sPath,sSheet, x, y);
                                				
                                				//Check if we need data as String or INT
                                                if(sStringorInt ==0)
                                                {	
                                                	//Return String
	                                                sVariable = str_;
	                                                System.out.println(sVariable_Desc + " : " + sVariable);
	                                                j = j +1;
	                                                return sVariable;
                                                }
                                                else
                                                {
                                                	//Return Int
                                                	sintVariable = Integer.parseInt(str_);
                                                    System.out.println(sVariable_Desc + " : " + sintVariable);
                                                    j = j +1;
                                                	return sintVariable;
                                                }	
                                             
                                              
                                               
	                                } catch (Exception e) 
	                                {	
	                                	//In case of Exception return null
	                                	System.out.println("Unable to fetch Run Variable of Application: " + sVariable_Desc);
	                                	return null;
	                                }
                                
                                
                }
   
      /*###################################################.2.#######################################################################*/ 
       /************* The Following method reads all the variables from Excel </br>
        * 
        * @param sPath - Path of Excel File
        * @param sSheet - Sheet of Excel file
        * @param i - Test case id or Row number
        */
       public static void Read_Variables(String sPath, String sSheet, int i)
       {
    	   try{
                       j = 1;
                       
                       // LogicNet URL
                       General_GlobalVariables.sLogicNet_URL= (String) Func_ReadVariable("LogicNet URL" , sPath,"LogicNet",0, i, j);
                       
                       // LogicNet UserName
                       General_GlobalVariables.sLogicNet_UserName = (String) Func_ReadVariable("LogicNet Username" , sPath,"LogicNet",0, i, j);
                       
                       //LogicNet Password
                       General_GlobalVariables.sLogicNet_Password = (String) Func_ReadVariable("LogicNet Password" , sPath,"LogicNet",0, i, j);
                       
                       //LogicNet FolderStructure
                       General_GlobalVariables.sFolderStructure = (String) Func_ReadVariable("LogicNet Folder structure" , sPath,"LogicNet",0, i, j);
                       
                       //LogicNet Patient ID
                       General_GlobalVariables.sPatientID = (String) Func_ReadVariable("Patient ID" , sPath,"LogicNet",0, i, j);
                       
                       //LogicNet ICG Name
                       General_GlobalVariables.sICGName = (String) Func_ReadVariable("ICG Name" , sPath,"LogicNet",0, i, j);
                       
                       //ICG Node & Answer on Algorithm view
                       General_GlobalVariables.sICGNodeAnswer = (String) Func_ReadVariable("ICG Name" , sPath,"LogicNet",0, i, j);
                       
                       //Fetch the folder structure values
                       if(Integer.parseInt(General_GlobalVariables.sFolderStructure)>0)
                       {
							General_GlobalVariables.strFolderStructure = General_ExcelUtilies.getCellDataAsArrayListColumnwise(sPath, "FolderStructure", (Integer.parseInt(General_GlobalVariables.sFolderStructure)-1), 1, 10, General_GlobalVariables.strFolderStructure);
					   } 
                       
                       //Fetch the ICG Node & Answer values
                       if(Integer.parseInt(General_GlobalVariables.sICGNodeAnswer)>0)
                       {
							General_GlobalVariables.strNode = General_ExcelUtilies.getCellDataAsArrayListColumnwise(sPath, "ICGAnswerFlow", (Integer.parseInt(General_GlobalVariables.sICGNodeAnswer)*2-2), 1, 15, General_GlobalVariables.strNode);
							General_GlobalVariables.strAnswerToNode = General_ExcelUtilies.getCellDataAsArrayListColumnwise(sPath, "ICGAnswerFlow", (Integer.parseInt(General_GlobalVariables.sICGNodeAnswer)*2-2)+1, 1, 15, General_GlobalVariables.strAnswerToNode);
					   } 
                       
    	   }catch (Exception e) 
    	   {
    		   // TODO Auto-generated catch block
    		   e.printStackTrace();
    	   }
                    	   
                       
                       
       }               
                               
}
