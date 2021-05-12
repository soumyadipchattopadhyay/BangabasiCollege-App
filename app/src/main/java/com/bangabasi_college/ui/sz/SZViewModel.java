package com.bangabasi_college.ui.sz;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SZViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SZViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }
}