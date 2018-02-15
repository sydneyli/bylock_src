package net.client.by.lock.p014c;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ap;
import java.util.Calendar;
import java.util.Date;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.gui.activity.SplashActivity;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.reciever.AlarmReceiver;
import net.client.by.lock.reciever.NetworkStatusReciever;
import net.client.by.lock.service.BackgroundService;

/* compiled from: MyApp */
public class C0323a {
    public static int f1404a = 21337;
    static Date f1405b = null;
    private static PendingIntent f1406c;
    private static PendingIntent f1407d;
    private static int f1408e = 3;
    private static String f1409f = "AlarmRecieverManager";

    public static void m2081a(Context context) {
        C0322b.m2075d(f1409f, "setupSavePassword start!");
        if (C0351r.m2359i().m2395q() && C0351r.m2359i().m2396r()) {
            C0331i.m2124a().m2138d(context);
            Calendar instance = Calendar.getInstance();
            instance.add(13, 1800);
            Intent intent = new Intent("by.lock.BackgroundService");
            intent.putExtra("what", 13);
            f1406c = PendingIntent.getBroadcast(context, 2928371, intent, 268435456);
            ((AlarmManager) context.getSystemService("alarm")).set(0, instance.getTimeInMillis(), f1406c);
        }
        C0322b.m2075d(f1409f, "setupSavePassword end!");
    }

    public static void m2082b(Context context) {
        f1408e = 3;
        C0322b.m2075d(f1409f, "setupGetRosterEvent start!");
        if (!NetworkStatusReciever.m2754a().booleanValue()) {
            C0322b.m2075d(f1409f, "setupGetRosterEvent not online!");
            f1408e = 30;
        }
        Calendar instance = Calendar.getInstance();
        instance.add(13, f1408e);
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra("alarm_message", "roster_event");
        f1406c = PendingIntent.getBroadcast(context, 292837, intent, 268435456);
        ((AlarmManager) context.getSystemService("alarm")).set(0, instance.getTimeInMillis(), f1406c);
        C0322b.m2075d(f1409f, "setupGetRosterEvent end!");
    }

    public static void m2083c(Context context) {
        C0322b.m2075d(f1409f, "setupTryLogin start!");
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(13, -10);
        if (f1405b == null || !f1405b.after(instance.getTime())) {
            int i;
            f1405b = date;
            try {
                if (!C0351r.m2359i().m2396r()) {
                    C0322b.m2078v(f1409f, "no user pass");
                    C0331i.m2124a().m2140e(context);
                    if (!C0351r.m2359i().m2396r()) {
                        C0322b.m2078v(f1409f, "still no user pass");
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                        Intent intent = new Intent(context, SplashActivity.class);
                        intent.addFlags(67108864);
                        CharSequence string = C0330h.m2111a().m2117b().getString(R.string.session_logged_off);
                        BackgroundService.m2758a(C0331i.m2124a().m2145h(context), 1);
                        notificationManager.notify(f1404a, new ap(context).m150a(false).m147a((int) R.drawable.action_logout).m149a((CharSequence) "byLock").m153c(string).m152b(true).m148a(PendingIntent.getActivity(context, f1404a, intent, 268435456)).m151b((CharSequence) "Session logged off, please relogin").m146a());
                        C0332j.m2148a().m2178d();
                        return;
                    }
                }
            } catch (Exception e) {
                C0322b.m2076e(f1409f, "setupTryLogin no username check failed!" + e.toString());
            }
            if (NetworkStatusReciever.m2754a().booleanValue()) {
                i = 3;
            } else {
                C0322b.m2075d(f1409f, "setupTryLogin not online!");
                i = 30;
            }
            instance.setTime(new Date());
            instance.add(13, i);
            Intent intent2 = new Intent(context, AlarmReceiver.class);
            intent2.putExtra("alarm_message", "try_login");
            f1407d = PendingIntent.getBroadcast(context, 192837, intent2, 268435456);
            ((AlarmManager) context.getSystemService("alarm")).set(0, instance.getTimeInMillis(), f1407d);
            C0322b.m2075d(f1409f, "setupTryLogin end!");
            return;
        }
        C0322b.m2075d(f1409f, "setupTryLogin early retry!");
    }

    public static void m2080a() {
        if (f1406c != null) {
            f1406c.cancel();
        }
        if (f1407d != null) {
            f1407d.cancel();
        }
    }
}
