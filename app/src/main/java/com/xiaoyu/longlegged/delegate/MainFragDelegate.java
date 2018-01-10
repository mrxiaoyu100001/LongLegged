package com.xiaoyu.longlegged.delegate;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.org.appfragme.utils.ViewInject;
import com.org.appfragme.view.FragmentDelegate;
import com.org.appfragme.widget.ActionBar;
import com.org.appfragme.widget.CommonTitleBar;
import com.vise.log.ViseLog;
import com.vise.netexpand.request.ApiPostRequest;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;
import com.xiaoyu.longlegged.R;
import com.xiaoyu.longlegged.common.BaseUrl;
import com.xiaoyu.longlegged.modle.request.LoginRequest;
import com.xiaoyu.longlegged.modle.request.TestRequest;
import com.xiaoyu.longlegged.modle.response.login.LoginResponse;
import com.xiaoyu.longlegged.modle.response.test.TestBean;

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

public class MainFragDelegate extends FragmentDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initWidget(View contentView) {
        super.initWidget(contentView);
        setOnClickListener(this, R.id.frag_tv_test);
    }

    @Override
    public void setTitleBar(@NonNull ActionBar titleBar) throws NullPointerException {
        super.setTitleBar(titleBar);
        titleBar.setShowTitleBar(true)
                .setStatusBarColor(R.color.color_A973FB)
                .setTitleBarColor(R.color.color_A973FB)
                .setLeftImageResource(R.mipmap.main_left)
                .setCenterType(CommonTitleBar.TYPE_CENTER_TEXTVIEW)
                .setCenterText(R.string.app_name)
                .setCenterTextColor(R.color.color_ffffff)
                .setCenterTextSize(18)
                .setRightType(CommonTitleBar.TYPE_RIGHT_IMAGEBUTTON)
                .setRightImageResource(R.mipmap.main_search)
                .setFillStatusBar(true);
    }

    @Override
    public void onBarClicked(View v, int action, String extra) {
        super.onBarClicked(v, action, extra);
        switch (action) {
            case CommonTitleBar.ACTION_LEFT_BUTTON:
                ViewInject.showCenterToast(this.getActivity(), "点击了左边");
                break;
            case CommonTitleBar.ACTION_RIGHT_BUTTON:
                ViewInject.showCenterToast(this.getActivity(), "点击了右边");
                break;
        }
    }

    @Override
    public void widgetClick(View view) {
        super.widgetClick(view);
        testPOST();
//        Bundle bundle = new Bundle();
//        bundle.putString(Constant.Constant_key, getActivity().getString(R.string.app_content));
//        AppMethod.postShowWith(this.getActivity(), FragmentPage.Search, bundle);
    }

    private void testPOST() {
        TestRequest request = new TestRequest();
        request.setId(1000L);
        request.setUserName("我是赵大宝");
        ViseHttp.POST()
//                .addParam("id", "100")
//                .addParam("author_id", "100")
//                .addParam("author_name", "大写的雨6")
//                .addParam("author_nickname", "小雨")
//                .addParam("author_account", "100")
//                .addParam("author_github", "100")
//                .addParam("author_csdn", "100")
//                .addParam("author_websit", "100")
//                .addParam("author_introduction", "100")
                .setJson(JSON.toJSONString(request))
                .suffixUrl(BaseUrl.TestUrl)
                .request(new ACallback<TestBean>() {
            @Override
            public void onSuccess(TestBean data) {
                ((TextView) bindView(R.id.frag_tv_test)).setText(data.getData());
            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }

    private void login() {
        LoginRequest request = new LoginRequest();
        request.setAccount("13241800853");
        request.setPassword("654321");
        ViseHttp.BASE(new ApiPostRequest()
//                .setJson(BaseUrl.desutil.getEncAndBase64String(JSON.toJSONString(request))))
                .setJson(JSON.toJSONString(request)))
                .suffixUrl(BaseUrl.Login)
                .request(new ACallback<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse userList) {
                        ViseLog.i("request onSuccess!" + userList);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
                    }
                });
    }

}
