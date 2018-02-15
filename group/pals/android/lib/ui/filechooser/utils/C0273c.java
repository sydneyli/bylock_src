package group.pals.android.lib.ui.filechooser.utils;

import android.content.Context;
import android.text.format.DateUtils;
import group.pals.android.lib.ui.filechooser.be;
import group.pals.android.lib.ui.filechooser.p009a.C0224b;
import java.util.Calendar;

/* compiled from: MyApp */
public class C0273c {
    public static String m1884a(Context context, long j, C0224b c0224b) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return C0273c.m1885a(context, instance, c0224b);
    }

    public static String m1885a(Context context, Calendar calendar, C0224b c0224b) {
        Calendar instance = Calendar.getInstance();
        instance.add(6, -1);
        if (DateUtils.isToday(calendar.getTimeInMillis())) {
            return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), 1);
        }
        if (calendar.get(1) == instance.get(1) && calendar.get(6) == instance.get(6)) {
            return String.format("%s, %s", new Object[]{context.getString(be.afc_yesterday), DateUtils.formatDateTime(context, calendar.getTimeInMillis(), 1)});
        } else if (calendar.get(1) == instance.get(1)) {
            if (c0224b.m1769a()) {
                return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), 65561);
            }
            return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), 65560);
        } else if (c0224b.m1771b()) {
            return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), 65565);
        } else {
            return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), 65564);
        }
    }
}
