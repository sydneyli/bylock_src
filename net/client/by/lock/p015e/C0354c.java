package net.client.by.lock.p015e;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import javax.xml.parsers.DocumentBuilderFactory;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p012d.C0334a;
import net.client.by.lock.p012d.C0335b;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p012d.C0348n;
import net.client.by.lock.p012d.C0350q;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0368m;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* compiled from: MyApp */
public class C0354c {
    private static String m2436e(byte[] bArr) {
        return C0353b.m2405a(bArr);
    }

    public static Document m2407a() {
        try {
            Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element createElement = newDocument.createElement("request");
            if (C0351r.m2359i().m2388j() != null) {
                createElement.setAttribute("id", C0351r.m2359i().m2388j());
            }
            newDocument.appendChild(createElement);
            Node createElement2 = newDocument.createElement("username");
            createElement2.appendChild(newDocument.createTextNode(C0351r.m2359i().m2389k()));
            createElement.appendChild(createElement2);
            createElement2 = newDocument.createElement("password");
            createElement2.setTextContent(C0368m.m2483a(C0351r.m2359i().m2390l()));
            Node createElement3 = newDocument.createElement("edition");
            createElement3.setTextContent("android");
            createElement.appendChild(createElement2);
            createElement.appendChild(createElement3);
            createElement2 = newDocument.createElement("version");
            createElement2.setTextContent("0.8-24");
            createElement.appendChild(createElement2);
            createElement2 = newDocument.createElement("tzid");
            createElement2.setTextContent(TimeZone.getDefault().getID());
            createElement.appendChild(createElement2);
            createElement2 = newDocument.createElement("audioV2");
            createElement2.setTextContent("1");
            createElement.appendChild(createElement2);
            return newDocument;
        } catch (Throwable e) {
            C0365j.m2476a("RequestBuilder: Error in creating xml for request", e);
            return null;
        }
    }

    public static Document m2421b() {
        int i = 0;
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        for (String str : C0351r.m2359i().m2378d()) {
            Node createElement = d.createElement("mailId");
            createElement.setTextContent(str);
            documentElement.appendChild(createElement);
        }
        String[] e = C0351r.m2359i().m2380e();
        int length = e.length;
        while (i < length) {
            String str2 = e[i];
            Node createElement2 = d.createElement("fileTransferId");
            createElement2.setTextContent(str2);
            documentElement.appendChild(createElement2);
            i++;
        }
        for (Entry entry : C0351r.m2359i().m2373c()) {
            Node createElement3 = d.createElement("lastChatId");
            createElement2 = d.createElement("friendUserId");
            createElement2.setTextContent(new StringBuilder(String.valueOf(((C0337c) entry.getKey()).m2237K())).toString());
            createElement3.appendChild(createElement2);
            Node createElement4 = d.createElement("chatId");
            createElement4.setTextContent(entry.getValue());
            createElement3.appendChild(createElement4);
            documentElement.appendChild(createElement3);
        }
        return d;
    }

