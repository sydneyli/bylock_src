package net.client.by.lock.p016f;

/* compiled from: MyApp */
public class C0366k {
    public static C0367l m2481a(String str) {
        if (str == null || str.length() < 6) {
            return C0367l.MISSING_LENGTH;
        }
        if (!str.matches(".*[a-zA-Z].*")) {
            return C0367l.MISSING_LETTER;
        }
        if (str.matches("[a-zA-Z0-9]*")) {
            return C0367l.MISSING_SYMBOL;
        }
        return C0367l.SECURE;
    }
}
