package com.example.multiselectpref;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.preference.MultiSelectListPreference;
import android.util.AttributeSet;

public class DataHolder extends MultiSelectListPreference {
	
	public DataHolder(Context context,AttributeSet attrs) {
	    super(context, attrs);
	    
	    List<CharSequence> entries = new ArrayList<CharSequence>();
	    List<CharSequence> entriesValues = new ArrayList<CharSequence>();
	    
	    /** We could use the String Array like you did in your Q, 
	     * But I preffer this way of populating data - 
	     * It keeps things open and unlimitted.
	     * If you really want the data picked up from the xml , just use : 
	     * context.getResources().getStringArray(R.array.entries)
	     * context.getResources().getStringArray(R.array.entryValues) 
	     * */
	    
        entries.add("0");
        entries.add("1");
        entries.add("2");
        entries.add("3");
        entries.add("4");
        entriesValues.add("Tom");
        entriesValues.add("David");
        entriesValues.add("Bob");
        entriesValues.add("Mary");
        entriesValues.add("Chris");
        
	    setEntries(entries.toArray(new CharSequence[5]));
	    setEntryValues(entriesValues.toArray(new CharSequence[5]));
	}
}
