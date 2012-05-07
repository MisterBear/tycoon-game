package com.tycoon.personal;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PersonalActivity extends Activity {
    /** Called when the activity is first created. */
	int flag;
    private Button engineer,programmer,designer,cancel,hire,fire,plus,minus;
    private TextView current,total,currentinwork,personal,currentpersonal;
    data recivedata;
    Resources res;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res=getResources();
        setContentView(R.layout.personalactivity);
        Intent out =getIntent();
        recivedata=(data)out.getSerializableExtra("Personal data");
        engineer=(Button)findViewById(R.id.Button01);
        engineer.setOnClickListener(engineerButton);
        programmer=(Button)findViewById(R.id.Button05);
        programmer.setOnClickListener(programmerButton);
        designer=(Button)findViewById(R.id.Button02);
        designer.setOnClickListener(designerButton);
        cancel=(Button)findViewById(R.id.Button04);
        cancel.setOnClickListener(cancelButton);
        plus=(Button)findViewById(R.id.Button07);
        plus.setOnClickListener(plusButton);
        minus=(Button)findViewById(R.id.Button06);
        minus.setOnClickListener(minusButton);
        hire=(Button)findViewById(R.id.Button08);
        hire.setOnClickListener(hireButton);
        fire=(Button)findViewById(R.id.Button03);
        fire.setOnClickListener(fireButton);
        current=(TextView)findViewById(R.id.TextView04);
        total=(TextView)findViewById(R.id.TextView06);
        currentinwork=(TextView)findViewById(R.id.textView7);
        currentpersonal=(TextView)findViewById(R.id.textView8);
        personal=(TextView)findViewById(R.id.TextView02);
        total.setText(Integer.toString(recivedata.gettotalpersonal()));
        update();
        flag=0;        
    }
	private OnClickListener programmerButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
        personal.setText(res.getString(R.string.Personal)+" "+res.getString(R.string.Programmer));
        flag=1;
        update();
        };  
    };
    
    private OnClickListener engineerButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	personal.setText(res.getString(R.string.Personal)+" "+res.getString(R.string.Engineer));
        flag=0;
        update();
    };  
    };

    private OnClickListener designerButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
        personal.setText(res.getString(R.string.Personal)+" "+res.getString(R.string.Designer));
        flag=2;
        update();
    };  
    };
    
    private OnClickListener cancelButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	Intent in = new Intent();
        in.putExtra("Personal data back",recivedata );
        setResult(3,in);
        finish();
    };  
    };
    
    private OnClickListener hireButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	if (recivedata.gettotalpersonal()>(recivedata.getCurrentDesigners()+recivedata.getCurrentEngineers()+recivedata.getCurrentProgrammers()))
        {
     	   switch(flag)
     	   {
     	   case 0:
     	   {
     		   recivedata.setCurrentEngineers(recivedata.getCurrentEngineers()+1);
       		   break;
     	   }
     	   case 1:
     	   {
     		   recivedata.setCurrentProgrammers(recivedata.getCurrentProgrammers()+1);
       		   break;
     	   }
     	   case 2:
     	   {
     		   recivedata.setCurrentDesigners(recivedata.getCurrentDesigners()+1);
       		   break;
     	   }
     	   }
        }

  	   update();
       };  
    };
    
    private OnClickListener fireButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    switch(flag)
  	   {
  	   case 0:
  	   {
  		   if(recivedata.getCurrentEngineers()>0)
  		   {
  			   if (recivedata.getCurrentEngineers()==recivedata.getCurrentEngineersInWork())
  			   {
  				 recivedata.setCurrentEngineers(recivedata.getCurrentEngineers()-1);
  				 recivedata.setCurrentEngineersInWork(recivedata.getCurrentEngineersInWork()-1);
  			   }
  			   else
    			recivedata.setCurrentEngineers(recivedata.getCurrentEngineers()-1);
  		   }
  		   break;
  	   }
  	   case 1:
  	   {
 		   if(recivedata.getCurrentProgrammers()>0)
  		   {
 			   if (recivedata.getCurrentProgrammers()==recivedata.getCurrentProgrammersInWork())
 			   {
 				   recivedata.setCurrentProgrammers(recivedata.getCurrentProgrammers()-1);
 				   recivedata.setCurrentProgrammersInWork(recivedata.getCurrentProgrammersInWork()-1);
 			   }
 			   else
 				   recivedata.setCurrentProgrammers(recivedata.getCurrentProgrammers()-1);
  		   }
 		   break;
  	   }
  	   case 2:
  	   {
  		 if(recivedata.getCurrentDesigners()>0)
		   {
			   if (recivedata.getCurrentDesigners()==recivedata.getCurrentDesignersInWorkrs())
			   {
				   recivedata.setCurrentDesigners(recivedata.getCurrentDesigners()-1);
				   recivedata.setCurrentDesignersInWorkrs(recivedata.getCurrentDesignersInWorkrs()-1);
			   }
			   else
				   recivedata.setCurrentDesigners(recivedata.getCurrentDesigners()-1);
 		   }
  		 break;
  		 }
  	   }

	   update();
    };  
    };
    
    private OnClickListener minusButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
    	switch(flag)
  	   {
  	   case 0:
  	   {
  		   if (0<recivedata.getCurrentEngineersInWork())
  		   recivedata.setCurrentEngineersInWork(recivedata.getCurrentEngineersInWork()-1);
  		   break;
  	   }
  	   case 2:
  	   {
  		  if (0<recivedata.getCurrentDesignersInWorkrs())
     	  recivedata.setCurrentDesignersInWorkrs(recivedata.getCurrentDesignersInWorkrs()-1);
  		   break;
  	   }
  	   case 1:
  	   {
  		  if (0<recivedata.getCurrentProgrammersInWork())
     	  recivedata.setCurrentProgrammersInWork(recivedata.getCurrentProgrammersInWork()-1);
  		   break;
  	   }
  	   }
  	   update();
    };  
    };
    
    private OnClickListener plusButton = new OnClickListener()  
    {      
    public void onClick(View v)  
    {
     	   switch(flag)
     	   {
     	   case 0:
     	   {
     		   if (recivedata.getCurrentEngineers()>recivedata.getCurrentEngineersInWork())
     		   recivedata.setCurrentEngineersInWork(recivedata.getCurrentEngineersInWork()+1);
     		   break;
     	   }
     	   case 2:
     	   {
     		  if (recivedata.getCurrentDesigners()>recivedata.getCurrentDesignersInWorkrs())
        	  recivedata.setCurrentDesignersInWorkrs(recivedata.getCurrentDesignersInWorkrs()+1);
     		   break;
     	   }
     	   case 1:
     	   {
     		  if (recivedata.getCurrentProgrammers()>recivedata.getCurrentProgrammersInWork())
        	  recivedata.setCurrentProgrammersInWork(recivedata.getCurrentProgrammersInWork()+1);
     		   break;
     	   }
     	   }
     	   update();
    };  
    };
    void update()
    {
    	switch(flag)
  	   {
  	   case 0:
  	   {
  		   current.setText(Integer.toString(recivedata.getCurrentEngineers()+recivedata.getCurrentDesigners()+recivedata.getCurrentProgrammers()));
  	       currentinwork.setText(Integer.toString(recivedata.getCurrentEngineersInWork()));
  	        currentpersonal.setText(Integer.toString(recivedata.getCurrentEngineers()));
  	       break;
  	   }
  	   case 1:
  	   {
  	        current.setText(Integer.toString(recivedata.getCurrentEngineers()+recivedata.getCurrentDesigners()+recivedata.getCurrentProgrammers()));
  	        currentinwork.setText(Integer.toString(recivedata.getCurrentProgrammersInWork()));
  	        currentpersonal.setText(Integer.toString(recivedata.getCurrentProgrammers()));
  		   break;
  	   }
  	   case 2:
  	   {
  	        current.setText(Integer.toString(recivedata.getCurrentEngineers()+recivedata.getCurrentDesigners()+recivedata.getCurrentProgrammers()));
  	        currentinwork.setText(Integer.toString(recivedata.getCurrentDesignersInWorkrs()));
  	        currentpersonal.setText(Integer.toString(recivedata.getCurrentDesigners()));
  	        break;
  	   }
  	   }
    }

    
}