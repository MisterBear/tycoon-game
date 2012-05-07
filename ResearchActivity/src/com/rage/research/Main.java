package com.rage.research;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	private Button b1;
	private Button b2;
	private Button b3;
	private TextView title;
	private int requestCode;
	private Context cont;
	private int research[];
	private int Money = 50000;
	
	static final long FPS = 2;
	private long ticksPS = 1000 / FPS;
	private long startTime;
	private long sleepTime;
	private long mLastMove;
	
	static private int NOT_RESEARCHED = 0;
	static private int CURRENT_RESEARCHED = 1;
	static private int RESEARCHED = 2;
	
	private ResearchInfo currentResearch;
	private ProgressBar researchProgress;
	
	private int mMode;
	static private int RUNNING = 1;
	static private int PAUSED = 2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        cont=getApplicationContext();
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(StartNewActivity);
        
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(StartHandler);
        
        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(StopHandler);
        
        researchProgress = (ProgressBar) findViewById(R.id.progressResearch);
                
        research = new int [36];
        for (int n = 0; n < research.length; n++)
        	research[n] = NOT_RESEARCHED;
        
        title  = (TextView) findViewById(R.id.textHell);
        
        mMode = RUNNING;
        update();
    }
    
    private RefreshHandler mRedrawHandler = new RefreshHandler();

    class RefreshHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
        	Main.this.update();
        	//Main.this.invalidate();
        }

        public void sleep(long delayMillis) {
        	this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    };
    

    public void update() {
    	Log.v("Update", String.valueOf(mMode));
        if (mMode == RUNNING) {
            long now = System.currentTimeMillis();

            if (now - mLastMove > ticksPS) {
                //clearTiles();
                //updateWalls();
                ///updateSnake();
                //..updateApples();
            	updateResearch();
            	//updateMoney();
                mLastMove = now;
            }
            mRedrawHandler.sleep(ticksPS);
        }
    }
    
    private void updateResearch()
    {
    	if (currentResearch != null)
    	{
	    	if (currentResearch.getWorkSize() > 0)
	    	{
	    		currentResearch.setWorkSize(currentResearch.getWorkSize() - 10);
	    		researchProgress.incrementProgressBy(10);
	    	}
	    	
	    	else
	    		research[currentResearch.getType() * 11 + currentResearch.getNumber()] = RESEARCHED;
	    	title.setText(String.valueOf(currentResearch.getWorkSize()));
    	}
    }
    
    private void updateMoney()
    {
    	Money -= 10;
    	//title.setText(String.valueOf(Money));
    }

    /*///////////////////////////////////////
    Bundle bundle=new Bundle(); //создаем посылочку
    bundle.putInt("StrArrays", listMans.size()); //пишем размер массива массивов
    for(int n=0; n < listMans.size(); n++) bundle.putString("Array"+n, listMans.get(n));//пишем нумерованный массив
    intent2.putExtra("mas", bundle); // засылаем посылочку в Intent

    и принять:

    Bundle bundleMas=getIntent().getExtras().getBundle("mas");
    int size=bundleMas.getInt("StrArrays");
    String[] mas;
    mas=new String[size];
    for(int n = 0; n < mas.length; n++)
    mas[n]=bundleMas.getString("Array"+n);
    ///////////////////////////////////////*/
        
    private OnClickListener StartNewActivity = new OnClickListener()  
    {      
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mMode = PAUSED;
			Intent i = new Intent(cont,ResearchActivity.class);   
	        
	        Bundle bundle=new Bundle(); //создаем посылочку
	        bundle.putInt("StrArrays", research.length); //пишем размер массива массивов
	        for(int n=0; n < research.length; n++) 
	        	bundle.putInt("Array"+n, research[n]);//пишем нумерованный массив
	        i.putExtra("mas", bundle); // засылаем посылочку в Intent
	        
	        ResearchInfo exp = new ResearchInfo(0,0,true);
	        i.putExtra("someextra", exp);
	        i.putExtra("Money", Money);
	        startActivityForResult(i, requestCode);
			
		};  
    };
    
    private OnClickListener StartHandler = new OnClickListener()  
    {      
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mMode = RUNNING;
			update();
		};  
    };
    
    private OnClickListener StopHandler = new OnClickListener()  
    {      
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mMode = PAUSED;
			Log.v("Pause", String.valueOf(mMode));
			//update();
		};  
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
        	currentResearch = (ResearchInfo)data.getSerializableExtra("extra2");
        	researchProgress.setProgress(0);
        	researchProgress.setMax(currentResearch.getWorkSize());
        	Money -= currentResearch.getCost();
        	research[currentResearch.getType() * 11 + currentResearch.getNumber()] = CURRENT_RESEARCHED;
            Toast.makeText(this, String.valueOf(Money) , Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
                mMode = RUNNING;
                update();
    }
}