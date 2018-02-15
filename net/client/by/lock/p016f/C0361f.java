package net.client.by.lock.p016f;

import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.net.ssl.X509TrustManager;

/* compiled from: MyApp */
class C0361f implements X509TrustManager {
    C0361f() {
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        } else if (!C0368m.m2487a(x509CertificateArr, getAcceptedIssuers(), m2466a())) {
            throw new CertificateException("Cannot verify certificate chain.");
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        if (C0360e.f1552a == null) {
            return null;
        }
        try {
            Enumeration aliases = C0360e.f1552a.aliases();
            ArrayList arrayList = new ArrayList();
            while (aliases.hasMoreElements()) {
                arrayList.add((X509Certificate) C0360e.f1552a.getCertificate((String) aliases.nextElement()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[0]);
        } catch (KeyStoreException e) {
            e.printStackTrace();
            return null;
        }
    }

    public X509Certificate[] m2466a() {
        if (C0360e.f1553b == null) {
            return null;
        }
        try {
            Enumeration aliases = C0360e.f1553b.aliases();
            ArrayList arrayList = new ArrayList();
            while (aliases.hasMoreElements()) {
                arrayList.add((X509Certificate) C0360e.f1553b.getCertificate((String) aliases.nextElement()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[0]);
        } catch (KeyStoreException e) {
            e.printStackTrace();
            return null;
        }
    }
}
