package com.rage.research;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class ResearchActivity extends Activity implements OnClickListener{
	 
	private RelativeLayout mLayout;
	private TextView MoneyCount;
	
	private Draw2D BackGround;
	
	static private int NOT_RESEARCHED = 0;
	static private int CURRENT_RESEARCHED = 1;
	static private int RESEARCHED = 2;
	
	
	static private int DIALOG_CHAGE_RESEARCH = 1;
	private AlertDialog alert;
	
	private int height, widht, VAligin, HAligin;
	private int VLvlCount = 6;
	private int HLvlCount = 9;
	private  int NumberOfButtons;

	MyImageButton MyMasButtons[][];
	ResearchInfo ResInfo;
	private int CurrentResearching[] = new int [2];

	private ResearchInfo Info;
	private int Money;
	
	private int VLevel[];
	private int HLevel[];
	private int AreaLVL[];
	private int Area;
	private int ActiveButtonNumber = -1;
	private int ActiveButtonType = -1;
	
	private Button ResBtn;
	private TextView Title;
	private TextView Description;
	private int research[];

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.research);
        
        Log.v("HI", "HERE WE STARTED");
        
        BackGround = new Draw2D(this);
        RelativeLayout.LayoutParams mParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT); 
        mLayout = (RelativeLayout) findViewById(R.id.mLay);
        mLayout.addView(BackGround, mParam);
        
        ResBtn = (Button) findViewById(R.id.researchButton);
        ResBtn.setOnClickListener(ResearchListener);
        
        research = new int [36];
        CurrentResearching[0] = -1;
        
        //Title = (TextView)findViewById
        
        /*ResInfo = new ResearchInfo[4][];
        for (int n = 0; n < 3; n++)
        	ResInfo[n] = new ResearchInfo [11];
        ResInfo[3] = new ResearchInfo [3];*/
        Log.v("HELLO", "CONTINUE WORKING");
        
        Intent out = getIntent();
        Bundle bundleMas=out.getExtras().getBundle("mas");
        int size=bundleMas.getInt("StrArrays");
        research = new int[size];
        for(int n = 0; n < research.length; n++)
        	research[n]=bundleMas.getInt("Array"+n);
        
        Info=(ResearchInfo)out.getSerializableExtra("someextra");
        //ResInfo = (ResearchInfo)out.getSerializableExtra("ResInf");
        Money = (int)out.getIntExtra("Money", 0);
        MoneyCount = (TextView) findViewById(R.id.textMoney);
        MoneyCount.setText(getString(R.string.money) + String.valueOf(Money));

    }
    
    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
            // the height will be set at this point
    	height = BackGround.getMeasuredHeight();
        widht = BackGround.getMeasuredWidth();
        
        Area = height/3;
        AreaLVL = new int [3];
        for (int n = 0; n < 3; n++)
        	AreaLVL[n] = n * Area;

        VAligin = height/VLvlCount;
        HAligin = widht/HLvlCount;
        int addV = height%VLvlCount;
        int addH = widht%HLvlCount;
        
        VLevel = new int[VLvlCount];
        for (int n = 0; n < VLvlCount; n++)
        	VLevel[n] = addV + n * VAligin;
        
        HLevel = new int[HLvlCount];
        for (int n = 0; n < HLvlCount; n++)
           	HLevel[n] = addH + n * HAligin;
            
        NumberOfButtons = VLvlCount*HLvlCount - VLvlCount/2 - 3*(VLvlCount - 1);
        
        MyMasButtons = new MyImageButton [4][];
        for (int n = 0; n < 3; n++)
        	MyMasButtons[n] = new MyImageButton [NumberOfButtons/3 - 1];
        MyMasButtons[3] = new MyImageButton [3];
        
        Log.v("pr ", String.valueOf(MyMasButtons[0].length));
        
        for (int firstParam = 0; firstParam < MyMasButtons.length; firstParam++)
        	for (int secParam = 0; secParam < MyMasButtons[firstParam].length; secParam++)
        		AlternativeCreateButton(firstParam, secParam);

        for (int firstParam = 0; firstParam < MyMasButtons.length; firstParam++)
        	for (int secParam = 0; secParam < MyMasButtons[firstParam].length; secParam++)
        	{
        		if (MyMasButtons[firstParam][secParam].getResearch()== RESEARCHED)
        			MyMasButtons[firstParam][secParam].setBackgroundColor(Color.BLACK);
        		if (MyMasButtons[firstParam][secParam].getResearch()== CURRENT_RESEARCHED)
        		{
        			MyMasButtons[firstParam][secParam].setBackgroundColor(Color.YELLOW);
        			CurrentResearching[0] = firstParam;
        			CurrentResearching[1] = secParam;
        		}
        	}
        		
    }
    
    public void AlternativeCreateButton(int firstParam, int secParam)
    {
    	MyMasButtons[firstParam][secParam] = new MyImageButton(this, secParam, firstParam);
    	MyMasButtons[firstParam][secParam].setOnClickListener(this);
    	MyMasButtons[firstParam][secParam].setResearch(research[11 * firstParam + secParam]);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
		ShapeDrawable w;
    	w = new ShapeDrawable(new RectShape());
		if (firstParam != 3)
		{
	    	if (secParam == 0)
	    		params.topMargin = VLevel[firstParam * 2] + VAligin - VAligin/2;
	    	else 
	    		if (secParam < 6)
	    			params.topMargin = VLevel[firstParam * 2];
	    		else
	    			params.topMargin = VLevel[firstParam * 2 + 1];
	    	int mod = 0;    	
	    	if ((secParam > 1 && secParam < 4) || (secParam > 6 && secParam < 9))
	    		mod = 1;
	    	if ((secParam > 3 && secParam < 6) || (secParam > 8))
	    		mod = 2;
	
	    	if (secParam < 6)
	    		params.leftMargin = HLevel[secParam + mod];
	    	else 
	    		params.leftMargin = HLevel[secParam + mod - 5];
	    	
	    	w.setIntrinsicHeight(2*VAligin/3);
	    	w.setIntrinsicWidth(HAligin/3);
	    	
	    	MyMasButtons[firstParam][secParam].setMaxHeight(2*VAligin/3);
	    	MyMasButtons[firstParam][secParam].setMaxWidth(HAligin/2);
		}
		else
		{
	   		w.setIntrinsicHeight(VLevel[5] + 2*VAligin/3 - VLevel[0]);
	   		
	   		params.topMargin = VLevel[0];
	   		params.leftMargin = HLevel[2 + secParam * 3];
	   		
	   		MyMasButtons[firstParam][secParam].setMaxHeight(VAligin*6);
	    	w.setIntrinsicWidth(HAligin/3);
	    	MyMasButtons[firstParam][secParam].setMaxWidth(HAligin/2);
		}
		
		w.getPaint().setColor(Color.WHITE);
    	//MyButtons[curBtn].setBackgroundColor(Color.TRANSPARENT);
    	MyMasButtons[firstParam][secParam].setImageDrawable(w);
		mLayout.addView(MyMasButtons[firstParam][secParam], params);
    }
               
	public Boolean CheckButton(MyImageButton checkBtn)
	{
		int type = checkBtn.getType();
		int number = checkBtn.getNumber();
		if (type !=3)
		{
			switch (number)
			{
				case 0:
					return true;
				case 1:
				case 6:
					return MyMasButtons[type][0].getResearched();
				case 2:
				case 7:
					return MyMasButtons[3][0].getResearched();
				case 4:
				case 9:
					return MyMasButtons[3][1].getResearched();
				default:
					return MyMasButtons[type][number-1].getResearched();
			}
			/*if (number == 0)
				return true;
			if (number == 1 || number == 6)
				return MyMasButtons[type][0].getResearched();
			if (number == 2 || number == 7)
				return GenButtons[0].getResearched();
			if (number == 4 || number == 9)
				return GenButtons[1].getResearched();
			return MyMasButtons[type][number-1].getResearched();*/
		}
		else
		{
			int a,b;
			if (number == 0)
			{
				a = 1;
				b = 6;
			}
			else 
			{
				if (number == 1)
				{
					a = 3;
					b = 8;
				}
				else 
				{
					a = 5;
					b = 10;
				}
			}
			for (int n = 0; n < 3; n++)
			{
				if(MyMasButtons[n][a].getResearched() || MyMasButtons[n][b].getResearched())
					return true;
			}
			return false;
		}
	}
	
	public OnClickListener ResearchListener = new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//MyImageButton btn = (MyImageButton)v;
			
			if (ActiveButtonNumber != -1)
			{
				
				if (CurrentResearching[0] == -1)
				{//MyMasButtons[ActiveButtonType][ActiveButtonNumber].setBackgroundColor(Color.BLACK);
				
				//info = new ResearchInfo(MyMasButtons[ActiveButtonType][ActiveButtonNumber]);
				
				//Money -= MyMasButtons[ActiveButtonType][ActiveButtonNumber].getCost();
				//MoneyCount.setText(getString(R.string.money) + String.valueOf(Money));
				
				ReturnResult();
				
				}
				else
				{
					CreateDialog();
					alert.show();
				}
			}
		}
	};
	
	private void ReturnResult()
	{
		ResearchInfo info;
		MyMasButtons[ActiveButtonType][ActiveButtonNumber].setResearch(CURRENT_RESEARCHED);
		info = new ResearchInfo(MyMasButtons[ActiveButtonType][ActiveButtonNumber]);
		Intent in = new Intent();
		in.putExtra("extra2", info);
        setResult(1,in);
        finish();
	}
	
	private void CreateDialog()
	{
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("“екущий прогресс будет утер€н если вы начнете новое иссследование. ѕродолжить?")
	       .setCancelable(false)
	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	        	   MyMasButtons[CurrentResearching[0]][CurrentResearching[1]].setResearch(NOT_RESEARCHED);
	        	   ReturnResult();
	        	   ResearchActivity.this.finish();
	        	    
	           }
	       })
	       .setNegativeButton("No", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	                dialog.cancel();
	           }
	       });
	alert = builder.create();
	}
	
	/*protected Dialog onCreateDialog(int id) {
	    Dialog dialog;
	    switch(id) {
	    case DIALOG_CHAGE_RESEARCH:
	        // do the work to define the pause Dialog
	        break;
	    case DIALOG_GAMEOVER_ID:
	        // do the work to define the game over Dialog
	        break;
	    default:
	        dialog = null;
	    }
	    return dialog;
	}*/
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		MyImageButton btn = (MyImageButton)v;
		TextView textTitle = (TextView) findViewById(R.id.textTitle);
		
		TextView textDescription = (TextView) findViewById(R.id.textDescription);
		textDescription.setText(btn.getDescription() + "\nCost:" + btn.getCost() + "\nWorkSize:" + btn.getWorkSize());
		ActiveButtonNumber = btn.getNumber();
		ActiveButtonType = btn.getType();
		textTitle.setText(btn.getTitle());
		if (!CheckButton(btn) || btn.getCost() > Money)	
			ResBtn.setEnabled(false);
		else ResBtn.setEnabled(true);
		}
}