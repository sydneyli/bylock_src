package net.client.by.lock.p013b;

import java.io.InputStream;

/* compiled from: MyApp */
public class C0320l extends InputStream {
    InputStream f1402a;
    C0316m f1403b;

    public C0320l(InputStream inputStream, C0316m c0316m) {
        this.f1402a = inputStream;
        this.f1403b = c0316m;
    }

    public int read() {
        int read = this.f1402a.read();
        this.f1403b.mo328b(read);
        return read;
    }
}
