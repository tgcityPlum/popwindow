package com.eagersoft.youzy.popwindowdemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eagersoft.youzy.popwindowdemo.utils.PopWindowUtil;

public class MainActivity extends AppCompatActivity {
    //弹框工具类
    private PopWindowUtil popwindowUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popwindowUtil = new PopWindowUtil();
    }

    /**
     * 处理控件的赋值和点击事件
     */
    private void onPopWindowView(@NonNull View contentView) {
        //内容控件
        TextView content = contentView.findViewById(R.id.tv_content);
        //按钮控件
        Button closePop = contentView.findViewById(R.id.btn_measure);

        content.setText("今天太热了，都不敢出去！");

        closePop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popwindowUtil.dismiss();
            }
        });
    }

    public void testPop(View view) {
        popwindowUtil.getInstance(this, R.layout.popup_coupon)
                .setPopWindow()
                .addBackground()
                .setPopWindowCallBack(new PopWindowUtil.PopWindowCallBack() {
                    @Override
                    public void onPopWindowCallBack(View contentView) {
                        //处理控件的赋值和点击事件
                        if (contentView != null) {
                            onPopWindowView(contentView);
                        }
                    }
                })
                .showCouponPopupWindow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        popwindowUtil.onDestroy();
    }


}
