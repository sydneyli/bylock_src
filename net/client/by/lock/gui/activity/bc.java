package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
class bc implements OnClickListener {
    private int f1776a;

    public bc(int i) {
        this.f1776a = i;
    }

    public void onClick(View view) {
        switch (this.f1776a) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                int i = (this.f1776a + 1) % 10;
                PinActivity.f1658g = PinActivity.f1658g + i;
                PinActivity.f1657f.append(new StringBuilder(String.valueOf(i)).toString());
                if (PinActivity.f1658g.length() == 1) {
                    PinActivity.f1657f.setError(null);
                }
                if (PinActivity.f1658g.length() == 4) {
                    if (C0331i.m2124a().m2144g().equals(PinActivity.f1658g)) {
                        C0391a.f1606b.set(false);
                        PinActivity.f1659h.finish();
                    } else {
                        PinActivity.f1657f.setError("Wrong Pin");
                    }
                    PinActivity.f1657f.setText("");
                    PinActivity.f1658g = "";
                    return;
                }
                return;
            case 10:
                if (PinActivity.f1658g.length() > 0) {
                    PinActivity.f1658g = PinActivity.f1658g.substring(0, PinActivity.f1658g.length() - 1);
                    PinActivity.f1657f.setText(PinActivity.f1658g);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
