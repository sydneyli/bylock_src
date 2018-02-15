package android.support.v4.app;

import android.support.v4.p004d.C0049b;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: MyApp */
final class C0017d extends aa implements Runnable {
    final C0031r f151a;
    C0018e f152b;
    C0018e f153c;
    int f154d;
    int f155e;
    int f156f;
    int f157g;
    int f158h;
    int f159i;
    int f160j;
    boolean f161k;
    boolean f162l = true;
    String f163m;
    boolean f164n;
    int f165o = -1;
    int f166p;
    CharSequence f167q;
    int f168r;
    CharSequence f169s;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f165o >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f165o);
        }
        if (this.f163m != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f163m);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m183a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m184a(str, printWriter, true);
    }

    public void m184a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f163m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f165o);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f164n);
            if (this.f159i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f159i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f160j));
            }
            if (!(this.f155e == 0 && this.f156f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f155e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f156f));
            }
            if (!(this.f157g == 0 && this.f158h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f157g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f158h));
            }
            if (!(this.f166p == 0 && this.f167q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f166p));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f167q);
            }
            if (!(this.f168r == 0 && this.f169s == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f168r));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f169s);
            }
        }
        if (this.f152b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0018e c0018e = this.f152b;
            while (c0018e != null) {
                String str3;
                switch (c0018e.f172c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0018e.f172c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0018e.f173d);
                if (z) {
                    if (!(c0018e.f174e == 0 && c0018e.f175f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0018e.f174e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0018e.f175f));
                    }
                    if (!(c0018e.f176g == 0 && c0018e.f177h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0018e.f176g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0018e.f177h));
                    }
                }
                if (c0018e.f178i != null && c0018e.f178i.size() > 0) {
                    for (int i2 = 0; i2 < c0018e.f178i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0018e.f178i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0018e.f178i.get(i2));
                    }
                }
                c0018e = c0018e.f170a;
                i++;
            }
        }
    }

    public C0017d(C0031r c0031r) {
        this.f151a = c0031r;
    }

    void m182a(C0018e c0018e) {
        if (this.f152b == null) {
            this.f153c = c0018e;
            this.f152b = c0018e;
        } else {
            c0018e.f171b = this.f153c;
            this.f153c.f170a = c0018e;
            this.f153c = c0018e;
        }
        c0018e.f174e = this.f155e;
        c0018e.f175f = this.f156f;
        c0018e.f176g = this.f157g;
        c0018e.f177h = this.f158h;
        this.f154d++;
    }

    public aa mo9a(int i, Fragment fragment, String str) {
        m176a(i, fragment, str, 1);
        return this;
    }

    private void m176a(int i, Fragment fragment, String str, int i2) {
        fragment.f64s = this.f151a;
        if (str != null) {
            if (fragment.f70y == null || str.equals(fragment.f70y)) {
                fragment.f70y = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f70y + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f68w == 0 || fragment.f68w == i) {
                fragment.f68w = i;
                fragment.f69x = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f68w + " now " + i);
            }
        }
        C0018e c0018e = new C0018e();
        c0018e.f172c = i2;
        c0018e.f173d = fragment;
        m182a(c0018e);
    }

    public aa mo10a(Fragment fragment) {
        C0018e c0018e = new C0018e();
        c0018e.f172c = 6;
        c0018e.f173d = fragment;
        m182a(c0018e);
        return this;
    }

    public aa mo12b(Fragment fragment) {
        C0018e c0018e = new C0018e();
        c0018e.f172c = 7;
        c0018e.f173d = fragment;
        m182a(c0018e);
        return this;
    }

    void m181a(int i) {
        if (this.f161k) {
            if (C0031r.f204a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0018e c0018e = this.f152b; c0018e != null; c0018e = c0018e.f170a) {
                Fragment fragment;
                if (c0018e.f173d != null) {
                    fragment = c0018e.f173d;
                    fragment.f63r += i;
                    if (C0031r.f204a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0018e.f173d + " to " + c0018e.f173d.f63r);
                    }
                }
                if (c0018e.f178i != null) {
                    for (int size = c0018e.f178i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) c0018e.f178i.get(size);
                        fragment.f63r += i;
                        if (C0031r.f204a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f63r);
                        }
                    }
                }
            }
        }
    }

    public int mo8a() {
        return m178a(false);
    }

    public int mo11b() {
        return m178a(true);
    }

    int m178a(boolean z) {
        if (this.f164n) {
            throw new IllegalStateException("commit already called");
        }
        if (C0031r.f204a) {
            Log.v("FragmentManager", "Commit: " + this);
            m183a("  ", null, new PrintWriter(new C0049b("FragmentManager")), null);
        }
        this.f164n = true;
        if (this.f161k) {
            this.f165o = this.f151a.m217a(this);
        } else {
            this.f165o = -1;
        }
        this.f151a.m234a((Runnable) this, z);
        return this.f165o;
    }

    public void run() {
        if (C0031r.f204a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f161k || this.f165o >= 0) {
            m181a(1);
            for (C0018e c0018e = this.f152b; c0018e != null; c0018e = c0018e.f170a) {
                Fragment fragment;
                switch (c0018e.f172c) {
                    case 1:
                        fragment = c0018e.f173d;
                        fragment.f37G = c0018e.f174e;
                        this.f151a.m232a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2;
                        fragment = c0018e.f173d;
                        if (this.f151a.f211g != null) {
                            fragment2 = fragment;
                            for (int i = 0; i < this.f151a.f211g.size(); i++) {
                                fragment = (Fragment) this.f151a.f211g.get(i);
                                if (C0031r.f204a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment2 == null || fragment.f69x == fragment2.f69x) {
                                    if (fragment == fragment2) {
                                        fragment2 = null;
                                        c0018e.f173d = null;
                                    } else {
                                        if (c0018e.f178i == null) {
                                            c0018e.f178i = new ArrayList();
                                        }
                                        c0018e.f178i.add(fragment);
                                        fragment.f37G = c0018e.f175f;
                                        if (this.f161k) {
                                            fragment.f63r++;
                                            if (C0031r.f204a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f63r);
                                            }
                                        }
                                        this.f151a.m230a(fragment, this.f159i, this.f160j);
                                    }
                                }
                            }
                        } else {
                            fragment2 = fragment;
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f37G = c0018e.f174e;
                        this.f151a.m232a(fragment2, false);
                        break;
                    case 3:
                        fragment = c0018e.f173d;
                        fragment.f37G = c0018e.f175f;
                        this.f151a.m230a(fragment, this.f159i, this.f160j);
                        break;
                    case 4:
                        fragment = c0018e.f173d;
                        fragment.f37G = c0018e.f175f;
                        this.f151a.m242b(fragment, this.f159i, this.f160j);
                        break;
                    case 5:
                        fragment = c0018e.f173d;
                        fragment.f37G = c0018e.f174e;
                        this.f151a.m248c(fragment, this.f159i, this.f160j);
                        break;
                    case 6:
                        fragment = c0018e.f173d;
                        fragment.f37G = c0018e.f175f;
                        this.f151a.m252d(fragment, this.f159i, this.f160j);
                        break;
                    case 7:
                        fragment = c0018e.f173d;
                        fragment.f37G = c0018e.f174e;
                        this.f151a.m254e(fragment, this.f159i, this.f160j);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0018e.f172c);
                }
            }
            this.f151a.m223a(this.f151a.f218n, this.f159i, this.f160j, true);
            if (this.f161k) {
                this.f151a.m243b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public void m187b(boolean z) {
        if (C0031r.f204a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m183a("  ", null, new PrintWriter(new C0049b("FragmentManager")), null);
        }
        m181a(-1);
        for (C0018e c0018e = this.f153c; c0018e != null; c0018e = c0018e.f171b) {
            Fragment fragment;
            switch (c0018e.f172c) {
                case 1:
                    fragment = c0018e.f173d;
                    fragment.f37G = c0018e.f177h;
                    this.f151a.m230a(fragment, C0031r.m215c(this.f159i), this.f160j);
                    break;
                case 2:
                    fragment = c0018e.f173d;
                    if (fragment != null) {
                        fragment.f37G = c0018e.f177h;
                        this.f151a.m230a(fragment, C0031r.m215c(this.f159i), this.f160j);
                    }
                    if (c0018e.f178i == null) {
                        break;
                    }
                    for (int i = 0; i < c0018e.f178i.size(); i++) {
                        fragment = (Fragment) c0018e.f178i.get(i);
                        fragment.f37G = c0018e.f176g;
                        this.f151a.m232a(fragment, false);
                    }
                    break;
                case 3:
                    fragment = c0018e.f173d;
                    fragment.f37G = c0018e.f176g;
                    this.f151a.m232a(fragment, false);
                    break;
                case 4:
                    fragment = c0018e.f173d;
                    fragment.f37G = c0018e.f176g;
                    this.f151a.m248c(fragment, C0031r.m215c(this.f159i), this.f160j);
                    break;
                case 5:
                    fragment = c0018e.f173d;
                    fragment.f37G = c0018e.f177h;
                    this.f151a.m242b(fragment, C0031r.m215c(this.f159i), this.f160j);
                    break;
                case 6:
                    fragment = c0018e.f173d;
                    fragment.f37G = c0018e.f176g;
                    this.f151a.m254e(fragment, C0031r.m215c(this.f159i), this.f160j);
                    break;
                case 7:
                    fragment = c0018e.f173d;
                    fragment.f37G = c0018e.f176g;
                    this.f151a.m252d(fragment, C0031r.m215c(this.f159i), this.f160j);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0018e.f172c);
            }
        }
        if (z) {
            this.f151a.m223a(this.f151a.f218n, C0031r.m215c(this.f159i), this.f160j, true);
        }
        if (this.f165o >= 0) {
            this.f151a.m240b(this.f165o);
            this.f165o = -1;
        }
    }

    public String m188c() {
        return this.f163m;
    }
}
