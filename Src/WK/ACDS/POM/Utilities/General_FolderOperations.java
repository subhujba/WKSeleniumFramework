package WK.ACDS.POM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class General_FolderOperations {
	
	  /*#############################################################.1.#################################################################*/
	  /************ Below block is used to copy Folder </br>
	   * 
	   * @param src - Source Folder which can be copied from
	   * @param dest - Destination in which folder structure will be copied
	   * @throws IOException
	   */
                public static void copyFolder(File src, File dest)
                {
                	try{
                        if(src.isDirectory())
                        {
                        		//if directory not exists, create it
                            	if(!dest.exists())
                            	{
	                            	dest.mkdir();
	                                System.out.println("Folder directory copied from " + src + "  to " + dest);
                            	}
               
                            	//list all the directory contents - SubFolder/ Files etc
                               String files[] = src.list();
                               

                               //construct the src and dest file structure
                               for (String file : files) {
                               File srcFile = new File(src, file);
                               File destFile = new File(dest, file);
                               
                               //recursive copy
                               copyFolder(srcFile,destFile);
                            }
               
                          }else
                          {
                                //if file exist, then copy it
                                //Use bytes stream to support all file types
                                InputStream in = new FileInputStream(src);
                                OutputStream out = new FileOutputStream(dest);
       
                                byte[] buffer = new byte[1024];
       
                                int length;
                                //copy the file content in bytes
                                while ((length = in.read(buffer)) > 0){
                                           out.write(buffer, 0, length);
                                }
       
                                in.close();
                                out.close();
                                System.out.println("File copied from " + src + " to " + dest);
                            }
                	}
                	catch(Exception E)
                	{
                		
                	}
                }
               
                /*#############################################################.1.#################################################################*/
          	  /************ Below block is used to create new folder for each run </br>
          	   * 
          	   * @throws InterruptedException
          	   */
                public static void CreateNewOPFolder() throws InterruptedException
                {
                               
//                                  String[] options = {"Create New folder", "Cancel"};
//                                  String strOPFolder = null;
//                                  //Get the name of Current output folder
//                                  try {
//                                                                List<String> slines = FileUtils.readLines(new File(IB_main_util_constants.sTempNotepad));
//                                                                for(String sline: slines)
//                                                      {       
//                                                                                strOPFolder = sline;
//                                                                                break;
//                                                      }
//                                                                } catch (IOException e) {
//                                                                                // TODO Auto-generated catch block
//                                                                                e.printStackTrace();
//                                                                }
//                                 
//                                int result = JOptionPane.showOptionDialog(null, "Current O/P Folder is :" + strOPFolder + "\nSelect the below option to create NEW Output folder.. \n Click Cancel to contiue with existing folder..", "IB Portal", JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
// 
//                                  switch (result)
//                                  {
//                                    case 0:
//                                               
//                                                String input = JOptionPane.showInputDialog("Enter new Folder name: \nIt will get appended with current Timestamp for creating new O/P Folder for eg. Regression, Cumalative");
//                                                    System.out.println(input);
//                                                    IB_main_util_constants.strOPFolder = IB_main_util_constants.strFolderpath + "Results/New Execution/" + "Run_" + input + "_" + IB_main_util_utilities.DateTimeStamptoAppend("ddMMMyyyy_mmss");
//                                                System.out.println("Created new output Folder as : " + IB_main_util_constants.strOPFolder);
//                                               
//                                                //Update current OP folder in notepad
//                                                FileWriter fstream;
//                                                                try {
//                                                                fstream = new FileWriter(IB_main_util_constants.sTempNotepad);
//                                                                BufferedWriter out = new BufferedWriter(fstream);
//                                                                out.write(IB_main_util_constants.strOPFolder);
//                                                                out.newLine();
//                                                                out.close();
//                                                                } catch (IOException e1) {
//                                                                                // TODO Auto-generated catch block
//                                                                                e1.printStackTrace();
//                                                                }
//                                                               
//                                               
//                                               
//                                                File srcFolder = new File(IB_main_util_constants.strOPTemplateFolder);
//                                                File destFolder = new File(IB_main_util_constants.strOPFolder);
//                                                try {
//                                                                IB_main_util_utilities.copyFolder(srcFolder, destFolder);
//                                                } catch (IOException e) {
//                                                                // TODO Auto-generated catch block
//                                                                e.printStackTrace();
//                                                }
//                                               
//                                                System.out.println("Done!! Created New Folder");
                              
}
}