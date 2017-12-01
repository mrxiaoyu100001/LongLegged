package com.xiaoyu.longlegged.delegate;

import com.org.appfragme.utils.DensityUtils;
import com.org.appfragme.view.AppDelegate;
import com.org.appfragme.widget.TitleBar;
import com.xiaoyu.longlegged.R;

/**
 * @Created: xiaoyu  on 2017.12.01 16:57.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.01 16:57.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class MainDelegate extends AppDelegate {

    private TitleBar tb_title;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tb_title = bindView(R.id.act_tb_title);
        tb_title.setTitle(getActivity().getString(R.string.app_name));
        tb_title.setHeight(DensityUtils.dip2dp(this.getActivity(), 44));
    }
}
