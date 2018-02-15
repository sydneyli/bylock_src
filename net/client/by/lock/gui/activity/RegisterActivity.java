package net.client.by.lock.gui.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.C0418b;

/* compiled from: MyApp */
public class RegisterActivity extends C0391a {
    public Dialog f1697e;
    private TextView f1698f;
    private TextView f1699g;
    private TextView f1700h;
    private Button f1701i;
    private Button f1702j;
    private InputMethodManager f1703k;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_register);
        this.f1698f = (TextView) findViewById(R.id.username);
        this.f1699g = (TextView) findViewById(R.id.password);
        this.f1700h = (TextView) findViewById(R.id.password_re);
        this.f1701i = (Button) findViewById(R.id.register);
        this.f1702j = (Button) findViewById(R.id.cancel);
        String[] stringArray = getResources().getStringArray(R.array.pass_security);
        this.f1703k = (InputMethodManager) getSystemService("input_method");
        this.f1702j.setOnClickListener(new bk(this));
        View findViewById = findViewById(R.id.content);
        findViewById.setOnTouchListener(new bl(this, findViewById));
        this.f1701i.setOnClickListener(new bm(this, stringArray));
        this.f1697e = C0418b.m2735a((Context) this, (int) R.string.registering);
    }
}
