package com.tycoon.createdevice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class main extends Activity {
	Button b1;
	int requestCode;
	Context cont;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        cont=getApplicationContext();
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(StartNewActivity);
    }
    private OnClickListener StartNewActivity = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
        Intent i = new Intent(cont,createdevice1.class);   
        data exp = new data(2,1,1,20,5);
        i.putExtra("Device Terms", exp);
        startActivityForResult(i, requestCode);
    };  
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
      //  	data exp=(data)data.getSerializableExtra("extra2");
      //      Toast.makeText(this, exp.getName(), Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }
}