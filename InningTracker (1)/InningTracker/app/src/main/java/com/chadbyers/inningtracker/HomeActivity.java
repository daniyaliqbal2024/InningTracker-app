package com.chadbyers.inningtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.chadbyers.inningtracker.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityHomeBinding binding;
    private static final String BUNDLE_NUMS_BALLS= "numballs";
    private static final String BUNDLE_NUM_STRIKES= "numStrikes";
    private static final String BUNDLE_NUM_OUTS="numOuts";


    private InningTracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonAddBall.setOnClickListener(this);
        binding.buttonAddStrike.setOnClickListener(this);
        binding.buttonAddOut.setOnClickListener(this);
        binding.buttonReset.setOnClickListener(this);
        if (savedInstanceState!= null)
        {
            int numBalls= savedInstanceState.getInt(BUNDLE_NUMS_BALLS);
            int numOuts= savedInstanceState.getInt(BUNDLE_NUM_OUTS);
            int numStrikes= savedInstanceState.getInt(BUNDLE_NUM_STRIKES);
            tracker= new InningTracker(numBalls, numStrikes, numOuts);

        }
        else {
            tracker = new InningTracker();
        }
        updateDisplay();
    }

    public void updateDisplay() {
        binding.textNumBalls.setText(String.valueOf(tracker.getNumBalls()));
        binding.textNumStrikes.setText(String.valueOf(tracker.getNumStrikes()));
        binding.textNumOuts.setText(String.valueOf(tracker.getNumOuts()));
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_add_ball:{
                // Add ball to inning data
                tracker.incrementNumBalls();
                break;
            }
            case R.id.button_add_strike:{
                // Add strike to inning data
                tracker.incrementNumStrikes();
                break;
            }
            case R.id.button_add_out:{
                // Add out to inning data
              tracker.incrementNumOuts();
                break;
            }
            case R.id.button_reset:{
                // Reset balls and strikes
                tracker.resetBallsAndStrikes();
                break;
            }
        }
        updateDisplay();
    }

    protected void onSavedInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_NUM_OUTS, tracker.getNumOuts());
        outState.putInt(BUNDLE_NUM_STRIKES, tracker.getNumStrikes());
        outState.putInt(BUNDLE_NUMS_BALLS, tracker.getNumBalls());
    }
}

