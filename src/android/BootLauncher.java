package fr.edps.cordova.bootlauncher;

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;

public class BootLauncher extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, com.ionicframework.ohmifismartsync137505.MainActivity.class);
        serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(serviceIntent);
    }

    @Override
    protected void onPause(Context context, Intent intent)
    {
      super.onPause();
      Intent mStartActivity = new Intent(context, com.ionicframework.ohmifismartsync137505.MainActivity.class);
      int mPendingIntentId = 123456;
      mStartActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
      PendingIntent mPendingIntent = PendingIntent.getActivity(context, mPendingIntentId, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
      AlarmManager mgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
      mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 10000, mPendingIntent);
   }
}
