package util;

import java.util.regex.Pattern;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
	
public class DocumentUtil {
	public static PlainDocument getPlainDocument(final int maxLength,final String reg) { 
		PlainDocument p = new PlainDocument() {  
		private static final long serialVersionUID = 1L;

		public void insertString(int arg0, String arg1, javax.swing.text.AttributeSet arg2)  
		throws BadLocationException {  
		// TODO Auto-generated method stub  
			if (getLength() + arg1.length() <= maxLength && Pattern.matches(reg, arg1))  
				super.insertString(arg0, arg1, arg2);  
			}
		};  
		return p;  
	}
}
