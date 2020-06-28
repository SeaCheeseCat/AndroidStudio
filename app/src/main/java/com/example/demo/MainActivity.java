package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"创建了方法",Toast.LENGTH_LONG).show();

        Log.i("Mainactity","调用oncreate方法");
        fragment fragment=new fragment();
        FragmentTransaction f=getSupportFragmentManager().beginTransaction();
        f.add(android.R.id.content,fragment);
        f.commit();


        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,wexindemo.class);
                startActivity(intent);

            }
        });

        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,intent1.class);
                startActivity(intent);
            }
        }

        );

        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,jisuanqi.class);
                startActivity(intent);

            }
        });


        ((Button)findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,QQ.class);
                startActivity(intent);
            }
        });


        ((Button)findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,show.class);
                startActivity(intent);

            }
        });

        ((Button)findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,longan.class);
                startActivity(intent);

            }
        });
        ((Button)findViewById(R.id.button7)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,shoushi.class);
                startActivity(intent);

            }
        });


        ((Button)findViewById(R.id.button8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,winds.class);
                startActivity(intent);
            }
        });


        ((Button)findViewById(R.id.button9)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,jishi.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.button10)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,duo.class);
                startActivity(intent);
            }
        });

        ((Button)findViewById(R.id.button11)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,qq2.class);
                startActivity(intent);
            }
        });

        ((Button)findViewById(R.id.button12)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,lunbotu.class);
                startActivity(intent);
            }
        });

        ((Button)findViewById(R.id.button13)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,services.class);
                startActivity(intent);
            }
        });


        ((Button)findViewById(R.id.button14)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,two.class);
                startActivity(intent);
            }
        });







    }

//页面可见

    @Override
    protected void onStart() {
        Log.i("MainActivity","调用onstart方法");
        super.onStart();
    }
//当activity获取焦点开始与用户交互时
    @Override
    protected void onResume() {
        Log.i("MainActivity","调用onresume方法");
        super.onResume();
    }

    //当activity被覆盖，失去焦点

    @Override
    protected void onPause() {
        Log.i("MainActivity","调用onPause方法");
        super.onPause();
    }

    //当页面不可见


    @Override
    protected void onStop() {
        Log.i("MainActivity","调用onStop方法");
        super.onStop();
    }

    //当页面销毁时执行


    @Override
    protected void onDestroy() {
        Log.i("MainActivity","调用onDestroy方法");
        super.onDestroy();
    }


}
