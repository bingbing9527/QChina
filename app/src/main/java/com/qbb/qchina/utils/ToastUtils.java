package com.qbb.qchina.utils;

import android.widget.Toast;

import com.qbb.qchina.App;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * 创建日期：2017/5/15 11:19
 *
 * @author Qian Bing Bing
 *         类说明：吐司工具类
 */

public class ToastUtils {

    public static Toast toast;

    public static Toast getInstance(CharSequence msg, int duration) {
        if (toast == null) {
            synchronized (ToastUtils.class) {
                if (toast == null) {
                    toast = Toast.makeText(App.context, msg, duration);
                }
            }
        } else {
            toast.setText(msg);
            toast.setDuration(duration);
        }
        return toast;
    }


    /**
     * 短时间内展示
     *
     * @param msg
     */
    public static void showShort(final CharSequence msg) {
//        getInstance(msg,Toast.LENGTH_SHORT).show();
//        Observable
//                .just(msg)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<CharSequence>() {
//                    @Override
//                    public void accept(@NonNull CharSequence sequence) throws Exception {
//                        getInstance(msg, Toast.LENGTH_SHORT).show();
//                    }
//                });
        Observable.create(new ObservableOnSubscribe<CharSequence>() {
            @Override
            public void subscribe(ObservableEmitter<CharSequence> e) throws Exception {
                e.onNext(msg);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence sequence) throws Exception {
                        getInstance(msg, Toast.LENGTH_SHORT).show();
                    }
                }).subscribe();
    }

    public static void showShortId(int stringId) {
        String msg = App.context.getString(stringId);
        showShort(msg);
    }

    /**
     * 长时间内展示
     *
     * @param msg
     */
    public void showLong(final CharSequence msg) {
//        getInstance(msg,Toast.LENGTH_SHORT).show();
//        Observable
//                .just(msg)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<CharSequence>() {
//                    @Override
//                    public void accept(@NonNull CharSequence sequence) throws Exception {
//                        getInstance(msg, Toast.LENGTH_LONG).show();
//                    }
//                });
    }

    public void showLongId(int stringId) {
        String msg = App.context.getString(stringId);
        showLong(msg);
    }

}
