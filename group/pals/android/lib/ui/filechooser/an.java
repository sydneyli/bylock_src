package group.pals.android.lib.ui.filechooser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import group.pals.android.lib.ui.filechooser.io.C0230a;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.p009a.C0223a;
import group.pals.android.lib.ui.filechooser.p009a.C0224b;
import group.pals.android.lib.ui.filechooser.services.C0254d;
import group.pals.android.lib.ui.filechooser.utils.C0272b;
import group.pals.android.lib.ui.filechooser.utils.C0273c;
import group.pals.android.lib.ui.filechooser.utils.C0276f;
import java.util.List;

/* compiled from: MyApp */
public class an extends BaseAdapter {
    public static final String f1109a = an.class.getName();
    private static /* synthetic */ int[] f1110j;
    private final Integer[] f1111b;
    private final C0254d f1112c;
    private final Context f1113d;
    private final C0224b f1114e;
    private List f1115f;
    private LayoutInflater f1116g;
    private boolean f1117h;
    private final OnLongClickListener f1118i = new ao(this);

    public /* synthetic */ Object getItem(int i) {
        return m1789a(i);
    }

    static /* synthetic */ int[] m1788c() {
        int[] iArr = f1110j;
        if (iArr == null) {
            iArr = new int[C0254d.values().length];
            try {
                iArr[C0254d.DirectoriesOnly.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0254d.FilesAndDirectories.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0254d.FilesOnly.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            f1110j = iArr;
        }
        return iArr;
    }

    public an(Context context, List list, C0254d c0254d, boolean z) {
        this.f1113d = context;
        this.f1115f = list;
        this.f1116g = LayoutInflater.from(this.f1113d);
        this.f1112c = c0254d;
        this.f1117h = z;
        switch (m1788c()[this.f1112c.ordinal()]) {
            case 1:
            case 2:
                this.f1111b = new Integer[]{Integer.valueOf(be.afc_cmd_advanced_selection_all), Integer.valueOf(be.afc_cmd_advanced_selection_none), Integer.valueOf(be.afc_cmd_advanced_selection_invert)};
                break;
            default:
                this.f1111b = new Integer[]{Integer.valueOf(be.afc_cmd_advanced_selection_all), Integer.valueOf(be.afc_cmd_advanced_selection_none), Integer.valueOf(be.afc_cmd_advanced_selection_invert), Integer.valueOf(be.afc_cmd_select_all_files), Integer.valueOf(be.afc_cmd_select_all_folders)};
                break;
        }
        this.f1114e = new C0224b(C0223a.m1764d(this.f1113d), C0223a.m1765e(this.f1113d));
    }

    public void notifyDataSetChanged() {
        m1790a();
        super.notifyDataSetChanged();
    }

    public void m1790a() {
        this.f1114e.m1768a(C0223a.m1764d(this.f1113d));
        this.f1114e.m1770b(C0223a.m1765e(this.f1113d));
    }

    public int getCount() {
        return this.f1115f != null ? this.f1115f.size() : 0;
    }

    public av m1789a(int i) {
        return this.f1115f != null ? (av) this.f1115f.get(i) : null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void m1791a(av avVar) {
        if (this.f1115f != null) {
            this.f1115f.add(avVar);
        }
    }

    public void m1795b(av avVar) {
        if (this.f1115f != null) {
            this.f1115f.remove(avVar);
        }
    }

    public void m1794b() {
        if (this.f1115f != null) {
            this.f1115f.clear();
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        au auVar;
        av a = m1789a(i);
        if (view == null) {
            inflate = this.f1116g.inflate(bc.afc_file_item, null);
            auVar = new au();
            auVar.f1133a = (ImageView) inflate.findViewById(ba.afc_file_item_imageview_icon);
            auVar.f1134b = (TextView) inflate.findViewById(ba.afc_file_item_textview_filename);
            auVar.f1135c = (TextView) inflate.findViewById(ba.afc_file_item_textview_file_info);
            auVar.f1136d = (CheckBox) inflate.findViewById(ba.afc_file_item_checkbox_selection);
            inflate.setTag(auVar);
        } else {
            auVar = (au) view.getTag();
            inflate = view;
        }
        m1786a(viewGroup, inflate, auVar, a, a.m1810a());
        return inflate;
    }

    private void m1786a(ViewGroup viewGroup, View view, au auVar, av avVar, IFile iFile) {
        auVar.f1134b.setSingleLine(viewGroup instanceof GridView);
        auVar.f1133a.setImageResource(C0276f.m1889a(iFile));
        auVar.f1134b.setText(iFile.getName());
        if (avVar.m1814c()) {
            auVar.f1134b.setPaintFlags(auVar.f1134b.getPaintFlags() | 16);
        } else {
            auVar.f1134b.setPaintFlags(auVar.f1134b.getPaintFlags() & -17);
        }
        CharSequence a = C0273c.m1884a(this.f1113d, iFile.lastModified(), this.f1114e);
        if (iFile.isDirectory()) {
            auVar.f1135c.setText(a);
        } else {
            auVar.f1135c.setText(String.format("%s, %s", new Object[]{C0272b.m1883a((double) iFile.length()), a}));
        }
        if (!this.f1117h) {
            auVar.f1136d.setVisibility(8);
        } else if (C0254d.FilesOnly.equals(this.f1112c) && iFile.isDirectory()) {
            auVar.f1136d.setVisibility(8);
        } else {
            auVar.f1136d.setVisibility(0);
            auVar.f1136d.setFocusable(false);
            auVar.f1136d.setOnCheckedChangeListener(new at(this, avVar));
            auVar.f1136d.setOnLongClickListener(this.f1118i);
            auVar.f1136d.setChecked(avVar.m1813b());
        }
    }

    public void m1793a(boolean z, C0230a c0230a) {
        for (int i = 0; i < getCount(); i++) {
            av a = m1789a(i);
            a.m1811a(c0230a == null ? true : c0230a.mo295a(a.m1810a()));
        }
        if (z) {
            notifyDataSetChanged();
        }
    }

    public void m1792a(boolean z) {
        for (int i = 0; i < getCount(); i++) {
            m1789a(i).m1811a(false);
        }
        if (z) {
            notifyDataSetChanged();
        }
    }

    public void m1796b(boolean z) {
        for (int i = 0; i < getCount(); i++) {
            av a = m1789a(i);
            a.m1811a(!a.m1813b());
        }
        if (z) {
            notifyDataSetChanged();
        }
    }
}
