package com.tycoon.createdevice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class createdevice1 extends Activity {
    /** Called when the activity is first created. */
	int manmul;
	int cash, generationhard, generationsoft, generationdesign, popbonus;//То что получили
	int FinCoast,ManCoast;		   //То что возратим
	final Context content = this;
	Button proc,ram,rom,addit,battery,next,cancel;
	TextView FinText,ManText;
	int[] PriviesClick=new int[10];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createdevice1);
        Intent out =getIntent();
        data recivedata=(data)out.getSerializableExtra("Device Terms");
        cash=recivedata.getcash();
        generationhard=recivedata.getgenerationhard();
        generationsoft=recivedata.getgenerationsoft();
        generationdesign=recivedata.getgenerationdesign();
        popbonus=recivedata.getpopbonus();
        proc=(Button)findViewById(R.id.button1);
        proc.setOnClickListener(ProcButton);
        ram=(Button)findViewById(R.id.button2);
        ram.setOnClickListener(RamButton);
        rom=(Button)findViewById(R.id.button3);
        rom.setOnClickListener(RomButton);
        addit=(Button)findViewById(R.id.button4);
        addit.setOnClickListener(AdditButton);
        battery=(Button)findViewById(R.id.button5);
        battery.setOnClickListener(BatteryButton);
        next=(Button)findViewById(R.id.button6);
        next.setOnClickListener(NextButton);
        cancel=(Button)findViewById(R.id.button7);
        cancel.setOnClickListener(CancelButton);
        FinText=(TextView)findViewById(R.id.textView2);
        ManText=(TextView)findViewById(R.id.textView4);
        FinCoast=0;
        ManCoast=0;
        manmul=150;
        FinText.setTextColor(Color.parseColor("#66ff33"));
    }
    private OnClickListener ProcButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[0]!=0)
    	{
    		FinCoast-=PriviesClick[0];
    		ManCoast-=PriviesClick[1];
    	}
    	    	final CharSequence[] Processors;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	Processors = res.getTextArray(R.array.Processros);
    	Price=res.getTextArray(R.array.ProcessorsPrice);
    	int n=generationhard*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (generationhard>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=Processors[(generationhard-1)*2+i-2].toString()+"         :"+Price[(generationhard-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=Processors[(generationhard-1)*2+i].toString()+"         :"+Price[(generationhard-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a processor");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        proc.setText(Processors[item]);
		        PriviesClick[0]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(popbonus/100));
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
    private OnClickListener RamButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[2]!=0)
    	{
    		FinCoast-=PriviesClick[2];
    		ManCoast-=PriviesClick[3];
    	}
    	final CharSequence[] RAM;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	RAM = res.getTextArray(R.array.RAM);
    	Price=res.getTextArray(R.array.RAMPrice);
    	int n=generationhard*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (generationhard>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=RAM[(generationhard-1)*2+i-2].toString()+"         :"+Price[(generationhard-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=RAM[(generationhard-1)*2+i].toString()+"         :"+Price[(generationhard-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a RAM");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        proc.setText(RAM[item]);
		        PriviesClick[2]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(popbonus/100));
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
    
    private OnClickListener RomButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[4]!=0)
    	{
    		FinCoast-=PriviesClick[4];
    		ManCoast-=PriviesClick[5];
    	}
    	final CharSequence[] ROM;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	ROM = res.getTextArray(R.array.ROM);
    	Price=res.getTextArray(R.array.ROMPrice);
    	int n=generationhard*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (generationhard>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=ROM[(generationhard-1)*2+i-2].toString()+"         :"+Price[(generationhard-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=ROM[(generationhard-1)*2+i].toString()+"         :"+Price[(generationhard-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a ROM");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        proc.setText(ROM[item]);
		        PriviesClick[4]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(popbonus/100));
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
    
    private OnClickListener AdditButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[6]!=0)
    	{
    		FinCoast-=PriviesClick[6];
    		ManCoast-=PriviesClick[7];
    	}
    	final CharSequence[] Additionally;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	Additionally = res.getTextArray(R.array.Additionally);
    	Price=res.getTextArray(R.array.AdditionallyPrice);
    	int n=generationhard*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (generationhard>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=Additionally[(generationhard-1)*2+i-2].toString()+"         :"+Price[(generationhard-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=Additionally[(generationhard-1)*2+i].toString()+"         :"+Price[(generationhard-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a processor");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        proc.setText(Additionally[item]);
		        PriviesClick[6]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(popbonus/100));
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
    
    private OnClickListener BatteryButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (PriviesClick[8]!=0)
    	{
    		FinCoast-=PriviesClick[8];
    		ManCoast-=PriviesClick[9];
    	}
    	final CharSequence[] Battery;
		final CharSequence[] Price; 
    	Resources res = getResources(); 
    	Battery = res.getTextArray(R.array.Battery);
    	Price=res.getTextArray(R.array.BatteryPrice);
    	int n=generationhard*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (generationhard>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=Battery[(generationhard-1)*2+i-2].toString()+"         :"+Price[(generationhard-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=Battery[(generationhard-1)*2+i].toString()+"         :"+Price[(generationhard-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a processor");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        proc.setText(Battery[item]);
		        PriviesClick[8]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
		        FinCoast-=(FinCoast*(popbonus/100));
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
    	if(FinCoast<cash)    	 		
    		FinText.setTextColor(Color.parseColor("#66ff33"));
       	else
       		FinText.setTextColor(Color.parseColor("#990000"));	
    	 
    }
}