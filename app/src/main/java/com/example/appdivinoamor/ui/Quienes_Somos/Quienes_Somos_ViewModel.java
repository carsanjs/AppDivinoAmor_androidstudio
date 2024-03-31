package com.example.appdivinoamor.ui.Quienes_Somos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Quienes_Somos_ViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public Quienes_Somos_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
