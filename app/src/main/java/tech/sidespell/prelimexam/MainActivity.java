package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    ////////////////// VARIABLES ///////////////////////////////
    private RadioButton rdbIncrement;
    private RadioButton rdbDecrement;
    private TextView txtSpeed;
    private SeekBar seekBar;
    private TextView txtTime;
    private ToggleButton btnOnOf;
    private int speed;
    private int time;

    ////////////////////////////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rdbIncrement= (RadioButton)findViewById(R.id.rdbIncrement);
        rdbDecrement= (RadioButton)findViewById(R.id.rdbDecrement);
        txtSpeed=(TextView)findViewById(R.id.txtSpeed);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        txtTime=(TextView)findViewById(R.id.txtTime);
        btnOnOf=(ToggleButton)findViewById(R.id.tglOnOff);

        btnOnOf.setOnCheckedChangeListener(this);

    }

    final Handler handler = new Handler();
    final Runnable runnable = new Runnable() {

        @Override
        public void run() {

            int speed = Integer.parseInt(txtSpeed.getText().toString());
            int time = Integer.parseInt(txtTime.getText().toString());
            if (rdbIncrement.isChecked()) {
                time++;

                txtTime.setText(time + "");
                handler.postDelayed(runnable, speed);
            } else if (rdbDecrement.isChecked()) {
                time--;
                txtTime.setText(time + "");

            }

        }
    };





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        speed=Integer.parseInt(txtSpeed.getText().toString());
        if(isChecked)
        {
            handler.postDelayed(runnable, speed);
        }





    }





}
