package net.client.by.lock.p013b;

import java.io.InputStream;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public abstract class C0309e extends InputStream {
    protected boolean f1344g = false;
    protected C0317i f1345h = new C0317i();
    protected boolean f1346i = false;
    protected InputStream f1347j;
    protected int f1348k;

    public C0317i m2008a() {
        return this.f1345h;
    }

    public void m2009a(int i) {
        this.f1348k = i;
        this.f1345h.m2065a(i);
    }

    protected void m2011b() {
        if (!this.f1346i) {
            this.f1346i = true;
            if (this.f1347j != null) {
                try {
                    this.f1347j.close();
                } catch (Throwable e) {
                    C0365j.m2476a("FileTransferInputStream", e);
                }
                this.f1347j = null;
            }
        }
    }

    public void mo320a(InputStream inputStream) {
        this.f1347j = inputStream;
    }

    public void close() {
        super.close();
        this.f1344g = true;
        m2011b();
    }
}
