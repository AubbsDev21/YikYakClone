package yikyakclone.plutonium239.com.yikyakclone.activities;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import yikyakclone.plutonium239.com.yikyakclone.R;
import yikyakclone.plutonium239.com.yikyakclone.events.NewYakActivityEvents;
import yikyakclone.plutonium239.com.yikyakclone.utilities.Utilities;

public class NewYakActivity extends AppCompatActivity {
    private Button saveYak;
    private EditText newYakEditText;
    private TextView characterCount;
    private NewYakActivityEvents events = new NewYakActivityEvents();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_yak);

        initializeComponents();
        setEvents();

        ActionBar bar = getSupportActionBar();
        bar.setHomeButtonEnabled(true);
    }

    private void setEvents() {
//        saveYak.setOnClickListener(events.saveYakOnClickListener(this));
        newYakEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = 200 - editable.toString().length();
                characterCount.setText(length + "");

                if(length < 0) {
                    characterCount.setTextColor(Color.RED);
                } else {
                    characterCount.setTextColor(Color.BLACK);
                }
            }
        });
    }

    private void initializeComponents() {
        newYakEditText = (EditText)findViewById(R.id.newYakEditText);
        characterCount = (TextView)findViewById(R.id.counter);
//        saveYak = (Button)findViewById(R.id.saveYak);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_yak, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sendNewYak) {
            events.getSaveYakEventExecutor(this, Utilities.getLocation()).executeEvent();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public EditText getNewYakEditText() {
        return newYakEditText;
    }

    public String getNewYakText() {
        return newYakEditText.getText().toString();
    }
}