    public static Document m2427c() {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("message");
        createElement.setTextContent((String) C0351r.m2359i().m2393o().m2467a());
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2414a(C0335b c0335b) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        C0337c E = c0335b.m1913E();
        Node createElement = d.createElement("toUserId");
        createElement.setTextContent(new StringBuilder(String.valueOf(E.m2237K())).toString());
        documentElement.appendChild(createElement);
        Node createElement2 = d.createElement("ciphertext");
        createElement2.setTextContent(C0354c.m2436e(c0335b.m2214e()));
        documentElement.appendChild(createElement2);
        createElement2 = d.createElement("signature");
        createElement2.setTextContent(C0354c.m2436e(c0335b.m2215f()));
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2410a(Integer num, String[] strArr, String[] strArr2, Set set) {
        int i = 0;
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("lastEventId");
        createElement.setTextContent(num);
        documentElement.appendChild(createElement);
        for (String str : strArr) {
            Node createElement2 = d.createElement("mailId");
            createElement2.setTextContent(str);
            documentElement.appendChild(createElement2);
        }
        int length = strArr2.length;
        while (i < length) {
            String str2 = strArr2[i];
            Node createElement3 = d.createElement("fileTransferId");
            createElement3.setTextContent(str2);
            documentElement.appendChild(createElement3);
            i++;
        }
        for (Entry entry : set) {
            createElement3 = d.createElement("lastChatId");
            createElement2 = d.createElement("friendUserId");
            createElement2.setTextContent(new StringBuilder(String.valueOf(((C0337c) entry.getKey()).m2237K())).toString());
            createElement3.appendChild(createElement2);
            Node createElement4 = d.createElement("chatId");
            createElement4.setTextContent(entry.getValue());
            createElement3.appendChild(createElement4);
            documentElement.appendChild(createElement3);
        }
        return d;
    }

    public static Document m2415a(C0337c c0337c) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("lastChatId");
        createElement.setTextContent(c0337c.m2276l());
        Node createElement2 = d.createElement("fromUserId");
        createElement2.setTextContent(new StringBuilder(String.valueOf(c0337c.m2237K())).toString());
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2433d() {
        try {
            Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Object createElement = newDocument.createElement("request");
            if (C0351r.m2359i().m2388j() != null) {
                createElement.setAttribute("id", C0351r.m2359i().m2388j());
            }
            newDocument.appendChild(createElement);
            Node createElement2 = newDocument.createElement("userId");
            createElement2.appendChild(newDocument.createTextNode(new StringBuilder(String.valueOf(C0351r.m2359i().m2391m())).toString()));
            createElement.appendChild(createElement2);
            return newDocument;
        } catch (Throwable e) {
            C0365j.m2476a("Error in creating xml for request", e);
            return null;
        }
    }

    public static Document m2420a(String[] strArr) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("username");
        createElement.setTextContent(strArr[0]);
        Node createElement2 = d.createElement("nickname");
        createElement2.setTextContent(strArr[1]);
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2408a(Integer num) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("friendUserId");
        createElement.setTextContent(num);
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2425b(C0337c c0337c) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("friendUserId");
        createElement.setTextContent(new StringBuilder(String.valueOf(c0337c.m2237K())).toString());
        Node createElement2 = d.createElement("friendNickname");
        createElement2.setTextContent(c0337c.m2230D());
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2431c(C0337c c0337c) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("friendUserId");
        createElement.setTextContent(new StringBuilder(String.valueOf(c0337c.m2237K())).toString());
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2411a(String str) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("fileId");
        createElement.setTextContent(str);
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2424b(String str) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("fileTransferId");
        createElement.setTextContent(str);
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2430c(String str) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("fileTransferId");
        createElement.setTextContent(str);
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2437e() {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("password");
        createElement.setTextContent(C0368m.m2483a(C0351r.m2359i().m2390l()));
        Node createElement2 = d.createElement("privateExponent");
        createElement2.setTextContent(C0354c.m2436e(C0351r.m2359i().m2394p().mo330d()));
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2413a(C0289c c0289c) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("calleeUserId");
        createElement.setTextContent(new StringBuilder(String.valueOf(c0289c.m1913E().m2237K())).toString());
        Node createElement2 = d.createElement("sessionKey");
        createElement2.setTextContent(C0354c.m2436e(c0289c.m1944f()));
        Node createElement3 = d.createElement("sessionIv");
        createElement3.setTextContent(C0354c.m2436e(c0289c.m1945g()));
        Node createElement4 = d.createElement("signature");
        createElement4.setTextContent(C0354c.m2436e(c0289c.m1946h()));
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        documentElement.appendChild(createElement3);
        documentElement.appendChild(createElement4);
        return d;
    }

    public static Document m2419a(byte[] bArr) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("callId");
        createElement.setTextContent(C0365j.m2475a(bArr));
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2426b(byte[] bArr) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("callId");
        createElement.setTextContent(C0365j.m2475a(bArr));
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2432c(byte[] bArr) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("callId");
        createElement.setTextContent(C0365j.m2475a(bArr));
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2435d(byte[] bArr) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("callId");
        createElement.setTextContent(C0365j.m2475a(bArr));
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2416a(C0337c c0337c, String str) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("friendUserId");
        createElement.setTextContent(new StringBuilder(String.valueOf(c0337c.m2237K())).toString());
        Node createElement2 = d.createElement("groupName");
        createElement2.setTextContent(str);
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2422b(Integer num) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("groupId");
        createElement.setTextContent(num);
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2417a(C0341g c0341g) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("groupId");
        createElement.setTextContent(new StringBuilder(String.valueOf(c0341g.m2301a())).toString());
        Node createElement2 = d.createElement("groupName");
        createElement2.setTextContent((String) c0341g.m2303b().m2467a());
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2439f() {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("password");
        createElement.setTextContent(C0368m.m2483a(C0351r.m2359i().m2390l()));
        Node createElement2 = d.createElement("privateExponent");
        createElement2.setTextContent(C0354c.m2436e(C0351r.m2359i().m2394p().mo330d()));
        Node createElement3 = d.createElement("modulus");
        createElement3.setTextContent(C0354c.m2436e(C0351r.m2359i().m2394p().m2298a()));
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        documentElement.appendChild(createElement3);
        return d;
    }

    public static Document m2418a(C0348n c0348n) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Iterator it = c0348n.m2339c().iterator();
        while (it.hasNext()) {
            C0348n c0348n2 = (C0348n) it.next();
            Node createElement = d.createElement("mail");
            Node createElement2 = d.createElement("toUserId");
            createElement2.setTextContent(new StringBuilder(String.valueOf(c0348n2.m1913E().m2237K())).toString());
            createElement.appendChild(createElement2);
            createElement2 = d.createElement("subject");
            createElement2.setTextContent(C0354c.m2436e(c0348n2.m2322k()));
            createElement.appendChild(createElement2);
            createElement2 = d.createElement("body");
            createElement2.setTextContent(C0354c.m2436e(c0348n2.m2323l()));
            createElement.appendChild(createElement2);
            createElement2 = d.createElement("other-recipients");
            createElement2.setTextContent(C0354c.m2436e(c0348n2.m2325n()));
            createElement.appendChild(createElement2);
            createElement2 = d.createElement("mail-signature");
            createElement2.setTextContent(C0354c.m2436e(c0348n2.m2320i()));
            createElement.appendChild(createElement2);
            Iterator it2 = c0348n2.m2324m().iterator();
            while (it2.hasNext()) {
                C0334a c0334a = (C0334a) it2.next();
                Node createElement3 = d.createElement("attachment");
                Node createElement4 = d.createElement("fileId");
                createElement4.setTextContent(c0334a.mo322b());
                createElement3.appendChild(createElement4);
                createElement4 = d.createElement("filename");
                createElement4.setTextContent(C0354c.m2436e(c0334a.m2203g()));
                createElement3.appendChild(createElement4);
                createElement4 = d.createElement("key");
                createElement4.setTextContent(C0354c.m2436e(c0334a.m2204h()));
                createElement3.appendChild(createElement4);
                createElement4 = d.createElement("iv");
                createElement4.setTextContent(C0354c.m2436e(c0334a.m2205i()));
                createElement3.appendChild(createElement4);
                createElement4 = d.createElement("signature");
                createElement4.setTextContent(C0354c.m2436e(c0334a.m2206j()));
                createElement3.appendChild(createElement4);
                createElement.appendChild(createElement3);
            }
            documentElement.appendChild(createElement);
        }
        return d;
    }

