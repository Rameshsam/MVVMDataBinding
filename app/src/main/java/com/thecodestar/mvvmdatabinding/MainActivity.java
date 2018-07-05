package com.thecodestar.mvvmdatabinding;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.thecodestar.mvvmdatabinding.interfaces.LoginResultCallback;
import com.thecodestar.mvvmdatabinding.viewmodels.LoginViewModel;
import com.thecodestar.mvvmdatabinding.viewmodels.LoginViewModelFactory;

public class MainActivity extends AppCompatActivity implements LoginResultCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this)).get(LoginViewModel.class));

    }

    @Override
    public void onSuccess(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
