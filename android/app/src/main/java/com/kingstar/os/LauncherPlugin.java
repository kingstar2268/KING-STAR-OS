package com.kingstar.os;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Launcher")
public class LauncherPlugin extends Plugin {

    @PluginMethod
    public void openApp(PluginCall call) {
        String app = call.getString("app", "");
        Intent intent;

        switch (app) {
            case "phone":
                intent = new Intent(Intent.ACTION_DIAL);
                break;
            case "messages":
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"));
                break;
            case "camera":
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                break;
            case "gallery":
                intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                break;
            case "settings":
                intent = new Intent(Settings.ACTION_SETTINGS);
                break;
            default:
                call.reject("Unknown application");
                return;
        }

        try {
            getActivity().startActivity(intent);
            call.resolve();
        } catch (Exception e) {
            call.reject("Application is not available", e);
        }
    }
}
