package com.example.calling;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText txt;
Button calling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(EditText)findViewById(R.id.no);
        calling=(Button)findViewById(R.id.dial);

        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1=txt.getText().toString();
                if(TextUtils.isEmpty(txt1))
                {
                    txt.setError("Enter No");
                }

                else
                {
                    if(ContextCompat.checkSelfPermission( MainActivity.this, Manifest.permission.CALL_PHONE)!=
                    PackageManager.PERMISSION_GRANTED)
                    {

                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                    }
                    else
                    {
                        Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+txt1));
                        startActivity(i);
                    }
                }


            }
        });

    }
}
