package com.example.dentalmanager;

import static android.app.backup.BackupAgent.FLAG_CLIENT_SIDE_ENCRYPTION_ENABLED;
import static android.app.backup.BackupAgent.FLAG_DEVICE_TO_DEVICE_TRANSFER;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.BackupDataOutput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;


public class AboutActivity extends AppCompatActivity {


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
//////////////////////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////////////////////
    @RequiresApi(api = Build.VERSION_CODES.P)

    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
                         ParcelFileDescriptor newState) throws IOException {
        if ((data.getTransportFlags() &
                FLAG_CLIENT_SIDE_ENCRYPTION_ENABLED) != 0) {
            // Client-side backup encryption is enabled.
        }

        if ((data.getTransportFlags() &
                FLAG_DEVICE_TO_DEVICE_TRANSFER) != 0) {
            // Local device-to-device transfer is enabled.
        }
    }

    // Implementation of onRestore() here.
}





