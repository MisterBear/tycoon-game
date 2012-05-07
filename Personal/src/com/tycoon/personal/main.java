package com.tycoon.personal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class main extends Activity {
	Button b1;
	int requestCode;
	Context cont;
	EditText Edit;
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
        Intent i = new Intent(cont,PersonalActivity.class);   
        data obj=new data(10,1,3,2,2,2,3);
        i.putExtra("Personal data", obj);
        startActivityForResult(i, requestCode);
    };  
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
        	      }
        else{
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }
}