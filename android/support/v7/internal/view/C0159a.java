package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0150d;
import android.support.v7.p008b.C0151e;
import android.support.v7.p008b.C0153g;
import android.support.v7.p008b.C0157k;

/* compiled from: MyApp */
public class C0159a {
    private Context f509a;

    public static C0159a m1162a(Context context) {
        return new C0159a(context);
    }

    private C0159a(Context context) {
        this.f509a = context;
    }

    public int m1163a() {
        return this.f509a.getResources().getInteger(C0153g.abc_max_action_buttons);
    }

    public boolean m1164b() {
        return VERSION.SDK_INT >= 11;
    }

    public int m1165c() {
        return this.f509a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m1166d() {
        return this.f509a.getResources().getBoolean(C0150d.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m1167e() {
        TypedArray obtainStyledAttributes = this.f509a.obtainStyledAttributes(null, C0157k.ActionBar, C0149c.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(1, 0);
        Resources resources = this.f509a.getResources();
        if (!m1166d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0151e.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m1168f() {
        return this.f509a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m1169g() {
        return this.f509a.getResources().getDimensionPixelSize(C0151e.abc_action_bar_stacked_tab_max_width);
    }
}
