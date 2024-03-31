package com.example.appdivinoamor.ui.noticias;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NoticiaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NoticiaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}