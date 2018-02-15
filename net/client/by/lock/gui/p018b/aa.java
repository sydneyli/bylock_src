package net.client.by.lock.gui.p018b;

import android.media.AudioRecord;
import android.os.AsyncTask;
import net.client.by.lock.R;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.p016f.C0358c;

/* compiled from: MyApp */
class aa extends AsyncTask {
    final /* synthetic */ C0440x f1835a;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m2712a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2713a((Integer) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object... objArr) {
        m2714a((Integer[]) objArr);
    }

    private aa(C0440x c0440x) {
        this.f1835a = c0440x;
    }

    protected Integer m2712a(Void... voidArr) {
        int[] iArr = new int[]{8000, 16000, 32000, 48000};
        short[] sArr = new short[1600];
        int c = C0358c.m2459c();
        for (int i : iArr) {
            publishProgress(new Integer[]{Integer.valueOf(i)});
            try {
                this.f1835a.f1925e = new AudioRecord(1, i, 16, c, AudioRecord.getMinBufferSize(i, 16, c) * 4);
                this.f1835a.f1925e.startRecording();
                int read = this.f1835a.f1925e.read(sArr, 0, sArr.length);
                this.f1835a.f1925e.stop();
                this.f1835a.f1925e.release();
                this.f1835a.f1925e = null;
                for (int i2 = 0; i2 < read; i2++) {
                    if (sArr[i2] != (short) 0) {
                        return Integer.valueOf(i);
                    }
                }
                continue;
            } catch (IllegalArgumentException e) {
            }
        }
        return Integer.valueOf(-1);
    }

    protected void m2714a(Integer... numArr) {
        this.f1835a.f1921a.setText(numArr[0]);
    }

    protected void m2713a(Integer num) {
        this.f1835a.f1924d.setVisibility(8);
        if (num.intValue() > 0) {
            this.f1835a.f1922b.setText(R.string.fr_found);
            this.f1835a.f1921a.setText(num);
            C0331i.m2124a().m2126a(num.intValue());
            this.f1835a.f1921a.postDelayed(new ab(this), 2600);
            return;
        }
        this.f1835a.f1926f.setVisibility(0);
        this.f1835a.f1927g.setVisibility(0);
        this.f1835a.f1921a.setVisibility(8);
        this.f1835a.f1922b.setText(R.string.fr_corrupt);
        C0331i.m2124a().m2126a(8000);
    }
}
