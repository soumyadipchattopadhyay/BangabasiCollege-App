package com.bangabasi_college.ui.developer;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class DeveloperViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DeveloperViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }
}