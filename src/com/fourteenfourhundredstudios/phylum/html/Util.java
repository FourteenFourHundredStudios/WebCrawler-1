package com.fourteenfourhundredstudios.phylum.html;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

public class Util{
	
	public static void removeFirstLine(String fileName)  {  
		try{
	    RandomAccessFile raf = new RandomAccessFile(fileName, "rw");          
	     //Initial write position                                             
	    long writePosition = raf.getFilePointer();                            
	    raf.readLine();                                                       
	    // Shift the next lines upwards.                                      
	    long readPosition = raf.getFilePointer();                             

	    byte[] buff = new byte[1024];                                         
	    int n;                                                                
	    while (-1 != (n = raf.read(buff))) {                                  
	        raf.seek(writePosition);                                          
	        raf.write(buff, 0, n);                                            
	        readPosition += n;                                                
	        writePosition += n;                                               
	        raf.seek(readPosition);                                           
	    }                                                                     
	    raf.setLength(writePosition);                                         
	    raf.close();       
		}catch(Exception e){
			e.printStackTrace();
		}
	}         
	
	
	public static String getHash(String str){
	    
		 StringBuffer sb = new StringBuffer();
        try{
        	MessageDigest md = MessageDigest.getInstance("SHA-256");

	        byte[] dataBytes = new byte[1024];
	        byte[] strBytes=str.getBytes();
	        
	        //int nread = 0; 
	        for(byte b:strBytes){
	          md.update(dataBytes, 0, b);
	        };
	        byte[] mdbytes = md.digest();
	     
	        //convert the byte to hex format method 1
	       
	        for (int i = 0; i < mdbytes.length; i++) {
	          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
        }catch(Exception e){
        	e.printStackTrace();
        	System.out.println("Could not hash");
        }
        //System.out.println("Hex format : " + sb.toString());
        //return("Hex format : " + sb.toString());
        return (sb.toString());
       //convert the byte to hex format method 2
        /*
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
    	}

    	System.out.println("Hex format : " + hexString.toString());
    	*/
    }

}
