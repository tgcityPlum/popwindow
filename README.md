# 自定义弹框项目

## 简单针对PopWindow进行utils处理
```
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
```

