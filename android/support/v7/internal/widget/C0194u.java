package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.Locale;

/* compiled from: MyApp */
public class C0194u {
    private boolean f922A;
    int f923a = Integer.MAX_VALUE;
    private Context f924b;
    private PopupWindow f925c;
    private ListAdapter f926d;
    private C0213x f927e;
    private int f928f = -2;
    private int f929g = -2;
    private int f930h;
    private int f931i;
    private boolean f932j;
    private boolean f933k = false;
    private boolean f934l = false;
    private View f935m;
    private int f936n = 0;
    private DataSetObserver f937o;
    private View f938p;
    private Drawable f939q;
    private OnItemClickListener f940r;
    private OnItemSelectedListener f941s;
    private final ac f942t = new ac();
    private final ab f943u = new ab();
    private final aa f944v = new aa();
    private final C0214y f945w = new C0214y();
    private Runnable f946x;
    private Handler f947y = new Handler();
    private Rect f948z = new Rect();

    public C0194u(Context context, AttributeSet attributeSet, int i) {
        this.f924b = context;
        this.f925c = new PopupWindow(context, attributeSet, i);
        this.f925c.setInputMethodMode(1);
        Locale locale = this.f924b.getResources().getConfiguration().locale;
    }

    public void mo265a(ListAdapter listAdapter) {
        if (this.f937o == null) {
            this.f937o = new C0215z();
        } else if (this.f926d != null) {
            this.f926d.unregisterDataSetObserver(this.f937o);
        }
        this.f926d = listAdapter;
        if (this.f926d != null) {
            listAdapter.registerDataSetObserver(this.f937o);
        }
        if (this.f927e != null) {
            this.f927e.setAdapter(this.f926d);
        }
    }

    public void m1564a(int i) {
        this.f936n = i;
    }

    public void m1570a(boolean z) {
        this.f922A = true;
        this.f925c.setFocusable(z);
    }

    public Drawable m1563a() {
        return this.f925c.getBackground();
    }

    public void m1565a(Drawable drawable) {
        this.f925c.setBackgroundDrawable(drawable);
    }

    public View m1571b() {
        return this.f938p;
    }

    public void m1566a(View view) {
        this.f938p = view;
    }

    public void m1572b(int i) {
        this.f930h = i;
    }

    public void m1574c(int i) {
        this.f931i = i;
        this.f932j = true;
    }

    public void m1576d(int i) {
        this.f929g = i;
    }

    public void m1578e(int i) {
        Drawable background = this.f925c.getBackground();
        if (background != null) {
            background.getPadding(this.f948z);
            this.f929g = (this.f948z.left + this.f948z.right) + i;
            return;
        }
        m1576d(i);
    }

    public void m1567a(OnItemClickListener onItemClickListener) {
        this.f940r = onItemClickListener;
    }

    public void mo267c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int j = m1561j();
        boolean g = m1582g();
        int i2;
        if (this.f925c.isShowing()) {
            if (this.f929g == -1) {
                i2 = -1;
            } else if (this.f929g == -2) {
                i2 = m1571b().getWidth();
            } else {
                i2 = this.f929g;
            }
            if (this.f928f == -1) {
                if (!g) {
                    j = -1;
                }
                if (g) {
                    PopupWindow popupWindow = this.f925c;
                    if (this.f929g != -1) {
                        i = 0;
                    }
                    popupWindow.setWindowLayoutMode(i, 0);
                } else {
                    this.f925c.setWindowLayoutMode(this.f929g == -1 ? -1 : 0, -1);
                }
            } else if (this.f928f != -2) {
                j = this.f928f;
            }
            PopupWindow popupWindow2 = this.f925c;
            if (!(this.f934l || this.f933k)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.f925c.update(m1571b(), this.f930h, this.f931i, i2, j);
            return;
        }
        int i3;
        if (this.f929g == -1) {
            i3 = -1;
        } else if (this.f929g == -2) {
            this.f925c.setWidth(m1571b().getWidth());
            i3 = 0;
        } else {
            this.f925c.setWidth(this.f929g);
            i3 = 0;
        }
        if (this.f928f == -1) {
            i2 = -1;
        } else if (this.f928f == -2) {
            this.f925c.setHeight(j);
            i2 = 0;
        } else {
            this.f925c.setHeight(this.f928f);
            i2 = 0;
        }
        this.f925c.setWindowLayoutMode(i3, i2);
        popupWindow = this.f925c;
        if (this.f934l || this.f933k) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.f925c.setTouchInterceptor(this.f943u);
        this.f925c.showAsDropDown(m1571b(), this.f930h, this.f931i);
        this.f927e.setSelection(-1);
        if (!this.f922A || this.f927e.isInTouchMode()) {
            m1577e();
        }
        if (!this.f922A) {
            this.f947y.post(this.f945w);
        }
    }

