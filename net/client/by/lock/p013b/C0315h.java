package net.client.by.lock.p013b;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.client.by.lock.gui.p017a.C0376a;
import net.client.by.lock.gui.p017a.C0388m;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0315h extends C0312d {
    ArrayList f1386c;

    public C0315h(File file) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128, C0351r.m2359i().m2361a());
            m2031a(new SecretKeySpec(instance.generateKey().getEncoded(), "AES"));
            m2030a(new IvParameterSpec(instance.generateKey().getEncoded()));
            m2027a(file);
            m2033b(file.getName());
            this.f1386c = new ArrayList();
        } catch (Throwable e) {
            C0365j.m2476a("Error in generating key for file transfer", e);
        }
    }

    public C0315h(C0308a c0308a) {
        m2033b(c0308a.mo325e());
        m2031a(c0308a.mo323c());
        m2030a(c0308a.mo324d());
        m2026a(c0308a.mo326f().intValue());
        m2028a(c0308a.mo322b());
        this.f.m2468a((Object) "IDLE");
        this.f1386c = new ArrayList();
    }

    public ArrayList m2060l() {
        return this.f1386c;
    }

    public void m2059a(ArrayList arrayList) {
        this.f1386c = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0311c a = ((C0337c) it.next()).m2242a((C0312d) this);
            if (a != null) {
                this.f1386c.add(a);
            }
        }
    }

    public void m2061m() {
        this.b = C0332j.m2148a().m2152a(this);
        this.f.m2468a((Object) "IN PROGRESS");
    }

    public boolean b_() {
        return true;
    }

    public void mo319z() {
    }

    public C0376a mo317A() {
        if (this.h == null) {
            this.h = new C0388m(this);
        }
        return this.h;
    }
}
