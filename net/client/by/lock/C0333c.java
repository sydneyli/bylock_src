package net.client.by.lock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.p015e.C0353b;
import net.client.by.lock.p016f.C0368m;
import net.client.by.lock.service.C0446c;

/* compiled from: MyApp */
public class C0333c {
    private static C0333c f1448a = null;
    private HashMap f1449b = new HashMap();

    private C0333c() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(C0331i.m2124a().m2139e()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String trim = readLine.trim();
                if (trim.equalsIgnoreCase((String) C0351r.m2359i().m2381f().m2467a())) {
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            StringTokenizer stringTokenizer = new StringTokenizer(readLine.trim(), "#");
                            if (stringTokenizer.countTokens() == 2) {
                                try {
                                    this.f1449b.put(stringTokenizer.nextToken(), C0353b.m2406a(stringTokenizer.nextToken()));
                                } catch (Exception e) {
                                }
                            }
                        } else {
                            return;
                        }
                    }
                }
                C0322b.m2076e("ModulusCache", trim);
            }
        } catch (IOException e2) {
        } catch (NullPointerException e3) {
            C0322b.m2076e("ModulusCache", "Some kind of null pointer occured.");
        }
    }

    public void m2188a() {
        StringBuilder append = new StringBuilder((String) C0351r.m2359i().m2381f().m2467a()).append("\r\n");
        for (Entry entry : this.f1449b.entrySet()) {
            append.append((String) entry.getKey()).append("#").append(C0353b.m2405a((byte[]) entry.getValue())).append("\r\n");
        }
        C0331i.m2124a().m2129a(append.toString());
    }

    public void m2191b() {
        this.f1449b.clear();
    }

    public static C0333c m2187c() {
        if (f1448a == null) {
            if (C0446c.f1956b == null) {
                f1448a = new C0333c();
                C0446c.f1956b = f1448a;
            } else {
                f1448a = C0446c.f1956b;
            }
        } else if (C0446c.f1956b == null) {
            C0446c.f1956b = f1448a;
        }
        return f1448a;
    }

    private String m2186c(Integer num, String str) {
        String a = C0368m.m2483a(new StringBuilder(String.valueOf(str)).append(num).toString());
        if (a != null) {
            int i = 0;
            while (i < 10) {
                String a2 = C0368m.m2483a(new StringBuilder(String.valueOf(i)).append(a).append(i).toString());
                i++;
                a = a2;
            }
        }
        return a;
    }

    public void m2190a(Integer num, String str, byte[] bArr) {
        String c = m2186c(num, str);
        if (c != null && c.length() > 0) {
            this.f1449b.put(c, bArr);
        }
    }

    public void m2189a(Integer num, String str) {
        String c = m2186c(num, str);
        if (c != null && c.length() > 0) {
            this.f1449b.remove(c);
        }
    }

    public boolean m2192b(Integer num, String str) {
        String c = m2186c(num, str);
        if (c == null || c.length() <= 0) {
            return false;
        }
        return this.f1449b.containsKey(c);
    }

    public boolean m2193b(Integer num, String str, byte[] bArr) {
        String c = m2186c(num, str);
        byte[] bArr2 = null;
        if (c != null && c.length() > 0) {
            bArr2 = (byte[]) this.f1449b.get(c);
        }
        if (bArr2 != null) {
            return Arrays.equals(bArr2, bArr);
        }
        return false;
    }
}
