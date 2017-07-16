package android.soundgear;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

import static android.content.Context.AUDIO_SERVICE;

/**
 * Created by Asus on 16.07.2017.
 */

public class TimeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ((AudioManager)context.getSystemService(AUDIO_SERVICE)).setRingerMode(AudioManager.RINGER_MODE_SILENT);
        Toast.makeText(context, "Sound off", Toast.LENGTH_SHORT).show();
    }
}