    public static Document m2434d(String str) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("mailId");
        createElement.setTextContent(str);
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2438e(String str) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("mailId");
        createElement.setTextContent(str);
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2428c(Integer num) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("status");
        createElement.setTextContent(num.toString());
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2440f(String str) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("name");
        createElement.setTextContent(str);
        documentElement.appendChild(createElement);
        return d;
    }

    public static Document m2409a(Integer num, Integer num2) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("senderId");
        createElement.setTextContent(num);
        Node createElement2 = d.createElement("chatId");
        createElement2.setTextContent(num2);
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2423b(Integer num, Integer num2) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("friendUserId");
        createElement.setTextContent(num);
        Node createElement2 = d.createElement("groupId");
        createElement2.setTextContent(num2);
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2429c(Integer num, Integer num2) {
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("friendUserId");
        createElement.setTextContent(num);
        Node createElement2 = d.createElement("groupId");
        createElement2.setTextContent(num2);
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        return d;
    }

    public static Document m2412a(String str, String str2) {
        C0351r.m2359i().m2382f(str2);
        C0351r.m2359i().m2366a(new C0350q());
        Document d = C0354c.m2433d();
        Element documentElement = d.getDocumentElement();
        Node createElement = d.createElement("username");
        createElement.setTextContent(str);
        Node createElement2 = d.createElement("password");
        createElement2.setTextContent(C0368m.m2483a(str2));
        Node createElement3 = d.createElement("privateExponent");
        createElement3.setTextContent(C0354c.m2436e(C0351r.m2359i().m2394p().mo330d()));
        Node createElement4 = d.createElement("modulus");
        createElement4.setTextContent(C0354c.m2436e(C0351r.m2359i().m2394p().m2298a()));
        Node createElement5 = d.createElement("edition");
        createElement5.setTextContent("android");
        Node createElement6 = d.createElement("tzid");
        createElement6.setTextContent(TimeZone.getDefault().getID());
        Node createElement7 = d.createElement("audioV2");
        createElement7.setTextContent("1");
        documentElement.appendChild(createElement);
        documentElement.appendChild(createElement2);
        documentElement.appendChild(createElement3);
        documentElement.appendChild(createElement4);
        documentElement.appendChild(createElement5);
        documentElement.appendChild(createElement6);
        documentElement.appendChild(createElement7);
        return d;
    }
}
