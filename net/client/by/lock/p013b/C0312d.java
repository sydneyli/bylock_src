package net.client.by.lock.p013b;

import java.io.File;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.client.by.lock.p012d.C0288k;
import net.client.by.lock.p016f.C0363h;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.task.FileTask;

/* compiled from: MyApp */
public abstract class C0312d extends C0288k implements C0308a {
    protected int f1361a;
    protected FileTask f1362b;
    private String f1363c;
    private String f1364i;
    private File f1365j;
    private String f1366k;
    private C0363h f1367l;
    private SecretKeySpec f1368m;
    private IvParameterSpec f1369n;

    protected C0312d() {
        this.f = new C0363h("IDLE", "stateProperty");
        this.f1367l = new C0363h("fileId");
        this.f1361a = -1;
        this.f1366k = null;
    }

    protected String mo318a() {
        return this.f1364i + " (Dosya) (" + C0365j.m2474a((long) this.f1361a) + ")";
    }

    public void m2039g() {
        this.f.m2468a((Object) "COMPLETED");
    }

    public void m2029a(Throwable th) {
        this.f.m2468a((Object) "ERROR");
        this.f1362b = null;
        C0365j.m2476a("Error occured in file transfer", th);
    }

    public Integer mo326f() {
        if (this.f1361a > 0) {
            return Integer.valueOf(this.f1361a);
        }
        if (this.f1365j == null || !this.f1365j.exists()) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf((int) this.f1365j.length());
    }

    public void m2026a(int i) {
        this.f1361a = i;
    }

    public void m2028a(String str) {
        this.f1367l.m2468a((Object) str);
    }

    public String mo322b() {
        return (String) this.f1367l.m2467a();
    }

    public C0363h m2040h() {
        return this.f1367l;
    }

    public void m2030a(IvParameterSpec ivParameterSpec) {
        this.f1369n = ivParameterSpec;
    }

    public IvParameterSpec mo324d() {
        return this.f1369n;
    }

    public String mo325e() {
        if (this.f1364i != null || this.f1365j == null) {
            return this.f1364i;
        }
        return this.f1365j.getName();
    }

    public void m2033b(String str) {
        this.f1364i = str;
    }

    public SecretKeySpec mo323c() {
        return this.f1368m;
    }

    public void m2031a(SecretKeySpec secretKeySpec) {
        this.f1368m = secretKeySpec;
    }

    public String m2041i() {
        return this.f1363c;
    }

    public void m2035c(String str) {
        this.f1363c = str;
    }

    public void m2027a(File file) {
        this.f1365j = file;
    }

    public File m2042j() {
        return this.f1365j;
    }

    public void m2043k() {
        if (this.f1362b != null) {
            this.f1362b.cancelTask(true);
            this.f.m2468a((Object) "IDLE");
            this.f1362b = null;
        }
    }
}