    public void m1575d() {
        this.f925c.dismiss();
        m1560i();
        this.f925c.setContentView(null);
        this.f927e = null;
        this.f947y.removeCallbacks(this.f942t);
    }

    public void m1569a(OnDismissListener onDismissListener) {
        this.f925c.setOnDismissListener(onDismissListener);
    }

    private void m1560i() {
        if (this.f935m != null) {
            ViewParent parent = this.f935m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f935m);
            }
        }
    }

    public void m1579f(int i) {
        this.f925c.setInputMethodMode(i);
    }

    public void m1581g(int i) {
        C0213x c0213x = this.f927e;
        if (m1580f() && c0213x != null) {
            c0213x.f973a = false;
            c0213x.setSelection(i);
            if (c0213x.getChoiceMode() != 0) {
                c0213x.setItemChecked(i, true);
            }
        }
    }

    public void m1577e() {
        C0213x c0213x = this.f927e;
        if (c0213x != null) {
            c0213x.f973a = true;
            c0213x.requestLayout();
        }
    }

    public boolean m1580f() {
        return this.f925c.isShowing();
    }

    public boolean m1582g() {
        return this.f925c.getInputMethodMode() == 2;
    }

    public ListView m1583h() {
        return this.f927e;
    }

    private int m1561j() {
        int measuredHeight;
        int i;
        int i2;
        boolean z = true;
        View linearLayout;
        LayoutParams layoutParams;
        if (this.f927e == null) {
            Context context = this.f924b;
            this.f946x = new C0211v(this);
            this.f927e = new C0213x(context, !this.f922A);
            if (this.f939q != null) {
                this.f927e.setSelector(this.f939q);
            }
            this.f927e.setAdapter(this.f926d);
            this.f927e.setOnItemClickListener(this.f940r);
            this.f927e.setFocusable(true);
            this.f927e.setFocusableInTouchMode(true);
            this.f927e.setOnItemSelectedListener(new C0212w(this));
            this.f927e.setOnScrollListener(this.f944v);
            if (this.f941s != null) {
                this.f927e.setOnItemSelectedListener(this.f941s);
            }
            View view = this.f927e;
            View view2 = this.f935m;
            if (view2 != null) {
                linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f936n) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams2);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f936n);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.f929g, Integer.MIN_VALUE), 0);
                layoutParams = (LayoutParams) view2.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (view2.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                linearLayout = view;
                measuredHeight = 0;
            }
            this.f925c.setContentView(linearLayout);
            i = measuredHeight;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f925c.getContentView();
            linearLayout = this.f935m;
            if (linearLayout != null) {
                layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                i = layoutParams.bottomMargin + (linearLayout.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i = 0;
            }
        }
        Drawable background = this.f925c.getBackground();
        if (background != null) {
            background.getPadding(this.f948z);
            measuredHeight = this.f948z.top + this.f948z.bottom;
            if (this.f932j) {
                i2 = measuredHeight;
            } else {
                this.f931i = -this.f948z.top;
                i2 = measuredHeight;
            }
        } else {
            this.f948z.setEmpty();
            i2 = 0;
        }
        if (this.f925c.getInputMethodMode() != 2) {
            z = false;
        }
        int a = m1562a(m1571b(), this.f931i, z);
        if (this.f933k || this.f928f == -1) {
            return a + i2;
        }
        int makeMeasureSpec;
        switch (this.f929g) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f924b.getResources().getDisplayMetrics().widthPixels - (this.f948z.left + this.f948z.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f924b.getResources().getDisplayMetrics().widthPixels - (this.f948z.left + this.f948z.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f929g, 1073741824);
                break;
        }
        measuredHeight = this.f927e.m1608a(makeMeasureSpec, 0, -1, a - i, -1);
        if (measuredHeight > 0) {
            i += i2;
        }
        return measuredHeight + i;
    }

    public int m1562a(View view, int i, boolean z) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        i2 = Math.max((i2 - (iArr[1] + view.getHeight())) - i, (iArr[1] - rect.top) + i);
        if (this.f925c.getBackground() == null) {
            return i2;
        }
        this.f925c.getBackground().getPadding(this.f948z);
        return i2 - (this.f948z.top + this.f948z.bottom);
    }
}
