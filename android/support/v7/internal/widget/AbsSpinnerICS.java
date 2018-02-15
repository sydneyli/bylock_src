package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;

/* compiled from: MyApp */
abstract class AbsSpinnerICS extends C0191l {
    private DataSetObserver f769E;
    SpinnerAdapter f770a;
    int f771b;
    int f772c;
    boolean f773d;
    int f774e = 0;
    int f775f = 0;
    int f776g = 0;
    int f777h = 0;
    final Rect f778i = new Rect();
    final C0197d f779j = new C0197d(this);

    /* compiled from: MyApp */
    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C0198e();
        long f742a;
        int f743b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f742a = parcel.readLong();
            this.f743b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f742a);
            parcel.writeInt(this.f743b);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f742a + " position=" + this.f743b + "}";
        }
    }

    public /* synthetic */ Adapter mo244e() {
        return m1453d();
    }

    AbsSpinnerICS(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1445o();
    }

    private void m1445o() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    public void mo261a(SpinnerAdapter spinnerAdapter) {
        int i = -1;
        if (this.f770a != null) {
            this.f770a.unregisterDataSetObserver(this.f769E);
            mo242a();
        }
        this.f770a = spinnerAdapter;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        if (this.f770a != null) {
            this.A = this.z;
            this.z = this.f770a.getCount();
            m1438i();
            this.f769E = new C0207n(this);
            this.f770a.registerDataSetObserver(this.f769E);
            if (this.z > 0) {
                i = 0;
            }
            m1432c(i);
            m1433d(i);
            if (this.z == 0) {
                m1441l();
            }
        } else {
            m1438i();
            mo242a();
            m1441l();
        }
        requestLayout();
    }

    void mo242a() {
        this.u = false;
        this.p = false;
        removeAllViewsInLayout();
        this.B = -1;
        this.C = Long.MIN_VALUE;
        m1432c(-1);
        m1433d(-1);
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        boolean z;
        int mode = MeasureSpec.getMode(i);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        Rect rect = this.f778i;
        if (paddingLeft <= this.f774e) {
            paddingLeft = this.f774e;
        }
        rect.left = paddingLeft;
        this.f778i.top = paddingTop > this.f775f ? paddingTop : this.f775f;
        this.f778i.right = paddingRight > this.f776g ? paddingRight : this.f776g;
        this.f778i.bottom = paddingBottom > this.f777h ? paddingBottom : this.f777h;
        if (this.u) {
            m1440k();
        }
        paddingTop = m1435f();
        if (paddingTop >= 0 && this.f770a != null && paddingTop < this.f770a.getCount()) {
            View a = this.f779j.m1589a(paddingTop);
            if (a == null) {
                a = this.f770a.getView(paddingTop, null, this);
            }
            if (a != null) {
                this.f779j.m1591a(paddingTop, a);
            }
            if (a != null) {
                if (a.getLayoutParams() == null) {
                    this.f773d = true;
                    a.setLayoutParams(generateDefaultLayoutParams());
                    this.f773d = false;
                }
                measureChild(a, i, i2);
                paddingTop = (m1446a(a) + this.f778i.top) + this.f778i.bottom;
                paddingLeft = (m1450b(a) + this.f778i.left) + this.f778i.right;
                z = false;
                if (z) {
                    paddingTop = this.f778i.top + this.f778i.bottom;
                    if (mode == 0) {
                        paddingLeft = this.f778i.left + this.f778i.right;
                    }
                }
                setMeasuredDimension(resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i), resolveSize(Math.max(paddingTop, getSuggestedMinimumHeight()), i2));
                this.f771b = i2;
                this.f772c = i;
            }
        }
        z = true;
        paddingLeft = 0;
        paddingTop = 0;
        if (z) {
            paddingTop = this.f778i.top + this.f778i.bottom;
            if (mode == 0) {
                paddingLeft = this.f778i.left + this.f778i.right;
            }
        }
        setMeasuredDimension(resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i), resolveSize(Math.max(paddingTop, getSuggestedMinimumHeight()), i2));
        this.f771b = i2;
        this.f772c = i;
    }

    int m1446a(View view) {
        return view.getMeasuredHeight();
    }

    int m1450b(View view) {
        return view.getMeasuredWidth();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    void m1451b() {
        int childCount = getChildCount();
        C0197d c0197d = this.f779j;
        int i = this.k;
        for (int i2 = 0; i2 < childCount; i2++) {
            c0197d.m1591a(i + i2, getChildAt(i2));
        }
    }

    public void m1448a(int i) {
        m1433d(i);
        requestLayout();
        invalidate();
    }

    public View mo243c() {
        if (this.z <= 0 || this.x < 0) {
            return null;
        }
        return getChildAt(this.x - this.k);
    }

    public void requestLayout() {
        if (!this.f773d) {
            super.requestLayout();
        }
    }

    public SpinnerAdapter m1453d() {
        return this.f770a;
    }

    public Parcelable onSaveInstanceState() {
        Object savedState = new SavedState(super.onSaveInstanceState());
        savedState.f742a = m1436g();
        if (savedState.f742a >= 0) {
            savedState.f743b = m1435f();
        } else {
            savedState.f743b = -1;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f742a >= 0) {
            this.u = true;
            this.p = true;
            this.n = savedState.f742a;
            this.m = savedState.f743b;
            this.q = 0;
            requestLayout();
        }
    }
}
