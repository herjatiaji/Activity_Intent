package com.pad1.activity_intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText addOrder;
    Button buttonMakanan;
    Button buttonMinuman;
    TextView Hasil;
    public static final String MESSAGE_ORDER = "MESSAGE_KEY";
    public static final String MESSAGE_ORDER2 = "MESSAGE_KEY2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addOrder = findViewById(R.id.addOrder);
        buttonMakanan = findViewById(R.id.buttonMakanan);
        buttonMinuman = findViewById(R.id.buttonMinuman);
        Hasil = findViewById(R.id.Hasil);

        buttonMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String message = addOrder.getText().toString();
                String message2 = "MAKANAN";
                intent.putExtra(MESSAGE_ORDER2, message2);
                intent.putExtra(MESSAGE_ORDER, message);
                launcher.launch(intent);

            }
        });

        buttonMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String message = addOrder.getText().toString();
                String message2 = "MINUMAN";
                intent.putExtra(MESSAGE_ORDER2, message2);
                intent.putExtra(MESSAGE_ORDER, message);
                launcher.launch(intent);

            }
        });
    }
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    if (o.getResultCode() == RESULT_OK){
                        String replytext = o.getData().getStringExtra(SecondActivity.REPLY_EXTRA);
                        Hasil.setText(replytext);
                    }
                }
            });
}