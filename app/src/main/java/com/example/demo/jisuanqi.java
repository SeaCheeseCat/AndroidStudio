package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class jisuanqi extends AppCompatActivity {

    private EditText editText;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jisuanqi);

        Button button = findViewById(R.id.jisuan);
        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n=Integer.parseInt(editText.getText().toString());
                int sum=0;
                for(int i=0;i<=n;i++) {
                    Log.i("sum=",Integer.toString(sum));
                    sum+=i;


                }

                editText1.setText("从0 加到"+n+"的总和是"+sum);
            }
        });

    }
}
