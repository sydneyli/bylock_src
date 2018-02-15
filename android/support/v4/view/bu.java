package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p005a.C0051a;
import android.support.v4.view.p005a.C0067q;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: MyApp */
class bu extends C0074a {
    final /* synthetic */ ViewPager f331b;

    bu(ViewPager viewPager) {
        this.f331b = viewPager;
    }

    public void mo93d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo93d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        C0067q a = C0067q.m484a();
        a.m486a(m684b());
        if (accessibilityEvent.getEventType() == 4096 && this.f331b.f283h != null) {
            a.m485a(this.f331b.f283h.mo346b());
            a.m487b(this.f331b.f284i);
            a.m488c(this.f331b.f284i);
        }
    }

    public void mo91a(View view, C0051a c0051a) {
        super.mo91a(view, c0051a);
        c0051a.m367a(ViewPager.class.getName());
        c0051a.m368a(m684b());
        if (this.f331b.canScrollHorizontally(1)) {
            c0051a.m365a(4096);
        }
        if (this.f331b.canScrollHorizontally(-1)) {
            c0051a.m365a(8192);
        }
    }

    public boolean mo92a(View view, int i, Bundle bundle) {
        if (super.mo92a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.f331b.canScrollHorizontally(1)) {
                    return false;
                }
                this.f331b.setCurrentItem(this.f331b.f284i + 1);
                return true;
            case 8192:
                if (!this.f331b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f331b.setCurrentItem(this.f331b.f284i - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean m684b() {
        return this.f331b.f283h != null && this.f331b.f283h.mo346b() > 1;
    }
}
