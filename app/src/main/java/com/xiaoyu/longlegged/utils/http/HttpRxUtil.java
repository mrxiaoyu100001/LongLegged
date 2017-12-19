//package com.xiaoyu.longlegged.utils.http;
//
//import com.vise.netexpand.request.ApiGetRequest;
//import com.vise.netexpand.request.ApiPostRequest;
//import com.vise.xsnow.common.GsonUtil;
//import com.vise.xsnow.http.ViseHttp;
//import com.vise.xsnow.http.callback.ACallback;
//import com.vise.xsnow.http.mode.CacheMode;
//import com.vise.xsnow.http.mode.CacheResult;
//
//import java.util.List;
//
///**
// * @Created: xiaoyu  on 2017.12.17 20:19.
// * @Describe：网络请求管理器
// * @Review：
// * @Modify：
// * @Version: v_1.0 on 2017.12.17 20:19.
// * @Blog:http://blog.csdn.net/noteschapter
// * @Github:https://github.com/mrxiaoyu100001
// * @Resources:
// * @Remark:
// */
//
//public class HttpRxUtil {
//
//    private HttpRxUtil() {
//        throw new RuntimeException("Not init!!!");
//    }
//    /*清除缓存*/
//    public static void clearCache() {
//        ViseHttp.getInstance().clearCache();
//    }
//
//    private void GET(String url, ResponseBack responseBack) {
//        ViseHttp.GET().suffixUrl("getAuthor").request(new ACallback<AuthorModel>() {
//            @Override
//            public void onSuccess(AuthorModel authorModel) {
//                ViseLog.i("request onSuccess!");
//                if (authorModel == null) {
//                    return;
//                }
//                mShow_response_data.setText(authorModel.toString());
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
//                ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//            }
//        });
//    }
//
//    private void request_get_2() {
//        mShow_response_data.setText("");
//        ViseHttp.GET()
//                .suffixUrl("getAuthor")
//                .setLocalCache(true)
//                .cacheMode(CacheMode.FIRST_CACHE)
//                .request(new ACallback<CacheResult<AuthorModel>>() {
//                    @Override
//                    public void onSuccess(CacheResult<AuthorModel> cacheResult) {
//                        ViseLog.i("request onSuccess!");
//                        if (cacheResult == null || cacheResult.getCacheData() == null) {
//                            return;
//                        }
//                        if (cacheResult.isCache()) {
//                            mShow_response_data.setText("From Cache:\n" + cacheResult.getCacheData().toString());
//                        } else {
//                            mShow_response_data.setText("From Remote:\n" + cacheResult.getCacheData().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
//    }
//
//    private void request_get_3() {
//        mShow_response_data.setText("");
//        ViseHttp.GET()
//                .suffixUrl("getAuthor")
//                .setLocalCache(true)
//                .cacheMode(CacheMode.FIRST_REMOTE)
//                .request(new ACallback<CacheResult<AuthorModel>>() {
//                    @Override
//                    public void onSuccess(CacheResult<AuthorModel> cacheResult) {
//                        ViseLog.i("request onSuccess!");
//                        if (cacheResult == null || cacheResult.getCacheData() == null) {
//                            return;
//                        }
//                        if (cacheResult.isCache()) {
//                            mShow_response_data.setText("From Cache:\n" + cacheResult.getCacheData().toString());
//                        } else {
//                            mShow_response_data.setText("From Remote:\n" + cacheResult.getCacheData().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
//    }
//
//    private void request_get_4() {
//        mShow_response_data.setText("");
//        ViseHttp.GET()
//                .suffixUrl("getAuthor")
//                .setLocalCache(true)
//                .cacheMode(CacheMode.ONLY_CACHE)
//                .request(new ACallback<CacheResult<AuthorModel>>() {
//                    @Override
//                    public void onSuccess(CacheResult<AuthorModel> cacheResult) {
//                        ViseLog.i("request onSuccess!");
//                        if (cacheResult == null || cacheResult.getCacheData() == null) {
//                            return;
//                        }
//                        if (cacheResult.isCache()) {
//                            mShow_response_data.setText("From Cache:\n" + cacheResult.getCacheData().toString());
//                        } else {
//                            mShow_response_data.setText("From Remote:\n" + cacheResult.getCacheData().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
//    }
//
//    private void request_get_5() {
//        mShow_response_data.setText("");
//        ViseHttp.GET()
//                .suffixUrl("getAuthor")
//                .setLocalCache(true)
//                .cacheMode(CacheMode.ONLY_REMOTE)
//                .request(new ACallback<CacheResult<AuthorModel>>() {
//                    @Override
//                    public void onSuccess(CacheResult<AuthorModel> cacheResult) {
//                        ViseLog.i("request onSuccess!");
//                        if (cacheResult == null || cacheResult.getCacheData() == null) {
//                            return;
//                        }
//                        if (cacheResult.isCache()) {
//                            mShow_response_data.setText("From Cache:\n" + cacheResult.getCacheData().toString());
//                        } else {
//                            mShow_response_data.setText("From Remote:\n" + cacheResult.getCacheData().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
//    }
//
//    private void request_get_6() {
//        mShow_response_data.setText("");
//        ViseHttp.GET()
//                .suffixUrl("getAuthor")
//                .setLocalCache(true)
//                .cacheMode(CacheMode.CACHE_AND_REMOTE)
//                .request(new ACallback<CacheResult<AuthorModel>>() {
//                    @Override
//                    public void onSuccess(CacheResult<AuthorModel> cacheResult) {
//                        ViseLog.i("request onSuccess!");
//                        if (cacheResult == null || cacheResult.getCacheData() == null) {
//                            return;
//                        }
//                        if (cacheResult.isCache()) {
//                            mShow_response_data.setText("From Cache:\n" + cacheResult.getCacheData().toString());
//                        } else {
//                            mShow_response_data.setText("From Remote:\n" + cacheResult.getCacheData().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
//    }
//
//    private void request_get_7() {
//        mShow_response_data.setText("");
//        ViseHttp.GET().suffixUrl("getString").request(new ACallback<String>() {
//            @Override
//            public void onSuccess(String data) {
//                ViseLog.i("request onSuccess!");
//                if (data == null) {
//                    return;
//                }
//                mShow_response_data.setText(data);
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
//                ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//            }
//        });
//    }
//
//    private void request_get_8() {
//        mShow_response_data.setText("");
//        ViseHttp.GET().suffixUrl("getListAuthor").request(new ACallback<List<AuthorModel>>() {
//            @Override
//            public void onSuccess(List<AuthorModel> authorModel) {
//                ViseLog.i("request onSuccess!");
//                if (authorModel == null) {
//                    return;
//                }
//                mShow_response_data.setText(authorModel.toString());
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
//                ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//            }
//        });
//    }
//
//    private void request_get_9() {
//        mShow_response_data.setText("");
//        ViseHttp.BASE(new ApiGetRequest()).suffixUrl("getApiResultAuthor").request(new ACallback<AuthorModel>() {
//            @Override
//            public void onSuccess(AuthorModel authorModel) {
//                ViseLog.i("request onSuccess!");
//                if (authorModel == null) {
//                    return;
//                }
//                mShow_response_data.setText(authorModel.toString());
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
//                ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//            }
//        });
//    }
//
//    private void request_get_10() {
//        mShow_response_data.setText("");
//        ViseHttp.BASE(new ApiGetRequest()).suffixUrl("getApiResultString").request(new ACallback<String>() {
//            @Override
//            public void onSuccess(String data) {
//                ViseLog.i("request onSuccess!");
//                if (data == null) {
//                    return;
//                }
//                mShow_response_data.setText(data);
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
//                ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//            }
//        });
//    }
//
//    private void request_get_11() {
//        mShow_response_data.setText("");
//        ViseHttp.BASE(new ApiGetRequest()).suffixUrl("getApiResultListAuthor").request(new ACallback<List<AuthorModel>>() {
//            @Override
//            public void onSuccess(List<AuthorModel> authorModel) {
//                ViseLog.i("request onSuccess!");
//                if (authorModel == null) {
//                    return;
//                }
//                mShow_response_data.setText(authorModel.toString());
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
//                ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//            }
//        });
//    }
//
//    private void request_post_1() {
//        mShow_response_data.setText("");
//        ViseHttp.BASE(new ApiPostRequest()).suffixUrl("postAuthor").request(new ACallback<String>() {
//            @Override
//            public void onSuccess(String data) {
//                ViseLog.i("request onSuccess!");
//                if (data == null) {
//                    return;
//                }
//                mShow_response_data.setText(data);
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
//                ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//            }
//        });
//    }
//
//    private void request_post_2() {
//        mShow_response_data.setText("");
//        ViseHttp.BASE(new ApiPostRequest()
//                .addForm("author_name", getString(R.string.author_name))
//                .addForm("author_nickname", getString(R.string.author_nickname))
//                .addForm("author_account", "xiaoyaoyou1212")
//                .addForm("author_github", "https://github.com/xiaoyaoyou1212")
//                .addForm("author_csdn", "http://blog.csdn.net/xiaoyaoyou1212")
//                .addForm("author_websit", "http://www.huwei.tech/")
//                .addForm("author_introduction", getString(R.string.author_introduction)))
//                .suffixUrl("postFormAuthor")
//                .request(new ACallback<String>() {
//                    @Override
//                    public void onSuccess(String data) {
//                        ViseLog.i("request onSuccess!");
//                        if (data == null) {
//                            return;
//                        }
//                        mShow_response_data.setText(data);
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
//    }
//
//    private void request_post_3() {
//        mShow_response_data.setText("");
//        AuthorModel mAuthorModel = new AuthorModel();
//        mAuthorModel.setAuthor_id(1008);
//        mAuthorModel.setAuthor_name(getString(R.string.author_name));
//        mAuthorModel.setAuthor_nickname(getString(R.string.author_nickname));
//        mAuthorModel.setAuthor_account("xiaoyaoyou1212");
//        mAuthorModel.setAuthor_github("https://github.com/xiaoyaoyou1212");
//        mAuthorModel.setAuthor_csdn("http://blog.csdn.net/xiaoyaoyou1212");
//        mAuthorModel.setAuthor_websit("http://www.huwei.tech/");
//        mAuthorModel.setAuthor_introduction(getString(R.string.author_introduction));
//        ViseHttp.BASE(new ApiPostRequest()
//                .setJson(GsonUtil.gson().toJson(mAuthorModel)))
//                .suffixUrl("postJsonAuthor")
//                .request(new ACallback<String>() {
//                    @Override
//                    public void onSuccess(String data) {
//                        ViseLog.i("request onSuccess!");
//                        if (data == null) {
//                            return;
//                        }
//                        mShow_response_data.setText(data);
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
//    }
//
//    private void request_post_4() {
//        mShow_response_data.setText("");
//        AuthorModel mAuthorModel = new AuthorModel();
//        mAuthorModel.setAuthor_id(1009);
//        mAuthorModel.setAuthor_name(getString(R.string.author_name));
//        mAuthorModel.setAuthor_nickname(getString(R.string.author_nickname));
//        mAuthorModel.setAuthor_account("xiaoyaoyou1212");
//        mAuthorModel.setAuthor_github("https://github.com/xiaoyaoyou1212");
//        mAuthorModel.setAuthor_csdn("http://blog.csdn.net/xiaoyaoyou1212");
//        mAuthorModel.setAuthor_websit("http://www.huwei.tech/");
//        mAuthorModel.setAuthor_introduction(getString(R.string.author_introduction));
//        ViseHttp.BASE(new ApiPostRequest()
//                .addUrlParam("appId", "10001")
//                .addUrlParam("appType", "Android")
//                .setJson(GsonUtil.gson().toJson(mAuthorModel)))
//                .suffixUrl("postUrlAuthor")
//                .request(new ACallback<String>() {
//                    @Override
//                    public void onSuccess(String data) {
//                        ViseLog.i("request onSuccess!");
//                        if (data == null) {
//                            return;
//                        }
//                        mShow_response_data.setText(data);
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        ViseLog.e("request errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
//    }
//
//    public interface ResponseBack {
//        void onSuccess(String response);
//        void onFail(int errCode, String errMsg);
//    }
//
//    private ResponseBack listener;
//
//}
