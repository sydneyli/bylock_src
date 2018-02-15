package net.client.by.lock.p015e;

import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p012d.C0334a;
import net.client.by.lock.p012d.C0335b;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p012d.C0347l;
import net.client.by.lock.p012d.C0349o;
import net.client.by.lock.p012d.C0350q;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p013b.C0314g;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0365j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: MyApp */
public class C0355d {
    private static byte[] m2446a(String str) {
        return C0353b.m2406a(str);
    }

    public static synchronized void m2443a(Document document, Boolean bool) {
        synchronized (C0355d.class) {
            if (bool.booleanValue()) {
                C0327e.m2092c().m2108h();
            }
            NodeList elementsByTagName = document.getElementsByTagName("friend");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Element element = (Element) elementsByTagName.item(i);
                Element element2 = (Element) element.getElementsByTagName("id").item(0);
                Element element3 = (Element) element.getElementsByTagName("username").item(0);
                Element element4 = (Element) element.getElementsByTagName("nickname").item(0);
                Element element5 = (Element) element.getElementsByTagName("name").item(0);
                Element element6 = (Element) element.getElementsByTagName("publicMessage").item(0);
                Element element7 = (Element) element.getElementsByTagName("lastOnlineTime").item(0);
                Element element8 = (Element) element.getElementsByTagName("status").item(0);
                element = (Element) element.getElementsByTagName("modulus").item(0);
                C0337c c0337c = new C0337c();
                if (element3 != null) {
                    c0337c.m2263c(element3.getTextContent());
                }
                if (element4 != null) {
                    c0337c.m2265d(element4.getTextContent());
                }
                if (element5 != null) {
                    c0337c.m2269f(element5.getTextContent());
                }
                if (element6 != null) {
                    c0337c.m2258b(element6.getTextContent());
                }
                if (element7 != null && element7.getTextContent().length() > 0) {
                    c0337c.m2267e(element7.getTextContent());
                }
                if (element8 != null) {
                    try {
                        c0337c.m2243a(Integer.parseInt(element8.getTextContent()));
                    } catch (Exception e) {
                    }
                }
                if (element != null) {
                    c0337c.m2252a(C0355d.m2446a(element.getTextContent()));
                }
                if (element2 != null) {
                    try {
                        c0337c.m2256b(Integer.parseInt(element2.getTextContent()));
                    } catch (Exception e2) {
                    }
                }
                C0327e.m2092c().m2099a(c0337c);
            }
        }
    }

    public static void m2445a(Document document, C0347l c0347l) {
        Element documentElement = document.getDocumentElement();
        Element element = (Element) documentElement.getElementsByTagName("id").item(0);
        if (element == null) {
            c0347l.m1921f("No mail id in response!");
        } else if (element.getTextContent().equals(c0347l.m2321j())) {
            element = (Element) documentElement.getElementsByTagName("subject").item(0);
            Element element2 = (Element) documentElement.getElementsByTagName("body").item(0);
            Element element3 = (Element) documentElement.getElementsByTagName("other-recipients").item(0);
            Element element4 = (Element) documentElement.getElementsByTagName("mail-signature").item(0);
            if (element == null || element2 == null || element4 == null) {
                c0347l.m1921f("some fields are missing!");
                return;
            }
            c0347l.m2328a(C0355d.m2446a(element.getTextContent()), C0355d.m2446a(element2.getTextContent()), C0355d.m2446a(element4.getTextContent()));
            if (element3 == null || element3.getTextContent() == null || element3.getTextContent().length() <= 0) {
                c0347l.m2317b(new byte[0]);
            } else {
                c0347l.m2317b(C0355d.m2446a(element3.getTextContent()));
            }
            NodeList elementsByTagName = documentElement.getElementsByTagName("attachment");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                element = (Element) elementsByTagName.item(i);
                element2 = (Element) element.getElementsByTagName("fileId").item(0);
                element4 = (Element) element.getElementsByTagName("filename").item(0);
                Element element5 = (Element) element.getElementsByTagName("filesize").item(0);
                documentElement = (Element) element.getElementsByTagName("key").item(0);
                Element element6 = (Element) element.getElementsByTagName("iv").item(0);
                Element element7 = (Element) element.getElementsByTagName("signature").item(0);
                if (!(element2 == null || element4 == null || documentElement == null || element6 == null || element7 == null)) {
                    c0347l.m2315a(new C0334a(element2.getTextContent(), c0347l.m1910B(), C0355d.m2446a(element4.getTextContent()), C0355d.m2446a(documentElement.getTextContent()), C0355d.m2446a(element6.getTextContent()), C0355d.m2446a(element7.getTextContent()), Integer.parseInt(element5.getTextContent())));
                }
            }
            if (c0347l.m1913E().m2285u() == null) {
                return;
            }
            if (!c0347l.m1913E().m2285u().m2297a(c0347l)) {
                c0347l.m1921f("Cannot verify mail!");
            } else if (c0347l.m2331d()) {
                c0347l.m1920e("COMPLETED");
            } else {
                c0347l.m1921f("Cannot decrypt mail!");
            }
        } else {
            c0347l.m1921f("id values do not match!");
        }
    }

    public static ArrayList m2441a(Document document) {
        NodeList elementsByTagName = document.getElementsByTagName("fileTransfer");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Element element = (Element) elementsByTagName.item(i);
            Element element2 = (Element) element.getElementsByTagName("fileTransferId").item(0);
            if (element2 != null) {
                String textContent = element2.getTextContent();
                if (textContent.length() != 0) {
                    element2 = (Element) element.getElementsByTagName("fileId").item(0);
                    Element element3 = (Element) element.getElementsByTagName("senderId").item(0);
                    Element element4 = (Element) element.getElementsByTagName("filename").item(0);
                    Element element5 = (Element) element.getElementsByTagName("fileSize").item(0);
                    Element element6 = (Element) element.getElementsByTagName("key").item(0);
                    Element element7 = (Element) element.getElementsByTagName("iv").item(0);
                    Element element8 = (Element) element.getElementsByTagName("signature").item(0);
                    element = (Element) element.getElementsByTagName("sentTime").item(0);
                    if (element2 == null || element3 == null || element4 == null || element5 == null || element6 == null || element7 == null || element8 == null || element == null) {
                        C0332j.m2148a().m2179d(textContent);
                    } else {
                        C0337c a;
                        try {
                            a = C0327e.m2092c().m2094a(Integer.valueOf(Integer.parseInt(element3.getTextContent())));
                        } catch (Exception e) {
                            a = null;
                        }
                        if (a == null) {
                            C0332j.m2148a().m2179d(textContent);
                        } else if (a.m2285u() == null) {
                            C0332j.m2148a().m2179d(textContent);
                        } else {
                            C0314g c0314g = new C0314g();
                            c0314g.m2035c(textContent);
                            c0314g.m2028a(element2.getTextContent());
                            c0314g.m1918b(a);
                            c0314g.m2047a(C0355d.m2446a(element4.getTextContent()));
                            try {
                                c0314g.m2026a(Integer.parseInt(element5.getTextContent()));
                                c0314g.m2048b(C0355d.m2446a(element6.getTextContent()));
                                c0314g.m2049c(C0355d.m2446a(element7.getTextContent()));
                                c0314g.m2050d(C0355d.m2446a(element8.getTextContent()));
                                c0314g.m1919d(element.getTextContent());
                                arrayList.add(c0314g);
                            } catch (NumberFormatException e2) {
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static ArrayList m2442a(Document document, C0337c c0337c) {
        ArrayList arrayList = new ArrayList();
        NodeList elementsByTagName = document.getDocumentElement().getElementsByTagName("chat");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Element element = (Element) elementsByTagName.item(i);
            NodeList elementsByTagName2 = element.getElementsByTagName("id");
            if (!(elementsByTagName2 == null || elementsByTagName2.getLength() == 0)) {
                String trim = elementsByTagName2.item(0).getTextContent().trim();
                if (trim.length() != 0) {
                    Integer.valueOf(-1);
                    try {
                        Integer valueOf = Integer.valueOf(Integer.parseInt(trim));
                        elementsByTagName2 = element.getElementsByTagName("ciphertext");
                        if (!(elementsByTagName2 == null || elementsByTagName2.getLength() == 0)) {
                            trim = elementsByTagName2.item(0).getTextContent().trim();
                            if (trim.length() != 0) {
                                NodeList elementsByTagName3 = element.getElementsByTagName("signature");
                                if (!(elementsByTagName3 == null || elementsByTagName3.getLength() == 0)) {
                                    String trim2 = elementsByTagName3.item(0).getTextContent().trim();
                                    if (trim2.length() != 0) {
                                        NodeList elementsByTagName4 = element.getElementsByTagName("sentTime");
                                        if (!(elementsByTagName4 == null || elementsByTagName4.getLength() == 0)) {
                                            String trim3 = elementsByTagName4.item(0).getTextContent().trim();
                                            if (trim3.length() != 0) {
                                                arrayList.add(new C0335b(c0337c, valueOf, C0355d.m2446a(trim), C0355d.m2446a(trim2), trim3));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        return arrayList;
    }

    public static ArrayList m2448b(Document document) {
        ArrayList arrayList = new ArrayList();
        if (document == null) {
            System.out.println("A possible bug around...");
        } else {
            NodeList elementsByTagName = document.getDocumentElement().getElementsByTagName("event");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                try {
                    Element element = (Element) elementsByTagName.item(i);
                    C0349o c0349o = new C0349o();
                    c0349o.m2345a(element.getElementsByTagName("type").item(0).getTextContent());
                    c0349o.m2344a(Integer.parseInt(element.getElementsByTagName("friendUserId").item(0).getTextContent()));
                    c0349o.m2348b(element.getElementsByTagName("parameter").item(0).getTextContent());
                    c0349o.m2347b(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
                    arrayList.add(c0349o);
                } catch (Exception e) {
                }
            }
        }
        return arrayList;
    }

    public static String[] m2447a(Document document, C0289c c0289c) {
        Element documentElement = document.getDocumentElement();
        Element element = (Element) documentElement.getElementsByTagName("callId").item(0);
        if (element == null) {
            return null;
        }
        Element element2 = (Element) documentElement.getElementsByTagName("nonce").item(0);
        if (element2 == null) {
            return null;
        }
        String textContent;
        Element element3 = (Element) documentElement.getElementsByTagName("callTime").item(0);
        String str = "";
        if (element3 != null) {
            textContent = element3.getTextContent();
        } else {
            textContent = str;
        }
        str = element.getTextContent();
        String textContent2 = element2.getTextContent();
        return new String[]{str, textContent2, textContent};
    }

    public static String[] m2449b(Document document, C0289c c0289c) {
        try {
            Element documentElement = document.getDocumentElement();
            String textContent = documentElement.getElementsByTagName("sessionKey").item(0).getTextContent();
            String textContent2 = documentElement.getElementsByTagName("sessionIv").item(0).getTextContent();
            String textContent3 = documentElement.getElementsByTagName("signature").item(0).getTextContent();
            int parseInt = Integer.parseInt(documentElement.getElementsByTagName("port").item(0).getTextContent());
            if (textContent.length() > 0 && textContent2.length() > 0 && textContent3.length() > 0 && parseInt > 0) {
                return new String[]{textContent, textContent2, textContent3, r4};
            }
        } catch (Throwable e) {
            C0365j.m2476a("", e);
        }
        return null;
    }

    public static void m2450c(Document document) {
        Element documentElement = document.getDocumentElement();
        NodeList elementsByTagName = documentElement.getElementsByTagName("userId");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            C0330h.m2111a().m2114a("Packet error: No UserId!");
            return;
        }
        try {
            C0351r.m2359i().m2362a(Integer.parseInt(elementsByTagName.item(0).getTextContent()));
            elementsByTagName = documentElement.getElementsByTagName("name");
            if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
                C0330h.m2111a().m2114a("Packet error: No Name");
                return;
            }
            Element element;
            Element element2;
            String textContent = elementsByTagName.item(0).getTextContent();
            NodeList elementsByTagName2 = documentElement.getElementsByTagName("publicMessage");
            if (elementsByTagName2 == null || elementsByTagName2.getLength() == 0) {
                C0330h.m2111a().m2114a("Packet error: No PublicMessage!");
            }
            C0351r.m2359i().m2387i(elementsByTagName2.item(0).getTextContent());
            C0351r.m2359i().m2384g(textContent);
            elementsByTagName = documentElement.getElementsByTagName("status");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                try {
                    C0351r.m2359i().m2363a(Integer.valueOf(Integer.parseInt(elementsByTagName.item(0).getTextContent())));
                } catch (Throwable e) {
                    C0365j.m2476a("ResponseParser", e);
                }
            }
            elementsByTagName = documentElement.getElementsByTagName("admin");
            if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
                C0351r.m2359i().m2372b(false);
            } else {
                C0351r.m2359i().m2372b(Integer.parseInt(elementsByTagName.item(0).getTextContent()) == 1);
            }
            if (documentElement.getElementsByTagName("privateExponent").getLength() > 0 && documentElement.getElementsByTagName("modulus").getLength() > 0) {
                C0351r.m2359i().m2366a(new C0350q(C0355d.m2446a(documentElement.getElementsByTagName("modulus").item(0).getTextContent()), C0355d.m2446a(documentElement.getElementsByTagName("privateExponent").item(0).getTextContent())));
            }
            C0355d.m2443a(document, Boolean.valueOf(true));
            NodeList elementsByTagName3 = document.getElementsByTagName("group");
            for (int i = 0; i < elementsByTagName3.getLength(); i++) {
                element = (Element) elementsByTagName3.item(i);
                element2 = (Element) element.getElementsByTagName("id").item(0);
                try {
                    Integer valueOf = Integer.valueOf(Integer.parseInt(element2.getTextContent()));
                    documentElement = (Element) element.getElementsByTagName("name").item(0);
                    if (element2 != null && element2.getTextContent().length() > 0 && documentElement != null && documentElement.getTextContent().length() > 0) {
                        C0327e.m2092c().m2100a(new C0341g(valueOf.intValue(), documentElement.getTextContent()));
                    }
                    NodeList elementsByTagName4 = element.getElementsByTagName("userId");
                    for (int i2 = 0; i2 < elementsByTagName4.getLength(); i2++) {
                        Integer valueOf2;
                        element = (Element) elementsByTagName4.item(i2);
                        Integer valueOf3 = Integer.valueOf(-1);
                        try {
                            valueOf2 = Integer.valueOf(Integer.parseInt(element.getTextContent()));
                        } catch (Throwable e2) {
                            C0365j.m2476a("", e2);
                            valueOf2 = valueOf3;
                        }
                        if (valueOf2.intValue() > 0) {
                            C0327e.m2092c().m2097a(valueOf2, valueOf);
                        }
                    }
                } catch (Throwable e22) {
                    C0365j.m2476a("", e22);
                }
            }
            if (C0351r.m2359i().m2394p() != null) {
                Iterator it = C0355d.m2441a(document).iterator();
                while (it.hasNext()) {
                    C0314g c0314g = (C0314g) it.next();
                    if (!c0314g.m1913E().m2254a(c0314g)) {
                        C0332j.m2148a().m2179d(c0314g.m2041i());
                    }
                }
                NodeList elementsByTagName5 = document.getElementsByTagName("chat");
                for (int i3 = 0; i3 < elementsByTagName5.getLength(); i3++) {
                    element = (Element) elementsByTagName5.item(i3);
                    documentElement = (Element) element.getElementsByTagName("id").item(0);
                    element2 = (Element) element.getElementsByTagName("senderUserId").item(0);
                    Element element3 = (Element) element.getElementsByTagName("ciphertext").item(0);
                    Element element4 = (Element) element.getElementsByTagName("signature").item(0);
                    Element element5 = (Element) element.getElementsByTagName("sentTime").item(0);
                    if (!(documentElement == null || element2 == null || element3 == null || element4 == null || element5 == null)) {
                        try {
                            C0337c a = C0327e.m2092c().m2094a(Integer.valueOf(Integer.parseInt(element2.getTextContent())));
                            if (a != null) {
                                a.m2250a(new C0335b(a, Integer.valueOf(Integer.parseInt(documentElement.getTextContent())), C0355d.m2446a(element3.getTextContent()), C0355d.m2446a(element4.getTextContent()), element5.getTextContent()));
                            }
                        } catch (Throwable e222) {
                            C0365j.m2476a("", e222);
                        }
                    }
                }
            }
        } catch (NumberFormatException e3) {
            C0330h.m2111a().m2114a("Packet error: UserId is not numeric!");
        }
    }

    public static boolean m2451d(Document document) {
        String str;
        String str2 = null;
        Element documentElement = document.getDocumentElement();
        NodeList elementsByTagName = documentElement.getElementsByTagName("userId");
        if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
            str = null;
        } else {
            str = elementsByTagName.item(0).getTextContent();
        }
        NodeList elementsByTagName2 = documentElement.getElementsByTagName("error");
        if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
            str2 = elementsByTagName2.item(0).getTextContent();
        }
        if (str != null || str2 == null) {
            try {
                C0351r.m2359i().m2362a(Integer.parseInt(str));
                return true;
            } catch (NumberFormatException e) {
                C0330h.m2111a().m2114a("Packet error: UserID is not numeric!");
                return false;
            }
        }
        C0330h.m2111a().m2114a(str2);
        return false;
    }

    public static String[] m2452e(Document document) {
        String textContent;
        String str = "";
        String str2 = "";
        Element element = (Element) document.getElementsByTagName("time").item(0);
        if (element != null) {
            str2 = element.getTextContent();
        }
        element = (Element) document.getElementsByTagName("fileId").item(0);
        if (element != null) {
            textContent = element.getTextContent();
        } else {
            textContent = str;
        }
        return new String[]{textContent, str2};
    }

    public static String m2453f(Document document) {
        Element element = (Element) document.getElementsByTagName("time").item(0);
        if (element != null) {
            return element.getTextContent();
        }
        return "";
    }

    public static void m2444a(Document document, Object obj) {
        Element element = (Element) document.getElementsByTagName("groupId").item(0);
        if (element != null) {
            String str = (String) ((ArrayList) obj).get(0);
            C0337c c0337c = (C0337c) ((ArrayList) obj).get(1);
            int parseInt = Integer.parseInt(element.getTextContent());
            C0327e.m2092c().m2100a(new C0341g(parseInt, str));
            C0327e.m2092c().m2097a(Integer.valueOf(c0337c.m2237K()), Integer.valueOf(parseInt));
        }
    }
}
