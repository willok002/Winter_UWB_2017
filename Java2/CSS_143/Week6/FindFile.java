
/**
 * FileSearch.java is a recursive file search program.
 *
 * @author Will O'Keeffe
 * @version 01/11/2018
 */
import java.io.*;
public class FindFile
{   
    public final int MAX_NUMBER_FILES_TO_FIND;
    private int count;
    private String [] files;
    /**
     * constructor for FindFile.java
     * @param max number of target files to find
     */
    public FindFile(int maxFiles){
        MAX_NUMBER_FILES_TO_FIND = maxFiles;
        files = new String [MAX_NUMBER_FILES_TO_FIND];//keeps track of locations
        count = 0;
    }
    /**
     * @param file to search for (targetName)
     * @param directory path to search
     * 
     * no return, counts the number of times targetName was found
     */
    public void directorySearch(String targetName, String pathToSearch) throws InvalidPath{
        File path = new File(pathToSearch);//converts given search path to a File object
        if(!(path.isDirectory()))
               throw new InvalidPath(pathToSearch); //throws error if not directory
        else{
            int i = 0; //index of files in directory
            File [] listFiles = path.listFiles();
            int size = files.length; //number of items in current directory
            //searches directory while more items available and space in MAX_NUMBER_FILES_TO_FIND
            while ( i < files.length && count < MAX_NUMBER_FILES_TO_FIND){
                if (listFiles[i].isFile()){ 
                    if(listFiles[i].getName().equals(targetName)){
                        files[count] = listFiles[i].getPath();
                        count ++;//count of files found, also index in files array
                        i++;
                    }
                    else
                        i++;
                }
                else//not a file ==> it's a directory!
                     directorySearch(targetName, listFiles[i].getPath());
            }   
        }
    }
    /**
     * @return count of times a file name matches given target file
     */
    public int getCount(){
        return count;
    }
}

