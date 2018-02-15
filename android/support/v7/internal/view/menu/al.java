package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: MyApp */
public class al extends C0174q implements SubMenu {
    private C0174q f681d;
    private C0187u f682e;

    public al(Context context, C0174q c0174q, C0187u c0187u) {
        super(context);
        this.f681d = c0174q;
        this.f682e = c0187u;
    }

    public void setQwertyMode(boolean z) {
        this.f681d.setQwertyMode(z);
    }

    public boolean mo232a() {
        return this.f681d.mo232a();
    }

    public boolean mo234b() {
        return this.f681d.mo234b();
    }

    public Menu m1367r() {
        return this.f681d;
    }

    public MenuItem getItem() {
        return this.f682e;
    }

    public void mo231a(C0133r c0133r) {
        this.f681d.mo231a(c0133r);
    }

    public C0174q mo238o() {
        return this.f681d;
    }

    public boolean mo233a(C0174q c0174q, MenuItem menuItem) {
        return super.mo233a(c0174q, menuItem) || this.f681d.mo233a(c0174q, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f682e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f682e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m1324a(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m1324a(m1345d().getResources().getDrawable(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m1326a(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m1326a(m1345d().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m1325a(view);
        return this;
    }

    public void clearHeader() {
    }

    public boolean mo235c(C0187u c0187u) {
        return this.f681d.mo235c(c0187u);
    }

    public boolean mo237d(C0187u c0187u) {
        return this.f681d.mo237d(c0187u);
    }
}
