package com.example.appdivinoamor.ui.contactanos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ContactosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}