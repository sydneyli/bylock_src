package net.client.by.lock.p011a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import net.client.by.lock.C0322b;
import net.client.by.lock.codec.Speex;
import net.client.by.lock.p016f.C0358c;

/* compiled from: MyApp */
public class C0293g {
    private static final int f1263a = (C0358c.m2457a() / 16);
    private ArrayList f1264b = new ArrayList();
    private ArrayBlockingQueue f1265c = new ArrayBlockingQueue(5);
    private int f1266d = 0;
    private int f1267e = 0;
    private int f1268f = Integer.MAX_VALUE;
    private Speex f1269g;

    public C0293g(Speex speex) {
        this.f1269g = speex;
    }

    public void m1971a(C0292f c0292f) {
        if (this.f1266d == 0) {
            this.f1266d = c0292f.m1967e();
        }
        this.f1267e = Math.max(this.f1267e, c0292f.m1908d());
        this.f1268f = Math.min(this.f1268f, c0292f.m1908d());
        if (this.f1264b.size() < 15) {
            int binarySearch = Collections.binarySearch(this.f1264b, c0292f);
            if (binarySearch < 0) {
                this.f1264b.add(-(binarySearch + 1), c0292f);
            }
        }
        try {
            m1968b();
        } catch (Exception e) {
            C0322b.m2077i("JitterBuffer", e.getMessage());
        }
    }

    private void m1968b() {
        if (m1969c()) {
            int size = this.f1264b.size();
            int i = 1;
            while (i < size && (((C0292f) this.f1264b.get(i - 1)).m1967e() + 1 >= ((C0292f) this.f1264b.get(i)).m1967e() || this.f1264b.size() >= 15)) {
                i++;
            }
            Object obj = new short[(((((C0292f) this.f1264b.get(i - 1)).m1967e() - this.f1266d) + 1) * 160)];
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                double d;
                Object obj2;
                int i4;
                int i5;
                double d2 = ((double) (i / 3)) * 0.01d;
                Object obj3;
                if (this.f1266d == ((C0292f) this.f1264b.get(0)).m1967e()) {
                    C0292f c0292f = (C0292f) this.f1264b.remove(0);
                    if (this.f1268f < this.f1267e && d2 > 0.0d) {
                        d2 *= 1.75d - (((double) (c0292f.m1908d() - this.f1268f)) / ((double) (this.f1267e - this.f1268f)));
                    }
                    Object obj4;
                    if (d2 > 0.0d) {
                        obj3 = new short[160];
                        this.f1269g.decode(c0292f.m1905a(), c0292f.m1907c(), c0292f.m1908d(), obj3, 0);
                        obj4 = 1;
                        d = d2;
                        obj2 = obj3;
                        i4 = i2;
                        i5 = 0;
                    } else {
                        d = d2;
                        i5 = 0;
                        obj2 = null;
                        i4 = this.f1269g.decode(c0292f.m1905a(), c0292f.m1907c(), c0292f.m1908d(), obj, i2);
                        obj4 = null;
                    }
                } else {
                    double d3 = 1.5d * d2;
                    obj3 = new short[160];
                    obj2 = obj3;
                    i5 = this.f1269g.decodeLost(obj3, 0);
                    d = d3;
                    size = 1;
                    i4 = i2;
                }
                if (d < 1.0d && r3 != null) {
                    int i6 = (int) (d * ((double) (i5 / f1263a)));
                    if (i6 > 0) {
                        size = (i5 - (f1263a * i6)) / i6;
                        int i7 = size - (size % f1263a);
                        size = i4;
                        for (i4 = 0; i4 < i6; i4++) {
                            System.arraycopy(obj2, (f1263a + i7) * i4, obj, size, i7);
                            size += i7;
                        }
                        System.arraycopy(obj2, (f1263a + i7) * i6, obj, size, (i5 - (f1263a * i6)) - (i7 * i6));
                        i4 = ((i5 - (f1263a * i6)) - (i6 * i7)) + size;
                    } else {
                        System.arraycopy(obj2, 0, obj, i4, i5);
                        i4 += i5;
                    }
                }
                if (this.f1266d > 0) {
                    this.f1266d++;
                }
                i3++;
                i2 = i4;
            }
            try {
                this.f1265c.add(new C0287b(obj, 0, i2));
            } catch (Exception e) {
            }
        }
    }

    private boolean m1969c() {
        if (this.f1264b.isEmpty()) {
            return false;
        }
        if (((C0292f) this.f1264b.get(0)).m1967e() == this.f1266d) {
            return true;
        }
        return this.f1264b.size() >= 15;
    }

    public C0287b m1970a() {
        return (C0287b) this.f1265c.take();
    }
}
