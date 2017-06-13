package com.example.admin.tp9_sms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void Envoyer(EditText num, EditText mes){
        String uri = "smsto:" + num.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
        intent.putExtra("sms_body", mes.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_main));

        final EditText text = (EditText) findViewById(R.id.textmessage);
        final EditText numero = (EditText) findViewById(R.id.numTel);
        final Button envoyerSms = (Button) findViewById(R.id.envoyer);

        envoyerSms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                Envoyer(numero,text);
            }
        });

    }

}
