package br.com.abstractlayer.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Classe que contem os utilitarios para a manipulacao de binarios 
 * no sistema de arquivos nativo
 * 
 * @author Nelson
 *
 */
public class SystemFileUtil {
	
	public static byte[] file2ByteFileArray(File arquivo) throws IOException  {
		InputStream is = new FileInputStream(arquivo);
	    
        // Get the size of the file
        long length = arquivo.length();
    
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];
    
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
        		&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
        	offset += numRead;
        }
        
        //Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+arquivo.getName());
        }
        
        //Close the input stream and return bytes
        is.close();
        return bytes;
	}
}
