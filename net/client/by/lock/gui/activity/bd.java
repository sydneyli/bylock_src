package net.client.by.lock.gui.activity;

import android.os.AsyncTask;
import android.text.Html;
import android.text.Spanned;
import net.client.by.lock.p012d.C0347l;
import net.client.by.lock.p016f.C0368m;

/* compiled from: MyApp */
class bd extends AsyncTask {
    final /* synthetic */ ReadIMailActivity f1777a;

    bd(ReadIMailActivity readIMailActivity) {
        this.f1777a = readIMailActivity;
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m2695a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2696a((Spanned) obj);
    }

    protected Spanned m2695a(Void... voidArr) {
        return Html.fromHtml(C0368m.m2484a(this.f1777a.f1680w.m2318g(), ((C0347l) this.f1777a.f1680w).m2332e()));
    }

    protected void m2696a(Spanned spanned) {
        this.f1777a.f1673o.setText(spanned);
    }
}
