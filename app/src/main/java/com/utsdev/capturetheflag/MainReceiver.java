package com.utsdev.capturetheflag;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.utsdev.capturetheflag.beaconkeeper.content.BeaconEntity;
import com.utsdev.capturetheflag.beaconkeeper.receiver.BeaconReceiver;
import com.utsdev.capturetheflag.beaconkeeper.service.BeaconService;

public class MainReceiver extends BeaconReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            BeaconService.onBootCompleted(context);
            android.util.Log.d("MainReceiver", "onBootCompleted");
        } else {
            super.onReceive(context, intent);
        }
    }

    @Override
    protected void onFoundBeacon(Context context, BeaconEntity beaconEntity) {
        Log.d("MainReceiver", "onFoundBeacon | " + beaconEntity.getIBeacon());
    }

}
