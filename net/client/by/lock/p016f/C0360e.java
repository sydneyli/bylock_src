package net.client.by.lock.p016f;

import android.content.Context;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import net.client.by.lock.R;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

/* compiled from: MyApp */
public class C0360e {
    private static KeyStore f1552a;
    private static KeyStore f1553b = null;

    public static HttpsURLConnection m2462a(String str, Context context) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        httpsURLConnection.setSSLSocketFactory(C0360e.m2463a(context));
        httpsURLConnection.setConnectTimeout(36000);
        httpsURLConnection.setReadTimeout(36000);
        httpsURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.1.6) Gecko/20061201 Firefox/2.0.0.6 (Ubuntu-feisty)");
        httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        return httpsURLConnection;
    }

    private static SSLSocketFactory m2463a(Context context) {
        SSLContext instance;
        Throwable e;
        KeyManagementException e2;
        C0360e.m2465b(context);
        try {
            instance = SSLContext.getInstance("TLS");
            try {
                instance.init(null, new TrustManager[]{new C0361f()}, null);
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                C0365j.m2476a("HttpsURLConnectionFactory", e);
                return instance.getSocketFactory();
            } catch (KeyManagementException e4) {
                e2 = e4;
                e2.printStackTrace();
                return instance.getSocketFactory();
            }
        } catch (Throwable e5) {
            Throwable th = e5;
            instance = null;
            e = th;
            C0365j.m2476a("HttpsURLConnectionFactory", e);
            return instance.getSocketFactory();
        } catch (KeyManagementException e6) {
            KeyManagementException keyManagementException = e6;
            instance = null;
            e2 = keyManagementException;
            e2.printStackTrace();
            return instance.getSocketFactory();
        }
        return instance.getSocketFactory();
    }

    private static void m2465b(Context context) {
        try {
            InputStream openRawResource;
            if (f1552a == null) {
                f1552a = KeyStore.getInstance("BKS");
                openRawResource = context.getApplicationContext().getResources().openRawResource(R.raw.issuers);
                f1552a.load(openRawResource, "caPaski.toBeTheKing".toCharArray());
                openRawResource.close();
            }
            if (f1553b == null) {
                f1553b = KeyStore.getInstance("BKS");
                openRawResource = context.getApplicationContext().getResources().openRawResource(R.raw.subjects);
                f1553b.load(openRawResource, "caPaski.toBeTheKing".toCharArray());
                openRawResource.close();
            }
        } catch (Exception e) {
            throw new KeyStoreException("Certificates cannot be loaded: " + e.getMessage());
        }
    }
}
