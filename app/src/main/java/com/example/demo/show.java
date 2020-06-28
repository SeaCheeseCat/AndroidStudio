package com.example.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;

public class show extends AppCompatActivity {

    private TextView viewById;
    private TextView viewById1;
    private TextView viewById2;
    private TextView viewById3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        viewById = findViewById(R.id.textView);
        viewById1 = findViewById(R.id.textView2);
        viewById2 = findViewById(R.id.textView3);
        viewById3 = findViewById(R.id.textView4);


        ((Button)findViewById(R.id.goumai)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(show.this,shop.class);
                startActivityForResult(intent,1);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


                iteminfo equip =(iteminfo) data.getSerializableExtra("e");
                viewById.setText(equip.getName().toString());
                Toast.makeText(show.this,"name"+equip.getName(),Toast.LENGTH_LONG).show();
                viewById1.setText(equip.getLeft()+"");
                viewById2.setText(equip.getAcctack()+"");
                viewById3.setText(equip.getSpeed()+"");



    }

}
