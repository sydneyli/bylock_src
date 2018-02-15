package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0087n;
import android.support.v4.view.C0088o;
import android.support.v7.internal.view.C0159a;
import android.support.v7.p008b.C0153g;
import android.support.v7.p008b.C0154h;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* compiled from: MyApp */
public class ActionMenuPresenter extends C0167l implements C0088o {
    final C0182h f569a = new C0182h();
    int f570b;
    private View f571i;
    private boolean f572j;
    private boolean f573k;
    private int f574l;
    private int f575m;
    private int f576n;
    private boolean f577o;
    private boolean f578p;
    private boolean f579q;
    private boolean f580r;
    private int f581s;
    private final SparseBooleanArray f582t = new SparseBooleanArray();
    private View f583u;
    private C0181g f584v;
    private C0178d f585w;
    private C0179e f586x;

    /* compiled from: MyApp */
    class SavedState implements Parcelable {
        public static final Creator CREATOR = new C0183i();
        public int f558a;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f558a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f558a);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0154h.abc_action_menu_layout, C0154h.abc_action_menu_item_layout);
    }

    public void mo209a(Context context, C0174q c0174q) {
        super.mo209a(context, c0174q);
        Resources resources = context.getResources();
        C0159a a = C0159a.m1162a(context);
        if (!this.f573k) {
            this.f572j = a.m1164b();
        }
        if (!this.f579q) {
            this.f574l = a.m1165c();
        }
        if (!this.f577o) {
            this.f576n = a.m1163a();
        }
        int i = this.f574l;
        if (this.f572j) {
            if (this.f571i == null) {
                this.f571i = new C0180f(this, this.c);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f571i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f571i.getMeasuredWidth();
        } else {
            this.f571i = null;
        }
        this.f575m = i;
        this.f581s = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f583u = null;
    }

    public void m1233a(Configuration configuration) {
        if (!this.f577o) {
            this.f576n = this.d.getResources().getInteger(C0153g.abc_max_action_buttons);
        }
        if (this.e != null) {
            this.e.m1340b(true);
        }
    }

    public void m1231a(int i, boolean z) {
        this.f574l = i;
        this.f578p = z;
        this.f579q = true;
    }

    public void m1236a(boolean z) {
        this.f572j = z;
        this.f573k = true;
    }

    public void m1230a(int i) {
        this.f576n = i;
        this.f577o = true;
    }

    public void m1241b(boolean z) {
        this.f580r = z;
    }

    public ah mo216a(ViewGroup viewGroup) {
        ah a = super.mo216a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View mo217a(C0187u c0187u, View view, ViewGroup viewGroup) {
        View actionView = c0187u.getActionView();
        if (actionView == null || c0187u.m1417n()) {
            if (!(view instanceof ActionMenuItemView)) {
                view = null;
            }
            actionView = super.mo217a(c0187u, view, viewGroup);
        }
        actionView.setVisibility(c0187u.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m1260a(layoutParams));
        }
        return actionView;
    }

    public void mo218a(C0187u c0187u, ai aiVar) {
        aiVar.mo204a(c0187u, 0);
        ((ActionMenuItemView) aiVar).setItemInvoker((ActionMenuView) this.h);
    }

    public boolean mo219a(int i, C0187u c0187u) {
        return c0187u.m1412i();
    }

    public void mo214c(boolean z) {
        int i = 1;
        int i2 = 0;
        super.mo214c(z);
        if (this.h != null) {
            int i3;
            if (this.e != null) {
                ArrayList j = this.e.m1352j();
                int size = j.size();
                for (i3 = 0; i3 < size; i3++) {
                    C0087n m = ((C0187u) j.get(i3)).m1416m();
                    if (m != null) {
                        m.m750a((C0088o) this);
                    }
                }
            }
            ArrayList k = this.e != null ? this.e.m1353k() : null;
            if (this.f572j && k != null) {
                i3 = k.size();
                if (i3 == 1) {
                    int i4;
                    if (((C0187u) k.get(0)).isActionViewExpanded()) {
                        i4 = 0;
                    } else {
                        i4 = 1;
                    }
                    i2 = i4;
                } else {
                    if (i3 <= 0) {
                        i = 0;
                    }
                    i2 = i;
                }
            }
            if (i2 != 0) {
                if (this.f571i == null) {
                    this.f571i = new C0180f(this, this.c);
                }
                ViewGroup viewGroup = (ViewGroup) this.f571i.getParent();
                if (viewGroup != this.h) {
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f571i);
                    }
                    ActionMenuView actionMenuView = (ActionMenuView) this.h;
                    actionMenuView.addView(this.f571i, actionMenuView.m1264b());
                }
            } else if (this.f571i != null && this.f571i.getParent() == this.h) {
                ((ViewGroup) this.h).removeView(this.f571i);
            }
            ((ActionMenuView) this.h).setOverflowReserved(this.f572j);
        }
    }

    public boolean mo220a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f571i) {
            return false;
        }
        return super.mo220a(viewGroup, i);
    }

    public boolean mo211a(al alVar) {
        if (!alVar.hasVisibleItems()) {
            return false;
        }
        al alVar2 = alVar;
        while (alVar2.m1367r() != this.e) {
            alVar2 = (al) alVar2.m1367r();
        }
        if (m1227a(alVar2.getItem()) == null) {
            if (this.f571i == null) {
                return false;
            }
            View view = this.f571i;
        }
        this.f570b = alVar.getItem().getItemId();
        this.f585w = new C0178d(this, alVar);
        this.f585w.m1369a(null);
        super.mo211a(alVar);
        return true;
    }

    private View m1227a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.h;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ai) && ((ai) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean m1237a() {
        if (!this.f572j || m1246e() || this.e == null || this.h == null || this.f586x != null) {
            return false;
        }
        this.f586x = new C0179e(this, new C0181g(this, this.d, this.e, this.f571i, true));
        ((View) this.h).post(this.f586x);
        super.mo211a(null);
        return true;
    }

    public boolean m1242b() {
        if (this.f586x == null || this.h == null) {
            ad adVar = this.f584v;
            if (adVar == null) {
                return false;
            }
            adVar.m1302b();
            return true;
        }
        ((View) this.h).removeCallbacks(this.f586x);
        this.f586x = null;
        return true;
    }

    public boolean m1244c() {
        return m1242b() | m1245d();
    }

    public boolean m1245d() {
        if (this.f585w == null) {
            return false;
        }
        this.f585w.m1368a();
        return true;
    }

    public boolean m1246e() {
        return this.f584v != null && this.f584v.m1305c();
    }

    public boolean m1247f() {
        return this.f572j;
    }

    public boolean mo215g() {
        int i;
        ArrayList h = this.e.m1350h();
        int size = h.size();
        int i2 = this.f576n;
        int i3 = this.f575m;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.h;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            C0187u c0187u = (C0187u) h.get(i6);
            if (c0187u.m1414k()) {
                i4++;
            } else if (c0187u.m1413j()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.f580r && c0187u.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.f572j && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.f582t;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f578p) {
            i = i3 / this.f581s;
            i5 = ((i3 % this.f581s) / i) + this.f581s;
        } else {
            i5 = 0;
        }
        int i7 = 0;
        i2 = 0;
        int i8 = i;
        while (i7 < size) {
            c0187u = (C0187u) h.get(i7);
            int i9;
            if (c0187u.m1414k()) {
                View a = mo217a(c0187u, this.f583u, viewGroup);
                if (this.f583u == null) {
                    this.f583u = a;
                }
                if (this.f578p) {
                    i8 -= ActionMenuView.m1256a(a, i5, i8, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = c0187u.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                c0187u.m1406d(true);
                i = i9;
                i2 = i6;
            } else if (c0187u.m1413j()) {
                boolean z;
                int groupId = c0187u.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.f578p || i8 > 0);
                if (z3) {
                    View a2 = mo217a(c0187u, this.f583u, viewGroup);
                    if (this.f583u == null) {
                        this.f583u = a2;
                    }
                    boolean z4;
                    if (this.f578p) {
                        int a3 = ActionMenuView.m1256a(a2, i5, i8, makeMeasureSpec, 0);
                        i9 = i8 - a3;
                        if (a3 == 0) {
                            i8 = 0;
                        } else {
                            z4 = z3;
                        }
                        i4 = i9;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i4 = i8;
                        z4 = z5;
                    }
                    i9 = a2.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.f578p) {
                        z = i8 & (i3 >= 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    } else {
                        z = i8 & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i2;
                    i2 = i8;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i8 = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i7; i6++) {
                        C0187u c0187u2 = (C0187u) h.get(i6);
                        if (c0187u2.getGroupId() == groupId) {
                            if (c0187u2.m1412i()) {
                                i4++;
                            }
                            c0187u2.m1406d(false);
                        }
                    }
                    i8 = i4;
                } else {
                    i8 = i6;
                }
                if (z) {
                    i8--;
                }
                c0187u.m1406d(z);
                i4 = i9;
                i = i3;
                int i10 = i2;
                i2 = i8;
                i8 = i10;
            } else {
                i4 = i2;
                i = i3;
                i2 = i6;
            }
            i7++;
            i3 = i;
            i6 = i2;
            i2 = i4;
        }
        return true;
    }

    public void mo210a(C0174q c0174q, boolean z) {
        m1244c();
        super.mo210a(c0174q, z);
    }
}
