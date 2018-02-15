package net.client.by.lock.task;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import net.client.by.lock.C0322b;
import net.client.by.lock.gui.p017a.C0388m;
import net.client.by.lock.p013b.C0311c;
import net.client.by.lock.p013b.C0313f;
import net.client.by.lock.p013b.C0315h;
import net.client.by.lock.p013b.C0318j;
import net.client.by.lock.p013b.C0319k;
import net.client.by.lock.p013b.C0321n;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0356a;
import net.client.by.lock.p016f.C0360e;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0371p;
import net.client.by.lock.p016f.C0374s;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class SendFileTask extends FileTask {
    private static final String TAG = "SendFileTask";
    C0315h fileTransfer;

    public SendFileTask(Context context, Object obj) {
        super(context, obj);
        this.fileTransfer = (C0315h) obj;
    }

    protected String getUrl() {
        return C0371p.m2516k();
    }

    protected Document getRequest() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    protected Document call() {
        OutputStream outputStream;
        InputStream inputStream;
        Throwable e;
        InputStream inputStream2 = null;
        C0321n c0321n = new C0321n();
        HttpsURLConnection a;
        try {
            a = C0360e.m2462a(getUrl(), this.ctx);
            try {
                Object basicHttpEntity;
                outputStream = a.getOutputStream();
                try {
                    this.ftis = new C0313f(this.fileTransfer);
                    this.ftis.m2008a().m2066a((C0318j) this);
                    initProgress();
                    InputStreamEntity inputStreamEntity = new InputStreamEntity(this.ftis, -1);
                    inputStreamEntity.setChunked(true);
                    inputStreamEntity.writeTo(outputStream);
                    basicHttpEntity = new BasicHttpEntity();
                    inputStream = a.getInputStream();
                } catch (Exception e2) {
                    e = e2;
                    inputStream = null;
                    try {
                        if (isCancelled()) {
                            C0365j.m2476a("Error in sending file", e);
                            if (a != null) {
                                a.disconnect();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (c0321n != null) {
                                c0321n.close();
                            }
                            return null;
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (c0321n != null) {
                            c0321n.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        inputStream2 = inputStream;
                        if (a != null) {
                            a.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (c0321n != null) {
                            c0321n.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (c0321n != null) {
                        c0321n.close();
                    }
                    throw e;
                }
                try {
                    basicHttpEntity.setContent(inputStream);
                    Document a2 = C0374s.m2547a(basicHttpEntity);
                    basicHttpEntity.consumeContent();
                    finalizeProgress();
                    this.ftis.close();
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (c0321n == null) {
                        return a2;
                    }
                    c0321n.close();
                    return a2;
                } catch (Exception e3) {
                    e = e3;
                    if (isCancelled()) {
                        C0365j.m2476a("Error in sending file", e);
                        if (a != null) {
                            a.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (c0321n != null) {
                            c0321n.close();
                        }
                        return null;
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (c0321n != null) {
                        c0321n.close();
                    }
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
                outputStream = null;
                if (isCancelled()) {
                    C0365j.m2476a("Error in sending file", e);
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (c0321n != null) {
                        c0321n.close();
                    }
                    return null;
                }
                if (a != null) {
                    a.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (c0321n != null) {
                    c0321n.close();
                }
                return null;
            } catch (Throwable th3) {
                e = th3;
                outputStream = null;
                if (a != null) {
                    a.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (c0321n != null) {
                    c0321n.close();
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            inputStream = null;
            outputStream = null;
            a = null;
            if (isCancelled()) {
                if (a != null) {
                    a.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (c0321n != null) {
                    c0321n.close();
                }
                return null;
            }
            C0365j.m2476a("Error in sending file", e);
            if (a != null) {
                a.disconnect();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (c0321n != null) {
                c0321n.close();
            }
            return null;
        } catch (Throwable th4) {
            e = th4;
            outputStream = null;
            a = null;
            if (a != null) {
                a.disconnect();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (c0321n != null) {
                c0321n.close();
            }
            throw e;
        }
    }

    protected Object[] onSuccess(Document document) {
        String[] e = C0355d.m2452e(document);
        Boolean valueOf = Boolean.valueOf(false);
        if (this.fileTransfer.mo322b() == null) {
            this.fileTransfer.m2028a(e[0]);
        } else {
            valueOf = Boolean.valueOf(true);
        }
        this.fileTransfer.m1919d(e[1]);
        C0319k.m2069b().m2072a(this.fileTransfer);
        this.fileTransfer.m2039g();
        this.fileTransfer.mo317A().m2553a(8);
        return new Object[]{"onSuccess", valueOf};
    }

    protected void restart() {
        C0332j.m2148a().m2152a(this.fileTransfer);
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess")) {
            try {
                File j = this.fileTransfer.m2042j();
                if (new File(C0356a.m2454a(), j.getName()).exists()) {
                    j.delete();
                }
            } catch (Exception e) {
                C0322b.m2077i(TAG, "file could not be deleted");
            }
            if (((Boolean) objArr[1]).booleanValue()) {
                Iterator it = this.fileTransfer.m2060l().iterator();
                while (it.hasNext()) {
                    C0327e.m2092c().m2094a(((C0311c) it.next()).m2024e()).m2261b(this.fileTransfer);
                }
                return;
            }
            ((C0388m) this.fileTransfer.mo317A()).m2552a();
        }
    }
}
