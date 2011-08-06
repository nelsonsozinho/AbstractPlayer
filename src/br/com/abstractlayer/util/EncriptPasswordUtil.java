package br.com.abstractlayer.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptPasswordUtil {
	
	private static MessageDigest messageDigest;

	static {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * TODO implementar
	 * 
	 * @param password
	 * @return
	 */
	public static String utilEncriptPasswordHashMD5(String password) {
		try {
            messageDigest.reset();
            messageDigest.update(password.getBytes("ISO-8859-1"));
            byte[] digestByte = messageDigest.digest();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < digestByte.length; i++) {
                String hex = Integer.toHexString(0xFF & digestByte[i]);
                if (hex.length() == 1) {
                    buffer.append("0" + hex);
                } else {
                    buffer.append(hex);
                }
            }
            return buffer.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

	}

}
