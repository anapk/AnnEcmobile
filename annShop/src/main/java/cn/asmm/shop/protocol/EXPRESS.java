
package cn.asmm.shop.protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;

@Table(name = "EXPRESS")
public class EXPRESS  extends Model
{

     @Column(name = "time")
     public String time;

     @Column(name = "context")
     public String context;

 public void fromJson(JSONObject jsonObject)  throws JSONException
 {
     if(null == jsonObject){
       return ;
      }


     JSONArray subItemArray;

     this.time = jsonObject.optString("time");

     this.context = jsonObject.optString("context");
     return ;
 }

 public JSONObject  toJson() throws JSONException 
 {
     JSONObject localItemObject = new JSONObject();
     JSONArray itemJSONArray = new JSONArray();
     localItemObject.put("time", time);
     localItemObject.put("context", context);
     return localItemObject;
 }

}
