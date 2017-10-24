package ch.notli.notli.view;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import ch.notli.notli.R;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.prefrences);
    }
}