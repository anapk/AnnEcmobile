
package cn.asmm.shop.protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;

@Table(name = "SESSION")
public class SESSION  extends Model
{

     @Column(name = "uid")
     public String uid;

     @Column(name = "sid")
     public String sid;
     
     
     private static SESSION instance;
     public static SESSION getInstance()
     {
         if (instance == null) {
             instance = new SESSION();
         }

         return instance;
     }
     

 public void fromJson(JSONObject jsonObject)  throws JSONException
 {
     if(null == jsonObject){
       return ;
      }



     JSONArray subItemArray;

     this.uid = jsonObject.optString("uid");

     this.sid = jsonObject.optString("sid");
     return ;
 }

 public JSONObject  toJson() throws JSONException 
 {
     JSONObject localItemObject = new JSONObject();
     JSONArray itemJSONArray = new JSONArray();
     localItemObject.put("uid", uid);
     localItemObject.put("sid", sid);
     return localItemObject;
 }

}
