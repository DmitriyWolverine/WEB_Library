package by.htp.login.bean.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

	private MD5() {
	}
	
	public static String md5Custom(String st) {
	    MessageDigest messageDigest = null;
	    byte[] digest = new byte[0];

	    try {
	        messageDigest = MessageDigest.getInstance("MD5");
	        messageDigest.reset();
	        messageDigest.update(st.getBytes());
	        digest = messageDigest.digest();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }

	    BigInteger bigInt = new BigInteger(1, digest);
	    String md5Hex = bigInt.toString(16);

	    while( md5Hex.length() < 32 ){
	        md5Hex = "0" + md5Hex;
	    }

	    return md5Hex;
	}
	
	
	public static String md5Apache(String st) {
	    return DigestUtils.md5Hex(st);
	}
	
	
}
