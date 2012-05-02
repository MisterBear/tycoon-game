package com.rage.research;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

public class Draw2D extends View{
	
	Context mContext;
	
	int viewWidth = 0;
    int viewHeight = 0;
    
    RelativeLayout mLayout;
    
    public Draw2D(Context context) 
    {
	        super(context);
	        mContext = context;
	        mLayout = (RelativeLayout) findViewById(R.id.mLay);
	}  
    
	@Override
	protected void onDraw(Canvas c){
	    super.onDraw(c);
	    
	    viewWidth = getWidth();
        viewHeight = getHeight();
	    
	    //Paint paint = new Paint();
	    //paint.setStyle(Paint.Style.FILL);

	    // закрашиваем холст белым цветом
	    //paint.setColor(Color.WHITE);
	    //c.drawPaint(paint);
	    
	    Paint paint1 = new Paint();
	    paint1.setStyle(Paint.Style.FILL);
	    paint1.setColor(Color.RED);
	    
	    Paint paint2 = new Paint();
	    paint2.setStyle(Paint.Style.FILL);
	    paint2.setColor(Color.BLUE);
	    
	    Paint paint3 = new Paint();
	    paint3.setStyle(Paint.Style.FILL);
	    paint3.setColor(Color.GREEN);
	    
	    int cmp = viewHeight/3;
	    Rect myRect1 = new Rect(0, 0, viewWidth, cmp);
	    Rect myRect2 = new Rect(0, cmp,viewWidth, 2 * cmp);
	    Rect myRect3 = new Rect(0, 2 * cmp, viewWidth, viewHeight);
	    c.drawRect(myRect1, paint1);
	    c.drawRect(myRect2, paint2);
	    c.drawRect(myRect3, paint3);
    }
	
}