package com.kundan.grapho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class quadDataActivity extends AppCompatActivity {
    Button backButton;
    Button plotButton;
    EditText mEditTexta;
    EditText mEditTextb;
    EditText mEditTextc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quad_data);
        backButton=findViewById(R.id.button2);
        plotButton=findViewById(R.id.button5);
        mEditTexta=findViewById(R.id.editText3);
        mEditTextb=findViewById(R.id.editText5);
        mEditTextc=findViewById(R.id.editText4);

        plotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Plotting Graph",Toast.LENGTH_SHORT).show();
                putData(mEditTexta.getText().toString(),mEditTextb.getText().toString(),mEditTextc.getText().toString());
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });




    }


    public void putData(String aValue,String bValue,String cValue){
        Bundle bundle=new Bundle();
        bundle.putString("a",aValue);
        bundle.putString("b",bValue);
        bundle.putString("d",cValue);
        bundle.putString("flag","0");
        Intent intent=new Intent(getApplicationContext(),GraphActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void goBack(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();

    }

}
