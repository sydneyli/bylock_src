package android.support.v4.app;

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
    private final ArrayList f87a;
    private Context f88b;
    private C0029p f89c;
    private int f90d;
    private OnTabChangeListener f91e;
    private C0039z f92f;
    private boolean f93g;

    /* compiled from: MyApp */
    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C0038y();
        String f86a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f86a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f86a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f86a + "}";
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f91e = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        aa aaVar = null;
        for (int i = 0; i < this.f87a.size(); i++) {
            C0039z c0039z = (C0039z) this.f87a.get(i);
            c0039z.f240d = this.f89c.mo14a(c0039z.f237a);
            if (!(c0039z.f240d == null || c0039z.f240d.m65e())) {
                if (c0039z.f237a.equals(currentTabTag)) {
                    this.f92f = c0039z;
                } else {
                    if (aaVar == null) {
                        aaVar = this.f89c.mo15a();
                    }
                    aaVar.mo10a(c0039z.f240d);
                }
            }
        }
        this.f93g = true;
        aa a = m91a(currentTabTag, aaVar);
        if (a != null) {
            a.mo8a();
            this.f89c.mo16b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f93g = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f86a = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f86a);
    }

    public void onTabChanged(String str) {
        if (this.f93g) {
            aa a = m91a(str, null);
            if (a != null) {
                a.mo8a();
            }
        }
        if (this.f91e != null) {
            this.f91e.onTabChanged(str);
        }
    }

    private aa m91a(String str, aa aaVar) {
        C0039z c0039z = null;
        int i = 0;
        while (i < this.f87a.size()) {
            C0039z c0039z2 = (C0039z) this.f87a.get(i);
            if (!c0039z2.f237a.equals(str)) {
                c0039z2 = c0039z;
            }
            i++;
            c0039z = c0039z2;
        }
        if (c0039z == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f92f != c0039z) {
            if (aaVar == null) {
                aaVar = this.f89c.mo15a();
            }
            if (!(this.f92f == null || this.f92f.f240d == null)) {
                aaVar.mo10a(this.f92f.f240d);
            }
            if (c0039z != null) {
                if (c0039z.f240d == null) {
                    c0039z.f240d = Fragment.m28a(this.f88b, c0039z.f238b.getName(), c0039z.f239c);
                    aaVar.mo9a(this.f90d, c0039z.f240d, c0039z.f237a);
                } else {
                    aaVar.mo12b(c0039z.f240d);
                }
            }
            this.f92f = c0039z;
        }
        return aaVar;
    }
}
