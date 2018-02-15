package android.support.v4.p000a;

import android.support.v4.p004d.C0048a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: MyApp */
public class C0012j {
    int f13a;
    C0013k f14b;
    boolean f15c;
    boolean f16d;
    boolean f17e;
    boolean f18f;
    boolean f19g;

    public void m18a(int i, C0013k c0013k) {
        if (this.f14b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f14b = c0013k;
        this.f13a = i;
    }

    public void m19a(C0013k c0013k) {
        if (this.f14b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f14b != c0013k) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f14b = null;
        }
    }

    public final void m17a() {
        this.f15c = true;
        this.f17e = false;
        this.f16d = false;
        m21b();
    }

    protected void m21b() {
    }

    public void m22c() {
        this.f15c = false;
        m23d();
    }

    protected void m23d() {
    }

    public void m24e() {
        m25f();
        this.f17e = true;
        this.f15c = false;
        this.f16d = false;
        this.f18f = false;
        this.f19g = false;
    }

    protected void m25f() {
    }

    public String m16a(Object obj) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0048a.m316a(obj, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0048a.m316a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f13a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m20a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f13a);
        printWriter.print(" mListener=");
        printWriter.println(this.f14b);
        if (this.f15c || this.f18f || this.f19g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f15c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f18f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f19g);
        }
        if (this.f16d || this.f17e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f16d);
            printWriter.print(" mReset=");
            printWriter.println(this.f17e);
        }
    }
}
