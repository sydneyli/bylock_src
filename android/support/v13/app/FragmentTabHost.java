package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

/* compiled from: MyApp */
public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList f1a;
    private Context f2b;
    private FragmentManager f3c;
    private int f4d;
    private OnTabChangeListener f5e;
    private C0002c f6f;
    private boolean f7g;

    /* compiled from: MyApp */
    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C0001b();
        String f0a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f0a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f0a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f0a + "}";
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f5e = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.f1a.size(); i++) {
            C0002c c0002c = (C0002c) this.f1a.get(i);
            c0002c.f11d = this.f3c.findFragmentByTag(c0002c.f8a);
            if (!(c0002c.f11d == null || c0002c.f11d.isDetached())) {
                if (c0002c.f8a.equals(currentTabTag)) {
                    this.f6f = c0002c;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f3c.beginTransaction();
                    }
                    fragmentTransaction.detach(c0002c.f11d);
                }
            }
        }
        this.f7g = true;
        FragmentTransaction a = m0a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.f3c.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7g = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f0a = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f0a);
    }

    public void onTabChanged(String str) {
        if (this.f7g) {
            FragmentTransaction a = m0a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.f5e != null) {
            this.f5e.onTabChanged(str);
        }
    }

    private FragmentTransaction m0a(String str, FragmentTransaction fragmentTransaction) {
        C0002c c0002c = null;
        int i = 0;
        while (i < this.f1a.size()) {
            C0002c c0002c2 = (C0002c) this.f1a.get(i);
            if (!c0002c2.f8a.equals(str)) {
                c0002c2 = c0002c;
            }
            i++;
            c0002c = c0002c2;
        }
        if (c0002c == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f6f != c0002c) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f3c.beginTransaction();
            }
            if (!(this.f6f == null || this.f6f.f11d == null)) {
                fragmentTransaction.detach(this.f6f.f11d);
            }
            if (c0002c != null) {
                if (c0002c.f11d == null) {
                    c0002c.f11d = Fragment.instantiate(this.f2b, c0002c.f9b.getName(), c0002c.f10c);
                    fragmentTransaction.add(this.f4d, c0002c.f11d, c0002c.f8a);
                } else {
                    fragmentTransaction.attach(c0002c.f11d);
                }
            }
            this.f6f = c0002c;
        }
        return fragmentTransaction;
    }
}
