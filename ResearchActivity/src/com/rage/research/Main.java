package com.rage.research;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {
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
        Intent i = new Intent(cont,ResearchActivity.class);   
        //classexample exp = new classexample(1,"some str");
        //i.putExtra("someextra", exp);
        startActivityForResult(i, requestCode);
    };  
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
        	ResearchInfo exp=(ResearchInfo)data.getSerializableExtra("extra2");
            Toast.makeText(this, exp.getTitle() , Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }
}