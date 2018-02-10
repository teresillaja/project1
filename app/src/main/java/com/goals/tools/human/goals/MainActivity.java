package com.goals.tools.human.goals;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.goals.tools.human.goals.goals.GoalsFragment;
import com.goals.tools.human.goals.reports.ReportsFragment;
import com.goals.tools.human.goals.tasks.TasksFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements GoalsFragment.OnFragmentInteractionListener,
        TasksFragment.OnFragmentInteractionListener,
        ReportsFragment.OnFragmentInteractionListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new GoalsFragment());
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_goals:
                    fragment = new GoalsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_tasks:
                    fragment = new TasksFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_reports:
                    fragment = new ReportsFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
