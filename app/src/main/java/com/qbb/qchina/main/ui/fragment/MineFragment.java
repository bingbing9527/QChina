package com.qbb.qchina.main.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.qbb.qchina.App;
import com.qbb.qchina.R;
import com.qbb.qchina.core.ui.BaseFragment;
import com.qbb.qchina.service.VideoLiveWallpaper;

/**
 * 创建日期：2017/5/15 15:31
 *
 * @author Qian Bing Bing
 *         类说明：我的Fragment
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private static final String FRAGMENT_INDEX = "fragment_index";
    public static MineFragment newInstance(int index){
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_INDEX, index);
        MineFragment fragment = new MineFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private Button button;
    private CheckBox mCbVoice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("tag","Fragment---4");
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCbVoice = (CheckBox) view.findViewById(R.id.id_cb_voice);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);

        mCbVoice.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView, boolean isChecked) {

                        if (isChecked) {
                            // 静音
                            VideoLiveWallpaper.voiceSilence(App.context);
                        } else {
                            VideoLiveWallpaper.voiceNormal(App.context);
                        }
                    }
                });
    }

    public void setVideoToWallPaper() {
        VideoLiveWallpaper.setToWallPaper(getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                setVideoToWallPaper();
                break;
        }
    }
}
