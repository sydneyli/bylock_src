package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p000a.C0012j;
import android.support.v4.p000a.C0013k;
import android.support.v4.p004d.C0048a;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: MyApp */
final class ae implements C0013k {
    final int f101a;
    final Bundle f102b;
    ac f103c;
    C0012j f104d;
    boolean f105e;
    boolean f106f;
    Object f107g;
    boolean f108h;
    boolean f109i;
    boolean f110j;
    boolean f111k;
    boolean f112l;
    boolean f113m;
    ae f114n;
    final /* synthetic */ ad f115o;

    void m112a() {
        if (this.f109i && this.f110j) {
            this.f108h = true;
        } else if (!this.f108h) {
            this.f108h = true;
            if (ad.f94a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f104d == null && this.f103c != null) {
                this.f104d = this.f103c.m99a(this.f101a, this.f102b);
            }
            if (this.f104d == null) {
                return;
            }
            if (!this.f104d.getClass().isMemberClass() || Modifier.isStatic(this.f104d.getClass().getModifiers())) {
                if (!this.f113m) {
                    this.f104d.m18a(this.f101a, this);
                    this.f113m = true;
                }
                this.f104d.m17a();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f104d);
        }
    }

    void m115b() {
        if (ad.f94a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f109i = true;
        this.f110j = this.f108h;
        this.f108h = false;
        this.f103c = null;
    }

    void m116c() {
        if (this.f109i) {
            if (ad.f94a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f109i = false;
            if (!(this.f108h == this.f110j || this.f108h)) {
                m118e();
            }
        }
        if (this.f108h && this.f105e && !this.f111k) {
            m113a(this.f104d, this.f107g);
        }
    }

    void m117d() {
        if (this.f108h && this.f111k) {
            this.f111k = false;
            if (this.f105e) {
                m113a(this.f104d, this.f107g);
            }
        }
    }

    void m118e() {
        if (ad.f94a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f108h = false;
        if (!this.f109i && this.f104d != null && this.f113m) {
            this.f113m = false;
            this.f104d.m19a((C0013k) this);
            this.f104d.m22c();
        }
    }

    void m119f() {
        String str;
        ac acVar = null;
        if (ad.f94a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f112l = true;
        boolean z = this.f106f;
        this.f106f = false;
        if (this.f103c != null && this.f104d != null && this.f105e && z) {
            if (ad.f94a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f115o.f98e != null) {
                String str2 = this.f115o.f98e.f181b.f225u;
                this.f115o.f98e.f181b.f225u = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f103c.m100a(this.f104d);
            } finally {
                acVar = this.f115o.f98e;
                if (acVar != null) {
                    acVar = this.f115o.f98e.f181b;
                    acVar.f225u = str;
                }
            }
        }
        this.f103c = acVar;
        this.f107g = acVar;
        this.f105e = false;
        if (this.f104d != null) {
            if (this.f113m) {
                this.f113m = false;
                this.f104d.m19a((C0013k) this);
            }
            this.f104d.m24e();
        }
        if (this.f114n != null) {
            this.f114n.m119f();
        }
    }

    void m113a(C0012j c0012j, Object obj) {
        String str;
        if (this.f103c != null) {
            if (this.f115o.f98e != null) {
                String str2 = this.f115o.f98e.f181b.f225u;
                this.f115o.f98e.f181b.f225u = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (ad.f94a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + c0012j + ": " + c0012j.m16a(obj));
                }
                this.f103c.m101a(c0012j, obj);
                this.f106f = true;
            } finally {
                if (this.f115o.f98e != null) {
                    this.f115o.f98e.f181b.f225u = str;
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f101a);
        stringBuilder.append(" : ");
        C0048a.m316a(this.f104d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m114a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f101a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f102b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f103c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f104d);
        if (this.f104d != null) {
            this.f104d.m20a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f105e || this.f106f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f105e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f106f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f107g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f108h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f111k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f112l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f109i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f110j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f113m);
        if (this.f114n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f114n);
            printWriter.println(":");
            this.f114n.m114a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
