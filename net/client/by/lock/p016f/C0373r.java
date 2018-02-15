package net.client.by.lock.p016f;

import android.content.SharedPreferences.Editor;
import java.util.Set;

/* compiled from: MyApp */
public class C0373r implements Editor {
    protected Editor f1573a;
    final /* synthetic */ C0372q f1574b;

    public /* synthetic */ Editor clear() {
        return m2538a();
    }

    public /* synthetic */ Editor putBoolean(String str, boolean z) {
        return m2546a(str, z);
    }

    public /* synthetic */ Editor putFloat(String str, float f) {
        return m2540a(str, f);
    }

    public /* synthetic */ Editor putInt(String str, int i) {
        return m2541a(str, i);
    }

    public /* synthetic */ Editor putLong(String str, long j) {
        return m2542a(str, j);
    }

    public /* synthetic */ Editor putString(String str, String str2) {
        return m2543a(str, str2);
    }

    public /* synthetic */ Editor putStringSet(String str, Set set) {
        return m2545a(str, set);
    }

    public /* synthetic */ Editor remove(String str) {
        return m2539a(str);
    }

    public C0373r(C0372q c0372q) {
        this.f1574b = c0372q;
        this.f1573a = c0372q.f1571a.edit();
    }

    public C0373r m2546a(String str, boolean z) {
        this.f1573a.putString(str, this.f1574b.m2532a(Boolean.toString(z)));
        return this;
    }

    public C0373r m2540a(String str, float f) {
        this.f1573a.putString(str, this.f1574b.m2532a(Float.toString(f)));
        return this;
    }

    public C0373r m2541a(String str, int i) {
        this.f1573a.putString(str, this.f1574b.m2532a(Integer.toString(i)));
        return this;
    }

    public C0373r m2542a(String str, long j) {
        this.f1573a.putString(str, this.f1574b.m2532a(Long.toString(j)));
        return this;
    }

    public C0373r m2543a(String str, String str2) {
        this.f1573a.putString(str, this.f1574b.m2532a(str2));
        return this;
    }

    public C0373r m2544a(String str, String str2, String str3) {
        this.f1573a.putString(str, this.f1574b.m2533a(str2, str3));
        return this;
    }

    public void apply() {
        this.f1573a.apply();
    }

    public C0373r m2538a() {
        this.f1573a.clear();
        return this;
    }

    public boolean commit() {
        return this.f1573a.commit();
    }

    public C0373r m2539a(String str) {
        this.f1573a.remove(str);
        return this;
    }

    public C0373r m2545a(String str, Set set) {
        throw new UnsupportedOperationException();
    }
}
