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

## 测试制表语法

方法名 | 含义
-|-
String getCurrentPager() | 获取当前的界面名称 |
int setLayout() | 设置界面的Layout |
void depositParameter() | 获取Intent传参 |
BasePresenter createPresenter() | 关联Presenter |
void init() | 初始化控件 |
void onLoadIndexData() | 加载界面第一个服务器接口 |
void setListener() | 设置监听事件 |
void LoadDataResult() | 处理服务器返回数据 |
void showProgress() | 显示加载进度条 |
void showError(Throwable e) | 显示错误 |
void showEmpty() | 显示空数据 |
void onMessageEvent(EventBusMessage message) | 接收广播 |
void onDestroy() | 销毁方法 |