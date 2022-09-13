package com.pad1.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView pesanan;
    TextView pesanan2;
    Button Ok;
    EditText Jumlah;
    public static final String REPLY_EXTRA = "REPLY_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        pesanan = findViewById(R.id.pesanan);
        pesanan2 = findViewById(R.id.pesanan2);
        Ok = findViewById(R.id.OK);
        Jumlah = findViewById(R.id.Jumlah);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_ORDER);
        String message2 = intent.getStringExtra(MainActivity.MESSAGE_ORDER2);
        pesanan.setText(message2);
        pesanan2.setText(message);

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String messageReply = Jumlah.getText().toString();
                intent.putExtra(REPLY_EXTRA,messageReply);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}