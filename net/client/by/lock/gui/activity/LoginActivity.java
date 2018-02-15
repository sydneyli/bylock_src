package net.client.by.lock.gui.activity;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.C0418b;
import net.client.by.lock.gui.p018b.C0440x;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class LoginActivity extends C0391a {
    public EditText f1640e;
    public Button f1641f;
    public Button f1642g;
    private String f1643h;
    private String f1644i;
    private EditText f1645j;
    private InputMethodManager f1646k;
    private Dialog f1647l;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C0351r.m2359i().m2399u() == null && C0351r.m2359i().m2395q()) {
            C0322b.m2076e(this.d, "Session.getInstance().loggedIn(): " + C0351r.m2359i().m2395q());
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(131072);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_login);
            C0351r.m2358a(true);
            C0331i.m2124a().m2127a((Context) this);
            C0330h.m2111a().m2113a(getApplicationContext());
            this.f1645j = (EditText) findViewById(R.id.username);
            this.f1640e = (EditText) findViewById(R.id.password);
            this.f1641f = (Button) findViewById(R.id.sign_in_button);
            this.f1642g = (Button) findViewById(R.id.register_button);
            this.f1646k = (InputMethodManager) getSystemService("input_method");
            this.f1645j.setText("");
            this.f1640e.setText("");
            this.f1640e.setOnEditorActionListener(new C0408r(this));
            this.f1641f.setOnClickListener(new C0409s(this));
            this.f1642g.setOnClickListener(new C0410t(this));
            View findViewById = findViewById(R.id.content);
            findViewById.setOnTouchListener(new C0411u(this, findViewById));
        }
        if (C0331i.m2124a().m2137d() == -1) {
            new C0440x(this).show();
        }
    }

    public void m2608c() {
        View view = null;
        if (C0351r.m2359i().m2395q()) {
            this.f1641f.setEnabled(true);
            return;
        }
        boolean z;
        this.f1645j.setError(null);
        this.f1640e.setError(null);
        this.f1643h = this.f1645j.getText().toString();
        this.f1644i = this.f1640e.getText().toString();
        C0351r.m2359i().m2377d(this.f1643h);
        C0351r.m2359i().m2382f(this.f1644i);
        if (TextUtils.isEmpty(this.f1644i)) {
            this.f1640e.setError(getString(R.string.error_field_required));
            view = this.f1640e;
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.isEmpty(this.f1643h)) {
            this.f1645j.setError(getString(R.string.error_field_required));
            view = this.f1645j;
            z = true;
        }
        if (z) {
            view.requestFocus();
            m2607a(false);
            this.f1641f.setEnabled(true);
        } else if (C0365j.m2477a((Context) this)) {
            m2607a(true);
            C0332j.m2148a().m2166b();
        } else {
            new Builder(this).setTitle(R.string.broke_connection).setPositiveButton(R.string.ok, new C0412v(this)).setNegativeButton(R.string.cancel, new C0413w(this)).create().show();
        }
    }

    public void m2607a(boolean z) {
        if (z) {
            try {
                if (this.f1647l == null) {
                    this.f1647l = C0418b.m2735a((Context) this, (int) R.string.login_progress_signing_in);
                }
                this.f1647l.show();
            } catch (Exception e) {
                C0322b.m2079w(this.d, "dialog error:" + e.toString());
            }
        } else if (this.f1647l != null) {
            this.f1647l.dismiss();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onBackPressed() {
        C0331i.m2124a().m2141f(this);
        moveTaskToBack(false);
        C0351r.m2359i().m2383g();
        C0332j.m2148a().m2178d();
    }
}
