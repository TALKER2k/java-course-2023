package edu.hw2;

public final class Task4 {
    private Task4() {}

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement callingMethod = stackTrace[2];
        return new CallingInfo(callingMethod.getClassName(), callingMethod.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {}
}
