package util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class StringUtil {
	public static String encriptString(String str) {
		String result = "";
		PBEKeySpec pbeKeySpec;
		PBEParameterSpec pbeParameterSpec;
		SecretKeyFactory keyFactory;
		char[] password = "a".toCharArray();
		byte[] salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c, (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
		int count = 20;
		try {
			pbeParameterSpec = new PBEParameterSpec(salt, count);
			pbeKeySpec = new PBEKeySpec(password);
			keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey pbeKey = keyFactory.generateSecret(pbeKeySpec);
			Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
			pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey,pbeParameterSpec);
			byte[] plainText = pbeCipher.doFinal(str.getBytes());
			result = new String(plainText);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public static String decriptString(String str) {
		String result = "";
		PBEKeySpec pbeKeySpec;
		PBEParameterSpec pbeParameterSpec;
		SecretKeyFactory keyFactory;
		char[] password = "a".toCharArray();
		byte[] salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c, (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
		int count = 20;
		try {
			pbeParameterSpec = new PBEParameterSpec(salt, count);
			pbeKeySpec = new PBEKeySpec(password);
			keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey pbeKey = keyFactory.generateSecret(pbeKeySpec);
			Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
			pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey,pbeParameterSpec);
			byte[] plainText = pbeCipher.doFinal(str.getBytes());
			result = new String(plainText);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public static String toUTF8(String isoString) {
		String utf8String = null;
		if(isoString!=null && !isoString.equals("")){
			try {
				byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");
				utf8String = new String(stringBytesISO,"UTF-8");
			} catch (Exception e) {
				utf8String = isoString;
			}
		}
		else{
			utf8String = isoString;
		}
		return utf8String;
		}
}
