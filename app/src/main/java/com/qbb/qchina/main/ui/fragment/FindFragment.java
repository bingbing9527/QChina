package com.qbb.qchina.main.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qbb.qchina.R;
import com.qbb.qchina.core.ui.BaseFragment;

/**
 * 创建日期：2017/5/15 15:31
 *
 * @author Qian Bing Bing
 *         类说明：发现Fragment
 */

public class FindFragment extends BaseFragment {
    private static final String FRAGMENT_INDEX = "fragment_index";
    public static FindFragment newInstance(int index){
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_INDEX, index);
        FindFragment fragment = new FindFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setText("Fragment---3");
        Log.e("tag","Fragment---3");
    }
}
