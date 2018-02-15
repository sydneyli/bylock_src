package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewAnimator;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.ai;
import net.client.by.lock.gui.p018b.ak;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0346m;
import net.client.by.lock.p012d.C0348n;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
public class ReadOMailActivity extends C0392q {
    private View f1684A;
    private ViewAnimator f1685B;
    private C0337c f1686o;
    private C0348n f1687p;
    private TextView f1688r;
    private TextView f1689s;
    private ListView f1690t;
    private ListView f1691u;
    private ai f1692v;
    private ak f1693w;
    private Button f1694x;
    private Button f1695y;
    private Button f1696z;

    protected void onCreate(Bundle bundle) {
        int i;
        String string;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_omail_read);
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
        this.f1686o = C0327e.m2092c().m2094a(Integer.valueOf(i));
        C0346m g = this.f1686o.m2270g(string);
        if (g == null || !(g instanceof C0348n)) {
            finish();
        } else {
            this.f1687p = (C0348n) g;
        }
        this.f1688r = (TextView) findViewById(R.id.mail_body);
        this.f1691u = (ListView) findViewById(R.id.mail_to);
        this.f1689s = (TextView) findViewById(R.id.mail_subject);
        this.f1690t = (ListView) findViewById(R.id.attachments);
        this.f1694x = (Button) findViewById(R.id.button1);
        this.f1695y = (Button) findViewById(R.id.button2);
        this.f1696z = (Button) findViewById(R.id.button3);
        this.f1685B = (ViewAnimator) findViewById(R.id.viewAnimator1);
        this.f1684A = findViewById(R.id.linearLayout3);
        this.f1692v = new ai(this);
        this.f1690t.setAdapter(this.f1692v);
        this.f1693w = new ak(this);
        this.f1691u.setAdapter(this.f1693w);
        this.f1689s.setText(this.f1687p.m2319h());
        this.f1688r.setText(Html.fromHtml(this.f1687p.m2318g()));
        this.f1692v.m2725a(this.f1687p.m2324m());
        this.f1693w.m2726a(this.f1687p.m2337b());
        m1020f().mo192a((CharSequence) "");
        m1020f().mo197c(true);
        this.f1694x.setOnClickListener(new bh(this));
        this.f1695y.setOnClickListener(new bi(this));
        this.f1696z.setOnClickListener(new bj(this));
        m2620b(0);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_mail_read, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                setResult(0);
                finish();
                return true;
            case R.id.menu_forward_mail:
                if (this.f1687p.m2318g() != null) {
                    Intent intent = new Intent();
                    intent.putExtra("forward", true);
                    intent.putExtra("id", this.f1686o.m2237K());
                    intent.putExtra("mailId", this.f1687p.m2321j());
                    setResult(-1, intent);
                    finish();
                    return false;
                }
                an.m2730b(this, "Body has not loaded yet.");
                return true;
            case R.id.menu_delete_mail:
                this.f1686o.m2251a(this.f1687p);
                C0332j.m2148a().m2185f(this.f1687p.m2321j());
                finish();
                return false;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("id", this.f1686o.m2237K());
        bundle.putString("mailId", this.f1687p.m2321j());
    }

    public void m2620b(int i) {
        int color = getResources().getColor(R.color.aaa_blue_button_background);
        int color2 = getResources().getColor(R.color.White);
        int color3 = getResources().getColor(R.color.aaa_blue_text_over_white_button);
        this.f1685B.setDisplayedChild(i);
        switch (i) {
            case 0:
                this.f1694x.setBackgroundColor(color);
                this.f1695y.setBackgroundColor(color2);
                this.f1696z.setBackgroundColor(color2);
                this.f1694x.setTextColor(color2);
                this.f1695y.setTextColor(color3);
                this.f1696z.setTextColor(color3);
                this.f1694x.setEnabled(false);
                this.f1695y.setEnabled(true);
                this.f1696z.setEnabled(true);
                break;
            case 1:
                this.f1694x.setBackgroundColor(color2);
                this.f1695y.setBackgroundColor(color);
                this.f1696z.setBackgroundColor(color2);
                this.f1694x.setTextColor(color3);
                this.f1695y.setTextColor(color2);
                this.f1696z.setTextColor(color3);
                this.f1694x.setEnabled(true);
                this.f1695y.setEnabled(false);
                this.f1696z.setEnabled(true);
                break;
            case 2:
                this.f1694x.setBackgroundColor(color2);
                this.f1695y.setBackgroundColor(color2);
                this.f1696z.setBackgroundColor(color);
                this.f1694x.setTextColor(color3);
                this.f1695y.setTextColor(color3);
                this.f1696z.setTextColor(color2);
                this.f1694x.setEnabled(true);
                this.f1695y.setEnabled(true);
                this.f1696z.setEnabled(false);
                break;
            default:
                throw new UnsupportedOperationException("Unknown type");
        }
        if (this.f1693w.getCount() == 0) {
            this.f1696z.setVisibility(8);
        } else {
            this.f1696z.setVisibility(0);
        }
        if (this.f1692v.getCount() == 0) {
            this.f1695y.setVisibility(8);
        } else {
            this.f1695y.setVisibility(0);
        }
        if (this.f1693w.getCount() == 0 && this.f1692v.getCount() == 0) {
            this.f1684A.setVisibility(8);
        } else {
            this.f1684A.setVisibility(0);
        }
    }
}
