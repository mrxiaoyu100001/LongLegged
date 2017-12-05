package com.org.appfragme.presenter;

/**
 * @Created: xiaoyu  on 2017.12.04 16:53.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2017.12.04 16:53.
 * @Blog:http://blog.csdn.net/noteschapter
 * @Github:https://github.com/mrxiaoyu100001
 * @Resources:
 * @Remark:
 */

public class AppBuilder {

    private AppBuilder(){
        throw new Error("ClassNotInitException");
    }

    /**
     *
     * @param stack
     * @return
     */
    public static FragmentStack init(int stack){
        return FragmentStack.getFragmentStack(stack);
    }
}
