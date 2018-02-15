package group.pals.android.lib.ui.filechooser.utils;

/* compiled from: MyApp */
public class C0272b {
    public static String m1883a(double d) {
        if (d <= 0.0d) {
            return "0 B";
        }
        String[] strArr = new String[]{"B", "KB", "MB", "GB", "TB"};
        Short valueOf = Short.valueOf((short) 1024);
        int log10 = (int) (Math.log10(d) / Math.log10((double) valueOf.shortValue()));
        if (log10 >= strArr.length) {
            log10 = strArr.length - 1;
        }
        double pow = d / Math.pow((double) valueOf.shortValue(), (double) log10);
        String str = "%s %%s";
        Object[] objArr = new Object[1];
        objArr[0] = log10 == 0 ? "%,.0f" : "%,.2f";
        return String.format(String.format(str, objArr), new Object[]{Double.valueOf(pow), strArr[log10]});
    }
}
