package net.client.by.lock.gui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0327e;

/* compiled from: MyApp */
public class ValidateActivity extends C0391a implements Observer {
    private C0337c f1711e;
    private Button f1712f;
    private TextView f1713g;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_validate);
        this.f1711e = C0327e.m2092c().m2094a(Integer.valueOf(getIntent().getExtras().getInt("id")));
        if (this.f1711e == null) {
            finish();
            return;
        }
        ((TextView) findViewById(R.id.textView1)).setText(this.f1711e.m2229C());
        ((TextView) findViewById(R.id.textView2)).setText(this.f1711e.m2231E());
        ((TextView) findViewById(R.id.textView3)).setText(this.f1711e.m2230D());
        this.f1713g = (TextView) findViewById(R.id.textView4);
        this.f1713g.setText((CharSequence) this.f1711e.m2228B().m2467a());
        ((Button) findViewById(R.id.button1)).setOnClickListener(new bw(this));
        this.f1712f = (Button) findViewById(R.id.button2);
        this.f1712f.setOnClickListener(new bx(this));
    }

    public void onResume() {
        super.onResume();
        this.f1711e.m2288x().addObserver(this);
        m2636c();
    }

    public void onPause() {
        this.f1711e.m2288x().deleteObserver(this);
        super.onPause();
    }

    public void update(Observable observable, Object obj) {
        if (!(obj instanceof String)) {
            return;
        }
        if (((String) obj).equals("verificationStateProperty")) {
            m2636c();
        } else {
            C0322b.m2076e(this.d, "unknown update material#2");
        }
    }

    private void m2636c() {
        String str = (String) this.f1711e.m2288x().m2467a();
        if (str.equals("NK")) {
            this.f1712f.setVisibility(8);
            this.f1713g.setError(null);
        } else if (str.equals("KWCS")) {
            this.f1712f.setText(R.string.invalidate);
            this.f1712f.setVisibility(0);
            this.f1713g.setError(null);
        } else if (str.equals("KWIS")) {
            this.f1712f.setText(R.string.ignore);
            this.f1712f.setVisibility(0);
            this.f1713g.setError(getResources().getString(R.string.fake_sas));
        } else if (str.equals("KWOS")) {
            this.f1712f.setText(R.string.validate);
            this.f1712f.setVisibility(0);
            this.f1713g.setError(null);
        }
    }
}
