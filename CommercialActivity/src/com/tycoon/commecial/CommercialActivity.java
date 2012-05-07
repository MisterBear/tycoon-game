package com.tycoon.commecial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.*;
import android.app.ListActivity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
 
public class CommercialActivity extends Activity {
	Context cont;
	data recivedata;
	Resources res;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commercialactivity);
        ListView list = (ListView)findViewById(R.id.listView1);
        res=getResources();
	    final CharSequence[] Name;     	
    	Name = res.getTextArray(R.array.Name);
        Intent out =getIntent();
        recivedata=(data)out.getSerializableExtra("Commercial data");
        // Creating the list adapter and populating the list
        ArrayAdapter<String> listAdapter = new CustomListAdapter(this, R.layout.list_item);
        for (int i=0; i<recivedata.getgeneration()*3;i++)
        {
        	listAdapter.add(Name[i].toString());
        }
        list.setAdapter(listAdapter);
        list.setOnItemClickListener(itemclick);
        cont=getApplicationContext();
    }
    private AdapterView.OnItemClickListener itemclick = new AdapterView.OnItemClickListener()  
    {      
    	public void onItemClick(AdapterView<?> parent, final View view, int position, long id)  
    {
        Toast.makeText(cont, "Ï„Û", 3).show();
    };  
    };
class CustomListAdapter extends ArrayAdapter<String> {

    public CustomListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.list_item, null);
        }

        ((TextView)convertView.findViewById(R.id.title)).setText(getItem(position));
        
        // Resets the toolbar to be closed
        return convertView;
    }
}
}
