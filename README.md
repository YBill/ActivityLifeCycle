# ActivityLifeCycle
## Activity生命周期
- 启动Activity：onCreate->onStart->onResume->onWindowFocusChanged (activity running)
- 锁屏或被其它Activity覆盖或跳转到其它Activity或按Home进入后台：onPause->onWindowFocusChanged->onSaveInstanceState->onStop
- 解锁或由被覆盖状态再回到前台：onRestart->onStart->onResume->onWindowFocusChanged
- 退回到此Activity：onRestart->onStart->onResume->onWindowFocusChanged
- 退出此Activity：onPause->onWindowFocusChanged->onStop->onDestory
- 从A跳转到B：当B的主题为透明时，A只会执行onPause（A-onPause->B-(onCreate->onStart->onResume->onWindowFocusChanged)）
- 从A跳转到B：A-onPause->B-(onCreate->onStart->onResume)-A-onSaveInstanceState->onStop(注意是A执行onPause后开始执行B的生命周期，B执行onResume后，A才执行onStop，所以尽量不要在onPause中做耗时操作)
- 从B返回到A：B-onPause->A-(onRestart->onStart->onResume->onWindowFocusChanged)-B-(onWindowFocusChanged->onStop->onDestroy)
- Activity内对话框弹出 onWindowFocusChanged
- Activity弹出是ActivityDialog onPause->onWindowFocusChanged->onSaveInstanceState

## onWindowFocusChanged方法
- 窗口焦点改变时被调用
- 在onResume之后获得焦点，onPause之后失去焦点

## onSaveInstanceState方法
- 用于保存Activity的状态存储一些临时数据
- Activity被覆盖或进入后台，由于系统资源不足被kill会被调用
- 用户改变屏幕方向会被调用
- 跳转到其它Activity或按Home进入后台会被调用
- 会在onStop之前被调用，和onPause的顺序不固定的

## onRestoreInstanceState(Bundle savedInstanceState)方法
- 用于恢复保存的临时数据，此方法的Bundle参数也会传递到onCreate方法中，你也可以在onCreate(Bundle savedInstanceState)方法中恢复数据
- onRestoreInstanceState和onCreate的区别：当onRestoreInstanceState被调用时Bundle参数一定是有值的，不用做为null判断，onCreate的Bundle则可能会为null。官方文档建议在此方法中进行数据恢复。
- 由于系统资源不足被kill之后又回到此Activity会被调用
- 用户改变屏幕方向重建Activity时会被调用
- 会在onStart之后被调用

## 问题：内存不足时，怎么保持Activity的一些状态，在哪个方法里面做具体操作？
- 在onSaveInstanceState方法中保存Activity的状态，在onRestoreInstanceState或onCreate方法中恢复Activity的状态

## 屏幕方向
- 竖屏：在AndroidManifest.xml中对指定的Activity设置android:screenOrientation=”portrait”或在onCreate方法中调用setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
- 横屏：在AndroidManifest.xml中对指定的Activity设置android:screenOrientation=”landscape”或在onCreate方法中调用setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

## 默认情况下，切换屏幕方向时Activity会销毁、重建
- onPause->onStop->onDestroy->onCreate->onStart->onResume
## 配置为android:configChanges="orientation|screenSize"时
- 只会调用onConfigurationChanged方法
- 注意当配置screenOrientation属性后，此属性无效。
