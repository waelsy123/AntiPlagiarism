import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class zip
{
   List<String> fileList;
   private  String INPUT_ZIP_FILE ;
   private  String OUTPUT_FOLDER ;

   public zip( String INPUT_ZIP_FILE, String OUTPUT_FOLDER )
   {
   	this.INPUT_ZIP_FILE = INPUT_ZIP_FILE;
   	this.OUTPUT_FOLDER = OUTPUT_FOLDER; 
   }

   /**
    * zip it
    * @param zipFile input zip file
    * @param output zip file output folder
    */
   public void unzip(){

    byte[] buffer = new byte[1024];

    try{

   	//create output directory is not exists
   	File folder = new File(OUTPUT_FOLDER);
   	if(!folder.exists()){
   	 folder.mkdir();
   	}

   	//get the zip file content
   	ZipInputStream zis = 
   	 new ZipInputStream(new FileInputStream(INPUT_ZIP_FILE));
   	//get the zipped file list entry
   	ZipEntry ze = zis.getNextEntry();

   	while(ze!=null){

   	   String fileName = ze.getName();
          File newFile = new File(OUTPUT_FOLDER + File.separator + fileName);

          System.out.println("file unzip : "+ newFile.getAbsoluteFile());
if (fileName.endsWith("/")) {
newFile.mkdirs();
ze = zis.getNextEntry();
continue;
}

File parent = newFile.getParentFile();
if (parent != null) {
parent.mkdirs();
}

           //create all non exists folders
           //else you will hit FileNotFoundException for compressed folder
           //new File(newFile.getParent()).mkdirs();

           FileOutputStream fos = new FileOutputStream(newFile);             

           int len;
           while ((len = zis.read(buffer)) > 0) {
      fos.write(buffer, 0, len);
           }

           fos.close();   
           ze = zis.getNextEntry();
   	}

       zis.closeEntry();
   	zis.close();

   	System.out.println("Done");

   }catch(IOException ex){
      ex.printStackTrace(); 
   }
  }    
}