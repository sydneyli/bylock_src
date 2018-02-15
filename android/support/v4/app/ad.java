package android.support.v4.app;

import android.support.v4.p004d.C0048a;
import android.support.v4.p004d.C0050c;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: MyApp */
class ad extends ab {
    static boolean f94a = false;
    final C0050c f95b = new C0050c();
    final C0050c f96c = new C0050c();
    final String f97d;
    C0024j f98e;
    boolean f99f;
    boolean f100g;

    ad(String str, C0024j c0024j, boolean z) {
        this.f97d = str;
        this.f98e = c0024j;
        this.f99f = z;
    }

    void m102a(C0024j c0024j) {
        this.f98e = c0024j;
    }

    void m105b() {
        if (f94a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f99f) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f99f = true;
        for (int a = this.f95b.m321a() - 1; a >= 0; a--) {
            ((ae) this.f95b.m323b(a)).m112a();
        }
    }

    void m106c() {
        if (f94a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f99f) {
            for (int a = this.f95b.m321a() - 1; a >= 0; a--) {
                ((ae) this.f95b.m323b(a)).m118e();
            }
            this.f99f = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m107d() {
        if (f94a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f99f) {
            this.f100g = true;
            this.f99f = false;
            for (int a = this.f95b.m321a() - 1; a >= 0; a--) {
                ((ae) this.f95b.m323b(a)).m115b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m108e() {
        if (this.f100g) {
            if (f94a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f100g = false;
            for (int a = this.f95b.m321a() - 1; a >= 0; a--) {
                ((ae) this.f95b.m323b(a)).m116c();
            }
        }
    }

    void m109f() {
        for (int a = this.f95b.m321a() - 1; a >= 0; a--) {
            ((ae) this.f95b.m323b(a)).f111k = true;
        }
    }

    void m110g() {
        for (int a = this.f95b.m321a() - 1; a >= 0; a--) {
            ((ae) this.f95b.m323b(a)).m117d();
        }
    }

    void m111h() {
        int a;
        if (!this.f100g) {
            if (f94a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (a = this.f95b.m321a() - 1; a >= 0; a--) {
                ((ae) this.f95b.m323b(a)).m119f();
            }
            this.f95b.m324b();
        }
        if (f94a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (a = this.f96c.m321a() - 1; a >= 0; a--) {
            ((ae) this.f96c.m323b(a)).m119f();
        }
        this.f96c.m324b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0048a.m316a(this.f98e, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m103a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f95b.m321a() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f95b.m321a(); i2++) {
                ae aeVar = (ae) this.f95b.m323b(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f95b.m322a(i2));
                printWriter.print(": ");
                printWriter.println(aeVar.toString());
                aeVar.m114a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f96c.m321a() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f96c.m321a()) {
                aeVar = (ae) this.f96c.m323b(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f96c.m322a(i));
                printWriter.print(": ");
                printWriter.println(aeVar.toString());
                aeVar.m114a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo2a() {
        int a = this.f95b.m321a();
        boolean z = false;
        for (int i = 0; i < a; i++) {
            int i2;
            ae aeVar = (ae) this.f95b.m323b(i);
            if (!aeVar.f108h || aeVar.f106f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
