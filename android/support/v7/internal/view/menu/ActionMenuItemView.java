package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.C0165s;
import android.support.v7.p008b.C0150d;
import android.support.v7.p008b.C0157k;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

/* compiled from: MyApp */
public class ActionMenuItemView extends C0165s implements ai, C0166j, OnClickListener, OnLongClickListener {
    private C0187u f550a;
    private CharSequence f551b;
    private Drawable f552c;
    private C0168s f553d;
    private boolean f554e;
    private boolean f555f;
    private int f556g;
    private int f557h;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f554e = context.getResources().getBoolean(C0150d.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.ActionMenuItemView, 0, 0);
        this.f556g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        setOnClickListener(this);
        setOnLongClickListener(this);
        setTransformationMethod(new C0175b(this));
        this.f557h = -1;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f557h = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C0187u getItemData() {
        return this.f550a;
    }

    public void mo204a(C0187u c0187u, int i) {
        this.f550a = c0187u;
        setIcon(c0187u.getIcon());
        setTitle(c0187u.m1395a((ai) this));
        setId(c0187u.getItemId());
        setVisibility(c0187u.isVisible() ? 0 : 8);
        setEnabled(c0187u.isEnabled());
    }

    public void onClick(View view) {
        if (this.f553d != null) {
            this.f553d.mo223a(this.f550a);
        }
    }

    public void setItemInvoker(C0168s c0168s) {
        this.f553d = c0168s;
    }

    public boolean mo205a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f555f != z) {
            this.f555f = z;
            if (this.f550a != null) {
                this.f550a.m1410g();
            }
        }
    }

    private void m1195e() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f551b) ? 1 : 0;
        if (this.f552c == null || (this.f550a.m1415l() && (this.f554e || this.f555f))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f551b : null);
    }

    public void setIcon(Drawable drawable) {
        this.f552c = drawable;
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        m1195e();
    }

    public boolean m1198b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f551b = charSequence;
        setContentDescription(this.f551b);
        m1195e();
    }

    public boolean mo206c() {
        return m1198b() && this.f550a.getIcon() == null;
    }

    public boolean mo207d() {
        return m1198b();
    }

    public boolean onLongClick(View view) {
        if (m1198b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.f550a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(53, (i2 - iArr[0]) - (width / 2), height);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m1198b();
        if (b && this.f557h >= 0) {
            super.setPadding(this.f557h, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f556g) : this.f556g;
        if (mode != 1073741824 && this.f556g > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f552c != null) {
            super.setPadding((getMeasuredWidth() - this.f552c.getIntrinsicWidth()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
