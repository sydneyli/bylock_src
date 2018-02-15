package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import net.client.by.lock.R;

/* compiled from: MyApp */
public class PinActivity extends C0391a {
    private static EditText f1657f;
    private static String f1658g = "";
    private static PinActivity f1659h = null;
    private View[] f1660e;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pin);
        f1657f = (EditText) findViewById(R.id.editText1);
        f1657f.setKeyListener(null);
        this.f1660e = new View[11];
        this.f1660e[0] = findViewById(R.id.button1);
        this.f1660e[1] = findViewById(R.id.button2);
        this.f1660e[2] = findViewById(R.id.button3);
        this.f1660e[3] = findViewById(R.id.button4);
        this.f1660e[4] = findViewById(R.id.button5);
        this.f1660e[5] = findViewById(R.id.button6);
        this.f1660e[6] = findViewById(R.id.button7);
        this.f1660e[7] = findViewById(R.id.button8);
        this.f1660e[8] = findViewById(R.id.button9);
        this.f1660e[9] = findViewById(R.id.button10);
        this.f1660e[10] = findViewById(R.id.button11);
        for (int i = 0; i < this.f1660e.length; i++) {
            this.f1660e[i].setOnClickListener(new bc(i));
        }
        f1659h = this;
    }

    protected void onPause() {
        if (isFinishing()) {
            f1659h = null;
        }
        super.onPause();
    }

    public void onBackPressed() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);
        finish();
    }
}
