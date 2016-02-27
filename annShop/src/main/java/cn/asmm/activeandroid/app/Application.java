package cn.asmm.activeandroid.app;

import cn.asmm.activeandroid.ActiveAndroid;

public class Application extends android.app.Application {
	@Override
	public void onCreate() {
		super.onCreate();
		ActiveAndroid.initialize(this);
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
		ActiveAndroid.dispose();
	}
}