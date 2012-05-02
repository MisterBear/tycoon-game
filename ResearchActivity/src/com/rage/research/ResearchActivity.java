package com.rage.research;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
	
	//RelativeLayout.LayoutParams mParam; 
	private RelativeLayout mLayout;
	
	private Draw2D BackGround;
	
	int height, widht, VAligin, HAligin;
	int VLvlCount = 6;
	int HLvlCount = 9;
	private  int NumberOfButtons;
	
	MyImageButton MyButtons[];
	
	/*MyImageButton HardButtons[];
	MyImageButton SoftButtons[];
	MyImageButton DesButtons[];*/
	MyImageButton MyMasButtons[][];
	MyImageButton GenButtons[];
	
	private int VLevel[];
	private int HLevel[];
	private int AreaLVL[];
	private int Area;
	private int ActiveButtonNumber = -1;
	private int ActiveButtonType = -1;
	
	private Button ResBtn;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.research);
        
        BackGround = new Draw2D(this);
        RelativeLayout.LayoutParams mParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT); 
        mLayout = (RelativeLayout) findViewById(R.id.mLay);
        mLayout.addView(BackGround, mParam);
        
        ResBtn = (Button) findViewById(R.id.button1);
        ResBtn.setOnClickListener(ResearchListener);
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
        MyButtons = new MyImageButton [NumberOfButtons];
        
        MyMasButtons = new MyImageButton [3][NumberOfButtons/3 - 1];
        GenButtons = new MyImageButton [3];
        
        Log.v("pr ", String.valueOf(MyMasButtons[0].length));
        
        int curBtn = 0;
        for (int firstParam = 0; firstParam < 3; firstParam++, curBtn = 0)
        	for (int secParam = 0; secParam < (NumberOfButtons/3 - 1); secParam++, curBtn++)
        	{
        		Log.v("pr ", String.valueOf(curBtn));
        		AlternativeCreateButton(firstParam, secParam, curBtn);
        	}
        /*for (int VLVL = 0; VLVL < VLvlCount; VLVL++)
       		for (int HLVL = 0; HLVL < HLvlCount; HLVL++)
       			if (HLVL != 2 && HLVL != 5 && HLVL != 8)
       			{
       				if ((VLVL == 1 || VLVL == 3 || VLVL == 5) && HLVL == 0 )
       					HLVL++;
       				CreateButton(VLVL, HLVL, curBtn, false);
       				curBtn++;
       			}*/
        for (int n = 0; n < 3; n++, curBtn++)
        	CreateButton(0, 2 + n*3, curBtn);
    }
    
    public void AlternativeCreateButton(int firstParam, int secParam, int curBtn)
    {
    	MyMasButtons[firstParam][secParam] = new MyImageButton(this, curBtn, firstParam);
    	MyMasButtons[firstParam][secParam].setOnClickListener(this);
		Log.v("CurrentButton ", String.valueOf(curBtn));
    	RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
    	
    	if (secParam == 0)
    		params.topMargin = VLevel[firstParam * 2] + VAligin - VAligin/2;
    	else 
    		if (secParam < 6)
    			params.topMargin = VLevel[firstParam * 2];
    		else
    			params.topMargin = VLevel[firstParam * 2 + 1];
    	
    	ShapeDrawable w;
    	w = new ShapeDrawable(new RectShape());
    	
    	w.setIntrinsicHeight(2*VAligin/3);
    	MyMasButtons[firstParam][secParam].setMaxHeight(2*VAligin/3);
    	
    	w.setIntrinsicWidth(HAligin/3);
    	MyMasButtons[firstParam][secParam].setMaxWidth(HAligin/2);
    	
    	//if (CheckButton(MyMasButtons[firstParam][secParam]))
    	w.getPaint().setColor(Color.WHITE);
    	//else w.getPaint().setColor(Color.BLACK);
    	//MyButtons[curBtn].setBackgroundColor(Color.TRANSPARENT);
    	MyMasButtons[firstParam][secParam].setImageDrawable(w);
    	
    	int mod = 0;    	
    	if ((secParam > 1 && secParam < 4) || (secParam > 6 && secParam < 9))
    		mod = 1;
    	if ((secParam > 3 && secParam < 6) || (secParam > 8))
    		mod = 2;

    	if (secParam < 6)
    		params.leftMargin = HLevel[secParam + mod];
    	else 
    		params.leftMargin = HLevel[secParam + mod - 5];
    	mLayout.addView(MyMasButtons[firstParam][secParam], params);
    }
               
	public void CreateButton(int vlvl, int hlvl, int curBtn)
    {
		GenButtons[curBtn] = new MyImageButton(this, curBtn, 3);
		GenButtons[curBtn].setOnClickListener(this);
		Log.v("CurrentButton ", String.valueOf(curBtn));
    	RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
    	if (hlvl == 0)
    		params.topMargin = VLevel[vlvl] + VAligin - VAligin/2;
    	else 
    		params.topMargin = VLevel[vlvl];
    	
    	ShapeDrawable w;
    	w = new ShapeDrawable(new RectShape());
   		w.setIntrinsicHeight(VLevel[5] + 2*VAligin/3 - VLevel[0]);
   		params.topMargin = VLevel[0];
   		GenButtons[curBtn].setMaxHeight(VAligin*6);
    	
    	w.setIntrinsicWidth(HAligin/3);
    	GenButtons[curBtn].setMaxWidth(HAligin/2);
    	
    	//if (CheckButton(GenButtons[curBtn]))
			w.getPaint().setColor(Color.WHITE);
    	//else w.getPaint().setColor(Color.BLACK);
    	
    	//MyButtons[curBtn].setBackgroundColor(Color.TRANSPARENT);
    	GenButtons[curBtn].setImageDrawable(w);

    	
    	params.leftMargin = HLevel[2 + curBtn * 3];
    	mLayout.addView(GenButtons[curBtn], params);
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
					return GenButtons[0].getResearched();
				case 4:
				case 9:
					return GenButtons[1].getResearched();
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
	
	/*public void CreateButton(int vlvl, int hlvl, int curBtn, Boolean genBtn)
    {
		MyButtons[curBtn] = new MyImageButton(this, curBtn);
		MyButtons[curBtn].setOnClickListener(this);
		Log.v("CurrentButton ", String.valueOf(curBtn));
    	RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
    	if (hlvl == 0)
    		params.topMargin = VLevel[vlvl] + VAligin - VAligin/2;
    	else 
    		params.topMargin = VLevel[vlvl];
    	
    	ShapeDrawable w;
    	w = new ShapeDrawable(new RectShape());
    	
    	if (!genBtn)
    	{
	    	w.setIntrinsicHeight(2*VAligin/3);
	    	MyButtons[curBtn].setMaxHeight(2*VAligin/3);
    	}
    	else 
    	{
    		w.setIntrinsicHeight(VLevel[5] + 2*VAligin/3 - VLevel[0]);
    		params.topMargin = VLevel[0];
    		MyButtons[curBtn].setMaxHeight(VAligin*6);
    	}
    	
    	w.setIntrinsicWidth(HAligin/3);
    	MyButtons[curBtn].setMaxWidth(HAligin/2);
    	
    	w.getPaint().setColor(Color.WHITE);
    	//MyButtons[curBtn].setBackgroundColor(Color.TRANSPARENT);
    	MyButtons[curBtn].setImageDrawable(w);

    	
    	params.leftMargin = HLevel[hlvl];
    	mLayout.addView(MyButtons[curBtn], params);
    }*/

	public OnClickListener ResearchListener = new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//MyImageButton btn = (MyImageButton)v;
			Log.v("HERE WE CRASHED", "CRASH");
			if (ActiveButtonNumber != -1)
			{
				/*TextView textTitle = (TextView) findViewById(R.id.textView1);
				textTitle.setText("Private");
				
				TextView textDescription = (TextView) findViewById(R.id.textView2);
				textDescription.setText("Private");*/
				//Drawable w;
				if (ActiveButtonType != 3)
				{
					MyMasButtons[ActiveButtonType][ActiveButtonNumber].setBackgroundColor(Color.BLACK);
					MyMasButtons[ActiveButtonType][ActiveButtonNumber].setResearching(true);
				}
					
				else
				{
					GenButtons[ActiveButtonNumber].setBackgroundColor(Color.BLACK);
					GenButtons[ActiveButtonNumber].setResearching(true);
				}
			
				/*ResearchInfo info = new ResearchInfo(MyMasButtons[ActiveButtonType][ActiveButtonNumber]);
				Intent in = new Intent();
				in.putExtra("extra2", info);
		        setResult(1,in);
		        finish();*/
			}
		}
	};
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		MyImageButton btn = (MyImageButton)v;
		TextView textTitle = (TextView) findViewById(R.id.textView1);
		//textTitle.setText(btn.getTitle());
		
		TextView textDescription = (TextView) findViewById(R.id.textView2);
		textDescription.setText(btn.getDescription());
		ActiveButtonNumber = btn.getNumber();
		ActiveButtonType = btn.getType();
		textTitle.setText(String.valueOf(ActiveButtonNumber));
		if (!CheckButton(btn))	
			ResBtn.setEnabled(false);
		else ResBtn.setEnabled(true);
		}
}