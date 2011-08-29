package util;

public class ServerUtil {
	public static String encryptionStr(String string) {
		String encStr = null;
		char  charBeEnc[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			char charWantEnc = string.charAt(i);
			int asii = (int)charWantEnc;
			int intEnc = asii+2;
			charBeEnc[i] = (char)intEnc;
		}
		encStr = new String(charBeEnc);
		return encStr;
	}
	public static String deencryptionStr(String string) {
		String deEncStr = null;
		char  charBeDeEnc[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			char charWantDeEnc = string.charAt(i);
			int asii = (int)charWantDeEnc;
			int intDeEnc = asii-2;
			charBeDeEnc[i] = (char)intDeEnc;
		}
		
		deEncStr = new String(charBeDeEnc);
		return deEncStr;
	}
}
