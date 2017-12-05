package com.xiaoyu.longlegged.delegate;

import android.view.View;

import com.org.appfragme.utils.DensityUtils;
import com.org.appfragme.view.AppDelegate;
import com.org.appfragme.widget.TitleBar;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.base.FragmentPage;
import com.xiaoyu.longlegged.common.AppMethod;

/**
 * @Created: xiaoyu  on 2017.12.04 17:13.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 17:13.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MainFragDelegate extends AppDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TitleBar tb_title = bindView(R.id.frag_tb_title);
        tb_title.setHeight(DensityUtils.dip2dp(this.getActivity(), 44));
        tb_title.setLeftImageResource(R.mipmap.main_left);
        tb_title.setTitle(R.string.main_title);
        tb_title.setTitleColor(getActivity().getResources().getColor(R.color.col_ffffff));
        tb_title.setTitleSize(DensityUtils.dip2sp(this.getActivity(), 18));
        tb_title.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppMethod.postShowWith(getActivity(), FragmentPage.Search);
            }
        });
        tb_title.setVisibility(View.GONE);
    }
}
