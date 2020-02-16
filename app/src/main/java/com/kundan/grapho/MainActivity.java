package com.kundan.grapho;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME = 2000;

    Button linearButton;
    Button quadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearButton=findViewById(R.id.linearButton);
        quadButton=findViewById(R.id.quadButton);



        linearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLinear();
            }
        });
        quadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goQuad();
            }
        });
    }

   private void goLinear(){
        Intent intent=new Intent(getApplicationContext(),DataInputActivity.class);
        startActivity(intent);
        finish();
    }


    private void goQuad(){
        Intent intent=new Intent(getApplicationContext(),quadDataActivity.class);
        startActivity(intent);
        finish();
    }

}
