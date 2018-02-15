package net.client.by.lock.p016f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.provider.Settings.Secure;
import android.util.Base64;
import java.security.Key;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/* compiled from: MyApp */
public class C0372q implements SharedPreferences {
    private static final char[] f1570c = "INSERT A RANDOM PASSWORD HERE".toCharArray();
    protected SharedPreferences f1571a;
    protected Context f1572b;

    public /* synthetic */ Editor edit() {
        return m2535a();
    }

    public C0372q(Context context) {
        this.f1571a = context.getSharedPreferences("AppPrefFile", 0);
        this.f1572b = context;
    }

    public C0373r m2535a() {
        return new C0373r(this);
    }

    public Map getAll() {
        throw new UnsupportedOperationException();
    }

    public boolean getBoolean(String str, boolean z) {
        String string = this.f1571a.getString(str, null);
        return string != null ? Boolean.parseBoolean(m2536b(string)) : z;
    }

    public float getFloat(String str, float f) {
        String string = this.f1571a.getString(str, null);
        return string != null ? Float.parseFloat(m2536b(string)) : f;
    }

    public int getInt(String str, int i) {
        String string = this.f1571a.getString(str, null);
        return string != null ? Integer.parseInt(m2536b(string)) : i;
    }

    public long getLong(String str, long j) {
        String string = this.f1571a.getString(str, null);
        return string != null ? Long.parseLong(m2536b(string)) : j;
    }

    public String getString(String str, String str2) {
        String string = this.f1571a.getString(str, null);
        return string != null ? m2536b(string) : str2;
    }

    public String m2534a(String str, String str2, String str3) {
        String string = this.f1571a.getString(str, null);
        return string != null ? m2537b(string, str3) : str2;
    }

    public boolean contains(String str) {
        return this.f1571a.contains(str);
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f1571a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f1571a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    protected String m2532a(String str) {
        return m2533a(str, "");
    }

    protected String m2533a(String str, String str2) {
        byte[] bytes;
        String stringBuilder = new StringBuilder(String.valueOf(new String(f1570c))).append(str2).toString();
        if (str != null) {
            try {
                bytes = str.getBytes("utf-8");
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        bytes = new byte[0];
        Key generateSecret = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(stringBuilder.toCharArray()));
        Cipher instance = Cipher.getInstance("PBEWithMD5AndDES");
        instance.init(1, generateSecret, new PBEParameterSpec(Secure.getString(this.f1572b.getContentResolver(), "android_id").getBytes("utf-8"), 20));
        return new String(Base64.encode(instance.doFinal(bytes), 2), "utf-8");
    }

    protected String m2536b(String str) {
        return m2537b(str, "");
    }

    protected String m2537b(String str, String str2) {
        byte[] decode;
        String stringBuilder = new StringBuilder(String.valueOf(new String(f1570c))).append(str2).toString();
        if (str != null) {
            try {
                decode = Base64.decode(str, 0);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        decode = new byte[0];
        Key generateSecret = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(stringBuilder.toCharArray()));
        Cipher instance = Cipher.getInstance("PBEWithMD5AndDES");
        instance.init(2, generateSecret, new PBEParameterSpec(Secure.getString(this.f1572b.getContentResolver(), "android_id").getBytes("utf-8"), 20));
        return new String(instance.doFinal(decode), "utf-8");
    }

    public Set getStringSet(String str, Set set) {
        throw new UnsupportedOperationException();
    }
}
