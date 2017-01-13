# ActivityLifeCycle

### 启动Activity：onCreate->onStart->onResume->onWindowFocusChanged (activity running)
### 锁屏或被其它Activity覆盖或跳转到其它Activity或按Home进入后台：onPause->onWindowFocusChanged->onSaveInstanceState->onStop
### 解锁或由被覆盖状态再回到前台：onRestart->onStart->onResume->onWindowFocusChanged
### 退回到此Activity：onRestart->onStart->onResume->onWindowFocusChanged
### 退出此Activity：onPause->onWindowFocusChanged->onStop->onDestory
### 从A跳转到B：当B的主题为透明时，A只会执行onPause（A-onPause->B-(onCreate->onStart->onResume->onWindowFocusChanged)）
### 从A跳转到B：A-onPause->B-(onCreate->onStart->onResume)-A-onSaveInstanceState->onStop(注意是A执行onPause后开始执行B的生命周期，B执行onResume后，A才执行onStop，所以尽量不要在onPause中做耗时操作)
### 从B返回到A：B-onPause->A-(onRestart->onStart->onResume->onWindowFocusChanged)-B-(onWindowFocusChanged->onStop->onDestroy)
### Activity内对话框弹出 onWindowFocusChanged
### Activity弹出是ActivityDialog onPause->onWindowFocusChanged->onSaveInstanceState
