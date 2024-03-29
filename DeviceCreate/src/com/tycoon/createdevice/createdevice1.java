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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class createdevice1 extends Activity {
    /** Called when the activity is first created. */
	int manmul,requestCode;
	int FinCoast,ManCoast;		   //�� ��� ��������
	final Context content = this;
	Button proc,ram,rom,addit,battery,next,cancel;
	TextView FinText,ManText;
	
	Resources res; 
	data recivedata;
	int[] PriviesClick=new int[10];
	//TODO ��� ���� ��� �� ������ ������ ���� ������ ���� ��� ���� ���� �� �������
	//TODO ���������� � ��� ������� ������ �������� �������
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createdevice1);
        Intent out =getIntent();
        recivedata=(data)out.getSerializableExtra("Device Terms");
    
        
      
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
        ManText=(TextView)findViewById(R.id.textView2);
        FinText=(TextView)findViewById(R.id.textView4);
        requestCode=2;
        FinCoast=0;
        ManCoast=0;
        manmul=150;
        res = getResources();
        ManText.setTextColor(res.getColor(R.color.green));
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
    	
    	Processors = res.getTextArray(R.array.Processros);
    	Price=res.getTextArray(R.array.ProcessorsPrice);
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=Processors[(recivedata.getgeneration()-1)*2+i-2].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=Processors[(recivedata.getgeneration()-1)*2+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i].toString();  
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
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=RAM[(recivedata.getgeneration()-1)*2+i-2].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=RAM[(recivedata.getgeneration()-1)*2+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a RAM");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        ram.setText(RAM[item]);
		        PriviesClick[2]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
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
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=ROM[(recivedata.getgeneration()-1)*2+i-2].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=ROM[(recivedata.getgeneration()-1)*2+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a ROM");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        rom.setText(ROM[item]);
		        PriviesClick[4]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
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
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=Additionally[(recivedata.getgeneration()-1)*2+i-2].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=Additionally[(recivedata.getgeneration()-1)*2+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a processor");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	addit.setText(Additionally[item]);
		        PriviesClick[6]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
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
    	int n=recivedata.getgeneration()*2;
    	final CharSequence[] items= new CharSequence[n];
    	if (recivedata.getgeneration()>1)
    	{
    		for (int i=0;i<n;i++)
    			{
    				items[i]=Battery[(recivedata.getgeneration()-1)*2+i-2].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i-2].toString();  
    			}
    	}
    	else
    	{
    		for (int i=0;i<n;i++)
			{
				items[i]=Battery[(recivedata.getgeneration()-1)*2+i].toString()+"         :"+Price[(recivedata.getgeneration()-1)*2+i].toString();  
			}
    	}
    		
    	AlertDialog.Builder builder = new AlertDialog.Builder(content);
		// set title
		builder.setTitle("Pick a processor");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        battery.setText(Battery[item]);
		        PriviesClick[8]=FinCoast;
		        FinCoast+=Integer.parseInt((String) Price[item]);
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
    	Intent i = new Intent(content,createdevice2.class);   
        device DataForSecondActivity = new device(proc.getText().toString(),ram.getText().toString(),rom.getText().toString(),addit.getText().toString(),battery.getText().toString());
    	i.putExtra("Device param", DataForSecondActivity);
    	i.putExtra("Device Terms", recivedata);
    	i.putExtra("Final coast", FinCoast);
    	i.putExtra("Man coast", ManCoast);
        startActivityForResult(i, requestCode);
    };  
    };
    
    private OnClickListener CancelButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
       finish();
    };  
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==2)
        {
        	setResult(1,data);
        	finish();
        }
        
    }
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