package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0418b {
    public static Dialog m2734a(Context context) {
        View inflate = View.inflate(context, R.layout.dialog_change_name, null);
        EditText editText = (EditText) inflate.findViewById(R.id.editText1);
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        inflate.findViewById(R.id.button1).setOnClickListener(new C0419c(editText, dialog));
        inflate.findViewById(R.id.button2).setOnClickListener(new C0430n(dialog));
        return dialog;
    }

    public static Dialog m2739b(Context context) {
        View inflate = View.inflate(context, R.layout.dialog_change_public_message, null);
        EditText editText = (EditText) inflate.findViewById(R.id.editText1);
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        inflate.findViewById(R.id.button1).setOnClickListener(new C0433q(editText, dialog));
        inflate.findViewById(R.id.button2).setOnClickListener(new C0434r(dialog));
        return dialog;
    }

    public static Dialog m2741c(Context context) {
        View inflate = View.inflate(context, R.layout.dialog_change_password, null);
        EditText editText = (EditText) inflate.findViewById(R.id.editText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.editText2);
        EditText editText3 = (EditText) inflate.findViewById(R.id.editText3);
        Dialog dialog = new Dialog(context);
        String[] stringArray = context.getResources().getStringArray(R.array.pass_security);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        inflate.findViewById(R.id.button1).setOnClickListener(new C0435s(editText, editText2, editText3, stringArray, dialog));
        inflate.findViewById(R.id.button2).setOnClickListener(new C0436t(dialog));
        return dialog;
    }

    public static Dialog m2742d(Context context) {
        View inflate = View.inflate(context, R.layout.dialog_force_change_password, null);
        EditText editText = (EditText) inflate.findViewById(R.id.editText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.editText2);
        Button button = (Button) inflate.findViewById(R.id.button1);
        String[] stringArray = context.getResources().getStringArray(R.array.pass_security);
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        button.setOnClickListener(new C0437u(editText, editText2, dialog));
        editText.addTextChangedListener(new C0438v(button, editText, stringArray));
        return dialog;
    }

    public static Dialog m2743e(Context context) {
        View inflate = View.inflate(context, R.layout.dialog_change_status, null);
        TextView textView = (TextView) inflate.findViewById(R.id.textView1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.textView2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.textView3);
        TextView textView4 = (TextView) inflate.findViewById(R.id.textView4);
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        OnClickListener c0439w = new C0439w(textView, textView2, textView3, textView4, dialog);
        textView.setOnClickListener(c0439w);
        textView2.setOnClickListener(c0439w);
        textView3.setOnClickListener(c0439w);
        textView4.setOnClickListener(c0439w);
        return dialog;
    }

    public static Dialog m2735a(Context context, int i) {
        View inflate = View.inflate(context, R.layout.dialog_in_progress, null);
        ((TextView) inflate.findViewById(R.id.textView1)).setText(i);
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate);
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog m2744f(Context context) {
        View inflate = View.inflate(context, R.layout.dialog_change_pin, null);
        EditText editText = (EditText) inflate.findViewById(R.id.editText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.editText2);
        EditText editText3 = (EditText) inflate.findViewById(R.id.editText3);
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        inflate.findViewById(R.id.button1).setOnClickListener(new C0420d(editText, editText2, editText3, dialog));
        inflate.findViewById(R.id.button2).setOnClickListener(new C0421e(dialog));
        return dialog;
    }

    public static Dialog m2736a(Context context, File file) {
        View inflate = View.inflate(context, R.layout.dialog_delete_file, null);
        ((TextView) inflate.findViewById(R.id.textView1)).setText(file.getName() + " " + C0365j.m2474a(file.length()));
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        inflate.findViewById(R.id.button1).setOnClickListener(new C0422f(file, dialog));
        inflate.findViewById(R.id.button2).setOnClickListener(new C0423g(dialog));
        return dialog;
    }

    public static Dialog m2738a(Context context, C0337c c0337c, C0341g c0341g) {
        View inflate = View.inflate(context, R.layout.dialog_friend_menu, null);
        ((TextView) inflate.findViewById(R.id.name)).setText(c0337c.m2233G());
        if (c0341g.m2301a() == 0) {
            inflate.findViewById(R.id.textView4).setVisibility(8);
        }
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        inflate.findViewById(R.id.textView1).setOnClickListener(new C0424h(c0337c, dialog));
        inflate.findViewById(R.id.textView2).setOnClickListener(new C0425i(c0337c, dialog));
        inflate.findViewById(R.id.textView3).setOnClickListener(new C0426j(c0337c, c0341g, dialog));
        inflate.findViewById(R.id.textView4).setOnClickListener(new C0427k(c0337c, c0341g, dialog));
        return dialog;
    }

    public static Dialog m2737a(Context context, C0337c c0337c) {
        View inflate = View.inflate(context, R.layout.dialog_change_name, null);
        EditText editText = (EditText) inflate.findViewById(R.id.editText1);
        editText.setText(c0337c.m2233G());
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        inflate.findViewById(R.id.button1).setOnClickListener(new C0428l(c0337c, editText, dialog));
        inflate.findViewById(R.id.button2).setOnClickListener(new C0429m(dialog));
        return dialog;
    }

    public static Dialog m2740b(Context context, C0337c c0337c, C0341g c0341g) {
        View inflate = View.inflate(context, R.layout.dialog_move_to_group, null);
        ((TextView) inflate.findViewById(R.id.name)).setText(c0337c.m2233G());
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) inflate.findViewById(R.id.editText1);
        Object arrayList = new ArrayList();
        Iterator it = C0327e.m2092c().m2105e().iterator();
        while (it.hasNext()) {
            C0341g c0341g2 = (C0341g) it.next();
            if (!(c0341g2.m2301a() == 0 || c0341g.m2301a() == c0341g2.m2301a())) {
                arrayList.add(c0341g2);
            }
        }
        ListAdapter arrayAdapter = new ArrayAdapter(context, 17367050, arrayList);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        inflate.findViewById(R.id.button1).setOnClickListener(new C0431o(autoCompleteTextView, dialog, arrayList, c0337c));
        inflate.findViewById(R.id.button2).setOnClickListener(new C0432p(dialog));
        return dialog;
    }
}
