package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p008b.C0152f;
import android.support.v7.p008b.C0154h;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* compiled from: MyApp */
public class ListMenuItemView extends LinearLayout implements ai {
    private C0187u f603a;
    private ImageView f604b;
    private RadioButton f605c;
    private TextView f606d;
    private CheckBox f607e;
    private TextView f608f;
    private Drawable f609g;
    private int f610h;
    private Context f611i;
    private boolean f612j;
    private int f613k;
    private Context f614l;
    private LayoutInflater f615m;
    private boolean f616n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f614l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.MenuView, i, 0);
        this.f609g = obtainStyledAttributes.getDrawable(5);
        this.f610h = obtainStyledAttributes.getResourceId(1, -1);
        this.f612j = obtainStyledAttributes.getBoolean(7, false);
        this.f611i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f609g);
        this.f606d = (TextView) findViewById(C0152f.title);
        if (this.f610h != -1) {
            this.f606d.setTextAppearance(this.f611i, this.f610h);
        }
        this.f608f = (TextView) findViewById(C0152f.shortcut);
    }

    public void mo204a(C0187u c0187u, int i) {
        this.f603a = c0187u;
        this.f613k = i;
        setVisibility(c0187u.isVisible() ? 0 : 8);
        setTitle(c0187u.m1395a((ai) this));
        setCheckable(c0187u.isCheckable());
        m1271a(c0187u.m1408e(), c0187u.m1403c());
        setIcon(c0187u.getIcon());
        setEnabled(c0187u.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.f616n = z;
        this.f612j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f606d.setText(charSequence);
            if (this.f606d.getVisibility() != 0) {
                this.f606d.setVisibility(0);
            }
        } else if (this.f606d.getVisibility() != 8) {
            this.f606d.setVisibility(8);
        }
    }

    public C0187u getItemData() {
        return this.f603a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f605c != null || this.f607e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f603a.m1409f()) {
                if (this.f605c == null) {
                    m1268c();
                }
                compoundButton = this.f605c;
                compoundButton2 = this.f607e;
            } else {
                if (this.f607e == null) {
                    m1269d();
                }
                compoundButton = this.f607e;
                compoundButton2 = this.f605c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f603a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f607e != null) {
                this.f607e.setVisibility(8);
            }
            if (this.f605c != null) {
                this.f605c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f603a.m1409f()) {
            if (this.f605c == null) {
                m1268c();
            }
            compoundButton = this.f605c;
        } else {
            if (this.f607e == null) {
                m1269d();
            }
            compoundButton = this.f607e;
        }
        compoundButton.setChecked(z);
    }

    public void m1271a(boolean z, char c) {
        int i = (z && this.f603a.m1408e()) ? 0 : 8;
        if (i == 0) {
            this.f608f.setText(this.f603a.m1405d());
        }
        if (this.f608f.getVisibility() != i) {
            this.f608f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f603a.m1411h() || this.f616n) ? 1 : 0;
        if (i == 0 && !this.f612j) {
            return;
        }
        if (this.f604b != null || drawable != null || this.f612j) {
            if (this.f604b == null) {
                m1267b();
            }
            if (drawable != null || this.f612j) {
                ImageView imageView = this.f604b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f604b.getVisibility() != 0) {
                    this.f604b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f604b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f604b != null && this.f612j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f604b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m1267b() {
        this.f604b = (ImageView) getInflater().inflate(C0154h.abc_list_menu_item_icon, this, false);
        addView(this.f604b, 0);
    }

    private void m1268c() {
        this.f605c = (RadioButton) getInflater().inflate(C0154h.abc_list_menu_item_radio, this, false);
        addView(this.f605c);
    }

    private void m1269d() {
        this.f607e = (CheckBox) getInflater().inflate(C0154h.abc_list_menu_item_checkbox, this, false);
        addView(this.f607e);
    }

    public boolean mo205a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f615m == null) {
            this.f615m = LayoutInflater.from(this.f614l);
        }
        return this.f615m;
    }
}
