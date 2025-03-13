package com.ayaz.appstopper;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

public class AppBlockerService extends AccessibilityService {

    private static final String TAG = "AppBlockerService";

    // List of blocked apps
    private final String[] blockedApps = {
            "com.instagram.android",
            "com.snapchat.android",
            "com.pubg.imobile",
            "com.tencent.ig",
            "com.pubg.krmobile",
            "com.dts.freefiremax",
            "com.garena.game.ffi"
//            "com.whatsapp",
//            "com.facebook.katana",
//            "com.youtube.android"
    };

    private Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            String packageName = event.getPackageName().toString();
            for (String blocked : blockedApps) {
                if (packageName.equals(blocked)) {
                    Log.d(TAG, "Blocking app: " + packageName);
                    showToast("Blocked: " + packageName);
                    sendToHomeScreen();  // Improved method
                    break;
                }
            }
        }
    }

    private void showToast(final String message) {
        handler.post(() -> Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show());
    }

    private void sendToHomeScreen() {
        Log.d(TAG, "Sending user to home screen");
        performGlobalAction(GLOBAL_ACTION_HOME);  // Use accessibility action to go to home
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "Accessibility Service Interrupted");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo info = getServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
        Log.d(TAG, "Accessibility Service Connected");
    }
}