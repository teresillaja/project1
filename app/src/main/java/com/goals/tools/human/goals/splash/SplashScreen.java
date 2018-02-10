package com.goals.tools.human.goals.splash;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.goals.tools.human.goals.DeadLineActivity.DeadLineActivity;
import com.goals.tools.human.goals.MainActivity;
import com.goals.tools.human.goals.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SplashViewModel viewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        viewModel.getStarted().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                SplashScreen.this.startNewActivity();
            }
        });
    }

    public void startNewActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}


