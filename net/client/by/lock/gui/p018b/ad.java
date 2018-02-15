package net.client.by.lock.gui.p018b;

/* compiled from: MyApp */
class ad extends Thread {
    final /* synthetic */ ac f1841a;

    ad(ac acVar) {
        this.f1841a = acVar;
    }

    public void run() {
        try {
            this.f1841a.notifyDataSetChanged();
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
