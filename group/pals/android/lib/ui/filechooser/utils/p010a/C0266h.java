package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import group.pals.android.lib.ui.filechooser.ay;
import group.pals.android.lib.ui.filechooser.bc;

/* compiled from: MyApp */
public class C0266h extends BaseAdapter {
    private final Context f1214a;
    private final Integer[] f1215b;
    private final int f1216c = this.f1214a.getResources().getDimensionPixelSize(ay.afc_5dp);
    private final int f1217d = this.f1214a.getResources().getDimensionPixelSize(ay.afc_context_menu_item_padding_left);

    public C0266h(Context context, Integer[] numArr) {
        this.f1214a = context;
        this.f1215b = numArr;
    }

    public int getCount() {
        return this.f1215b.length;
    }

    public Object getItem(int i) {
        return this.f1215b[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = LayoutInflater.from(this.f1214a).inflate(bc.afc_context_menu_tiem, null);
        } else {
            inflate = view;
        }
        ((TextView) inflate).setText(this.f1215b[i].intValue());
        inflate.setPadding(this.f1217d, this.f1216c, this.f1216c, this.f1216c);
        return inflate;
    }
}
