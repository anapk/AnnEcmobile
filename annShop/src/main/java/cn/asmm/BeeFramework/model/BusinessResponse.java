package cn.asmm.BeeFramework.model;

import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.androidquery.callback.AjaxStatus;

public interface BusinessResponse
{    
	public abstract void OnMessageResponse(String url, JSONObject jo, AjaxStatus status) throws JSONException;
}
