package com.kingstar.os;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(LauncherPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
