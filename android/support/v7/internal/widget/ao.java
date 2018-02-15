package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* compiled from: MyApp */
class ao extends C0194u implements aq {
    final /* synthetic */ ak f949b;
    private CharSequence f950c;
    private ListAdapter f951d;

    public ao(ak akVar, Context context, AttributeSet attributeSet, int i) {
        this.f949b = akVar;
        super(context, attributeSet, i);
        m1566a((View) akVar);
        m1570a(true);
        m1564a(0);
        m1567a(new C0208p(akVar, new ap(this, akVar)));
    }

    public void mo265a(ListAdapter listAdapter) {
        super.mo265a(listAdapter);
        this.f951d = listAdapter;
    }

    public void mo266a(CharSequence charSequence) {
        this.f950c = charSequence;
    }

    public void mo267c() {
        int paddingLeft = this.f949b.getPaddingLeft();
        if (this.f949b.f911E == -2) {
            int width = this.f949b.getWidth();
            m1578e(Math.max(this.f949b.m1541a((SpinnerAdapter) this.f951d, m1563a()), (width - paddingLeft) - this.f949b.getPaddingRight()));
        } else if (this.f949b.f911E == -1) {
            m1578e((this.f949b.getWidth() - paddingLeft) - this.f949b.getPaddingRight());
        } else {
            m1578e(this.f949b.f911E);
        }
        Drawable a = m1563a();
        int i = 0;
        if (a != null) {
            a.getPadding(this.f949b.f915I);
            i = -this.f949b.f915I.left;
        }
        m1572b(i + paddingLeft);
        m1579f(2);
        super.mo267c();
        m1583h().setChoiceMode(1);
        m1581g(this.f949b.m1435f());
    }
}
