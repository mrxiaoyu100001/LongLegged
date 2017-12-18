package com.org.appfragme.view.radius;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

/**
 * Created: AriesHoo on 2017-02-13 16:10
 * Function:用于需要圆角矩形框背景的CheckBox的情况,减少直接使用CheckBox时引入的shape资源文件
 * Desc:
 */
public class RadiusCheckBox extends CheckBox {
    private RadiusViewDelegate delegate;

    public RadiusCheckBox(Context context) {
        this(context, null);
    }

    public RadiusCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        delegate = new RadiusViewDelegate(this, context, attrs);
    }

    /**
     * 获取代理类用于Java代码控制shape属性
     *
     * @return
     */
    public RadiusViewDelegate getDelegate() {
        return delegate;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (delegate.getWidthHeightEqualEnable() && getWidth() > 0 && getHeight() > 0) {
            int max = Math.max(getWidth(), getHeight());
            int measureSpec = MeasureSpec.makeMeasureSpec(max, MeasureSpec.EXACTLY);
            super.onMeasure(measureSpec, measureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (delegate.getRadiusHalfHeightEnable()) {
            if (delegate != null)
                delegate.setRadius(getHeight() / 2);
        } else {
            if (delegate != null)
                delegate.setBgSelector();
        }
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (delegate != null)
            delegate.setBgSelector();
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        if (delegate != null)
            delegate.setBgSelector();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (delegate != null)
            delegate.setBgSelector();
    }
}
