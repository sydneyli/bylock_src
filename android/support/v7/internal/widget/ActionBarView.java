package android.support.v7.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p001b.p002a.C0040a;
import android.support.v4.p001b.p002a.C0041b;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.C0169a;
import android.support.v7.internal.view.menu.C0174q;
import android.support.v7.internal.view.menu.C0187u;
import android.support.v7.internal.view.menu.ag;
import android.support.v7.p006a.C0128c;
import android.support.v7.p006a.C0129d;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0150d;
import android.support.v7.p008b.C0152f;
import android.support.v7.p008b.C0154h;
import android.support.v7.p008b.C0155i;
import android.support.v7.p008b.C0157k;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* compiled from: MyApp */
public class ActionBarView extends C0192a {
    private ProgressBarICS f816A;
    private int f817B;
    private int f818C;
    private int f819D;
    private int f820E;
    private int f821F;
    private int f822G;
    private boolean f823H;
    private boolean f824I;
    private boolean f825J;
    private boolean f826K;
    private C0174q f827L;
    private ActionBarContextView f828M;
    private C0169a f829N;
    private SpinnerAdapter f830O;
    private C0129d f831P;
    private Runnable f832Q;
    private C0204j f833R;
    private final C0200q f834S = new C0201g(this);
    private final OnClickListener f835T = new C0202h(this);
    private final OnClickListener f836U = new C0203i(this);
    View f837g;
    Callback f838h;
    private int f839i;
    private int f840j = -1;
    private CharSequence f841k;
    private CharSequence f842l;
    private Drawable f843m;
    private Drawable f844n;
    private Context f845o;
    private HomeView f846p;
    private HomeView f847q;
    private LinearLayout f848r;
    private TextView f849s;
    private TextView f850t;
    private View f851u;
    private ak f852v;
    private LinearLayout f853w;
    private ScrollingTabContainerView f854x;
    private View f855y;
    private ProgressBarICS f856z;

    /* compiled from: MyApp */
    class HomeView extends FrameLayout {
        private ImageView f809a;
        private ImageView f810b;
        private int f811c;
        private int f812d;
        private Drawable f813e;

        public HomeView(Context context) {
            this(context, null);
        }

        public HomeView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void m1478a(boolean z) {
            this.f809a.setVisibility(z ? 0 : 8);
        }

        public void m1477a(Drawable drawable) {
            this.f810b.setImageDrawable(drawable);
        }

        public void m1479b(Drawable drawable) {
            ImageView imageView = this.f809a;
            if (drawable == null) {
                drawable = this.f813e;
            }
            imageView.setImageDrawable(drawable);
            this.f812d = 0;
        }

        public void m1476a(int i) {
            this.f812d = i;
            this.f809a.setImageDrawable(i != 0 ? getResources().getDrawable(i) : null);
        }

        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            if (this.f812d != 0) {
                m1476a(this.f812d);
            }
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            CharSequence contentDescription = getContentDescription();
            if (!TextUtils.isEmpty(contentDescription)) {
                accessibilityEvent.getText().add(contentDescription);
            }
            return true;
        }

        protected void onFinishInflate() {
            this.f809a = (ImageView) findViewById(C0152f.up);
            this.f810b = (ImageView) findViewById(C0152f.home);
            this.f813e = this.f809a.getDrawable();
        }

        public int m1475a() {
            return this.f809a.getVisibility() == 8 ? this.f811c : 0;
        }

