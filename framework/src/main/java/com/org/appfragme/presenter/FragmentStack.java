package com.org.appfragme.presenter;

import android.widget.TextView;

import com.org.appfragme.utils.XXXLog;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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

    private Map<Class, FragmentPresenter> cacheStack;
    private List<Class> backStack;
    private static String Tag = " FragmentStack ";
    private static FragmentStack instance;

    /**
     * @param stack
     */
    private FragmentStack(int stack) {
        cacheStack = new LinkedHashMap<>(stack);
        backStack = new LinkedList<>();
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
                }
            }
        }
        return instance;
    }

    public static <T extends FragmentPresenter>T getFragment(Class<T> cla) {
        return null;
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
     *
     * @param cla
     * @return
     */
    public FragmentPresenter addFragment(Class<? extends FragmentPresenter> cla) {
        if (!quaryCache(cla)) {
            if (cacheStack != null) {
                try {
                    cacheStack.put(cla, newInstance(cla));
                    backStack.add(cla);
                    return getCacheStock(cla);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    return null;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } else {
            return getCacheStock(cla);
        }
        return null;
    }

    /**
     * 移除除回退栈内对象外的所有对象
     *
     * @return
     */
    public boolean removeOtherCache() {
        Map<Class, FragmentPresenter> map = saveBackFragment();
        if (removeCacheFragment()) {
            cacheStack = map;
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    private Map<Class, FragmentPresenter> saveBackFragment() {
        Map<Class, FragmentPresenter> map = new LinkedHashMap<>();
        if (backStack != null && backStack.size() > 0) {
            for (Class cla : backStack) {
                map.put(cla, cacheStack.get(cla));
            }
            return map;
        }
        return map;
    }

    /**
     * 移除所有的缓存栈对象
     *
     * @return
     */
    public boolean removeCacheFragment() {
        if (cacheStack != null) {
            Iterator<Class> iter = cacheStack.keySet().iterator();
            while (iter.hasNext()) {
                Class cla = iter.next();
                cla = null;
                iter.remove();
            }
            return true;
        }
        return false;
    }

    /**
     * 移除所有的回退栈对象
     *
     * @return
     */
    public boolean removeBackFrgment() {
        if (backStack != null && backStack.size() > 0) {
            for (int i = 0; i < backStack.size(); i++) {
                backStack.remove(i);
            }
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    public boolean removeAllFragment() {
        removeCacheFragment();
        removeBackFrgment();
        return true;
    }

    /**
     * 移除回退栈中相应的FragmentPresenter
     *
     * @param cla
     * @return
     */
    public boolean removeFragment(Class<?> cla) {
        if (backStack != null) {
            if (quaryCache(cla)) {
                backStack.remove(cla);
                return true;
            }
        }
        return false;
    }

    /**
     * 移除相应位置的fragment
     *
     * @param position
     * @return
     */
    public boolean removeFragment(int position) {
        if (backStack != null) {
            backStack.remove(position);
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
    public boolean updateFragment(Class cla) {
        try {
            if (quaryCache(cla)) {
                if (cacheStack != null && backStack != null) {
                    cacheStack.put(cla, newInstance(cla));
                    if (!quaryBackStack(cla)) {
                        backStack.add(cla);
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * 查询相应FragmentPresenter
     *
     * @param cla
     * @return
     */
    public boolean quaryCache(Class<?> cla) {
        if (cacheStack != null) {
            return cacheStack.containsKey(cla);
        }
        return false;
    }

    /**
     * 判断当前位置是否有对象
     *
     * @param cla
     * @return
     */
    public boolean quaryBackStack(Class<?> cla) {
        if (backStack != null && backStack.size() > 0) {
            for (Class key : backStack) {
                return cla == key;
            }
        }
        return false;
    }

    /**
     * 获取缓存栈中相应的FragmentPresenter
     *
     * @param cla
     * @return
     */
    public FragmentPresenter getCacheStock(Class<?> cla) {
        if (cacheStack != null) {
            return cacheStack.get(cla);
        }
        return null;
    }

    /**
     * 获取回退栈中的对象
     *
     * @param cla
     * @return
     */
    public FragmentPresenter getBackStock(Class<?> cla) {
        for (Class key : backStack) {
            if (cla == key) {
                return getCacheStock(key);
            }
        }
        return null;
    }

    /**
     * 获取栈中对象数
     *
     * @return
     */
    public int getStackNum() {
        if (backStack != null) {
            return backStack.size();
        }
        return 0;
    }

    /**
     * 获取栈顶对象
     *
     * @return
     */
    public FragmentPresenter getBackStackTop() {
        if (backStack != null) {
            return getCacheStock(backStack.get(getStackNum() - 1));
        }
        return null;
    }

    /**
     * 判断当前对象是否是mainfragment
     *
     * @param cla
     * @return
     */
    public boolean isTopFragment(Class<?> cla) {
        if (cacheStack != null) {
            FragmentPresenter top = getBackStackTop();
            FragmentPresenter current = getCacheStock(cla);
            XXXLog.e(Tag + top);
            XXXLog.e(Tag + current);
            XXXLog.e(Tag + (top.hashCode() == current.hashCode()));
            return top.hashCode() == current.hashCode();
        }
        return false;
    }

    /**
     * 获取栈顶下面的对象
     *
     * @return
     */
    public FragmentPresenter getNextFragment() {
        if (cacheStack != null) {
            return getCacheStock(backStack.get(getStackNum() - 2));
        }
        return null;
    }

    /**
     * 对象回退时移除栈顶位置的fragment
     *
     * @return
     */
    public boolean removeTopStack() {
        //移除缓存栈里指定的对象
//        removeFragment(backStack.get(getStackNum() - 1));
        removeFragment(getStackNum() - 1);
        //移除缓存栈里除回退栈以外的所有对象
        removeOtherCache();
        return true;
    }
}
