package br.com.abstractlayer.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TestSystemFileUtil {

	@Test
	public void testFile2ByteFileArray() {
		File arquivo = new File("src/applicationContext.xml");
		byte[] binario = null;
		
		assertTrue("arquivo nao existente",arquivo.exists());
		
		try {
			binario = SystemFileUtil.file2ByteFileArray(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(binario);
	}
	
}
