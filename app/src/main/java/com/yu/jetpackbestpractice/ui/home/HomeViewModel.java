package com.yu.jetpackbestpractice.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yu.jetpackbestpractice.model.Feed;
import com.yu.jetpackbestpractice.ui.AbsViewModel;

public class HomeViewModel extends AbsViewModel<Feed> {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}