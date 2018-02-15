package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.ai;
import net.client.by.lock.gui.p018b.am;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0346m;
import net.client.by.lock.p012d.C0347l;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
public class ReadIMailActivity extends C0392q {
    private View f1670A;
    private ViewAnimator f1671B;
    private am f1672C;
    public TextView f1673o;
    public TextView f1674p;
    public TextView f1675r;
    public ListView f1676s;
    public ListView f1677t;
    public ai f1678u;
    private C0337c f1679v;
    private C0346m f1680w;
    private Button f1681x;
    private Button f1682y;
    private Button f1683z;

    protected void onCreate(Bundle bundle) {
        int i;
        String string;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_imail_read);
        if (bundle != null) {
            i = bundle.getInt("id");
            string = bundle.getString("mailId");
        } else if (getIntent() != null) {
            i = getIntent().getExtras().getInt("id");
            string = getIntent().getExtras().getString("mailId");
        } else {
            finish();
            return;
        }
        this.f1679v = C0327e.m2092c().m2094a(Integer.valueOf(i));
        this.f1680w = this.f1679v.m2270g(string);
        if (this.f1680w == null) {
            finish();
        }
        this.f1673o = (TextView) findViewById(R.id.mail_body);
        this.f1674p = (TextView) findViewById(R.id.mail_from);
        this.f1675r = (TextView) findViewById(R.id.mail_subject);
        this.f1677t = (ListView) findViewById(R.id.mail_to);
        this.f1676s = (ListView) findViewById(R.id.attachments);
        this.f1681x = (Button) findViewById(R.id.button1);
        this.f1682y = (Button) findViewById(R.id.button2);
        this.f1683z = (Button) findViewById(R.id.button3);
        this.f1671B = (ViewAnimator) findViewById(R.id.viewAnimator1);
        this.f1670A = findViewById(R.id.linearLayout3);
        this.f1678u = new ai(this);
        this.f1672C = new am(this);
        this.f1676s.setAdapter(this.f1678u);
        this.f1677t.setAdapter(this.f1672C);
        this.f1674p.setText(this.f1680w.m1913E().m2233G());
        m2619h();
        ((TextView) findViewById(R.id.textView1)).setTypeface(null, 1);
        ((TextView) findViewById(R.id.textView2)).setTypeface(null, 1);
        this.f1675r.setText(this.f1680w.m2319h());
        if (((String) this.f1680w.m1914F().m2467a()).equals("COMPLETED")) {
            new bd(this).execute(new Void[0]);
            this.f1678u.m2725a(this.f1680w.m2324m());
        } else {
            ((C0347l) this.f1680w).m2330c();
        }
        m1020f().mo192a((CharSequence) "");
        m1020f().mo197c(true);
        this.f1681x.setOnClickListener(new be(this));
        this.f1682y.setOnClickListener(new bf(this));
        this.f1683z.setOnClickListener(new bg(this));
        m2618b(0);
    }

    public void m2619h() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1680w.m2326o().iterator();
        while (it.hasNext()) {
            C0337c a = C0327e.m2092c().m2094a(Integer.valueOf(((Integer) it.next()).intValue()));
            if (a != null) {
                arrayList.add(a.m2233G());
            }
        }
        if (arrayList.size() > 0) {
            m2618b(2);
            this.f1672C.m2727a(arrayList);
        }
    }

    protected void onStop() {
        finish();
        super.onStop();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_mail_read, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            case R.id.menu_forward_mail:
                if (this.f1680w.m2318g() != null) {
                    intent = new Intent();
                    intent.putExtra("forward", true);
                    intent.putExtra("id", this.f1679v.m2237K());
                    intent.putExtra("mailId", this.f1680w.m2321j());
                    setResult(-1, intent);
                    finish();
                    return false;
                }
                an.m2730b(this, "Body has not loaded yet.");
                return true;
            case R.id.menu_reply_mail:
                if (this.f1680w.m2318g() != null) {
                    intent = new Intent();
                    intent.putExtra("reply", true);
                    intent.putExtra("id", this.f1679v.m2237K());
                    intent.putExtra("mailId", this.f1680w.m2321j());
                    setResult(-1, intent);
                    finish();
                    return false;
                }
                an.m2730b(this, "Body has not loaded yet.");
                return true;
            case R.id.menu_delete_mail:
                this.f1679v.m2251a(this.f1680w);
                C0332j.m2148a().m2185f(this.f1680w.m2321j());
                finish();
                return false;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("id", this.f1679v.m2237K());
        bundle.putString("mailId", this.f1680w.m2321j());
    }

    public void m2618b(int i) {
        int color = getResources().getColor(R.color.aaa_blue_button_background);
        int color2 = getResources().getColor(R.color.White);
        int color3 = getResources().getColor(R.color.aaa_blue_text_over_white_button);
        this.f1671B.setDisplayedChild(i);
        switch (i) {
            case 0:
                this.f1681x.setBackgroundColor(color);
                this.f1682y.setBackgroundColor(color2);
                this.f1683z.setBackgroundColor(color2);
                this.f1681x.setTextColor(color2);
                this.f1682y.setTextColor(color3);
                this.f1683z.setTextColor(color3);
                this.f1681x.setEnabled(false);
                this.f1682y.setEnabled(true);
                this.f1683z.setEnabled(true);
                break;
            case 1:
                this.f1681x.setBackgroundColor(color2);
                this.f1682y.setBackgroundColor(color);
                this.f1683z.setBackgroundColor(color2);
                this.f1681x.setTextColor(color3);
                this.f1682y.setTextColor(color2);
                this.f1683z.setTextColor(color3);
                this.f1681x.setEnabled(true);
                this.f1682y.setEnabled(false);
                this.f1683z.setEnabled(true);
                break;
            case 2:
                this.f1681x.setBackgroundColor(color2);
                this.f1682y.setBackgroundColor(color2);
                this.f1683z.setBackgroundColor(color);
                this.f1681x.setTextColor(color3);
                this.f1682y.setTextColor(color3);
                this.f1683z.setTextColor(color2);
                this.f1681x.setEnabled(true);
                this.f1682y.setEnabled(true);
                this.f1683z.setEnabled(false);
                break;
            default:
                throw new UnsupportedOperationException("Unknown type");
        }
        if (this.f1672C.getCount() == 0) {
            this.f1683z.setVisibility(8);
        } else {
            this.f1683z.setVisibility(0);
        }
        if (this.f1678u.getCount() == 0) {
            this.f1682y.setVisibility(8);
        } else {
            this.f1682y.setVisibility(0);
        }
        if (this.f1672C.getCount() == 0 && this.f1678u.getCount() == 0) {
            this.f1670A.setVisibility(8);
        } else {
            this.f1670A.setVisibility(0);
        }
    }
}
