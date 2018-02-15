package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.p006a.C0126a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p012d.C0342s;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p016f.C0362g;

/* compiled from: MyApp */
public class SelectFriendsActivity extends C0392q {
    private ArrayList f1705o;
    private LinearLayout f1706p;
    private C0362g f1707r;
    private ArrayList f1708s;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_select_friends);
        this.f1706p = (LinearLayout) findViewById(R.id.linearLayout1);
        this.f1705o = new ArrayList();
        this.f1708s = new ArrayList();
        Collection integerArrayListExtra = getIntent().getIntegerArrayListExtra("mSelectedFriends");
        if (integerArrayListExtra != null) {
            this.f1708s.addAll(integerArrayListExtra);
        }
        this.f1707r = C0327e.m2092c().m2102b().m2306e();
        OnClickListener bsVar = new bs(this);
        OnClickListener btVar = new bt(this);
        for (int i = 0; i < this.f1707r.size(); i++) {
            C0342s c0342s = (C0342s) this.f1707r.get(i);
            CheckedTextView checkedTextView = (CheckedTextView) CheckedTextView.inflate(this, R.layout.item_select_group, null);
            CheckedTextView checkedTextView2 = (CheckedTextView) CheckedTextView.inflate(this, R.layout.item_select_friend, null);
            checkedTextView.setText((CharSequence) ((C0341g) c0342s.m2305d()).m2303b().m2467a());
            checkedTextView2.setText("Select All");
            checkedTextView2.setTag(c0342s);
            checkedTextView2.setOnClickListener(btVar);
            this.f1705o.add(checkedTextView);
            this.f1705o.add(checkedTextView2);
            for (int i2 = 0; i2 < c0342s.m2306e().size(); i2++) {
                C0337c c0337c = (C0337c) ((C0342s) c0342s.m2306e().get(i2)).m2305d();
                checkedTextView = (CheckedTextView) CheckedTextView.inflate(this, R.layout.item_select_friend, null);
                checkedTextView.setText(c0337c.m2233G());
                checkedTextView.setTag(c0337c);
                if (this.f1708s.contains(Integer.valueOf(c0337c.m2237K()))) {
                    checkedTextView.setChecked(true);
                }
                checkedTextView.setOnClickListener(bsVar);
                this.f1705o.add(checkedTextView);
            }
        }
        C0126a f = m1020f();
        f.mo196b(true);
        f.mo198d(true);
        f.mo197c(true);
        f.mo192a((CharSequence) "Select Friends");
        f.mo190a(17170445);
    }

    protected void m2632a(C0337c c0337c, boolean z) {
        if (!z) {
            this.f1708s.remove(Integer.valueOf(c0337c.m2237K()));
        } else if (!this.f1708s.contains(Integer.valueOf(c0337c.m2237K()))) {
            this.f1708s.add(Integer.valueOf(c0337c.m2237K()));
        }
        Iterator it = this.f1705o.iterator();
        while (it.hasNext()) {
            CheckedTextView checkedTextView = (CheckedTextView) it.next();
            Object tag = checkedTextView.getTag();
            if (tag != null && (tag instanceof C0337c) && c0337c.equals(tag)) {
                checkedTextView.setChecked(z);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        Iterator it = this.f1705o.iterator();
        while (it.hasNext()) {
            this.f1706p.addView((View) it.next());
        }
    }

    protected void onPause() {
        super.onPause();
        this.f1706p.removeAllViews();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_select_friends, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            case R.id.menu_done:
                Intent intent = new Intent();
                intent.putIntegerArrayListExtra("selected", this.f1708s);
                setResult(-1, intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
