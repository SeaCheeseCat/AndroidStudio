package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class shop extends AppCompatActivity {

    private com.example.demo.iteminfo iteminfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        iteminfo = new iteminfo("小猫",20,30,60);
        TextView name = findViewById(R.id.name);
        TextView speed = findViewById(R.id.speed);
        TextView acctack = findViewById(R.id.acctack);
        TextView left=findViewById(R.id.left);

        name.setText("名字"+ iteminfo.getName());
        left.setText("生命"+ iteminfo.getLeft());
        acctack.setText("攻击"+ iteminfo.getAcctack());
        speed.setText("速度"+ iteminfo.getSpeed());

        ((Button)findViewById(R.id.goumai2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("e",iteminfo);
                setResult(1,intent);
                finish();

            }
        });

    }
}
