package net.client.by.lock.gui.activity;

import android.media.AudioManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: MyApp */
class C0403l implements OnCheckedChangeListener {
    private AudioManager f1816a;

    public C0403l(AudioManager audioManager) {
        this.f1816a = audioManager;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1816a.setSpeakerphoneOn(z);
    }
}
