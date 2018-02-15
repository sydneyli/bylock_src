package net.client.by.lock.gui.activity;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.C0307a;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.ac;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p012d.C0342s;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
public class am extends Fragment {
    public static ExpandableListView f1736P;
    private static ViewGroup f1737Q;
    private static ContextMenu f1738R;
    private int f1739S;

    public void mo348c(Bundle bundle) {
        ad.f1720b = m47b();
        super.mo348c(bundle);
        m51b(true);
        m2656a((LayoutInflater) ad.f1720b.getSystemService("layout_inflater"));
    }

    public void mo350j() {
        if (C0307a.f1342b != null) {
            int groupCount = C0307a.f1342b.getGroupCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < groupCount; i++) {
                if (f1736P.isGroupExpanded(i)) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (C0331i.m2125h()) {
                C0331i.m2124a().m2130a(arrayList);
                C0331i.m2124a().m2141f(m47b());
            }
        }
        super.mo350j();
    }

    public View mo347a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ad.f1720b = m47b();
        if (f1737Q == null) {
            m2656a(layoutInflater);
        } else if (f1737Q.getParent() != null && (f1737Q.getParent() instanceof ViewGroup)) {
            ((ViewGroup) f1737Q.getParent()).removeView(f1737Q);
        }
        return f1737Q;
    }

    public void mo352a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.action_home, menu);
        super.mo352a(menu, menuInflater);
    }

    public boolean mo353a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_settings:
                m35a(new Intent(ad.f1720b, SettingsActivity.class));
                return true;
            default:
                return super.mo353a(menuItem);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        MenuInflater menuInflater = m47b().getMenuInflater();
        long j = ((ExpandableListContextMenuInfo) contextMenuInfo).packedPosition;
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(j);
        if (ExpandableListView.getPackedPositionChild(j) == -1) {
            menuInflater.inflate(R.menu.activity_group, contextMenu);
            C0341g c0341g = (C0341g) ((C0342s) C0327e.m2092c().m2095a().m2306e().get(packedPositionGroup)).m2305d();
            f1738R = contextMenu.setHeaderTitle((CharSequence) c0341g.m2303b().m2467a());
            if (c0341g.m2301a() == 0) {
                f1738R.findItem(R.id.menu_delete_group).setVisible(false);
                f1738R.findItem(R.id.menu_rename_group).setVisible(false);
            }
        }
    }

    public boolean mo354b(MenuItem menuItem) {
        this.f1739S = ExpandableListView.getPackedPositionGroup(((ExpandableListContextMenuInfo) menuItem.getMenuInfo()).packedPosition);
        C0341g c0341g = (C0341g) ((C0342s) C0327e.m2092c().m2095a().m2306e().get(this.f1739S)).m2305d();
        switch (menuItem.getItemId()) {
            case R.id.menu_rename_group:
                m2657a(c0341g);
                break;
            case R.id.menu_delete_group:
                C0332j.m2148a().m2174c(Integer.valueOf(c0341g.m2301a()));
                break;
            default:
                return super.mo354b(menuItem);
        }
        return super.mo354b(menuItem);
    }

    private void m2656a(LayoutInflater layoutInflater) {
        f1737Q = (ViewGroup) layoutInflater.inflate(R.layout.fragment_friendlist, null);
        f1736P = (ExpandableListView) f1737Q.findViewById(R.id.listView1);
        C0307a.f1342b = new ac(ad.f1720b);
        f1736P.setAdapter(C0307a.f1342b);
        f1736P.setOnItemLongClickListener(new an(this));
        f1736P.setOnChildClickListener(new ao(this));
        m41a(f1736P);
        ArrayList c = C0331i.m2124a().m2135c();
        int groupCount = C0307a.f1342b.getGroupCount();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (groupCount > intValue) {
                f1736P.expandGroup(intValue);
            }
        }
    }

    private void m2657a(C0341g c0341g) {
        Builder builder = new Builder(m47b());
        View editText = new EditText(m47b());
        editText.setText((CharSequence) c0341g.m2303b().m2467a());
        editText.setInputType(1);
        builder.setView(editText).setPositiveButton(R.string.rename_group, new ap(this, c0341g, editText)).setNegativeButton(R.string.cancel, new aq(this)).show();
        editText.setSelection(0, editText.getText().length());
    }

    public void mo351l() {
        super.mo351l();
        f1736P = null;
        f1737Q = null;
        f1738R = null;
    }
}
