package net.client.by.lock.p011a;

import java.util.concurrent.ArrayBlockingQueue;
import net.client.by.lock.p016f.C0358c;

/* compiled from: MyApp */
public class C0295i extends ArrayBlockingQueue {
    public C0295i() {
        super(50);
    }

    public void m1975a(C0286a c0286a) {
        int pow = ((int) ((25.0d * Math.pow((double) size(), 2.0d)) * ((double) c0286a.m1902b()))) / 100;
        if (pow == 0) {
            add(c0286a);
            return;
        }
        int a = C0358c.m2457a() / 16;
        if (pow * a < c0286a.m1902b()) {
            Object obj = new short[(c0286a.m1902b() - (pow * a))];
            int length = obj.length / pow;
            for (int i = 0; i < pow; i++) {
                System.arraycopy(c0286a.m1901a(), (length + a) * i, obj, length * i, length);
            }
            System.arraycopy(c0286a.m1901a(), (a + length) * pow, obj, length * pow, obj.length - (pow * length));
            add(new C0286a(obj, obj.length));
        }
    }
}
