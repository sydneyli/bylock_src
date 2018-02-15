package net.client.by.lock.task;

import java.net.HttpURLConnection;
import java.net.URLConnection;

/* compiled from: MyApp */
public class C0450c implements Runnable {
    Thread f1958a;
    URLConnection f1959b;

    public C0450c(Thread thread, URLConnection uRLConnection) {
        this.f1958a = thread;
        this.f1959b = uRLConnection;
    }

    public void run() {
        try {
            Thread.sleep(60000);
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.f1959b;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
