package com.example.multiselectpref;

import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.util.Log;
import android.preference.PreferenceFragment;



public class SettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new SettingsFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    	
    	public static final String KEY_PREF_NAME_CHOICE = "pref_key_name_choice";
    	
    	@Override
    	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
    			String key) {
    		if (key.equals(KEY_PREF_NAME_CHOICE)) {
    			Set<String> choice = sharedPreferences.getStringSet(key, new HashSet<String>());
    			String[] choice_array = choice.toArray(new String[choice.size()]);
    			
    			Log.d("test", "========");
    			for (String name : choice_array) {
    				Log.d("test", name);
				}
    		}
    		
    	}

        public SettingsFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
        	super.onCreate(savedInstanceState);
        	
        	addPreferencesFromResource(R.xml.preferences);
        }
        
        @Override
        public void onResume() {
        	super.onResume();
        	getPreferenceScreen().getSharedPreferences()
        		.registerOnSharedPreferenceChangeListener(this);
        }
        
        @Override
        public void onPause() {
        	super.onPause();
        	getPreferenceScreen().getSharedPreferences()
        		.unregisterOnSharedPreferenceChangeListener(this);
        }

    }
}
