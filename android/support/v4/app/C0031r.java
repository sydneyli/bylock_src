package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p004d.C0048a;
import android.support.v4.p004d.C0049b;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: MyApp */
final class C0031r extends C0029p {
    static final Interpolator f201A = new DecelerateInterpolator(1.5f);
    static final Interpolator f202B = new AccelerateInterpolator(2.5f);
    static final Interpolator f203C = new AccelerateInterpolator(1.5f);
    static boolean f204a = false;
    static final boolean f205b;
    static final Interpolator f206z = new DecelerateInterpolator(2.5f);
    ArrayList f207c;
    Runnable[] f208d;
    boolean f209e;
    ArrayList f210f;
    ArrayList f211g;
    ArrayList f212h;
    ArrayList f213i;
    ArrayList f214j;
    ArrayList f215k;
    ArrayList f216l;
    ArrayList f217m;
    int f218n = 0;
    C0024j f219o;
    C0020o f220p;
    Fragment f221q;
    boolean f222r;
    boolean f223s;
    boolean f224t;
    String f225u;
    boolean f226v;
    Bundle f227w = null;
    SparseArray f228x = null;
    Runnable f229y = new C0032s(this);

    C0031r() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f205b = z;
    }

    private void m213a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0049b("FragmentManager"));
        if (this.f219o != null) {
            try {
                this.f219o.dump("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m235a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public aa mo15a() {
        return new C0017d(this);
    }

    public boolean mo16b() {
        return m255e();
    }

    public boolean m249c() {
        m216t();
        mo16b();
        return m236a(this.f219o.f180a, null, -1, 0);
    }

    public void m227a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f51f < 0) {
            m213a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f51f);
    }

    public Fragment m219a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f210f.size()) {
            m213a(new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f210f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m213a(new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f221q != null) {
            C0048a.m316a(this.f221q, stringBuilder);
        } else {
            C0048a.m316a(this.f219o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m235a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f210f != null) {
            size = this.f210f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    Fragment fragment;
                    fragment = (Fragment) this.f210f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.m43a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f211g != null) {
            size = this.f211g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f211g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f214j != null) {
            size = this.f214j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f214j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f213i != null) {
            size = this.f213i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0017d c0017d = (C0017d) this.f213i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0017d.toString());
                    c0017d.m183a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f215k != null) {
                int size2 = this.f215k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0017d = (C0017d) this.f215k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0017d);
                    }
                }
            }
            if (this.f216l != null && this.f216l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f216l.toArray()));
            }
        }
        if (this.f207c != null) {
            i = this.f207c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f207c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.f219o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f220p);
        if (this.f221q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f221q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f218n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f223s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f224t);
        if (this.f222r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f222r);
        }
        if (this.f225u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f225u);
        }
        if (this.f212h != null && this.f212h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f212h.toArray()));
        }
    }

    static Animation m212a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f206z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f201A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m211a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f201A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m222a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m30a(i, z, fragment.f37G);
        if (a != null) {
            return a;
        }
        if (fragment.f37G != 0) {
            a = AnimationUtils.loadAnimation(this.f219o, fragment.f37G);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0031r.m214b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return C0031r.m212a(this.f219o, 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0031r.m212a(this.f219o, 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0031r.m212a(this.f219o, 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0031r.m212a(this.f219o, 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0031r.m211a(this.f219o, 0.0f, 1.0f);
            case 6:
                return C0031r.m211a(this.f219o, 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f219o.getWindow() != null) {
                    i2 = this.f219o.getWindow().getAttributes().windowAnimations;
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m229a(Fragment fragment) {
        if (!fragment.f41K) {
            return;
        }
        if (this.f209e) {
            this.f226v = true;
            return;
        }
        fragment.f41K = false;
        m231a(fragment, this.f218n, 0, 0, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m231a(android.support.v4.app.Fragment r10, int r11, int r12, int r13, boolean r14) {
        /*
        r9 = this;
        r8 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r10.f57l;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r10.f31A;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r11 <= r5) goto L_0x0010;
    L_0x000f:
        r11 = r5;
    L_0x0010:
        r0 = r10.f58m;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r10.f46a;
        if (r11 <= r0) goto L_0x001a;
    L_0x0018:
        r11 = r10.f46a;
    L_0x001a:
        r0 = r10.f41K;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r10.f46a;
        if (r0 >= r8) goto L_0x0025;
    L_0x0022:
        if (r11 <= r6) goto L_0x0025;
    L_0x0024:
        r11 = r6;
    L_0x0025:
        r0 = r10.f46a;
        if (r0 >= r11) goto L_0x0240;
    L_0x0029:
        r0 = r10.f60o;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r10.f61p;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r10.f47b;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r10.f47b = r7;
        r2 = r10.f48c;
        r0 = r9;
        r1 = r10;
        r4 = r3;
        r0.m231a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r10.f46a;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0126;
            case 2: goto L_0x01ef;
            case 3: goto L_0x01ef;
            case 4: goto L_0x0210;
            default: goto L_0x0045;
        };
    L_0x0045:
        r10.f46a = r11;
        goto L_0x0031;
    L_0x0048:
        r0 = f204a;
        if (r0 == 0) goto L_0x0064;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0064:
        r0 = r10.f49d;
        if (r0 == 0) goto L_0x009d;
    L_0x0068:
        r0 = r10.f49d;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r10.f50e = r0;
        r0 = r10.f49d;
        r1 = "android:target_state";
        r0 = r9.m219a(r0, r1);
        r10.f54i = r0;
        r0 = r10.f54i;
        if (r0 == 0) goto L_0x008a;
    L_0x0080:
        r0 = r10.f49d;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r10.f56k = r0;
    L_0x008a:
        r0 = r10.f49d;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r10.f42L = r0;
        r0 = r10.f42L;
        if (r0 != 0) goto L_0x009d;
    L_0x0098:
        r10.f41K = r5;
        if (r11 <= r6) goto L_0x009d;
    L_0x009c:
        r11 = r6;
    L_0x009d:
        r0 = r9.f219o;
        r10.f65t = r0;
        r0 = r9.f221q;
        r10.f67v = r0;
        r0 = r9.f221q;
        if (r0 == 0) goto L_0x00d9;
    L_0x00a9:
        r0 = r9.f221q;
        r0 = r0.f66u;
    L_0x00ad:
        r10.f64s = r0;
        r10.f36F = r3;
        r0 = r9.f219o;
        r10.m33a(r0);
        r0 = r10.f36F;
        if (r0 != 0) goto L_0x00de;
    L_0x00ba:
        r0 = new android.support.v4.app.ba;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00d9:
        r0 = r9.f219o;
        r0 = r0.f181b;
        goto L_0x00ad;
    L_0x00de:
        r0 = r10.f67v;
        if (r0 != 0) goto L_0x00e7;
    L_0x00e2:
        r0 = r9.f219o;
        r0.m198a(r10);
    L_0x00e7:
        r0 = r10.f33C;
        if (r0 != 0) goto L_0x00f0;
    L_0x00eb:
        r0 = r10.f49d;
        r10.m69g(r0);
    L_0x00f0:
        r10.f33C = r3;
        r0 = r10.f60o;
        if (r0 == 0) goto L_0x0126;
    L_0x00f6:
        r0 = r10.f49d;
        r0 = r10.m48b(r0);
        r1 = r10.f49d;
        r0 = r10.m49b(r0, r7, r1);
        r10.f39I = r0;
        r0 = r10.f39I;
        if (r0 == 0) goto L_0x0239;
    L_0x0108:
        r0 = r10.f39I;
        r10.f40J = r0;
        r0 = r10.f39I;
        r0 = android.support.v4.app.ak.m143a(r0);
        r10.f39I = r0;
        r0 = r10.f71z;
        if (r0 == 0) goto L_0x011f;
    L_0x0118:
        r0 = r10.f39I;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x011f:
        r0 = r10.f39I;
        r1 = r10.f49d;
        r10.m42a(r0, r1);
    L_0x0126:
        if (r11 <= r5) goto L_0x01ef;
    L_0x0128:
        r0 = f204a;
        if (r0 == 0) goto L_0x0144;
    L_0x012c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0144:
        r0 = r10.f60o;
        if (r0 != 0) goto L_0x01df;
    L_0x0148:
        r0 = r10.f69x;
        if (r0 == 0) goto L_0x0397;
    L_0x014c:
        r0 = r9.f220p;
        r1 = r10.f69x;
        r0 = r0.mo13a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x019b;
    L_0x0158:
        r1 = r10.f62q;
        if (r1 != 0) goto L_0x019b;
    L_0x015c:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "No view found for id 0x";
        r2 = r2.append(r3);
        r3 = r10.f69x;
        r3 = java.lang.Integer.toHexString(r3);
        r2 = r2.append(r3);
        r3 = " (";
        r2 = r2.append(r3);
        r3 = r10.m54c();
        r4 = r10.f69x;
        r3 = r3.getResourceName(r4);
        r2 = r2.append(r3);
        r3 = ") for fragment ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        r1.<init>(r2);
        r9.m213a(r1);
    L_0x019b:
        r10.f38H = r0;
        r1 = r10.f49d;
        r1 = r10.m48b(r1);
        r2 = r10.f49d;
        r1 = r10.m49b(r1, r0, r2);
        r10.f39I = r1;
        r1 = r10.f39I;
        if (r1 == 0) goto L_0x023d;
    L_0x01af:
        r1 = r10.f39I;
        r10.f40J = r1;
        r1 = r10.f39I;
        r1 = android.support.v4.app.ak.m143a(r1);
        r10.f39I = r1;
        if (r0 == 0) goto L_0x01cd;
    L_0x01bd:
        r1 = r9.m222a(r10, r12, r5, r13);
        if (r1 == 0) goto L_0x01c8;
    L_0x01c3:
        r2 = r10.f39I;
        r2.startAnimation(r1);
    L_0x01c8:
        r1 = r10.f39I;
        r0.addView(r1);
    L_0x01cd:
        r0 = r10.f71z;
        if (r0 == 0) goto L_0x01d8;
    L_0x01d1:
        r0 = r10.f39I;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x01d8:
        r0 = r10.f39I;
        r1 = r10.f49d;
        r10.m42a(r0, r1);
    L_0x01df:
        r0 = r10.f49d;
        r10.m71h(r0);
        r0 = r10.f39I;
        if (r0 == 0) goto L_0x01ed;
    L_0x01e8:
        r0 = r10.f49d;
        r10.m38a(r0);
    L_0x01ed:
        r10.f49d = r7;
    L_0x01ef:
        if (r11 <= r6) goto L_0x0210;
    L_0x01f1:
        r0 = f204a;
        if (r0 == 0) goto L_0x020d;
    L_0x01f5:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x020d:
        r10.m82r();
    L_0x0210:
        if (r11 <= r8) goto L_0x0045;
    L_0x0212:
        r0 = f204a;
        if (r0 == 0) goto L_0x022e;
    L_0x0216:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x022e:
        r10.f59n = r5;
        r10.m83s();
        r10.f49d = r7;
        r10.f50e = r7;
        goto L_0x0045;
    L_0x0239:
        r10.f40J = r7;
        goto L_0x0126;
    L_0x023d:
        r10.f40J = r7;
        goto L_0x01df;
    L_0x0240:
        r0 = r10.f46a;
        if (r0 <= r11) goto L_0x0045;
    L_0x0244:
        r0 = r10.f46a;
        switch(r0) {
            case 1: goto L_0x024b;
            case 2: goto L_0x02cb;
            case 3: goto L_0x02aa;
            case 4: goto L_0x0289;
            case 5: goto L_0x0265;
            default: goto L_0x0249;
        };
    L_0x0249:
        goto L_0x0045;
    L_0x024b:
        if (r11 >= r5) goto L_0x0045;
    L_0x024d:
        r0 = r9.f224t;
        if (r0 == 0) goto L_0x025c;
    L_0x0251:
        r0 = r10.f47b;
        if (r0 == 0) goto L_0x025c;
    L_0x0255:
        r0 = r10.f47b;
        r10.f47b = r7;
        r0.clearAnimation();
    L_0x025c:
        r0 = r10.f47b;
        if (r0 == 0) goto L_0x0338;
    L_0x0260:
        r10.f48c = r11;
        r11 = r5;
        goto L_0x0045;
    L_0x0265:
        r0 = 5;
        if (r11 >= r0) goto L_0x0289;
    L_0x0268:
        r0 = f204a;
        if (r0 == 0) goto L_0x0284;
    L_0x026c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0284:
        r10.m85u();
        r10.f59n = r3;
    L_0x0289:
        if (r11 >= r8) goto L_0x02aa;
    L_0x028b:
        r0 = f204a;
        if (r0 == 0) goto L_0x02a7;
    L_0x028f:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02a7:
        r10.m86v();
    L_0x02aa:
        if (r11 >= r6) goto L_0x02cb;
    L_0x02ac:
        r0 = f204a;
        if (r0 == 0) goto L_0x02c8;
    L_0x02b0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02c8:
        r10.m87w();
    L_0x02cb:
        r0 = 2;
        if (r11 >= r0) goto L_0x024b;
    L_0x02ce:
        r0 = f204a;
        if (r0 == 0) goto L_0x02ea;
    L_0x02d2:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ea:
        r0 = r10.f39I;
        if (r0 == 0) goto L_0x02fd;
    L_0x02ee:
        r0 = r9.f219o;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x02fd;
    L_0x02f6:
        r0 = r10.f50e;
        if (r0 != 0) goto L_0x02fd;
    L_0x02fa:
        r9.m253e(r10);
    L_0x02fd:
        r10.m88x();
        r0 = r10.f39I;
        if (r0 == 0) goto L_0x0330;
    L_0x0304:
        r0 = r10.f38H;
        if (r0 == 0) goto L_0x0330;
    L_0x0308:
        r0 = r9.f218n;
        if (r0 <= 0) goto L_0x0394;
    L_0x030c:
        r0 = r9.f224t;
        if (r0 != 0) goto L_0x0394;
    L_0x0310:
        r0 = r9.m222a(r10, r12, r3, r13);
    L_0x0314:
        if (r0 == 0) goto L_0x0329;
    L_0x0316:
        r1 = r10.f39I;
        r10.f47b = r1;
        r10.f48c = r11;
        r1 = new android.support.v4.app.t;
        r1.<init>(r9, r10);
        r0.setAnimationListener(r1);
        r1 = r10.f39I;
        r1.startAnimation(r0);
    L_0x0329:
        r0 = r10.f38H;
        r1 = r10.f39I;
        r0.removeView(r1);
    L_0x0330:
        r10.f38H = r7;
        r10.f39I = r7;
        r10.f40J = r7;
        goto L_0x024b;
    L_0x0338:
        r0 = f204a;
        if (r0 == 0) goto L_0x0354;
    L_0x033c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0354:
        r0 = r10.f33C;
        if (r0 != 0) goto L_0x035b;
    L_0x0358:
        r10.m89y();
    L_0x035b:
        r10.f36F = r3;
        r10.m79o();
        r0 = r10.f36F;
        if (r0 != 0) goto L_0x0383;
    L_0x0364:
        r0 = new android.support.v4.app.ba;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0383:
        if (r14 != 0) goto L_0x0045;
    L_0x0385:
        r0 = r10.f33C;
        if (r0 != 0) goto L_0x038e;
    L_0x0389:
        r9.m251d(r10);
        goto L_0x0045;
    L_0x038e:
        r10.f65t = r7;
        r10.f64s = r7;
        goto L_0x0045;
    L_0x0394:
        r0 = r7;
        goto L_0x0314;
    L_0x0397:
        r0 = r7;
        goto L_0x019b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.r.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void m241b(Fragment fragment) {
        m231a(fragment, this.f218n, 0, 0, false);
    }

    void m225a(int i, boolean z) {
        m223a(i, 0, 0, z);
    }

    void m223a(int i, int i2, int i3, boolean z) {
        if (this.f219o == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.f218n != i) {
            this.f218n = i;
            if (this.f210f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f210f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f210f.get(i4);
                    if (fragment != null) {
                        m231a(fragment, i, i2, i3, false);
                        if (fragment.f43M != null) {
                            a = i5 | fragment.f43M.mo2a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m250d();
                }
                if (this.f222r && this.f219o != null && this.f218n == 5) {
                    this.f219o.mo155c();
                    this.f222r = false;
                }
            }
        }
    }

    void m250d() {
        if (this.f210f != null) {
            for (int i = 0; i < this.f210f.size(); i++) {
                Fragment fragment = (Fragment) this.f210f.get(i);
                if (fragment != null) {
                    m229a(fragment);
                }
            }
        }
    }

    void m247c(Fragment fragment) {
        if (fragment.f51f < 0) {
            if (this.f212h == null || this.f212h.size() <= 0) {
                if (this.f210f == null) {
                    this.f210f = new ArrayList();
                }
                fragment.m32a(this.f210f.size(), this.f221q);
                this.f210f.add(fragment);
            } else {
                fragment.m32a(((Integer) this.f212h.remove(this.f212h.size() - 1)).intValue(), this.f221q);
                this.f210f.set(fragment.f51f, fragment);
            }
            if (f204a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void m251d(Fragment fragment) {
        if (fragment.f51f >= 0) {
            if (f204a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f210f.set(fragment.f51f, null);
            if (this.f212h == null) {
                this.f212h = new ArrayList();
            }
            this.f212h.add(Integer.valueOf(fragment.f51f));
            this.f219o.m200a(fragment.f52g);
            fragment.m78n();
        }
    }

    public void m232a(Fragment fragment, boolean z) {
        if (this.f211g == null) {
            this.f211g = new ArrayList();
        }
        if (f204a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m247c(fragment);
        if (!fragment.f31A) {
            if (this.f211g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f211g.add(fragment);
            fragment.f57l = true;
            fragment.f58m = false;
            if (fragment.f34D && fragment.f35E) {
                this.f222r = true;
            }
            if (z) {
                m241b(fragment);
            }
        }
    }

    public void m230a(Fragment fragment, int i, int i2) {
        if (f204a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f63r);
        }
        boolean z = !fragment.m45a();
        if (!fragment.f31A || z) {
            int i3;
            if (this.f211g != null) {
                this.f211g.remove(fragment);
            }
            if (fragment.f34D && fragment.f35E) {
                this.f222r = true;
            }
            fragment.f57l = false;
            fragment.f58m = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m231a(fragment, i3, i, i2, false);
        }
    }

    public void m242b(Fragment fragment, int i, int i2) {
        if (f204a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f71z) {
            fragment.f71z = true;
            if (fragment.f39I != null) {
                Animation a = m222a(fragment, i, true, i2);
                if (a != null) {
                    fragment.f39I.startAnimation(a);
                }
                fragment.f39I.setVisibility(8);
            }
            if (fragment.f57l && fragment.f34D && fragment.f35E) {
                this.f222r = true;
            }
            fragment.m44a(true);
        }
    }

    public void m248c(Fragment fragment, int i, int i2) {
        if (f204a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f71z) {
            fragment.f71z = false;
            if (fragment.f39I != null) {
                Animation a = m222a(fragment, i, true, i2);
                if (a != null) {
                    fragment.f39I.startAnimation(a);
                }
                fragment.f39I.setVisibility(0);
            }
            if (fragment.f57l && fragment.f34D && fragment.f35E) {
                this.f222r = true;
            }
            fragment.m44a(false);
        }
    }

    public void m252d(Fragment fragment, int i, int i2) {
        if (f204a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f31A) {
            fragment.f31A = true;
            if (fragment.f57l) {
                if (this.f211g != null) {
                    if (f204a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f211g.remove(fragment);
                }
                if (fragment.f34D && fragment.f35E) {
                    this.f222r = true;
                }
                fragment.f57l = false;
                m231a(fragment, 1, i, i2, false);
            }
        }
    }

    public void m254e(Fragment fragment, int i, int i2) {
        if (f204a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f31A) {
            fragment.f31A = false;
            if (!fragment.f57l) {
                if (this.f211g == null) {
                    this.f211g = new ArrayList();
                }
                if (this.f211g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f204a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f211g.add(fragment);
                fragment.f57l = true;
                if (fragment.f34D && fragment.f35E) {
                    this.f222r = true;
                }
                m231a(fragment, this.f218n, i, i2, false);
            }
        }
    }

    public Fragment m218a(int i) {
        int size;
        Fragment fragment;
        if (this.f211g != null) {
            for (size = this.f211g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f211g.get(size);
                if (fragment != null && fragment.f68w == i) {
                    return fragment;
                }
            }
        }
        if (this.f210f != null) {
            for (size = this.f210f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f210f.get(size);
                if (fragment != null && fragment.f68w == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment mo14a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f211g == null || str == null)) {
            for (size = this.f211g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f211g.get(size);
                if (fragment != null && str.equals(fragment.f70y)) {
                    return fragment;
                }
            }
        }
        if (!(this.f210f == null || str == null)) {
            for (size = this.f210f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f210f.get(size);
                if (fragment != null && str.equals(fragment.f70y)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    private void m216t() {
        if (this.f223s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f225u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f225u);
        }
    }

    public void m234a(Runnable runnable, boolean z) {
        if (!z) {
            m216t();
        }
        synchronized (this) {
            if (this.f219o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f207c == null) {
                this.f207c = new ArrayList();
            }
            this.f207c.add(runnable);
            if (this.f207c.size() == 1) {
                this.f219o.f180a.removeCallbacks(this.f229y);
                this.f219o.f180a.post(this.f229y);
            }
        }
    }

    public int m217a(C0017d c0017d) {
        int size;
        synchronized (this) {
            if (this.f216l == null || this.f216l.size() <= 0) {
                if (this.f215k == null) {
                    this.f215k = new ArrayList();
                }
                size = this.f215k.size();
                if (f204a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0017d);
                }
                this.f215k.add(c0017d);
            } else {
                size = ((Integer) this.f216l.remove(this.f216l.size() - 1)).intValue();
                if (f204a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0017d);
                }
                this.f215k.set(size, c0017d);
            }
        }
        return size;
    }

    public void m224a(int i, C0017d c0017d) {
        synchronized (this) {
            if (this.f215k == null) {
                this.f215k = new ArrayList();
            }
            int size = this.f215k.size();
            if (i < size) {
                if (f204a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0017d);
                }
                this.f215k.set(i, c0017d);
            } else {
                while (size < i) {
                    this.f215k.add(null);
                    if (this.f216l == null) {
                        this.f216l = new ArrayList();
                    }
                    if (f204a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f216l.add(Integer.valueOf(size));
                    size++;
                }
                if (f204a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0017d);
                }
                this.f215k.add(c0017d);
            }
        }
    }

    public void m240b(int i) {
        synchronized (this) {
            this.f215k.set(i, null);
            if (this.f216l == null) {
                this.f216l = new ArrayList();
            }
            if (f204a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f216l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m255e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f209e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f219o;
        r3 = r3.f180a;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.f207c;	 Catch:{ all -> 0x0097 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.f207c;	 Catch:{ all -> 0x0097 }
        r3 = r3.size();	 Catch:{ all -> 0x0097 }
        if (r3 != 0) goto L_0x005a;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r0 = r6.f226v;
        if (r0 == 0) goto L_0x00a5;
    L_0x0037:
        r3 = r2;
        r4 = r2;
    L_0x0039:
        r0 = r6.f210f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x009e;
    L_0x0041:
        r0 = r6.f210f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r5 = r0.f43M;
        if (r5 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r0.f43M;
        r0 = r0.mo2a();
        r4 = r4 | r0;
    L_0x0056:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0039;
    L_0x005a:
        r1 = r6.f207c;	 Catch:{ all -> 0x0097 }
        r3 = r1.size();	 Catch:{ all -> 0x0097 }
        r1 = r6.f208d;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r1 = r6.f208d;	 Catch:{ all -> 0x0097 }
        r1 = r1.length;	 Catch:{ all -> 0x0097 }
        if (r1 >= r3) goto L_0x006d;
    L_0x0069:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0097 }
        r6.f208d = r1;	 Catch:{ all -> 0x0097 }
    L_0x006d:
        r1 = r6.f207c;	 Catch:{ all -> 0x0097 }
        r4 = r6.f208d;	 Catch:{ all -> 0x0097 }
        r1.toArray(r4);	 Catch:{ all -> 0x0097 }
        r1 = r6.f207c;	 Catch:{ all -> 0x0097 }
        r1.clear();	 Catch:{ all -> 0x0097 }
        r1 = r6.f219o;	 Catch:{ all -> 0x0097 }
        r1 = r1.f180a;	 Catch:{ all -> 0x0097 }
        r4 = r6.f229y;	 Catch:{ all -> 0x0097 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0097 }
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r6.f209e = r0;
        r1 = r2;
    L_0x0086:
        if (r1 >= r3) goto L_0x009a;
    L_0x0088:
        r4 = r6.f208d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f208d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0086;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r6.f209e = r2;
        r1 = r0;
        goto L_0x0025;
    L_0x009e:
        if (r4 != 0) goto L_0x00a5;
    L_0x00a0:
        r6.f226v = r2;
        r6.m250d();
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.r.e():boolean");
    }

    void m257f() {
        if (this.f217m != null) {
            for (int i = 0; i < this.f217m.size(); i++) {
                ((C0030q) this.f217m.get(i)).m210a();
            }
        }
    }

    void m243b(C0017d c0017d) {
        if (this.f213i == null) {
            this.f213i = new ArrayList();
        }
        this.f213i.add(c0017d);
        m257f();
    }

    boolean m236a(Handler handler, String str, int i, int i2) {
        if (this.f213i == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f213i.size() - 1;
            if (size < 0) {
                return false;
            }
            ((C0017d) this.f213i.remove(size)).m187b(true);
            m257f();
        } else {
            int size2;
            C0017d c0017d;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f213i.size() - 1;
                while (size2 >= 0) {
                    c0017d = (C0017d) this.f213i.get(size2);
                    if ((str != null && str.equals(c0017d.m188c())) || (i >= 0 && i == c0017d.f165o)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0017d = (C0017d) this.f213i.get(size2);
                        if ((str == null || !str.equals(c0017d.m188c())) && (i < 0 || i != c0017d.f165o)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f213i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f213i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f213i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            for (int i3 = 0; i3 <= size3; i3++) {
                boolean z;
                if (f204a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                c0017d = (C0017d) arrayList.get(i3);
                if (i3 == size3) {
                    z = true;
                } else {
                    z = false;
                }
                c0017d.m187b(z);
            }
            m257f();
        }
        return true;
    }

    ArrayList m258g() {
        ArrayList arrayList = null;
        if (this.f210f != null) {
            for (int i = 0; i < this.f210f.size(); i++) {
                Fragment fragment = (Fragment) this.f210f.get(i);
                if (fragment != null && fragment.f32B) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f33C = true;
                    fragment.f55j = fragment.f54i != null ? fragment.f54i.f51f : -1;
                    if (f204a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    void m253e(Fragment fragment) {
        if (fragment.f40J != null) {
            if (this.f228x == null) {
                this.f228x = new SparseArray();
            } else {
                this.f228x.clear();
            }
            fragment.f40J.saveHierarchyState(this.f228x);
            if (this.f228x.size() > 0) {
                fragment.f50e = this.f228x;
                this.f228x = null;
            }
        }
    }

    Bundle m256f(Fragment fragment) {
        Bundle bundle;
        if (this.f227w == null) {
            this.f227w = new Bundle();
        }
        fragment.m73i(this.f227w);
        if (this.f227w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f227w;
            this.f227w = null;
        }
        if (fragment.f39I != null) {
            m253e(fragment);
        }
        if (fragment.f50e != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f50e);
        }
        if (!fragment.f42L) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f42L);
        }
        return bundle;
    }

    Parcelable m259h() {
        BackStackState[] backStackStateArr = null;
        m255e();
        if (f205b) {
            this.f223s = true;
        }
        if (this.f210f == null || this.f210f.size() <= 0) {
            return null;
        }
        int size = this.f210f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f210f.get(i);
            if (fragment != null) {
                if (fragment.f51f < 0) {
                    m213a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f51f));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f46a <= 0 || fragmentState.f84j != null) {
                    fragmentState.f84j = fragment.f49d;
                } else {
                    fragmentState.f84j = m256f(fragment);
                    if (fragment.f54i != null) {
                        if (fragment.f54i.f51f < 0) {
                            m213a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f54i));
                        }
                        if (fragmentState.f84j == null) {
                            fragmentState.f84j = new Bundle();
                        }
                        m227a(fragmentState.f84j, "android:target_state", fragment.f54i);
                        if (fragment.f56k != 0) {
                            fragmentState.f84j.putInt("android:target_req_state", fragment.f56k);
                        }
                    }
                }
                if (f204a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f84j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f211g != null) {
                i = this.f211g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f211g.get(i2)).f51f;
                        if (iArr[i2] < 0) {
                            m213a(new IllegalStateException("Failure saving state: active " + this.f211g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f204a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f211g.get(i2));
                        }
                    }
                    if (this.f213i != null) {
                        i = this.f213i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState(this, (C0017d) this.f213i.get(i2));
                                if (f204a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f213i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f72a = fragmentStateArr;
                    fragmentManagerState.f73b = iArr;
                    fragmentManagerState.f74c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f213i != null) {
                i = this.f213i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState(this, (C0017d) this.f213i.get(i2));
                        if (f204a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f213i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f72a = fragmentStateArr;
            fragmentManagerState.f73b = iArr;
            fragmentManagerState.f74c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f204a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m228a(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f72a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (arrayList != null) {
                    for (i = 0; i < arrayList.size(); i++) {
                        fragment = (Fragment) arrayList.get(i);
                        if (f204a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f72a[fragment.f51f];
                        fragmentState.f85k = fragment;
                        fragment.f50e = null;
                        fragment.f63r = 0;
                        fragment.f61p = false;
                        fragment.f57l = false;
                        fragment.f54i = null;
                        if (fragmentState.f84j != null) {
                            fragmentState.f84j.setClassLoader(this.f219o.getClassLoader());
                            fragment.f50e = fragmentState.f84j.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f210f = new ArrayList(fragmentManagerState.f72a.length);
                if (this.f212h != null) {
                    this.f212h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f72a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f72a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m90a(this.f219o, this.f221q);
                        if (f204a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f210f.add(a);
                        fragmentState2.f85k = null;
                    } else {
                        this.f210f.add(null);
                        if (this.f212h == null) {
                            this.f212h = new ArrayList();
                        }
                        if (f204a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f212h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        fragment = (Fragment) arrayList.get(i3);
                        if (fragment.f55j >= 0) {
                            if (fragment.f55j < this.f210f.size()) {
                                fragment.f54i = (Fragment) this.f210f.get(fragment.f55j);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f55j);
                                fragment.f54i = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f73b != null) {
                    this.f211g = new ArrayList(fragmentManagerState.f73b.length);
                    for (i = 0; i < fragmentManagerState.f73b.length; i++) {
                        fragment = (Fragment) this.f210f.get(fragmentManagerState.f73b[i]);
                        if (fragment == null) {
                            m213a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f73b[i]));
                        }
                        fragment.f57l = true;
                        if (f204a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f211g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f211g.add(fragment);
                    }
                } else {
                    this.f211g = null;
                }
                if (fragmentManagerState.f74c != null) {
                    this.f213i = new ArrayList(fragmentManagerState.f74c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f74c.length; i2++) {
                        C0017d a2 = fragmentManagerState.f74c[i2].m26a(this);
                        if (f204a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f165o + "): " + a2);
                            a2.m184a("  ", new PrintWriter(new C0049b("FragmentManager")), false);
                        }
                        this.f213i.add(a2);
                        if (a2.f165o >= 0) {
                            m224a(a2.f165o, a2);
                        }
                    }
                    return;
                }
                this.f213i = null;
            }
        }
    }

    public void m233a(C0024j c0024j, C0020o c0020o, Fragment fragment) {
        if (this.f219o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f219o = c0024j;
        this.f220p = c0020o;
        this.f221q = fragment;
    }

    public void m260i() {
        this.f223s = false;
    }

    public void m261j() {
        this.f223s = false;
        m225a(1, false);
    }

    public void m262k() {
        this.f223s = false;
        m225a(2, false);
    }

    public void m263l() {
        this.f223s = false;
        m225a(4, false);
    }

    public void m264m() {
        this.f223s = false;
        m225a(5, false);
    }

    public void m265n() {
        m225a(4, false);
    }

    public void m266o() {
        this.f223s = true;
        m225a(3, false);
    }

    public void m267p() {
        m225a(2, false);
    }

    public void m268q() {
        m225a(1, false);
    }

    public void m269r() {
        this.f224t = true;
        m255e();
        m225a(0, false);
        this.f219o = null;
        this.f220p = null;
        this.f221q = null;
    }

    public void m226a(Configuration configuration) {
        if (this.f211g != null) {
            for (int i = 0; i < this.f211g.size(); i++) {
                Fragment fragment = (Fragment) this.f211g.get(i);
                if (fragment != null) {
                    fragment.m37a(configuration);
                }
            }
        }
    }

    public void m270s() {
        if (this.f211g != null) {
            for (int i = 0; i < this.f211g.size(); i++) {
                Fragment fragment = (Fragment) this.f211g.get(i);
                if (fragment != null) {
                    fragment.m84t();
                }
            }
        }
    }

    public boolean m238a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f211g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f211g.size()) {
                fragment = (Fragment) this.f211g.get(i2);
                if (fragment != null && fragment.m52b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f214j != null) {
            while (i < this.f214j.size()) {
                fragment = (Fragment) this.f214j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m80p();
                }
                i++;
            }
        }
        this.f214j = arrayList;
        return z;
    }

    public boolean m237a(Menu menu) {
        if (this.f211g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f211g.size(); i++) {
            Fragment fragment = (Fragment) this.f211g.get(i);
            if (fragment != null && fragment.m57c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m239a(MenuItem menuItem) {
        if (this.f211g == null) {
            return false;
        }
        for (int i = 0; i < this.f211g.size(); i++) {
            Fragment fragment = (Fragment) this.f211g.get(i);
            if (fragment != null && fragment.m58c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean m246b(MenuItem menuItem) {
        if (this.f211g == null) {
            return false;
        }
        for (int i = 0; i < this.f211g.size(); i++) {
            Fragment fragment = (Fragment) this.f211g.get(i);
            if (fragment != null && fragment.m63d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m244b(Menu menu) {
        if (this.f211g != null) {
            for (int i = 0; i < this.f211g.size(); i++) {
                Fragment fragment = (Fragment) this.f211g.get(i);
                if (fragment != null) {
                    fragment.m60d(menu);
                }
            }
        }
    }

    public static int m215c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m214b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }
}
