
/**
 * FileSearch.java is a recursive file search program.
 *
 * @author Will O'Keeffe
 * @version 02/11/2018
 */
import java.io.*;
public class FindFile
{   
    public int MAX_NUMBER_FILES_TO_FIND;
    private int count;
    private String [] files;
    /**
     * constructor for FindFile.java
     * @param max number of target files to find
     * -Precondition, maxFiles > 0
     *      -if not met, exeption thrown and caught
     */
    public FindFile(int maxFiles) throws InvalidSizeException{
            if(maxFiles > 0){
                MAX_NUMBER_FILES_TO_FIND = maxFiles;
                files = new String [MAX_NUMBER_FILES_TO_FIND];//keeps track of locations
                count = 0;
            }
            else{
                throw new InvalidSizeException();
            }
    }
    /**
     * directorySearch(String, String) takes two inputs (the file target and the starting path to search) and searches each directory until either the search is complete
     * or the max number of files to be found is reached. 
     * throws MaxFoundException if max number of files is found
     * thorws InvalidPathException if proveded path is not a directory
     * 
     * This is a recrusive linear search 
     * 
     * @param file to search for (targetName)
     * @param directory path to search
     * 
     * no return, counts the number of times targetName was found
     */
    public void directorySearch(String targetName, String pathToSearch) throws InvalidPathException, MaxFoundException{
        File path = new File(pathToSearch);//converts given search path to a File object
        if(path.isDirectory())
        {
            int i = 0; //index of files in directory
            File [] listFiles = path.listFiles();
            int size = listFiles.length; //number of items in current directory            
            //searches directory while more items available and space in MAX_NUMBER_FILES_TO_FIND
            while ( i < listFiles.length ){
                if (listFiles[i].isFile()){ 
                    if(listFiles[i].getName().equals(targetName)){
                        files[count] = listFiles[i].getPath();
                        count ++;//count of files found, also index in files array
                        i++;//moves to next file in directory
                        if(count >= files.length)
                            throw new MaxFoundException();
                    }
                    else
                        i++;//moves to next file in directory
                }
                else{//not a file ==> it's a directory!
                     directorySearch(targetName, listFiles[i].getPath());
                }
            }
        }
        else{
            throw new InvalidPathException(pathToSearch); //throws error if not directory
        }
    }
    /**
     * @return count of times a file name matches given target file
     */
    public int getCount(){
        return count;
    }
}

