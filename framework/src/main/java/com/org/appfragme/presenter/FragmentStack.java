package com.org.appfragme.presenter;

import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Created: xiaoyu  on 2017.12.04 15:20.
 * @Describe：界面工厂
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 15:20.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class FragmentStack {

    private Map<Class, FragmentPresenter> fragments;
    private String Tag = " AppFactory ";
    private static AppFactory instance;

    private FragmentStack() {
        //界面应该不超过300个
        fragments = new HashMap<>(300);
    }

    /**
     * 这个东西不知道有没有用，暂时先写上。
     *
     * @return
     */
    public static AppFactory getFactory() {
        if (instance == null) {
            synchronized (AppFactory.class) {
                if (instance == null) {
                    instance = new AppFactory();
                }
            }
        }
        return instance;
    }

    /**
     * 加入fragment队列里面
     * @param cla
     * @return
     */
    private boolean addFragment(Class cla){
        if (!quaryFragment(cla)){
            if (fragments != null){
                try {
                    fragments.put(cla, (FragmentPresenter) cla.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    return false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 移除相应的界面
     * @param cla
     * @return
     */
    private boolean removeFragment(Class<?> cla){
        if (fragments != null){
            if (quaryFragment(cla)){
                fragments.remove(cla);
                return true;
            }
        }
        return false;
    }

    /**
     * 删除全部的界面
     * @return
     */
    private boolean removeAllFragment(){
        if (fragments != null){
            Iterator<Class> iter = fragments.keySet().iterator();
            while (iter.hasNext()){
                iter.next();
                iter.remove();
            }
            return true;
        }
        return false;
    }

    /**
     * 更新相应的界面
     * @param cla
     * @return
     */
    private boolean updateFragment(Class<?> cla){
        return false;
    }

    /**
     * 查询相应界面
     * @param cla
     * @return
     */
    private boolean quaryFragment(Class<?> cla){
        if (fragments != null){
            return fragments.containsKey(cla);
        }
        return false;
    }

    /**
     * 获取相应的界
     * @param cla
     * @return
     */
    private Fragment getFragment(Class<?> cla){
        if (fragments != null){
            return fragments.get(cla);
        }
        return null;
    }

}
