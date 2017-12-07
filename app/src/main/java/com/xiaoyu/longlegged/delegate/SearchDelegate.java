package com.xiaoyu.longlegged.delegate;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.org.appfragme.utils.BindView;
import com.org.appfragme.utils.Constant;
import com.org.appfragme.utils.XXXLog;
import com.org.appfragme.view.AppDelegate;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.common.AppMethod;

import static android.R.attr.id;

/**
 * @Created: xiaoyu  on 2017.12.05 15:19.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.05 15:19.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class SearchDelegate extends AppDelegate implements View.OnClickListener {

    private TextView tv_sub;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        tv_sub = bindView(R.id.frag_tv_sub);
        setOnClickListener(this, R.id.frag_tv_sub);
        setOnClickListener(this, R.id.frag_tv_sub2);
    }

    @Override
    public void widgetClick(View view) {
        super.widgetClick(view);
        if (view.getId() == R.id.frag_tv_sub) {
            AppMethod.postShowWith(this.getActivity(), FragmentPage.Detail);
        }else if (view.getId() == R.id.frag_tv_sub2){
            AppMethod.postShowWith(this.getActivity(),FragmentPage.Detail, Constant.Constant_one, this);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Bundle data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
