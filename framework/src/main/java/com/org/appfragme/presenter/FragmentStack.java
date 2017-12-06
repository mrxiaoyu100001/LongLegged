package com.org.appfragme.presenter;

import com.org.appfragme.utils.XXXLog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Created: xiaoyu  on 2017.12.04 15:20.
 * @Describe：FragmentPresenter工厂
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
    private static String Tag = " FragmentStack ";
    private static FragmentStack instance;

    /**
     * @param stack
     */
    private FragmentStack(int stack) {
        fragments = new HashMap<>(stack);
    }

    /**
     * 这个东西不知道有没有用，暂时先写上。
     *
     * @param stack
     * @return
     */
    public static FragmentStack getFragmentStack(int stack) {
        if (instance == null) {
            synchronized (FragmentStack.class) {
                if (instance == null) {
                    instance = new FragmentStack(stack);
                    XXXLog.i(Tag + "init success!");
                }
            }
        }
        return instance;
    }

    /**
     * @param cla
     * @param <T>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private <T extends FragmentPresenter> T newInstance(Class<T> cla) throws
            InstantiationException, IllegalAccessException {
        return (T) cla.newInstance();
    }

    /**
     * 加入fragment队列里面
     * @param cla
     * @return
     */
    public FragmentPresenter addFragment(Class<? extends FragmentPresenter> cla) {
        if (!quaryFragment(cla)) {
            if (fragments != null) {
                try {
                    fragments.put(cla, newInstance(cla));
                    XXXLog.i(Tag + "add success!");
                    return getFragment(cla);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    XXXLog.i(Tag + "InstantiationException");
                    return null;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    XXXLog.i(Tag + "IllegalAccessException");
                    return null;
                }
            }
        } else {
            XXXLog.i(Tag + "get fragment");
            return getFragment(cla);
        }
        return null;
    }

    /**
     * 移除相应的FragmentPresenter
     *
     * @param cla
     * @return
     */
    public boolean removeFragment(Class<?> cla) {
        if (fragments != null) {
            if (quaryFragment(cla)) {
                fragments.remove(cla);
                return true;
            }
        }
        return false;
    }

    /**
     * 删除全部的FragmentPresenter
     *
     * @return
     */
    public boolean removeAllFragment() {
        if (fragments != null) {
            Iterator<Class> iter = fragments.keySet().iterator();
            while (iter.hasNext()) {
                iter.next();
                iter.remove();
            }
            XXXLog.e(Tag + "remove success!! " + fragments);
            return true;
        }
        return false;
    }

    /**
     * 更新相应的FragmentPresenter
     *
     * @param cla
     * @return
     */
    public boolean updateFragment(Class<?> cla) {
        if (quaryFragment(cla)) {
            //do something...
        }
        return false;
    }

    /**
     * 查询相应FragmentPresenter
     *
     * @param cla
     * @return
     */
    public boolean quaryFragment(Class<?> cla) {
        if (fragments != null) {
            return fragments.containsKey(cla);
        }
        return false;
    }

    /**
     * 获取相应的FragmentPresenter
     *
     * @param cla
     * @return
     */
    public FragmentPresenter getFragment(Class<?> cla) {
        if (fragments != null) {
            XXXLog.i(Tag + "get fragment success!");
            return fragments.get(cla);
        }
        XXXLog.e(Tag + " get fragment fail!");
        return null;
    }

}
