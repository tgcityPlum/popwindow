package com.eagersoft.youzy.popwindowdemo.utils;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class PopWindowUtil {
    //弹框控件
    private PopupWindow mCouponPopup;
    //Activity对象
    private Activity mActivity;
    //popup's content
    private View mContentView;
    //Retrieve the current {@link android.view.Window} for the activity
    private Window mWindow;

    /**
     * 初始化PopupWindow
     */
    public PopWindowUtil getInstance(Activity activity, int layout) {
        mActivity = activity;
        if (mCouponPopup == null) {
            View contentView = LayoutInflater.from(activity).inflate(layout, null);
            mContentView = contentView;

            mCouponPopup = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        }
        return this;
    }

    /**
     * 设置属性
     */
    public PopWindowUtil setPopWindow() {
        mCouponPopup.setContentView(mContentView);
        mCouponPopup.setOutsideTouchable(true);
        mCouponPopup.setFocusable(true);
        mCouponPopup.setTouchable(true);

        return this;
    }

    /**
     * 设置颜色变化
     */
    public PopWindowUtil addBackground() {
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;//调节透明度
        getWindow().setAttributes(lp);
        //dismiss时恢复原样
        mCouponPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });

        return this;
    }

    public PopWindowUtil setPopWindowCallBack(PopWindowCallBack popWindowCallBack) {
        if (popWindowCallBack != null) {
            popWindowCallBack.onPopWindowCallBack(mContentView);
        }

        return this;
    }

    /**
     * 显示弹框
     * 默认显示在底部
     */
    public void showCouponPopupWindow() {
        showCouponPopupWindow(Gravity.BOTTOM);
    }

    /**
     * 显示弹框
     * 自定义显示位置显示在底部
     */
    public void showCouponPopupWindow(int gravity) {
        View parent = getWindow().getDecorView();
        mCouponPopup.showAtLocation(parent, gravity, 0, 0);
    }

    /**
     * Retrieve the current {@link android.view.Window} for the activity.
     * This can be used to directly access parts of the Window API that
     * are not available through Activity/Screen.
     *
     * @return Window The current window, or null if the activity is not
     * visual.
     */
    private Window getWindow() {
        if (mWindow == null) {
            mWindow = mActivity.getWindow();
        }
        return mWindow;
    }

    /**
     * 隐藏悬浮框
     */
    public void dismiss(){
        mCouponPopup.dismiss();
    }

    /**
     * 回调接口
     */
    public interface PopWindowCallBack {
        //回调对象
        void onPopWindowCallBack(View contentView);
    }

    /**
     * 释放资源
     */
    public void onDestroy() {
        mCouponPopup = null;
        mActivity = null;
        mWindow = null;
    }
}
