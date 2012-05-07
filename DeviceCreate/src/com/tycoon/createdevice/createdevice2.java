package com.tycoon.createdevice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class createdevice2 extends Activity {
    /** Called when the activity is first created. */
	int manmul;
	int FinCoast,ManCoast;		   //То что возратим
	final Context content = this;
	Button OS,Keypad,Display,Color,Material,next,cancel;
	TextView FinText,ManText;
	Resources res; 
	device recievedevicedata;
	data recivedata;
	int[] PriviesClick=new int[10];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createdevice2);
        Intent out =getIntent();
        recivedata=(data)out.getSerializableExtra("Device Terms");
        recievedevicedata=(device)out.getSerializableExtra("Device param");
        FinCoast=out.getIntExtra("Final coast", 0);
        ManCoast=out.getIntExtra("Man coast", 0); 
        OS=(Button)findViewById(R.id.button1);
        OS.setOnClickListener(OSButton);
        Keypad=(Button)findViewById(R.id.button2);
        Keypad.setOnClickListener(KeypadButton);
        Display=(Button)findViewById(R.id.button3);
        Display.setOnClickListener(DisplayButton);
        Color=(Button)findViewById(R.id.button4);
        Color.setOnClickListener(ColorButton);
        Material=(Button)findViewById(R.id.button5);
        Material.setOnClickListener(MaterialButton);
        next=(Button)findViewById(R.id.button6);
        next.setOnClickListener(NextButton);
        cancel=(Button)findViewById(R.id.button7);
        cancel.setOnClickListener(CancelButton);
        ManText=(TextView)findViewById(R.id.textView2);
        FinText=(TextView)findViewById(R.id.textView4);
        manmul=150;
        res = getResources();
        ManText.setTextColor(res.getColor(R.color.green));
        UpdateCoast();
    }
    private OnClickListener OSButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[0]!=0)
    	{
    		FinCoast-=PriviesClick[0];
    		ManCoast-=PriviesClick[1];
    	}
    	final CharSequence[] OSes;
		final CharSequence[] Price; 
    	
		OSes = res.getTextArray(R.array.OS);
    	Price=res.getTextArray(R.array.OSPrice);
    	int n=recivedata.getgeneration();
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=OSes[(recivedata.getgeneration()-1)+i-1].toString()+"         :"+Price[(recivedata.getgeneration()-1)+i-1].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=OSes[(recivedata.getgeneration()-1)+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a operating system");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	OS.setText(OSes[item]);
		        PriviesClick[0]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(recivedata.getPriceBonus()/100));
		        PriviesClick[0]=FinCoast-PriviesClick[0];
		        ManCoast+=Integer.parseInt((String) Price[item])*manmul;
		        PriviesClick[1]=Integer.parseInt((String) Price[item])*manmul;
		        UpdateCoast();
		    }
		});
		AlertDialog alertDialog = builder.create();			// show it
		alertDialog.show();	
    	};  
    
    };
    private OnClickListener KeypadButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[2]!=0)
    	{
    		FinCoast-=PriviesClick[2];
    		ManCoast-=PriviesClick[3];
    	}
    	final CharSequence[] KEYPAD;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	KEYPAD = res.getTextArray(R.array.Keypad);
    	Price=res.getTextArray(R.array.KeypadPrice);
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=KEYPAD[(recivedata.getgeneration()-1)*2+i-2].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=KEYPAD[(recivedata.getgeneration()-1)*2+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a keypad");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        Keypad.setText(KEYPAD[item]);
		        PriviesClick[2]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(recivedata.getPriceBonus()/100));
		        PriviesClick[2]=FinCoast-PriviesClick[2];
		        ManCoast+=Integer.parseInt((String) Price[item])*manmul;
		        PriviesClick[3]=Integer.parseInt((String) Price[item])*manmul;
		        UpdateCoast();
		    }
		});
		AlertDialog alertDialog = builder.create();			// show it
		alertDialog.show();	
    };  
    };
    
    private OnClickListener DisplayButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[4]!=0)
    	{
    		FinCoast-=PriviesClick[4];
    		ManCoast-=PriviesClick[5];
    	}
    	final CharSequence[] DISPLAY;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	DISPLAY = res.getTextArray(R.array.Display);
    	Price=res.getTextArray(R.array.DisplayPrice);
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=DISPLAY[(recivedata.getgeneration()-1)*2+i-2].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=DISPLAY[(recivedata.getgeneration()-1)*2+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a display");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	Display.setText(DISPLAY[item]);
		        PriviesClick[4]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(recivedata.getPriceBonus()/100));
		        PriviesClick[4]=FinCoast-PriviesClick[4];
		        ManCoast+=Integer.parseInt((String) Price[item])*manmul;
		        PriviesClick[5]=Integer.parseInt((String) Price[item])*manmul;
		        UpdateCoast();
		    }
		});
		AlertDialog alertDialog = builder.create();			// show it
		alertDialog.show();	
    };  
    };
    
    private OnClickListener ColorButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[6]!=0)
    	{
    		FinCoast-=PriviesClick[6];
    		ManCoast-=PriviesClick[7];
    	}
    	final CharSequence[] COLOR;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	COLOR = res.getTextArray(R.array.Color);
    	Price=res.getTextArray(R.array.ColorPrice);
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
     	for (int i=0;i<n;i++)
    			{
    				items[i]=COLOR[recivedata.getgeneration()].toString()+"         :"+Price[recivedata.getgeneration()].toString();  
    			}
    	
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a color");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	Color.setText(COLOR[item]);
		        PriviesClick[6]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(recivedata.getPriceBonus()/100));
		        PriviesClick[6]=FinCoast-PriviesClick[6];
		        ManCoast+=Integer.parseInt((String) Price[item])*manmul;
		        PriviesClick[7]=Integer.parseInt((String) Price[item])*manmul;
		        UpdateCoast();
		    }
		});
		AlertDialog alertDialog = builder.create();			// show it
		alertDialog.show();	
    };  
    };
    
    private OnClickListener MaterialButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[8]!=0)
    	{
    		FinCoast-=PriviesClick[8];
    		ManCoast-=PriviesClick[9];
    	}
    	final CharSequence[] MATERIAL;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	MATERIAL = res.getTextArray(R.array.Material);
    	Price=res.getTextArray(R.array.MaterialPrice);
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=MATERIAL[(recivedata.getgeneration()-1)*2+i-2].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=MATERIAL[(recivedata.getgeneration()-1)*2+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a material");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        Material.setText(MATERIAL[item]);
		        PriviesClick[8]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(recivedata.getPriceBonus()/100));
		        PriviesClick[8]=FinCoast-PriviesClick[8];
		        ManCoast+=Integer.parseInt((String) Price[item])*manmul;
		        PriviesClick[9]=Integer.parseInt((String) Price[item])*manmul;
		        UpdateCoast();
		    }
		});
		AlertDialog alertDialog = builder.create();			// show it
		alertDialog.show();	
    };  
    };
    
    private OnClickListener NextButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
    	builder.setMessage("Popularity to final coast:\nWithout popularity bonus: "+Integer.toString(FinCoast)+" \nWith popularity bonus: "+Integer.toString((int)(FinCoast+FinCoast*((double)recivedata.getPriceBonus()/100))))
    	       .setCancelable(false)
    	       .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) 
    	           {
    	        	dialog.cancel();
    	        	FinCoast=(int) (FinCoast+FinCoast*((double)recivedata.getPriceBonus()/100));
    	           	Intent in = new Intent();
    	            recievedevicedata.setOS(OS.getText().toString());
    	            recievedevicedata.setColor(Color.getText().toString());
    	            recievedevicedata.setDisplay(Display.getText().toString());
    	            recievedevicedata.setKeypad(Keypad.getText().toString());
    	            recievedevicedata.setMaterial(Material.getText().toString());
    	            in.putExtra("Final coast", FinCoast);
    	        	in.putExtra("Man coast", ManCoast);
    	            in.putExtra("Device param", recievedevicedata);
    	            setResult(2,in);
    	            finish();
    	           }
    	       });
    	AlertDialog alert = builder.create();
    	alert.show();

    };  
    };
    
    private OnClickListener CancelButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {    
    	finish();
    };  
    };
    
    private void UpdateCoast()
    {
    	ManText.setText(Integer.toString(ManCoast));
    	FinText.setText(Integer.toString(FinCoast));
    	if(FinCoast<recivedata.getcash())    	 		
    		ManText.setTextColor(res.getColor(R.color.green));
       	else
       		ManText.setTextColor(res.getColor(R.color.red));	
    	 
    }
}