package adts;

import java.awt.Container;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public class Utilities {
	
	private static final String version = "2.00.00";
	
	public static String getVersion() {
		return version;
	}
	
	public static long getVersionLong() {
		String str = version.replaceAll("[.]", "");
		return Long.parseLong(str);
	}
	
	public static long getSerialVersionUID() {
		return getVersionLong();
	}
	
	public static String readString(String str, InputStream in) throws IOException {
		if (str != null) System.out.println(str);
		StringBuffer buffer = new StringBuffer();
		int c = in.read();
		while (c == '\n' || c == '\r') c = in.read();
		while (c != '\n' || c != '\r') {
			buffer.append((char)c);
			c = in.read();
		}
		return buffer.toString();
	}
	
	public static String toStringContainer(String className, Path<?> p) {
		StringBuffer buffer = new StringBuffer("{" + className + ": ");
		while (p.isNext()) {
			Position<?> kv = (Position<?>) p.next();
			buffer.append(kv.getElem());
			if (p.isNext()) buffer.append(", ");
		}
		buffer.append("}");
		return buffer.toString();
	}
	
	public static String toStringContainerDelegation(String className, Container implementation) {
		return "[" + className + ": " + implementation.toString() + "]";
	}	
}
