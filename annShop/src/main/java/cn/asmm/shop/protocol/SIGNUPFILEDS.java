
package cn.asmm.shop.protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;

@Table(name = "SIGNUPFILEDS")
public class SIGNUPFILEDS  extends Model
{

     @Column(name = "need")
     public String need;

     @Column(name = "SIGNUPFILEDS_id")
     public String id;

     @Column(name = "name")
     public String name;

 public void  fromJson(JSONObject jsonObject)  throws JSONException
 {
     if(null == jsonObject){
       return ;
      }


     JSONArray subItemArray;

     this.need = jsonObject.optString("need");

     this.id = jsonObject.optString("id");

     this.name = jsonObject.optString("name");
     return ;
 }

 public JSONObject  toJson() throws JSONException 
 {
     JSONObject localItemObject = new JSONObject();
     JSONArray itemJSONArray = new JSONArray();
     localItemObject.put("need", need);
     localItemObject.put("id", id);
     localItemObject.put("name", name);
     return localItemObject;
 }

}
