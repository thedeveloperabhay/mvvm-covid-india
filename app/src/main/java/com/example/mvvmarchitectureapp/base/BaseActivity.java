package com.example.mvvmarchitectureapp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.mvvmarchitectureapp.R;
import com.example.mvvmarchitectureapp.databinding.ActivityBaseBinding;

public class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements LoaderContracts{

    private ActivityBaseBinding baseBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseBinding = DataBindingUtil.setContentView(this,R.layout.activity_base);
    }

    @Override
    public void showProgressBar(Context context) {
        baseBinding.progresBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgressBar() {
        baseBinding.progresBar.setVisibility(View.GONE);
    }

    @Override
    public void setCollapsibleToolbarTitle(String title) {
        baseBinding.baseCollapsibleToolbar.setTitle(title);
    }

    public ViewGroup getContainer(){
        return baseBinding.baseFrameLayoutContainer;
    }
}
