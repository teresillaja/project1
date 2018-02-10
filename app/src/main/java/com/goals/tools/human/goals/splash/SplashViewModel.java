package com.goals.tools.human.goals.splash;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashViewModel extends ViewModel {
    private LiveData<Boolean> started;

    public LiveData<Boolean> getStarted() {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();
        Single.just(Boolean.TRUE)
                .delay(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Boolean s) {
                        data.setValue(Boolean.TRUE);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        return data;
    }

}
