package net.client.by.lock.p013b;

import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0317i implements C0316m {
    private int f1387a;
    private int f1388b = 0;
    private int f1389c = 0;
    private String f1390d = "";
    private String f1391e = "";
    private String f1392f = "";
    private String f1393g = "";
    private long f1394h = System.currentTimeMillis();
    private long f1395i = this.f1394h;
    private double f1396j = 0.0d;
    private Object f1397k = new Object();
    private C0318j f1398l;

    public void m2064a() {
        synchronized (this.f1397k) {
            this.f1389c++;
        }
        m2067b();
    }

    public void m2067b() {
        if ((((double) (this.f1389c - this.f1388b)) * 100.0d) / ((double) this.f1387a) >= 1.0d || this.f1389c == this.f1387a) {
            synchronized (this.f1397k) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis <= this.f1394h || this.f1389c <= this.f1388b) {
                    this.f1390d = "";
                    this.f1392f = "";
                } else {
                    double d = ((double) (currentTimeMillis - this.f1395i)) / 1000.0d;
                    double d2 = ((double) (currentTimeMillis - this.f1394h)) / 1000.0d;
                    this.f1393g = C0365j.m2473a((int) Math.round(d));
                    d2 = ((double) (this.f1389c - this.f1388b)) / d2;
                    this.f1390d = C0365j.m2472a(d2);
                    this.f1392f = C0365j.m2473a((int) Math.round(((double) (this.f1387a - this.f1389c)) / d2));
                    this.f1391e = C0365j.m2472a(((double) this.f1389c) / d);
                    this.f1396j = ((double) this.f1389c) / ((double) this.f1387a);
                    this.f1398l.updateProgress((int) (this.f1396j * 100.0d));
                    this.f1388b = this.f1389c;
                    this.f1394h = currentTimeMillis;
                }
            }
        }
    }

    public void m2065a(int i) {
        this.f1387a = i;
    }

    public void mo328b(int i) {
        if (i != -1) {
            m2064a();
        }
    }

    public void m2066a(C0318j c0318j) {
        this.f1398l = c0318j;
    }
}
