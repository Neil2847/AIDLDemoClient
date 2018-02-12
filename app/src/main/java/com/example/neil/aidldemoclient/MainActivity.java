package com.example.neil.aidldemoclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.neil.aidldemo.IMyAidlInterface;
import com.example.neil.aidldemo.User;

public class MainActivity extends AppCompatActivity {

    private IMyAidlInterface iMyAidlInterface;
    private Button touchMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        touchMe = findViewById(R.id.touch_me);

        Intent intent = new Intent("com.example.neil.aidldemo.IMyAidlInterface");
        //Android5.0后无法只通过隐式Intent绑定远程Service
        intent.setPackage("com.example.neil.aidldemo");

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        },BIND_AUTO_CREATE);


        touchMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    touchMe.setText(iMyAidlInterface.getName().toString());

                    User user =iMyAidlInterface.getUserData("Chien-Li Chen");
                    Log.e("AIDL","Address :"+user.getAddress());
                    Log.e("AIDL","Mail :"+user.getMail());
                    Log.e("AIDL","Nickname :"+user.getNickname());
                    Log.e("AIDL","phoneNumber :"+user.getPhoneNumber());

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
