package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p004d.C0048a;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

/* compiled from: MyApp */
public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final HashMap f30P = new HashMap();
    boolean f31A;
    boolean f32B;
    boolean f33C;
    boolean f34D;
    boolean f35E = true;
    boolean f36F;
    int f37G;
    ViewGroup f38H;
    View f39I;
    View f40J;
    boolean f41K;
    boolean f42L = true;
    ad f43M;
    boolean f44N;
    boolean f45O;
    int f46a = 0;
    View f47b;
    int f48c;
    Bundle f49d;
    SparseArray f50e;
    int f51f = -1;
    String f52g;
    Bundle f53h;
    Fragment f54i;
    int f55j = -1;
    int f56k;
    boolean f57l;
    boolean f58m;
    boolean f59n;
    boolean f60o;
    boolean f61p;
    boolean f62q;
    int f63r;
    C0031r f64s;
    C0024j f65t;
    C0031r f66u;
    Fragment f67v;
    int f68w;
    int f69x;
    String f70y;
    boolean f71z;

    /* compiled from: MyApp */
    public class SavedState implements Parcelable {
        public static final Creator CREATOR = new C0023i();
        final Bundle f29a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f29a = parcel.readBundle();
            if (classLoader != null && this.f29a != null) {
                this.f29a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f29a);
        }
    }

    public static Fragment m27a(Context context, String str) {
        return m28a(context, str, null);
    }

    public static Fragment m28a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f30P.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f30P.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f53h = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new C0022h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0022h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0022h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    final void m38a(Bundle bundle) {
        if (this.f50e != null) {
            this.f40J.restoreHierarchyState(this.f50e);
            this.f50e = null;
        }
        this.f36F = false;
        m64e(bundle);
        if (!this.f36F) {
            throw new ba("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    final void m32a(int i, Fragment fragment) {
        this.f51f = i;
        if (fragment != null) {
            this.f52g = fragment.f52g + ":" + this.f51f;
        } else {
            this.f52g = "android:fragment:" + this.f51f;
        }
    }

    final boolean m45a() {
        return this.f63r > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0048a.m316a(this, stringBuilder);
        if (this.f51f >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f51f);
        }
        if (this.f68w != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f68w));
        }
        if (this.f70y != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f70y);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final C0024j m47b() {
        return this.f65t;
    }

    public final Resources m54c() {
        if (this.f65t != null) {
            return this.f65t.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final boolean m62d() {
        return this.f65t != null && this.f57l;
    }

    public final boolean m65e() {
        return this.f31A;
    }

    public final boolean m67f() {
        return this.f71z;
    }

    public void m44a(boolean z) {
    }

    public void m51b(boolean z) {
        if (this.f34D != z) {
            this.f34D = z;
            if (m62d() && !m67f()) {
                this.f65t.mo155c();
            }
        }
    }

    public void m56c(boolean z) {
        if (this.f35E != z) {
            this.f35E = z;
            if (this.f34D && m62d() && !m67f()) {
                this.f65t.mo155c();
            }
        }
    }

    public void m61d(boolean z) {
        if (!this.f42L && z && this.f46a < 4) {
            this.f64s.m229a(this);
        }
        this.f42L = z;
        this.f41K = !z;
    }

    public void m35a(Intent intent) {
        if (this.f65t == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f65t.m199a(this, intent, -1);
    }

    public void m36a(Intent intent, int i) {
        if (this.f65t == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f65t.m199a(this, intent, i);
    }

    public void mo356a(int i, int i2, Intent intent) {
    }

    public LayoutInflater m48b(Bundle bundle) {
        return this.f65t.getLayoutInflater();
    }

    public void m34a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f36F = true;
    }

    public void m33a(Activity activity) {
        this.f36F = true;
    }

    public Animation m30a(int i, boolean z, int i2) {
        return null;
    }

    public void mo348c(Bundle bundle) {
        this.f36F = true;
    }

    public View mo347a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void m42a(View view, Bundle bundle) {
    }

    public View m68g() {
        return this.f39I;
    }

    public void m59d(Bundle bundle) {
        this.f36F = true;
    }

    public void m64e(Bundle bundle) {
        this.f36F = true;
    }

    public void m70h() {
        this.f36F = true;
        if (!this.f44N) {
            this.f44N = true;
            if (!this.f45O) {
                this.f45O = true;
                this.f43M = this.f65t.m197a(this.f52g, this.f44N, false);
            }
            if (this.f43M != null) {
                this.f43M.m105b();
            }
        }
    }

    public void mo349i() {
        this.f36F = true;
    }

    public void m66f(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f36F = true;
    }

    public void mo350j() {
        this.f36F = true;
    }

    public void m75k() {
        this.f36F = true;
    }

    public void onLowMemory() {
        this.f36F = true;
    }

    public void mo351l() {
        this.f36F = true;
    }

    public void m77m() {
        this.f36F = true;
        if (!this.f45O) {
            this.f45O = true;
            this.f43M = this.f65t.m197a(this.f52g, this.f44N, false);
        }
        if (this.f43M != null) {
            this.f43M.m111h();
        }
    }

    void m78n() {
        this.f51f = -1;
        this.f52g = null;
        this.f57l = false;
        this.f58m = false;
        this.f59n = false;
        this.f60o = false;
        this.f61p = false;
        this.f62q = false;
        this.f63r = 0;
        this.f64s = null;
        this.f65t = null;
        this.f68w = 0;
        this.f69x = 0;
        this.f70y = null;
        this.f71z = false;
        this.f31A = false;
        this.f33C = false;
        this.f43M = null;
        this.f44N = false;
        this.f45O = false;
    }

    public void m79o() {
        this.f36F = true;
    }

    public void mo352a(Menu menu, MenuInflater menuInflater) {
    }

    public void m39a(Menu menu) {
    }

    public void m80p() {
    }

    public boolean mo353a(MenuItem menuItem) {
        return false;
    }

    public void m50b(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m47b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void m41a(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public boolean mo354b(MenuItem menuItem) {
        return false;
    }

    public void m43a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f68w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f69x));
        printWriter.print(" mTag=");
        printWriter.println(this.f70y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f46a);
        printWriter.print(" mIndex=");
        printWriter.print(this.f51f);
        printWriter.print(" mWho=");
        printWriter.print(this.f52g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f63r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f57l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f58m);
        printWriter.print(" mResumed=");
        printWriter.print(this.f59n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f60o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f61p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f71z);
        printWriter.print(" mDetached=");
        printWriter.print(this.f31A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f35E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f34D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f32B);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f33C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f42L);
        if (this.f64s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f64s);
        }
        if (this.f65t != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.f65t);
        }
        if (this.f67v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f67v);
        }
        if (this.f53h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f53h);
        }
        if (this.f49d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f49d);
        }
        if (this.f50e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f50e);
        }
        if (this.f54i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f54i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f56k);
        }
        if (this.f37G != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f37G);
        }
        if (this.f38H != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f38H);
        }
        if (this.f39I != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f39I);
        }
        if (this.f40J != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f39I);
        }
        if (this.f47b != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f47b);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f48c);
        }
        if (this.f43M != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f43M.m103a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f66u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f66u + ":");
            this.f66u.m235a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void m81q() {
        this.f66u = new C0031r();
        this.f66u.m233a(this.f65t, new C0021g(this), this);
    }

    void m69g(Bundle bundle) {
        if (this.f66u != null) {
            this.f66u.m260i();
        }
        this.f36F = false;
        mo348c(bundle);
        if (!this.f36F) {
            throw new ba("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f66u == null) {
                    m81q();
                }
                this.f66u.m228a(parcelable, null);
                this.f66u.m261j();
            }
        }
    }

    View m49b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f66u != null) {
            this.f66u.m260i();
        }
        return mo347a(layoutInflater, viewGroup, bundle);
    }

    void m71h(Bundle bundle) {
        if (this.f66u != null) {
            this.f66u.m260i();
        }
        this.f36F = false;
        m59d(bundle);
        if (!this.f36F) {
            throw new ba("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f66u != null) {
            this.f66u.m262k();
        }
    }

    void m82r() {
        if (this.f66u != null) {
            this.f66u.m260i();
            this.f66u.m255e();
        }
        this.f36F = false;
        m70h();
        if (this.f36F) {
            if (this.f66u != null) {
                this.f66u.m263l();
            }
            if (this.f43M != null) {
                this.f43M.m110g();
                return;
            }
            return;
        }
        throw new ba("Fragment " + this + " did not call through to super.onStart()");
    }

    void m83s() {
        if (this.f66u != null) {
            this.f66u.m260i();
            this.f66u.m255e();
        }
        this.f36F = false;
        mo349i();
        if (!this.f36F) {
            throw new ba("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f66u != null) {
            this.f66u.m264m();
            this.f66u.m255e();
        }
    }

    void m37a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f66u != null) {
            this.f66u.m226a(configuration);
        }
    }

    void m84t() {
        onLowMemory();
        if (this.f66u != null) {
            this.f66u.m270s();
        }
    }

    boolean m52b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f71z) {
            return false;
        }
        if (this.f34D && this.f35E) {
            z = true;
            mo352a(menu, menuInflater);
        }
        if (this.f66u != null) {
            return z | this.f66u.m238a(menu, menuInflater);
        }
        return z;
    }

    boolean m57c(Menu menu) {
        boolean z = false;
        if (this.f71z) {
            return false;
        }
        if (this.f34D && this.f35E) {
            z = true;
            m39a(menu);
        }
        if (this.f66u != null) {
            return z | this.f66u.m237a(menu);
        }
        return z;
    }

    boolean m58c(MenuItem menuItem) {
        if (!this.f71z) {
            if (this.f34D && this.f35E && mo353a(menuItem)) {
                return true;
            }
            if (this.f66u != null && this.f66u.m239a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean m63d(MenuItem menuItem) {
        if (!this.f71z) {
            if (mo354b(menuItem)) {
                return true;
            }
            if (this.f66u != null && this.f66u.m246b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m60d(Menu menu) {
        if (!this.f71z) {
            if (this.f34D && this.f35E) {
                m50b(menu);
            }
            if (this.f66u != null) {
                this.f66u.m244b(menu);
            }
        }
    }

    void m73i(Bundle bundle) {
        m66f(bundle);
        if (this.f66u != null) {
            Parcelable h = this.f66u.m259h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    void m85u() {
        if (this.f66u != null) {
            this.f66u.m265n();
        }
        this.f36F = false;
        mo350j();
        if (!this.f36F) {
            throw new ba("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m86v() {
        if (this.f66u != null) {
            this.f66u.m266o();
        }
        this.f36F = false;
        m75k();
        if (!this.f36F) {
            throw new ba("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m87w() {
        if (this.f66u != null) {
            this.f66u.m267p();
        }
        if (this.f44N) {
            this.f44N = false;
            if (!this.f45O) {
                this.f45O = true;
                this.f43M = this.f65t.m197a(this.f52g, this.f44N, false);
            }
            if (this.f43M == null) {
                return;
            }
            if (this.f65t.f187h) {
                this.f43M.m107d();
            } else {
                this.f43M.m106c();
            }
        }
    }

    void m88x() {
        if (this.f66u != null) {
            this.f66u.m268q();
        }
        this.f36F = false;
        mo351l();
        if (!this.f36F) {
            throw new ba("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f43M != null) {
            this.f43M.m109f();
        }
    }

    void m89y() {
        if (this.f66u != null) {
            this.f66u.m269r();
        }
        this.f36F = false;
        m77m();
        if (!this.f36F) {
            throw new ba("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
