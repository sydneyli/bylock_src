package net.client.by.lock.p016f;

import java.security.cert.X509Certificate;

/* compiled from: MyApp */
class C0369n {
    X509Certificate f1567a = null;
    C0369n f1568b = null;
    C0369n f1569c = null;

    public C0369n(X509Certificate x509Certificate) {
        this.f1567a = x509Certificate;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0369n)) {
            return false;
        }
        C0369n c0369n = (C0369n) obj;
        if (this.f1567a == null && c0369n.f1567a == null) {
            return true;
        }
        if (this.f1567a == null || c0369n.f1567a == null) {
            return false;
        }
        return this.f1567a.equals(c0369n.f1567a);
    }

    public int hashCode() {
        return this.f1567a == null ? 0 : this.f1567a.hashCode();
    }
}
