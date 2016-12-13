package com.abir.callhimagain;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abir.callhimagain.util.CallDetectService;

public class MainActivity extends AppCompatActivity {

    private Button btnCall;
    private EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = (Button) findViewById(R.id.btnCall);
        etNumber = (EditText) findViewById(R.id.etNumber);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "tel:" + etNumber.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
                // ToDo - need to add runtime permission
                startActivity(intent);
            }
        });

        Intent intent = new Intent(this, CallDetectService.class);
        startService(intent);
    }
}
