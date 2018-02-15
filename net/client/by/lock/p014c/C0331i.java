package net.client.by.lock.p014c;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Environment;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.client.by.lock.C0322b;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0372q;
import net.client.by.lock.p016f.C0373r;

/* compiled from: MyApp */
public class C0331i {
    private static C0331i f1433a = null;
    private static boolean f1434j = false;
    private String f1435b = "";
    private int f1436c = -1;
    private String f1437d = "";
    private ArrayList f1438e = new ArrayList();
    private Uri f1439f;
    private Uri f1440g;
    private Uri f1441h;
    private Uri f1442i;
    private boolean f1443k = false;
    private String f1444l = "";

    public static C0331i m2124a() {
        if (f1433a == null) {
            f1433a = new C0331i();
        }
        return f1433a;
    }

    private C0331i() {
    }

    public String m2132b() {
        return this.f1435b;
    }

    public void m2127a(Context context) {
        C0372q c0372q = new C0372q(context);
        this.f1435b = c0372q.getString("downloadDirectory", new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/byLock-Downloads").toString());
        this.f1437d = c0372q.getString("cache", "null");
        this.f1436c = c0372q.getInt("frequency", -1);
        for (String str : c0372q.getString("expandedGroups", "0;").split(";")) {
            if (str.length() > 0) {
                this.f1438e.add(Integer.valueOf(Integer.parseInt(str)));
            }
        }
        this.f1439f = Uri.parse(c0372q.getString("ringTone", RingtoneManager.getDefaultUri(1).toString()));
        this.f1440g = Uri.parse(c0372q.getString("fileTone", RingtoneManager.getDefaultUri(2).toString()));
        this.f1441h = Uri.parse(c0372q.getString("msgTone", RingtoneManager.getDefaultUri(2).toString()));
        this.f1442i = Uri.parse(c0372q.getString("mailTone", RingtoneManager.getDefaultUri(2).toString()));
    }

    public void m2133b(Context context) {
        C0372q c0372q = new C0372q(context);
        String str = "";
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Throwable e) {
            C0365j.m2476a("SettingsManager", e);
        }
        messageDigest.reset();
        messageDigest.update(C0351r.m2359i().m2389k().getBytes());
        String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
        this.f1444l = c0372q.getString("pin@" + bigInteger, "");
        messageDigest.reset();
        this.f1443k = Boolean.valueOf(c0372q.getBoolean("lock" + bigInteger, false)).booleanValue();
        f1434j = true;
    }

    public void m2136c(Context context) {
        m2128a(context, "", "");
    }

    public void m2138d(Context context) {
        m2128a(context, C0351r.m2359i().m2389k(), C0351r.m2359i().m2390l());
    }

    public void m2128a(Context context, String str, String str2) {
        C0373r a = new C0372q(context).m2535a();
        String a2 = m2123a(Boolean.valueOf(false));
        a.m2544a("usr", str, a2);
        a.m2544a("psw", str2, a2);
        a.commit();
    }

    private String m2123a(Boolean bool) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyyHH");
        String str = "letItBE!1";
        try {
            Date date = new Date();
            if (bool.booleanValue()) {
                date.setTime(date.getTime() - 3600000);
            }
            str = new StringBuilder(String.valueOf(str)).append(simpleDateFormat.format(date)).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public void m2140e(Context context) {
        try {
            C0372q c0372q = new C0372q(context);
            String a = m2123a(Boolean.valueOf(false));
            String a2 = c0372q.m2534a("usr", "", a);
            if (a2 == null || a2.equals("")) {
                a = m2123a(Boolean.valueOf(true));
                a2 = c0372q.m2534a("usr", "", a);
            }
            C0351r.m2359i().m2377d(a2);
            C0351r.m2359i().m2382f(c0372q.m2534a("psw", "", a));
        } catch (Exception e) {
            C0322b.m2076e("SettingsManager", "loadusr failed:" + e.toString());
        }
    }

    public void m2141f(Context context) {
        Editor a = new C0372q(context).m2535a();
        a.putString("downloadDirectory", this.f1435b);
        a.putString("cache", this.f1437d);
        a.putInt("frequency", this.f1436c);
        Iterator it = this.f1438e.iterator();
        String str = "";
        while (it.hasNext()) {
            str = new StringBuilder(String.valueOf(str)).append(((Integer) it.next()).intValue()).append(";").toString();
        }
        a.putString("expandedGroups", str);
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Throwable e) {
            C0365j.m2476a("SettingsManager", e);
        }
        a.putString("ringTone", this.f1439f.toString());
        a.putString("msgTone", this.f1441h.toString());
        a.putString("fileTone", this.f1440g.toString());
        a.putString("mailTone", this.f1442i.toString());
        messageDigest.reset();
        messageDigest.update(C0351r.m2359i().m2389k().getBytes());
        String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
        a.putString("pin@" + bigInteger, this.f1444l);
        a.putBoolean("lock@" + bigInteger, this.f1443k);
        if (!a.commit()) {
            C0322b.m2076e("SettingsManager", "save, cannot commit");
        }
    }

    public ArrayList m2135c() {
        return this.f1438e;
    }

    public void m2130a(ArrayList arrayList) {
        this.f1438e = arrayList;
    }

    public int m2137d() {
        return this.f1436c;
    }

    public void m2126a(int i) {
        this.f1436c = i;
    }

    public String m2139e() {
        return this.f1437d;
    }

    public void m2129a(String str) {
        this.f1437d = str;
    }

    public Uri m2143g(Context context) {
        if (RingtoneManager.getRingtone(context, this.f1439f) == null) {
            this.f1439f = RingtoneManager.getDefaultUri(1);
        }
        return this.f1439f;
    }

    public Uri m2145h(Context context) {
        if (RingtoneManager.getRingtone(context, this.f1440g) == null) {
            this.f1440g = RingtoneManager.getDefaultUri(2);
        }
        return this.f1440g;
    }

    public Uri m2146i(Context context) {
        if (RingtoneManager.getRingtone(context, this.f1441h) == null) {
            this.f1441h = RingtoneManager.getDefaultUri(2);
        }
        return this.f1441h;
    }

    public Uri m2147j(Context context) {
        if (RingtoneManager.getRingtone(context, this.f1442i) == null) {
            this.f1442i = RingtoneManager.getDefaultUri(2);
        }
        return this.f1442i;
    }

    public void m2131a(boolean z) {
        this.f1443k = z;
    }

    public boolean m2142f() {
        return this.f1443k;
    }

    public void m2134b(String str) {
        this.f1444l = str;
    }

    public String m2144g() {
        if (this.f1444l.equals("")) {
            this.f1444l = "1234";
        }
        return this.f1444l;
    }

    public static boolean m2125h() {
        return f1434j;
    }
}
