package com.tycoon.createdevice;

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
        Edit=(EditText)findViewById(R.id.editText1);
        cont=getApplicationContext();
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(StartNewActivity);
    }
    private OnClickListener StartNewActivity = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
        Intent i = new Intent(cont,createdevice1.class);   
        data exp = new data(2,19000,5);
        i.putExtra("Device Terms", exp);
        startActivityForResult(i, requestCode);
    };  
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
        	device recievedevicedata = (device)data.getSerializableExtra("Device param");
            int FinCoast = data.getIntExtra("Final coast", 0);
            int ManCoast = data.getIntExtra("Man coast", 0); 
            Edit.setText(recievedevicedata.getprocessor()+" "+recievedevicedata.getDisplay()+"\n"+Integer.toString(FinCoast)+" "+Integer.toString(ManCoast));
        }
        else{
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }
}