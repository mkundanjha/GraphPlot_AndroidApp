package com.kundan.grapho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataInputActivity extends AppCompatActivity {
    Button backButton;
    Button plot;
    EditText slope;
    EditText intercept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);
        backButton=findViewById(R.id.button3);
        slope=findViewById(R.id.editText2);
        intercept=findViewById(R.id.editText);
        plot=findViewById(R.id.button4);





        plot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Plotting Graph",Toast.LENGTH_SHORT).show();
                putData(slope.getText().toString(),intercept.getText().toString());
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    private void goBack(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void putData(String slopeValue,String interceptValue){
        Bundle bundle=new Bundle();
        bundle.putString("m",slopeValue);
        bundle.putString("c",interceptValue);
        bundle.putString("flag","1");
        Intent intent=new Intent(getApplicationContext(),GraphActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onBackPressed(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();

    }
}