        protected void onMeasure(int i, int i2) {
            measureChildWithMargins(this.f809a, i, 0, i2, 0);
            LayoutParams layoutParams = (LayoutParams) this.f809a.getLayoutParams();
            this.f811c = (layoutParams.leftMargin + this.f809a.getMeasuredWidth()) + layoutParams.rightMargin;
            int i3 = this.f809a.getVisibility() == 8 ? 0 : this.f811c;
            int measuredHeight = (layoutParams.topMargin + this.f809a.getMeasuredHeight()) + layoutParams.bottomMargin;
            measureChildWithMargins(this.f810b, i, i3, i2, 0);
            layoutParams = (LayoutParams) this.f810b.getLayoutParams();
            int measuredWidth = i3 + ((layoutParams.leftMargin + this.f810b.getMeasuredWidth()) + layoutParams.rightMargin);
            measuredHeight = Math.max(measuredHeight, layoutParams.bottomMargin + (layoutParams.topMargin + this.f810b.getMeasuredHeight()));
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            switch (mode) {
                case Integer.MIN_VALUE:
                    size = Math.min(measuredWidth, size);
                    break;
                case 1073741824:
                    break;
                default:
                    size = measuredWidth;
                    break;
            }
            switch (mode2) {
                case Integer.MIN_VALUE:
                    size2 = Math.min(measuredHeight, size2);
                    break;
                case 1073741824:
                    break;
                default:
                    size2 = measuredHeight;
                    break;
            }
            setMeasuredDimension(size, size2);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams;
            int measuredHeight;
            int i5;
            int i6 = 0;
            int i7 = (i4 - i2) / 2;
            int i8 = i3 - i;
            if (this.f809a.getVisibility() != 8) {
                layoutParams = (LayoutParams) this.f809a.getLayoutParams();
                measuredHeight = this.f809a.getMeasuredHeight();
                int measuredWidth = this.f809a.getMeasuredWidth();
                int i9 = i7 - (measuredHeight / 2);
                this.f809a.layout(0, i9, measuredWidth, measuredHeight + i9);
                i5 = layoutParams.rightMargin + (layoutParams.leftMargin + measuredWidth);
                i6 = i8 - i5;
                i += i5;
                i6 = i5;
            }
            layoutParams = (LayoutParams) this.f810b.getLayoutParams();
            i8 = this.f810b.getMeasuredHeight();
            measuredHeight = this.f810b.getMeasuredWidth();
            i6 += Math.max(layoutParams.leftMargin, ((i3 - i) / 2) - (measuredHeight / 2));
            i5 = Math.max(layoutParams.topMargin, i7 - (i8 / 2));
            this.f810b.layout(i6, i5, measuredHeight + i6, i8 + i5);
        }
    }

    /* compiled from: MyApp */
    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C0205k();
        int f814a;
        boolean f815b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f814a = parcel.readInt();
            this.f815b = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f814a);
            parcel.writeInt(this.f815b ? 1 : 0);
        }
    }

    public /* bridge */ /* synthetic */ boolean mo246a() {
        return super.mo246a();
    }

    public /* bridge */ /* synthetic */ void mo247b() {
        super.mo247b();
    }

    public /* bridge */ /* synthetic */ boolean mo248c() {
        return super.mo248c();
    }

    public /* bridge */ /* synthetic */ boolean mo249d() {
        return super.mo249d();
    }

    public /* bridge */ /* synthetic */ boolean mo250e() {
        return super.mo250e();
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ void setContentHeight(int i) {
        super.setContentHeight(i);
    }

    public /* bridge */ /* synthetic */ void setSplitView(ActionBarContainer actionBarContainer) {
        super.setSplitView(actionBarContainer);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f845o = context;
        setBackgroundResource(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.ActionBar, C0149c.actionBarStyle, 0);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        PackageManager packageManager = context.getPackageManager();
        this.f839i = obtainStyledAttributes.getInt(2, 0);
        this.f841k = obtainStyledAttributes.getText(0);
        this.f842l = obtainStyledAttributes.getText(4);
        this.f844n = obtainStyledAttributes.getDrawable(8);
        if (this.f844n == null && VERSION.SDK_INT >= 9) {
            if (context instanceof Activity) {
                try {
                    this.f844n = packageManager.getActivityLogo(((Activity) context).getComponentName());
                } catch (Throwable e) {
                    Log.e("ActionBarView", "Activity component name not found!", e);
                }
            }
            if (this.f844n == null) {
                this.f844n = applicationInfo.loadLogo(packageManager);
            }
        }
        this.f843m = obtainStyledAttributes.getDrawable(7);
        if (this.f843m == null) {
            if (context instanceof Activity) {
                try {
                    this.f843m = packageManager.getActivityIcon(((Activity) context).getComponentName());
                } catch (Throwable e2) {
                    Log.e("ActionBarView", "Activity component name not found!", e2);
                }
            }
            if (this.f843m == null) {
                this.f843m = applicationInfo.loadIcon(packageManager);
            }
        }
        LayoutInflater from = LayoutInflater.from(context);
        int resourceId = obtainStyledAttributes.getResourceId(14, C0154h.abc_action_bar_home);
        this.f846p = (HomeView) from.inflate(resourceId, this, false);
        this.f847q = (HomeView) from.inflate(resourceId, this, false);
        this.f847q.m1478a(true);
        this.f847q.setOnClickListener(this.f835T);
        this.f847q.setContentDescription(getResources().getText(C0155i.abc_action_bar_up_description));
        this.f819D = obtainStyledAttributes.getResourceId(5, 0);
        this.f820E = obtainStyledAttributes.getResourceId(6, 0);
        this.f821F = obtainStyledAttributes.getResourceId(15, 0);
        this.f822G = obtainStyledAttributes.getResourceId(16, 0);
        this.f817B = obtainStyledAttributes.getDimensionPixelOffset(17, 0);
        this.f818C = obtainStyledAttributes.getDimensionPixelOffset(18, 0);
        setDisplayOptions(obtainStyledAttributes.getInt(3, 0));
        int resourceId2 = obtainStyledAttributes.getResourceId(13, 0);
        if (resourceId2 != 0) {
            this.f855y = from.inflate(resourceId2, this, false);
            this.f839i = 0;
            setDisplayOptions(this.f840j | 16);
        }
        this.f = obtainStyledAttributes.getLayoutDimension(1, 0);
        obtainStyledAttributes.recycle();
        this.f829N = new C0169a(context, 0, 16908332, 0, 0, this.f841k);
        this.f846p.setOnClickListener(this.f836U);
        this.f846p.setClickable(true);
        this.f846p.setFocusable(true);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f849s = null;
        this.f850t = null;
        this.f851u = null;
        if (this.f848r != null && this.f848r.getParent() == this) {
            removeView(this.f848r);
        }
        this.f848r = null;
        if ((this.f840j & 8) != 0) {
            m1494m();
        }
        if (this.f854x != null && this.f824I) {
            ViewGroup.LayoutParams layoutParams = this.f854x.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = -1;
            }
            this.f854x.setAllowCollapse(true);
        }
    }

    public void setWindowCallback(Callback callback) {
        this.f838h = callback;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f832Q);
        if (this.b != null) {
            this.b.m1242b();
            this.b.m1245d();
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void m1502f() {
        this.f856z = new ProgressBarICS(this.f845o, null, 0, this.f821F);
        this.f856z.setId(C0152f.progress_horizontal);
        this.f856z.setMax(10000);
        this.f856z.setVisibility(8);
        addView(this.f856z);
    }

    public void m1503g() {
        this.f816A = new ProgressBarICS(this.f845o, null, 0, this.f822G);
        this.f816A.setId(C0152f.progress_circular);
        this.f816A.setVisibility(8);
        addView(this.f816A);
    }

    public void setSplitActionBar(boolean z) {
        if (this.d != z) {
            if (this.a != null) {
                ViewGroup viewGroup = (ViewGroup) this.a.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.a);
                }
                if (z) {
                    if (this.c != null) {
                        this.c.addView(this.a);
                    }
                    this.a.getLayoutParams().width = -1;
                } else {
                    addView(this.a);
                    this.a.getLayoutParams().width = -2;
                }
                this.a.requestLayout();
            }
            if (this.c != null) {
                this.c.setVisibility(z ? 0 : 8);
            }
            if (this.b != null) {
                if (z) {
                    this.b.m1241b(false);
                    this.b.m1231a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.b.m1230a(Integer.MAX_VALUE);
                } else {
                    this.b.m1241b(getResources().getBoolean(C0150d.abc_action_bar_expanded_action_views_exclusive));
                }
            }
            super.setSplitActionBar(z);
        }
    }

    public boolean m1504h() {
        return this.d;
    }

    public boolean m1505i() {
        return this.f824I;
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f854x != null) {
            removeView(this.f854x);
        }
        this.f854x = scrollingTabContainerView;
        this.f824I = scrollingTabContainerView != null;
        if (this.f824I && this.f839i == 2) {
            addView(this.f854x);
            ViewGroup.LayoutParams layoutParams = this.f854x.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void setCallback(C0129d c0129d) {
        this.f831P = c0129d;
    }

    public void m1496a(C0040a c0040a, ag agVar) {
        if (c0040a != this.f827L) {
            ActionMenuView actionMenuView;
            if (this.f827L != null) {
                this.f827L.m1338b(this.b);
                this.f827L.m1338b(this.f833R);
            }
            C0174q c0174q = (C0174q) c0040a;
            this.f827L = c0174q;
            if (this.a != null) {
                ViewGroup viewGroup = (ViewGroup) this.a.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.a);
                }
            }
            if (this.b == null) {
                this.b = new ActionMenuPresenter(this.f845o);
                this.b.m1211a(agVar);
                this.b.m1220b(C0152f.action_menu_presenter);
                this.f833R = new C0204j();
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            ViewGroup viewGroup2;
            if (this.d) {
                this.b.m1241b(false);
                this.b.m1231a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                this.b.m1230a(Integer.MAX_VALUE);
                layoutParams.width = -1;
                m1481a(c0174q);
                actionMenuView = (ActionMenuView) this.b.mo216a((ViewGroup) this);
                if (this.c != null) {
                    viewGroup2 = (ViewGroup) actionMenuView.getParent();
                    if (!(viewGroup2 == null || viewGroup2 == this.c)) {
                        viewGroup2.removeView(actionMenuView);
                    }
                    actionMenuView.setVisibility(getAnimatedVisibility());
                    this.c.addView(actionMenuView, layoutParams);
                } else {
                    actionMenuView.setLayoutParams(layoutParams);
                }
            } else {
                this.b.m1241b(getResources().getBoolean(C0150d.abc_action_bar_expanded_action_views_exclusive));
                m1481a(c0174q);
                actionMenuView = (ActionMenuView) this.b.mo216a((ViewGroup) this);
                viewGroup2 = (ViewGroup) actionMenuView.getParent();
                if (!(viewGroup2 == null || viewGroup2 == this)) {
                    viewGroup2.removeView(actionMenuView);
                }
                addView(actionMenuView, layoutParams);
            }
            this.a = actionMenuView;
        }
    }

    private void m1481a(C0174q c0174q) {
        if (c0174q != null) {
            c0174q.m1328a(this.b);
            c0174q.m1328a(this.f833R);
        } else {
            this.b.mo209a(this.f845o, null);
            this.f833R.mo209a(this.f845o, null);
        }
        this.b.mo214c(true);
        this.f833R.mo214c(true);
    }

    public boolean m1506j() {
        return (this.f833R == null || this.f833R.f963b == null) ? false : true;
    }

    public void m1507k() {
        C0187u c0187u = this.f833R == null ? null : this.f833R.f963b;
        if (c0187u != null) {
            c0187u.collapseActionView();
        }
    }

    public void setCustomNavigationView(View view) {
        Object obj = (this.f840j & 16) != 0 ? 1 : null;
        if (!(this.f855y == null || obj == null)) {
            removeView(this.f855y);
        }
        this.f855y = view;
        if (this.f855y != null && obj != null) {
            addView(this.f855y);
        }
    }

    public CharSequence getTitle() {
        return this.f841k;
    }

    public void setTitle(CharSequence charSequence) {
        this.f823H = true;
        setTitleImpl(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f823H) {
            setTitleImpl(charSequence);
        }
    }

    private void setTitleImpl(CharSequence charSequence) {
        int i = 0;
        this.f841k = charSequence;
        if (this.f849s != null) {
            this.f849s.setText(charSequence);
            int i2 = (this.f837g != null || (this.f840j & 8) == 0 || (TextUtils.isEmpty(this.f841k) && TextUtils.isEmpty(this.f842l))) ? 0 : 1;
            LinearLayout linearLayout = this.f848r;
            if (i2 == 0) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
        if (this.f829N != null) {
            this.f829N.setTitle(charSequence);
        }
    }

    public CharSequence getSubtitle() {
        return this.f842l;
    }

    public void setSubtitle(CharSequence charSequence) {
        int i = 0;
        this.f842l = charSequence;
        if (this.f850t != null) {
            int i2;
            this.f850t.setText(charSequence);
            this.f850t.setVisibility(charSequence != null ? 0 : 8);
            if (this.f837g != null || (this.f840j & 8) == 0 || (TextUtils.isEmpty(this.f841k) && TextUtils.isEmpty(this.f842l))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            LinearLayout linearLayout = this.f848r;
            if (i2 == 0) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
    }

    public void setHomeButtonEnabled(boolean z) {
        this.f846p.setEnabled(z);
        this.f846p.setFocusable(z);
        if (!z) {
            this.f846p.setContentDescription(null);
        } else if ((this.f840j & 4) != 0) {
            this.f846p.setContentDescription(this.f845o.getResources().getText(C0155i.abc_action_bar_up_description));
        } else {
            this.f846p.setContentDescription(this.f845o.getResources().getText(C0155i.abc_action_bar_home_description));
        }
    }

    public void setDisplayOptions(int i) {
        int i2 = 8;
        int i3 = -1;
        boolean z = true;
        if (this.f840j != -1) {
            i3 = this.f840j ^ i;
        }
        this.f840j = i;
        if ((i3 & 31) != 0) {
            boolean z2;
            int i4;
            boolean z3;
            if ((i & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && this.f837g == null) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            this.f846p.setVisibility(i4);
            if ((i3 & 4) != 0) {
                if ((i & 4) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f846p.m1478a(z3);
                if (z3) {
                    setHomeButtonEnabled(true);
                }
            }
            if ((i3 & 1) != 0) {
                z3 = (this.f844n == null || (i & 1) == 0) ? false : true;
                this.f846p.m1477a(z3 ? this.f844n : this.f843m);
            }
            if ((i3 & 8) != 0) {
                if ((i & 8) != 0) {
                    m1494m();
                } else {
                    removeView(this.f848r);
                }
            }
            if (!(this.f848r == null || (i3 & 6) == 0)) {
                if ((this.f840j & 4) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                View view = this.f851u;
                if (!z2) {
                    i2 = z3 ? 0 : 4;
                }
                view.setVisibility(i2);
                LinearLayout linearLayout = this.f848r;
                if (z2 || !z3) {
                    z = false;
                }
                linearLayout.setEnabled(z);
            }
            if (!((i3 & 16) == 0 || this.f855y == null)) {
                if ((i & 16) != 0) {
                    addView(this.f855y);
                } else {
                    removeView(this.f855y);
                }
            }
            requestLayout();
        } else {
            invalidate();
        }
        if (!this.f846p.isEnabled()) {
            this.f846p.setContentDescription(null);
        } else if ((i & 4) != 0) {
            this.f846p.setContentDescription(this.f845o.getResources().getText(C0155i.abc_action_bar_up_description));
        } else {
            this.f846p.setContentDescription(this.f845o.getResources().getText(C0155i.abc_action_bar_home_description));
        }
    }

    public void setIcon(Drawable drawable) {
        this.f843m = drawable;
        if (drawable != null && ((this.f840j & 1) == 0 || this.f844n == null)) {
            this.f846p.m1477a(drawable);
        }
        if (this.f837g != null) {
            this.f847q.m1477a(this.f843m.getConstantState().newDrawable(getResources()));
        }
    }

    public void setIcon(int i) {
        setIcon(this.f845o.getResources().getDrawable(i));
    }

    public void setLogo(Drawable drawable) {
        this.f844n = drawable;
        if (drawable != null && (this.f840j & 1) != 0) {
            this.f846p.m1477a(drawable);
        }
    }

    public void setLogo(int i) {
        setLogo(this.f845o.getResources().getDrawable(i));
    }

    public void setNavigationMode(int i) {
        int i2 = this.f839i;
        if (i != i2) {
            switch (i2) {
                case 1:
                    if (this.f853w != null) {
                        removeView(this.f853w);
                        break;
                    }
                    break;
                case 2:
                    if (this.f854x != null && this.f824I) {
                        removeView(this.f854x);
                        break;
                    }
            }
            switch (i) {
                case 1:
                    if (this.f852v == null) {
                        this.f852v = new ak(this.f845o, null, C0149c.actionDropDownStyle);
                        this.f853w = (LinearLayout) LayoutInflater.from(this.f845o).inflate(C0154h.abc_action_bar_view_list_nav_layout, null);
                        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                        layoutParams.gravity = 17;
                        this.f853w.addView(this.f852v, layoutParams);
                    }
                    if (this.f852v.m1453d() != this.f830O) {
                        this.f852v.mo261a(this.f830O);
                    }
                    this.f852v.m1428a(this.f834S);
                    addView(this.f853w);
                    break;
                case 2:
                    if (this.f854x != null && this.f824I) {
                        addView(this.f854x);
                        break;
                    }
            }
            this.f839i = i;
            requestLayout();
        }
    }

    public void setDropdownAdapter(SpinnerAdapter spinnerAdapter) {
        this.f830O = spinnerAdapter;
        if (this.f852v != null) {
            this.f852v.mo261a(spinnerAdapter);
        }
    }

    public SpinnerAdapter getDropdownAdapter() {
        return this.f830O;
    }

    public void setDropdownSelectedPosition(int i) {
        this.f852v.m1448a(i);
    }

    public int getDropdownSelectedPosition() {
        return this.f852v.m1435f();
    }

    public View getCustomNavigationView() {
        return this.f855y;
    }

    public int getNavigationMode() {
        return this.f839i;
    }

    public int getDisplayOptions() {
        return this.f840j;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0128c(19);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        addView(this.f846p);
        if (this.f855y != null && (this.f840j & 16) != 0) {
            ActionBarView parent = this.f855y.getParent();
            if (parent != this) {
                if (parent instanceof ViewGroup) {
                    parent.removeView(this.f855y);
                }
                addView(this.f855y);
            }
        }
    }

    private void m1494m() {
        boolean z = true;
        if (this.f848r == null) {
            boolean z2;
            this.f848r = (LinearLayout) LayoutInflater.from(getContext()).inflate(C0154h.abc_action_bar_title_item, this, false);
            this.f849s = (TextView) this.f848r.findViewById(C0152f.action_bar_title);
            this.f850t = (TextView) this.f848r.findViewById(C0152f.action_bar_subtitle);
            this.f851u = this.f848r.findViewById(C0152f.up);
            this.f848r.setOnClickListener(this.f836U);
            if (this.f819D != 0) {
                this.f849s.setTextAppearance(this.f845o, this.f819D);
            }
            if (this.f841k != null) {
                this.f849s.setText(this.f841k);
            }
            if (this.f820E != 0) {
                this.f850t.setTextAppearance(this.f845o, this.f820E);
            }
            if (this.f842l != null) {
                this.f850t.setText(this.f842l);
                this.f850t.setVisibility(0);
            }
            boolean z3 = (this.f840j & 4) != 0;
            if ((this.f840j & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            View view = this.f851u;
            int i = !z2 ? z3 ? 0 : 4 : 8;
            view.setVisibility(i);
            LinearLayout linearLayout = this.f848r;
            if (!z3 || z2) {
                z = false;
            }
            linearLayout.setEnabled(z);
        }
        addView(this.f848r);
        if (this.f837g != null || (TextUtils.isEmpty(this.f841k) && TextUtils.isEmpty(this.f842l))) {
            this.f848r.setVisibility(8);
        }
    }

    public void setContextView(ActionBarContextView actionBarContextView) {
        this.f828M = actionBarContextView;
    }

    public void setCollapsable(boolean z) {
        this.f825J = z;
    }

    public boolean m1508l() {
        return this.f826K;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r20, int r21) {
        /*
        r19 = this;
        r13 = r19.getChildCount();
        r0 = r19;
        r1 = r0.f825J;
        if (r1 == 0) goto L_0x0045;
    L_0x000a:
        r2 = 0;
        r1 = 0;
        r18 = r1;
        r1 = r2;
        r2 = r18;
    L_0x0011:
        if (r2 >= r13) goto L_0x0036;
    L_0x0013:
        r0 = r19;
        r3 = r0.getChildAt(r2);
        r4 = r3.getVisibility();
        r5 = 8;
        if (r4 == r5) goto L_0x0033;
    L_0x0021:
        r0 = r19;
        r4 = r0.a;
        if (r3 != r4) goto L_0x0031;
    L_0x0027:
        r0 = r19;
        r3 = r0.a;
        r3 = r3.getChildCount();
        if (r3 == 0) goto L_0x0033;
    L_0x0031:
        r1 = r1 + 1;
    L_0x0033:
        r2 = r2 + 1;
        goto L_0x0011;
    L_0x0036:
        if (r1 != 0) goto L_0x0045;
    L_0x0038:
        r1 = 0;
        r2 = 0;
        r0 = r19;
        r0.setMeasuredDimension(r1, r2);
        r1 = 1;
        r0 = r19;
        r0.f826K = r1;
    L_0x0044:
        return;
    L_0x0045:
        r1 = 0;
        r0 = r19;
        r0.f826K = r1;
        r1 = android.view.View.MeasureSpec.getMode(r20);
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r1 == r2) goto L_0x0079;
    L_0x0052:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r19.getClass();
        r3 = r3.getSimpleName();
        r2 = r2.append(r3);
        r3 = " can only be used ";
        r2 = r2.append(r3);
        r3 = "with android:layout_width=\"MATCH_PARENT\" (or fill_parent)";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x0079:
        r1 = android.view.View.MeasureSpec.getMode(r21);
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r1 == r2) goto L_0x00a8;
    L_0x0081:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r19.getClass();
        r3 = r3.getSimpleName();
        r2 = r2.append(r3);
        r3 = " can only be used ";
        r2 = r2.append(r3);
        r3 = "with android:layout_height=\"wrap_content\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x00a8:
        r14 = android.view.View.MeasureSpec.getSize(r20);
        r0 = r19;
        r1 = r0.f;
        if (r1 <= 0) goto L_0x0271;
    L_0x00b2:
        r0 = r19;
        r1 = r0.f;
        r3 = r1;
    L_0x00b7:
        r1 = r19.getPaddingTop();
        r2 = r19.getPaddingBottom();
        r15 = r1 + r2;
        r1 = r19.getPaddingLeft();
        r2 = r19.getPaddingRight();
        r10 = r3 - r15;
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r4);
        r1 = r14 - r1;
        r5 = r1 - r2;
        r4 = r5 / 2;
        r0 = r19;
        r1 = r0.f837g;
        if (r1 == 0) goto L_0x0278;
    L_0x00dd:
        r0 = r19;
        r1 = r0.f847q;
    L_0x00e1:
        r2 = r1.getVisibility();
        r7 = 8;
        if (r2 == r7) goto L_0x03ab;
    L_0x00e9:
        r2 = r1.getLayoutParams();
        r7 = r2.width;
        if (r7 >= 0) goto L_0x027e;
    L_0x00f1:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2);
    L_0x00f7:
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r7);
        r1.measure(r2, r7);
        r2 = r1.getMeasuredWidth();
        r1 = r1.m1475a();
        r1 = r1 + r2;
        r2 = 0;
        r5 = r5 - r1;
        r2 = java.lang.Math.max(r2, r5);
        r5 = 0;
        r1 = r2 - r1;
        r1 = java.lang.Math.max(r5, r1);
    L_0x0116:
        r0 = r19;
        r5 = r0.a;
        if (r5 == 0) goto L_0x0141;
    L_0x011c:
        r0 = r19;
        r5 = r0.a;
        r5 = r5.getParent();
        r0 = r19;
        if (r5 != r0) goto L_0x0141;
    L_0x0128:
        r0 = r19;
        r5 = r0.a;
        r7 = 0;
        r0 = r19;
        r2 = r0.m1455a(r5, r2, r6, r7);
        r5 = 0;
        r0 = r19;
        r7 = r0.a;
        r7 = r7.getMeasuredWidth();
        r4 = r4 - r7;
        r4 = java.lang.Math.max(r5, r4);
    L_0x0141:
        r0 = r19;
        r5 = r0.f816A;
        if (r5 == 0) goto L_0x016c;
    L_0x0147:
        r0 = r19;
        r5 = r0.f816A;
        r5 = r5.getVisibility();
        r7 = 8;
        if (r5 == r7) goto L_0x016c;
    L_0x0153:
        r0 = r19;
        r5 = r0.f816A;
        r7 = 0;
        r0 = r19;
        r2 = r0.m1455a(r5, r2, r6, r7);
        r5 = 0;
        r0 = r19;
        r6 = r0.f816A;
        r6 = r6.getMeasuredWidth();
        r4 = r4 - r6;
        r4 = java.lang.Math.max(r5, r4);
    L_0x016c:
        r0 = r19;
        r5 = r0.f848r;
        if (r5 == 0) goto L_0x0288;
    L_0x0172:
        r0 = r19;
        r5 = r0.f848r;
        r5 = r5.getVisibility();
        r6 = 8;
        if (r5 == r6) goto L_0x0288;
    L_0x017e:
        r0 = r19;
        r5 = r0.f840j;
        r5 = r5 & 8;
        if (r5 == 0) goto L_0x0288;
    L_0x0186:
        r5 = 1;
    L_0x0187:
        r0 = r19;
        r6 = r0.f837g;
        if (r6 != 0) goto L_0x0194;
    L_0x018d:
        r0 = r19;
        r6 = r0.f839i;
        switch(r6) {
            case 1: goto L_0x028b;
            case 2: goto L_0x02d5;
            default: goto L_0x0194;
        };
    L_0x0194:
        r6 = r1;
        r7 = r2;
    L_0x0196:
        r1 = 0;
        r0 = r19;
        r2 = r0.f837g;
        if (r2 == 0) goto L_0x031f;
    L_0x019d:
        r0 = r19;
        r1 = r0.f837g;
        r12 = r1;
    L_0x01a2:
        if (r12 == 0) goto L_0x022a;
    L_0x01a4:
        r1 = r12.getLayoutParams();
        r0 = r19;
        r2 = r0.generateLayoutParams(r1);
        r1 = r2 instanceof android.support.v7.p006a.C0128c;
        if (r1 == 0) goto L_0x0334;
    L_0x01b2:
        r1 = r2;
        r1 = (android.support.v7.p006a.C0128c) r1;
        r11 = r1;
    L_0x01b6:
        r8 = 0;
        r1 = 0;
        if (r11 == 0) goto L_0x01c4;
    L_0x01ba:
        r1 = r11.leftMargin;
        r8 = r11.rightMargin;
        r8 = r8 + r1;
        r1 = r11.topMargin;
        r9 = r11.bottomMargin;
        r1 = r1 + r9;
    L_0x01c4:
        r0 = r19;
        r9 = r0.f;
        if (r9 > 0) goto L_0x0338;
    L_0x01ca:
        r9 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x01cc:
        r16 = 0;
        r0 = r2.height;
        r17 = r0;
        if (r17 < 0) goto L_0x01de;
    L_0x01d4:
        r0 = r2.height;
        r17 = r0;
        r0 = r17;
        r10 = java.lang.Math.min(r0, r10);
    L_0x01de:
        r1 = r10 - r1;
        r0 = r16;
        r16 = java.lang.Math.max(r0, r1);
        r1 = r2.width;
        r10 = -2;
        if (r1 == r10) goto L_0x0348;
    L_0x01eb:
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x01ed:
        r17 = 0;
        r10 = r2.width;
        if (r10 < 0) goto L_0x034c;
    L_0x01f3:
        r10 = r2.width;
        r10 = java.lang.Math.min(r10, r7);
    L_0x01f9:
        r10 = r10 - r8;
        r0 = r17;
        r10 = java.lang.Math.max(r0, r10);
        if (r11 == 0) goto L_0x034f;
    L_0x0202:
        r11 = r11.f448a;
    L_0x0204:
        r11 = r11 & 7;
        r17 = 1;
        r0 = r17;
        if (r11 != r0) goto L_0x03a5;
    L_0x020c:
        r2 = r2.width;
        r11 = -1;
        if (r2 != r11) goto L_0x03a5;
    L_0x0211:
        r2 = java.lang.Math.min(r6, r4);
        r2 = r2 * 2;
    L_0x0217:
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1);
        r0 = r16;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9);
        r12.measure(r1, r2);
        r1 = r12.getMeasuredWidth();
        r1 = r1 + r8;
        r7 = r7 - r1;
    L_0x022a:
        r0 = r19;
        r1 = r0.f837g;
        if (r1 != 0) goto L_0x0254;
    L_0x0230:
        if (r5 == 0) goto L_0x0254;
    L_0x0232:
        r0 = r19;
        r1 = r0.f848r;
        r0 = r19;
        r2 = r0.f;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4);
        r4 = 0;
        r0 = r19;
        r0.m1455a(r1, r7, r2, r4);
        r1 = 0;
        r0 = r19;
        r2 = r0.f848r;
        r2 = r2.getMeasuredWidth();
        r2 = r6 - r2;
        java.lang.Math.max(r1, r2);
    L_0x0254:
        r0 = r19;
        r1 = r0.f;
        if (r1 > 0) goto L_0x039c;
    L_0x025a:
        r2 = 0;
        r1 = 0;
        r3 = r1;
    L_0x025d:
        if (r3 >= r13) goto L_0x0353;
    L_0x025f:
        r0 = r19;
        r1 = r0.getChildAt(r3);
        r1 = r1.getMeasuredHeight();
        r1 = r1 + r15;
        if (r1 <= r2) goto L_0x03a2;
    L_0x026c:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r1;
        goto L_0x025d;
    L_0x0271:
        r1 = android.view.View.MeasureSpec.getSize(r21);
        r3 = r1;
        goto L_0x00b7;
    L_0x0278:
        r0 = r19;
        r1 = r0.f846p;
        goto L_0x00e1;
    L_0x027e:
        r2 = r2.width;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r7);
        goto L_0x00f7;
    L_0x0288:
        r5 = 0;
        goto L_0x0187;
    L_0x028b:
        r0 = r19;
        r6 = r0.f853w;
        if (r6 == 0) goto L_0x0194;
    L_0x0291:
        if (r5 == 0) goto L_0x02d0;
    L_0x0293:
        r0 = r19;
        r6 = r0.f818C;
        r6 = r6 * 2;
    L_0x0299:
        r7 = 0;
        r2 = r2 - r6;
        r2 = java.lang.Math.max(r7, r2);
        r7 = 0;
        r1 = r1 - r6;
        r1 = java.lang.Math.max(r7, r1);
        r0 = r19;
        r6 = r0.f853w;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r7);
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8);
        r6.measure(r7, r8);
        r0 = r19;
        r6 = r0.f853w;
        r6 = r6.getMeasuredWidth();
        r7 = 0;
        r2 = r2 - r6;
        r2 = java.lang.Math.max(r7, r2);
        r7 = 0;
        r1 = r1 - r6;
        r1 = java.lang.Math.max(r7, r1);
        r6 = r1;
        r7 = r2;
        goto L_0x0196;
    L_0x02d0:
        r0 = r19;
        r6 = r0.f818C;
        goto L_0x0299;
    L_0x02d5:
        r0 = r19;
        r6 = r0.f854x;
        if (r6 == 0) goto L_0x0194;
    L_0x02db:
        if (r5 == 0) goto L_0x031a;
    L_0x02dd:
        r0 = r19;
        r6 = r0.f818C;
        r6 = r6 * 2;
    L_0x02e3:
        r7 = 0;
        r2 = r2 - r6;
        r2 = java.lang.Math.max(r7, r2);
        r7 = 0;
        r1 = r1 - r6;
        r1 = java.lang.Math.max(r7, r1);
        r0 = r19;
        r6 = r0.f854x;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r7);
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8);
        r6.measure(r7, r8);
        r0 = r19;
        r6 = r0.f854x;
        r6 = r6.getMeasuredWidth();
        r7 = 0;
        r2 = r2 - r6;
        r2 = java.lang.Math.max(r7, r2);
        r7 = 0;
        r1 = r1 - r6;
        r1 = java.lang.Math.max(r7, r1);
        r6 = r1;
        r7 = r2;
        goto L_0x0196;
    L_0x031a:
        r0 = r19;
        r6 = r0.f818C;
        goto L_0x02e3;
    L_0x031f:
        r0 = r19;
        r2 = r0.f840j;
        r2 = r2 & 16;
        if (r2 == 0) goto L_0x03a8;
    L_0x0327:
        r0 = r19;
        r2 = r0.f855y;
        if (r2 == 0) goto L_0x03a8;
    L_0x032d:
        r0 = r19;
        r1 = r0.f855y;
        r12 = r1;
        goto L_0x01a2;
    L_0x0334:
        r1 = 0;
        r11 = r1;
        goto L_0x01b6;
    L_0x0338:
        r9 = r2.height;
        r16 = -2;
        r0 = r16;
        if (r9 == r0) goto L_0x0344;
    L_0x0340:
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x01cc;
    L_0x0344:
        r9 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        goto L_0x01cc;
    L_0x0348:
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        goto L_0x01ed;
    L_0x034c:
        r10 = r7;
        goto L_0x01f9;
    L_0x034f:
        r11 = 19;
        goto L_0x0204;
    L_0x0353:
        r0 = r19;
        r0.setMeasuredDimension(r14, r2);
    L_0x0358:
        r0 = r19;
        r1 = r0.f828M;
        if (r1 == 0) goto L_0x0369;
    L_0x035e:
        r0 = r19;
        r1 = r0.f828M;
        r2 = r19.getMeasuredHeight();
        r1.setContentHeight(r2);
    L_0x0369:
        r0 = r19;
        r1 = r0.f856z;
        if (r1 == 0) goto L_0x0044;
    L_0x036f:
        r0 = r19;
        r1 = r0.f856z;
        r1 = r1.getVisibility();
        r2 = 8;
        if (r1 == r2) goto L_0x0044;
    L_0x037b:
        r0 = r19;
        r1 = r0.f856z;
        r0 = r19;
        r2 = r0.f817B;
        r2 = r2 * 2;
        r2 = r14 - r2;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r3);
        r3 = r19.getMeasuredHeight();
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r4);
        r1.measure(r2, r3);
        goto L_0x0044;
    L_0x039c:
        r0 = r19;
        r0.setMeasuredDimension(r14, r3);
        goto L_0x0358;
    L_0x03a2:
        r1 = r2;
        goto L_0x026c;
    L_0x03a5:
        r2 = r10;
        goto L_0x0217;
    L_0x03a8:
        r12 = r1;
        goto L_0x01a2;
    L_0x03ab:
        r1 = r4;
        r2 = r5;
        goto L_0x0116;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.ActionBarView.onMeasure(int, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
        r9 = this;
        r1 = r9.getPaddingLeft();
        r2 = r9.getPaddingTop();
        r0 = r14 - r12;
        r3 = r9.getPaddingTop();
        r0 = r0 - r3;
        r3 = r9.getPaddingBottom();
        r3 = r0 - r3;
        if (r3 > 0) goto L_0x0018;
    L_0x0017:
        return;
    L_0x0018:
        r0 = r9.f837g;
        if (r0 == 0) goto L_0x011a;
    L_0x001c:
        r0 = r9.f847q;
    L_0x001e:
        r4 = r0.getVisibility();
        r5 = 8;
        if (r4 == r5) goto L_0x01c5;
    L_0x0026:
        r4 = r0.m1475a();
        r5 = r1 + r4;
        r0 = r9.m1458b(r0, r5, r2, r3);
        r0 = r0 + r4;
        r0 = r0 + r1;
    L_0x0032:
        r1 = r9.f837g;
        if (r1 != 0) goto L_0x0059;
    L_0x0036:
        r1 = r9.f848r;
        if (r1 == 0) goto L_0x011e;
    L_0x003a:
        r1 = r9.f848r;
        r1 = r1.getVisibility();
        r4 = 8;
        if (r1 == r4) goto L_0x011e;
    L_0x0044:
        r1 = r9.f840j;
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x011e;
    L_0x004a:
        r1 = 1;
    L_0x004b:
        if (r1 == 0) goto L_0x0054;
    L_0x004d:
        r4 = r9.f848r;
        r4 = r9.m1458b(r4, r0, r2, r3);
        r0 = r0 + r4;
    L_0x0054:
        r4 = r9.f839i;
        switch(r4) {
            case 0: goto L_0x0121;
            case 1: goto L_0x0124;
            case 2: goto L_0x013a;
            default: goto L_0x0059;
        };
    L_0x0059:
        r1 = r0;
    L_0x005a:
        r0 = r13 - r11;
        r4 = r9.getPaddingRight();
        r0 = r0 - r4;
        r4 = r9.a;
        if (r4 == 0) goto L_0x0079;
    L_0x0065:
        r4 = r9.a;
        r4 = r4.getParent();
        if (r4 != r9) goto L_0x0079;
    L_0x006d:
        r4 = r9.a;
        r9.m1460c(r4, r0, r2, r3);
        r4 = r9.a;
        r4 = r4.getMeasuredWidth();
        r0 = r0 - r4;
    L_0x0079:
        r4 = r9.f816A;
        if (r4 == 0) goto L_0x01c2;
    L_0x007d:
        r4 = r9.f816A;
        r4 = r4.getVisibility();
        r5 = 8;
        if (r4 == r5) goto L_0x01c2;
    L_0x0087:
        r4 = r9.f816A;
        r9.m1460c(r4, r0, r2, r3);
        r2 = r9.f816A;
        r2 = r2.getMeasuredWidth();
        r0 = r0 - r2;
        r2 = r0;
    L_0x0094:
        r0 = 0;
        r3 = r9.f837g;
        if (r3 == 0) goto L_0x0150;
    L_0x0099:
        r0 = r9.f837g;
        r7 = r0;
    L_0x009c:
        if (r7 == 0) goto L_0x00f6;
    L_0x009e:
        r0 = r7.getLayoutParams();
        r3 = r0 instanceof android.support.v7.p006a.C0128c;
        if (r3 == 0) goto L_0x015f;
    L_0x00a6:
        r0 = (android.support.v7.p006a.C0128c) r0;
        r5 = r0;
    L_0x00a9:
        if (r5 == 0) goto L_0x0163;
    L_0x00ab:
        r0 = r5.f448a;
    L_0x00ad:
        r8 = r7.getMeasuredWidth();
        r4 = 0;
        r3 = 0;
        if (r5 == 0) goto L_0x01b9;
    L_0x00b5:
        r3 = r5.leftMargin;
        r4 = r1 + r3;
        r1 = r5.rightMargin;
        r3 = r2 - r1;
        r2 = r5.topMargin;
        r1 = r5.bottomMargin;
        r5 = r2;
        r6 = r3;
        r3 = r4;
        r4 = r1;
    L_0x00c5:
        r1 = r0 & 7;
        r2 = 1;
        if (r1 != r2) goto L_0x016d;
    L_0x00ca:
        r2 = r9.getWidth();
        r2 = r2 - r8;
        r2 = r2 / 2;
        if (r2 >= r3) goto L_0x0167;
    L_0x00d3:
        r1 = 3;
    L_0x00d4:
        r2 = r1;
    L_0x00d5:
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x0174;
            case 2: goto L_0x00d9;
            case 3: goto L_0x017e;
            case 4: goto L_0x00d9;
            case 5: goto L_0x0181;
            default: goto L_0x00d9;
        };
    L_0x00d9:
        r2 = r1;
    L_0x00da:
        r1 = r0 & 112;
        r6 = -1;
        if (r0 != r6) goto L_0x00e2;
    L_0x00df:
        r0 = 16;
        r1 = r0;
    L_0x00e2:
        r0 = 0;
        switch(r1) {
            case 16: goto L_0x0186;
            case 48: goto L_0x019e;
            case 80: goto L_0x01a5;
            default: goto L_0x00e6;
        };
    L_0x00e6:
        r1 = r7.getMeasuredWidth();
        r4 = r2 + r1;
        r5 = r7.getMeasuredHeight();
        r5 = r5 + r0;
        r7.layout(r2, r0, r4, r5);
        r0 = r3 + r1;
    L_0x00f6:
        r0 = r9.f856z;
        if (r0 == 0) goto L_0x0017;
    L_0x00fa:
        r0 = r9.f856z;
        r0.bringToFront();
        r0 = r9.f856z;
        r0 = r0.getMeasuredHeight();
        r0 = r0 / 2;
        r1 = r9.f856z;
        r2 = r9.f817B;
        r3 = -r0;
        r4 = r9.f817B;
        r5 = r9.f856z;
        r5 = r5.getMeasuredWidth();
        r4 = r4 + r5;
        r1.layout(r2, r3, r4, r0);
        goto L_0x0017;
    L_0x011a:
        r0 = r9.f846p;
        goto L_0x001e;
    L_0x011e:
        r1 = 0;
        goto L_0x004b;
    L_0x0121:
        r1 = r0;
        goto L_0x005a;
    L_0x0124:
        r4 = r9.f853w;
        if (r4 == 0) goto L_0x0059;
    L_0x0128:
        if (r1 == 0) goto L_0x012d;
    L_0x012a:
        r1 = r9.f818C;
        r0 = r0 + r1;
    L_0x012d:
        r1 = r9.f853w;
        r1 = r9.m1458b(r1, r0, r2, r3);
        r4 = r9.f818C;
        r1 = r1 + r4;
        r0 = r0 + r1;
        r1 = r0;
        goto L_0x005a;
    L_0x013a:
        r4 = r9.f854x;
        if (r4 == 0) goto L_0x0059;
    L_0x013e:
        if (r1 == 0) goto L_0x0143;
    L_0x0140:
        r1 = r9.f818C;
        r0 = r0 + r1;
    L_0x0143:
        r1 = r9.f854x;
        r1 = r9.m1458b(r1, r0, r2, r3);
        r4 = r9.f818C;
        r1 = r1 + r4;
        r0 = r0 + r1;
        r1 = r0;
        goto L_0x005a;
    L_0x0150:
        r3 = r9.f840j;
        r3 = r3 & 16;
        if (r3 == 0) goto L_0x01bf;
    L_0x0156:
        r3 = r9.f855y;
        if (r3 == 0) goto L_0x01bf;
    L_0x015a:
        r0 = r9.f855y;
        r7 = r0;
        goto L_0x009c;
    L_0x015f:
        r0 = 0;
        r5 = r0;
        goto L_0x00a9;
    L_0x0163:
        r0 = 19;
        goto L_0x00ad;
    L_0x0167:
        r2 = r2 + r8;
        if (r2 <= r6) goto L_0x00d4;
    L_0x016a:
        r1 = 5;
        goto L_0x00d4;
    L_0x016d:
        r2 = -1;
        if (r0 != r2) goto L_0x01b6;
    L_0x0170:
        r1 = 3;
        r2 = r1;
        goto L_0x00d5;
    L_0x0174:
        r1 = r9.getWidth();
        r1 = r1 - r8;
        r1 = r1 / 2;
        r2 = r1;
        goto L_0x00da;
    L_0x017e:
        r2 = r3;
        goto L_0x00da;
    L_0x0181:
        r1 = r6 - r8;
        r2 = r1;
        goto L_0x00da;
    L_0x0186:
        r0 = r9.getPaddingTop();
        r1 = r9.getHeight();
        r4 = r9.getPaddingBottom();
        r1 = r1 - r4;
        r0 = r1 - r0;
        r1 = r7.getMeasuredHeight();
        r0 = r0 - r1;
        r0 = r0 / 2;
        goto L_0x00e6;
    L_0x019e:
        r0 = r9.getPaddingTop();
        r0 = r0 + r5;
        goto L_0x00e6;
    L_0x01a5:
        r0 = r9.getHeight();
        r1 = r9.getPaddingBottom();
        r0 = r0 - r1;
        r1 = r7.getMeasuredHeight();
        r0 = r0 - r1;
        r0 = r0 - r4;
        goto L_0x00e6;
    L_0x01b6:
        r2 = r1;
        goto L_0x00d5;
    L_0x01b9:
        r5 = r4;
        r6 = r2;
        r4 = r3;
        r3 = r1;
        goto L_0x00c5;
    L_0x01bf:
        r7 = r0;
        goto L_0x009c;
    L_0x01c2:
        r2 = r0;
        goto L_0x0094;
    L_0x01c5:
        r0 = r1;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.ActionBarView.onLayout(boolean, int, int, int, int):void");
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0128c(getContext(), attributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        return layoutParams;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f833R == null || this.f833R.f963b == null)) {
            savedState.f814a = this.f833R.f963b.getItemId();
        }
        savedState.f815b = mo249d();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.f814a == 0 || this.f833R == null || this.f827L == null)) {
            C0041b c0041b = (C0041b) this.f827L.findItem(savedState.f814a);
            if (c0041b != null) {
                c0041b.expandActionView();
            }
        }
        if (savedState.f815b) {
            mo247b();
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f846p.m1479b(drawable);
    }

    public void setHomeAsUpIndicator(int i) {
        this.f846p.m1476a(i);
    }
}
