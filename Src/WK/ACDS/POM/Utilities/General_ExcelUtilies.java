/**
* ######################################## Summary of Class ###################################################################
* Framework - WK_UpToDate_ACDS
* Version - 1.0
* Creation Date - Jan, 2016
* Author - Supresh Bhujbal
* 
* Description:
 *All Functions related to Excel connection, data manipulations are defined here.
 *
* #################################### Functions Defined in this Class: #########################################################
#1. setExcelFile(String Path,String SheetName) - Create a Object of Excel file
#2. getCellData(String Path,String SheetName, int RowNum, int ColNum) - Get the cell data from Excel cell
* ###############################################################################################################################
 **/


package WK.ACDS.POM.Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class General_ExcelUtilies {
 
	  private static XSSFSheet ExcelWSheet;
	  private static XSSFWorkbook ExcelWBook;
      private static XSSFCell Cell;
      @SuppressWarnings("unused")
      private static XSSFRow Row;
      public static String newFolderResult;
      public static String newFolderScreenshot;
      public static String newFolderRunResult;
	
	     /*###########################################################.1.#######################################################################*/ 
		 /**This method is to set the File path and to open the Excel file </br>
		  * 
		  * @param Path - Path of Excel File
		  * @param SheetName - Sheet name or sheet number
		  * @throws Exception
		  */
			public static void setExcelFile(String Path,String SheetName) throws Exception {
	
	           try {
	
		               //Open the Excel file
		        	   FileInputStream ExcelFile = new FileInputStream(Path);
		
		               //Access the required test data sheet & Work book
		        	   ExcelWBook = new XSSFWorkbook(ExcelFile);
		        	   ExcelWSheet  = ExcelWBook.getSheet(SheetName);
	
	            }catch (Exception e)
	           {
	            	//Log the Exception & Abort
					e.printStackTrace();
					WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
	            }
	
			}
		
		/*############################################################.2.###################################################################*/ 
		 /**This method is to read the test <STRING> data from the Excel cell, in this we are passing parameters as Row num and Col num </br>
		  * 
		  * @param Path - Path of Excel
		  * @param SheetName - Sheet name
		  * @param RowNum - Row number
		  * @param ColNum - Column number
		  * @return
		  * @throws Exception
		  */
        public static String getCellData(String Path,String SheetName, int RowNum, int ColNum) throws Exception{
            try {
                             // Open the Excel file
                            FileInputStream ExcelFile = new FileInputStream(Path);
            
                             // Access the required test data sheet & Work book
                             ExcelWBook = new XSSFWorkbook(ExcelFile);
                             ExcelWSheet = ExcelWBook.getSheet(SheetName);
                             } catch (Exception e){
                            	//Log the Exception & Abort
             					e.printStackTrace();
             					WK.ACDS.POM.Utilities.General_GlobalVariables.sAbortExecution = "true";
                             }  
                             
                             try {
	                                // Fetch string value data from required row & column 
	                                Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	                                
	                                // Get the data as String
	                                String CellData = Cell.getStringCellValue();
	                                
	                                // Release the Object
	                                ExcelWBook = null;
	                                ExcelWSheet = null;
	                                System.out.println(CellData);
	                                return CellData;
	                                
                                  } catch (Exception e) 
                             	  {
                                	  return "";
                                      //e.printStackTrace();
                                  }
                    }
        
        /*###############################################################.3.################################################################*/ 
        /**This method is to read the test <STRING> data from the Excel cell into an Array list, in this we are passing parameters as Row num and Col num & Last row as parameter </br>
         * 
         * @param Path - Path of Excel file
         * @param SheetName - Sheet of Excel file
         * @param RowNum - Row number
         * @param ColNum - Column Number 
         * @param sLastRow - Last row till which data is to be fetched
         * @param strArrayListData
         * @return
         * @throws Exception
         */
        public static ArrayList<String> getCellDataAsArrayList(String Path,String SheetName, int RowNum, int ColNum, int sLastRow, ArrayList<String> strArrayListData) throws Exception{
            try {
                             // Open the Excel file
                            FileInputStream ExcelFile = new FileInputStream(Path);
            
                             // Access the required test data sheet & Work book
                             ExcelWBook = new XSSFWorkbook(ExcelFile);
                             ExcelWSheet = ExcelWBook.getSheet(SheetName);
                             }catch (Exception e)
            				 {
                                 e.printStackTrace();
                             }  
                             
                             			try {
                                                     // Fetch string value data from required row & column
                                                     for(int i = RowNum;i<=sLastRow;i++)
                                                     {
                                                    	 			// Get the data 
                                                                     try{
                                                                    	 Cell = ExcelWSheet.getRow(i).getCell(ColNum);
                                                                     }catch(Exception E){}
                                                                     
                                                                    // Fetch the data as String 
                                                                    String CellData;
                                                                    try
                                                                    {
                                                                     CellData = Cell.getStringCellValue();
                                                                    }
                                                                    catch(Exception E)
                                                                    {
                                                                     CellData= "NULL";
                                                                    }
                                                                    
                                                                    // Add the data into Array
                                                                    strArrayListData.add(CellData);
                                                                    // System.out.println(CellData);
                                                     } 
                                                     	
                                                     // Release the Object
                                         			 ExcelWBook = null;
                                                     ExcelWSheet = null;
                                                                           
                                            } catch (Exception e)
                             				{
                                                            e.printStackTrace();
                                            }
                             
                             	//Return all the value with an Array
                                return strArrayListData;
                    }
        
        /*###############################################################.4.################################################################*/
        /** Columnwise  - This method is to read the test <STRING> data from the Excel cell, in this we are passing parameters as Row num and Col num <br/>
         * 
         * @param Path
         * @param SheetName
         * @param RowNum
         * @param ColNum
         * @param sLastColNum
         * @param strMapQueryExpectedResultLang
         * @return
         * @throws Exception
         */
        public static ArrayList<String> getCellDataAsArrayListColumnwise(String Path,String SheetName, int RowNum, int ColNum, int sLastColNum, ArrayList<String> strMapQueryExpectedResultLang) throws Exception{
            try {
                             /*** Open the Excel file ***/
                            FileInputStream ExcelFile = new FileInputStream(Path);
            
                            /*** Access the required test data sheet & Work book ***/
                             ExcelWBook = new XSSFWorkbook(ExcelFile);
                             ExcelWSheet = ExcelWBook.getSheet(SheetName);
                             } catch (Exception e){
                                 e.printStackTrace();
                             }  
                             
                             try {
                                                             /*** Fetch string value data from required row & column ***/
                                                             for(int i = ColNum;i<=sLastColNum;i++)
                                                             {
                                                                            Cell = ExcelWSheet.getRow(RowNum).getCell(i);
                                                                            String CellData;
                                                                            try{
                                                                             CellData = Cell.getStringCellValue();
                                                                                            }
                                                                            catch(Exception E)
                                                                            {
                                                                                            CellData= "NULL";
                                                                            }
                                                                            if(!CellData.contentEquals("NULL"))
                                                                            strMapQueryExpectedResultLang.add(CellData);
                                                                            
                                                                            System.out.println(CellData);
                                                             } 
                                                             
                                                             ExcelWBook = null;
                                                                         ExcelWSheet = null;
                                                                           
                                            } catch (Exception e){
                                                            e.printStackTrace();
                                            }
                                                                            return strMapQueryExpectedResultLang;
                    } 
}
