package net.client.by.lock.gui.activity;

import android.media.AudioManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: MyApp */
class C0401j implements OnCheckedChangeListener {
    private AudioManager f1812a;

    public C0401j(AudioManager audioManager) {
        this.f1812a = audioManager;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1812a.setStreamMute(0, z);
    }
}
