package ua.plitker.core.util.logging;

public class LoggerUtil {

	public static Class<?> getLoggingClass() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final String className = stackTrace[1].getClassName();
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getLoggingClassName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[1].getClassName();
	}
}
