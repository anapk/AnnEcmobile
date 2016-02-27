
package cn.asmm.shop.protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;

@Table(name = "REGIONS")
public class REGIONS  extends Model
{

     @Column(name = "REGIONS_id",unique = true)
     public String id;

     @Column(name = "name")
     public String name;

     @Column(name = "parent_id")
     public String parent_id;

 public void  fromJson(JSONObject jsonObject)  throws JSONException
 {
     if(null == jsonObject){
       return ;
      }

     JSONArray subItemArray;

     this.id = jsonObject.optString("id");

     this.name = jsonObject.optString("name");

     this.parent_id = jsonObject.optString("parent_id");
     return ;
 }

 public JSONObject  toJson() throws JSONException 
 {
     JSONObject localItemObject = new JSONObject();
     JSONArray itemJSONArray = new JSONArray();
     localItemObject.put("id", id);
     localItemObject.put("name", name);
     localItemObject.put("parent_id", parent_id);
     return localItemObject;
 }

}
