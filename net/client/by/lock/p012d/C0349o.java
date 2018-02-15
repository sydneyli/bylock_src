package net.client.by.lock.p012d;

import java.util.StringTokenizer;
import net.client.by.lock.gui.activity.C0391a;
import net.client.by.lock.gui.activity.ChatActivity;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0353b;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0349o {
    private Integer f1521a;
    private String f1522b;
    private int f1523c;
    private String f1524d;

    public String m2343a() {
        return this.f1522b;
    }

    public void m2345a(String str) {
        this.f1522b = str;
    }

    public void m2344a(int i) {
        this.f1523c = i;
    }

    public void m2348b(String str) {
        this.f1524d = str;
    }

    public void m2346b() {
        int i = 0;
        C0337c a = C0327e.m2092c().m2094a(Integer.valueOf(this.f1523c));
        if (a != null) {
            if (this.f1522b.equalsIgnoreCase("LOGIN")) {
                a.m2243a(3);
                a.m2267e(this.f1524d);
            } else if (this.f1522b.equalsIgnoreCase("LOGOUT")) {
                a.m2243a(0);
            } else if (this.f1522b.equalsIgnoreCase("UPDATE STATUS")) {
                try {
                    a.m2243a(Integer.parseInt(this.f1524d));
                } catch (NumberFormatException e) {
                }
            } else if (this.f1522b.equalsIgnoreCase("UPDATE PUBLIC MESSAGE")) {
                a.m2258b(this.f1524d);
            } else if (this.f1522b.equalsIgnoreCase("CHAT")) {
                a.m2277m();
                r0 = C0325c.m2086a().m2088b();
                if (r0 instanceof ChatActivity) {
                    C0337c h = ((ChatActivity) r0).m2602h();
                    if (!(h == null || h.equals(a)) || C0391a.m2577a()) {
                        C0330h.m2111a().m2116a(a, 1);
                    }
                } else {
                    C0330h.m2111a().m2116a(a, 1);
                }
            } else if (this.f1522b.equalsIgnoreCase("UPDATE KEY")) {
                a.m2252a(C0353b.m2406a(this.f1524d));
            } else if (this.f1522b.equalsIgnoreCase("UPDATE NAME")) {
                a.m2269f(this.f1524d);
            } else if (this.f1522b.equalsIgnoreCase("REMOVE FROM ROSTER")) {
                C0327e.m2092c().m2104b(a);
            } else if (this.f1522b.equalsIgnoreCase("SEND FILE")) {
                C0332j.m2148a().m2169b(this.f1524d);
                r0 = C0325c.m2086a().m2088b();
                if (!(r0 instanceof ChatActivity)) {
                    C0330h.m2111a().m2116a(a, 2);
                } else if (!((ChatActivity) r0).m2602h().equals(a) || C0391a.m2577a()) {
                    C0330h.m2111a().m2116a(a, 2);
                }
            } else if (this.f1522b.equalsIgnoreCase("MAKE CALL")) {
                r0 = new StringTokenizer(this.f1524d, "#");
                if (r0.countTokens() == 4) {
                    byte[] a2 = C0365j.m2480a(r0.nextToken());
                    byte[] a3 = C0365j.m2480a(r0.nextToken());
                    r4 = r0.nextToken();
                    boolean equals = r0.nextToken().equals("1");
                    if (!(a2 == null || a3 == null)) {
                        a.m2253a(a2, a3, r4, equals);
                    }
                }
            } else if (this.f1522b.equalsIgnoreCase("ANSWER CALL")) {
                r0 = new StringTokenizer(this.f1524d, "#");
                if (r0.countTokens() == 2) {
                    try {
                        a.m2244a(Integer.parseInt(r0.nextToken()), r0.nextToken().equals("1"));
                    } catch (NumberFormatException e2) {
                    }
                }
            } else if (this.f1522b.equalsIgnoreCase("REJECT CALL")) {
                a.m2264d();
            } else if (this.f1522b.equalsIgnoreCase("MISS CALL")) {
                a.m2266e();
            } else if (this.f1522b.equalsIgnoreCase("CANCEL CALL")) {
                a.m2268f();
            } else if (this.f1522b.equalsIgnoreCase("CLOSE CALL")) {
                a.m2271g();
            } else if (this.f1522b.equalsIgnoreCase("BUSY CALL")) {
                a.m2273i();
            } else if (this.f1522b.equalsIgnoreCase("CALL ERROR")) {
                a.m2272h();
            } else if (this.f1522b.equalsIgnoreCase("MAIL")) {
                StringTokenizer stringTokenizer = new StringTokenizer(this.f1524d, "#");
                if (stringTokenizer.countTokens() == 4) {
                    String nextToken = stringTokenizer.nextToken();
                    r4 = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    i = stringTokenizer.nextToken().trim().equals("1");
                    a.m2248a(nextToken, r4, C0353b.m2406a(nextToken2), (boolean) i);
                }
                if (i == 0) {
                    r0 = C0325c.m2086a().m2088b();
                    if (!(r0 instanceof ChatActivity)) {
                        C0330h.m2111a().m2116a(a, 3);
                    } else if (((ChatActivity) r0).m2603i() != this.f1523c || C0391a.m2577a()) {
                        C0330h.m2111a().m2116a(a, 3);
                    }
                }
            }
        } else if (this.f1522b.equalsIgnoreCase("ADD TO ROSTER")) {
            C0332j.m2148a().m2153a(Integer.valueOf(this.f1523c));
        } else if (this.f1522b.equalsIgnoreCase("UPDATE SELF STATUS")) {
            try {
                C0351r.m2359i().m2363a(Integer.valueOf(Integer.parseInt(this.f1524d)));
            } catch (Throwable e3) {
                C0365j.m2476a("", e3);
            }
        } else if (this.f1522b.equalsIgnoreCase("UPDATE SELF PUBLIC MESSAGE")) {
            C0351r.m2359i().m2387i(this.f1524d);
        } else if (this.f1522b.equalsIgnoreCase("CREATE GROUP")) {
            r0 = this.f1524d.split("#", -1);
            if (r0.length == 3) {
                try {
                    r1 = Integer.valueOf(Integer.parseInt(r0[0]));
                    String str = r0[1];
                    Integer valueOf = Integer.valueOf(Integer.parseInt(r0[2]));
                    C0327e.m2092c().m2100a(new C0341g(r1.intValue(), str));
                    C0327e.m2092c().m2097a(valueOf, r1);
                } catch (Throwable e32) {
                    C0365j.m2476a("", e32);
                }
            }
        } else if (this.f1522b.equalsIgnoreCase("RENAME GROUP")) {
            r0 = this.f1524d.split("#", -1);
            if (r0.length == 2) {
                try {
                    C0327e.m2092c().m2098a(Integer.valueOf(Integer.parseInt(r0[0])), r0[1]);
                } catch (Throwable e322) {
                    C0365j.m2476a("", e322);
                }
            }
        } else if (this.f1522b.equalsIgnoreCase("ADD TO GROUP")) {
            r0 = this.f1524d.split("#", -1);
            if (r0.length == 2) {
                try {
                    r1 = Integer.valueOf(Integer.parseInt(r0[0]));
                    C0327e.m2092c().m2097a(Integer.valueOf(Integer.parseInt(r0[1])), r1);
                } catch (Throwable e3222) {
                    C0365j.m2476a("", e3222);
                }
            }
        } else if (this.f1522b.equalsIgnoreCase("REMOVE FROM GROUP")) {
            r0 = this.f1524d.split("#", -1);
            if (r0.length == 2) {
                try {
                    r1 = Integer.valueOf(Integer.parseInt(r0[0]));
                    C0327e.m2092c().m2103b(Integer.valueOf(Integer.parseInt(r0[1])), r1);
                } catch (Throwable e32222) {
                    C0365j.m2476a("", e32222);
                }
            }
        } else if (this.f1522b.equalsIgnoreCase("DELETE GROUP")) {
            try {
                C0327e.m2092c().m2096a(Integer.valueOf(Integer.parseInt(this.f1524d)).intValue());
            } catch (Throwable e322222) {
                C0365j.m2476a("", e322222);
            }
        } else if (this.f1522b.equalsIgnoreCase("RENAME FRIEND")) {
            r0 = this.f1524d.split("#", -1);
            if (r0.length == 2) {
                try {
                    C0327e.m2092c().m2094a(Integer.valueOf(Integer.parseInt(r0[0]))).m2265d(r0[1]);
                } catch (Throwable e3222222) {
                    C0365j.m2476a("", e3222222);
                }
            }
        }
        C0351r.m2359i().m2374c(this.f1521a);
    }

    public void m2347b(int i) {
        this.f1521a = Integer.valueOf(i);
    }
}
