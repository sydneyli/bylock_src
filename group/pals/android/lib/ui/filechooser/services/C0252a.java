package group.pals.android.lib.ui.filechooser.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* compiled from: MyApp */
public abstract class C0252a extends Service implements C0251c {
    private final IBinder f1172a = new C0253b(this);
    private boolean f1173b = false;
    private String f1174c = null;
    private C0254d f1175d = C0254d.FilesOnly;
    private int f1176e = 1024;
    private C0256f f1177f = C0256f.SortByName;
    private C0255e f1178g = C0255e.Ascending;

    public IBinder onBind(Intent intent) {
        return this.f1172a;
    }

    public void mo307a(boolean z) {
        this.f1173b = z;
    }

    public boolean m1855a() {
        return this.f1173b;
    }

    public void mo306a(String str) {
        this.f1174c = str;
    }

    public String m1856b() {
        return this.f1174c;
    }

    public void mo303a(C0254d c0254d) {
        this.f1175d = c0254d;
    }

    public C0254d mo308c() {
        return this.f1175d;
    }

    public void mo305a(C0256f c0256f) {
        this.f1177f = c0256f;
    }

    public C0256f mo309d() {
        return this.f1177f;
    }

    public void mo304a(C0255e c0255e) {
        this.f1178g = c0255e;
    }

    public C0255e mo310e() {
        return this.f1178g;
    }

    public void mo302a(int i) {
        this.f1176e = i;
    }

    public int mo311f() {
        return this.f1176e;
    }
}
