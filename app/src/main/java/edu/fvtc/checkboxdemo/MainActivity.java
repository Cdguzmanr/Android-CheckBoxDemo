package edu.fvtc.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    // to write the tag faster, write psfs and press tab
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox chkInfo = findViewById(R.id.chkInfo);
        chkInfo.setOnCheckedChangeListener(this);

        initToggleButton();
        this.setTitle(getString(R.string.checkbox_demo));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;

    }


    private void initToggleButton() {
        Button btnToggle = findViewById(R.id.btnToggle);

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox chkInfo = findViewById(R.id.chkInfo);

                // Method 1
                /*
                boolean isChecked = chkInfo.isChecked();
                chkInfo.setChecked(!isChecked);
                */

                // Method 2
                chkInfo.toggle();

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton checkbox, boolean isChecked) {
        Log.d(TAG, "OnCheckedChanged: ");

        TextView tvInfo = findViewById(R.id.tvInfo);

        if (isChecked){
            checkbox.setText(R.string.checked);
        }
        else {
            checkbox.setText(R.string.unchecked);
        }
        tvInfo.setText(checkbox.getText());

    }
}