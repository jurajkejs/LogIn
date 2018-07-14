package com.codeboss.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewRegister, textViewLogIn;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RegisterFragment registerFragment;
    private LogInFragment logInFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRegister = findViewById(R.id.textViewRegister);
        textViewLogIn = findViewById(R.id.textViewLogIn);
        fragmentManager = getSupportFragmentManager();
        registerFragment = new RegisterFragment();
        logInFragment = new LogInFragment();

        switchFragment(registerFragment);

        textViewRegister.setOnClickListener(this);
        textViewLogIn.setOnClickListener(this);

    }

    private void switchFragment(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment == registerFragment) {
            fragmentTransaction.replace(R.id.frameLayoutContainer, fragment, fragment.getClass().getSimpleName());
        } else {
            fragmentTransaction.replace(R.id.frameLayoutContainer, fragment, fragment.getClass().getSimpleName());
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewRegister:
                textViewRegister.setBackground(getResources().getDrawable(R.drawable.drawable_primary_left));
                textViewRegister.setTextColor(getResources().getColor(R.color.colorWhite));
                textViewLogIn.setBackground(getResources().getDrawable(R.drawable.drawable_white_right));
                textViewLogIn.setTextColor(getResources().getColor(R.color.colorPrimary));
                switchFragment(registerFragment);
                break;
            case R.id.textViewLogIn:
                textViewRegister.setBackground(getResources().getDrawable(R.drawable.drawable_white_left));
                textViewRegister.setTextColor(getResources().getColor(R.color.colorPrimary));
                textViewLogIn.setBackground(getResources().getDrawable(R.drawable.drawable_primary_right));
                textViewLogIn.setTextColor(getResources().getColor(R.color.colorWhite));
                switchFragment(logInFragment);
                break;
        }
    }
}
