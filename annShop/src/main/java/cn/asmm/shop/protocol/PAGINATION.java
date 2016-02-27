
package cn.asmm.shop.protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;

@Table(name = "PAGINATION")
public class PAGINATION  extends Model
{

     @Column(name = "count")
     public int count;

     @Column(name = "page")
     public int page;

 public void fromJson(JSONObject jsonObject)  throws JSONException
 {
     if(null == jsonObject){
       return ;
      }


     JSONArray subItemArray;

     this.count = jsonObject.optInt("count");
     this.page = jsonObject.optInt("page");
     return ;
 }

 public JSONObject  toJson() throws JSONException 
 {
     JSONObject localItemObject = new JSONObject();
     JSONArray itemJSONArray = new JSONArray();
     localItemObject.put("count", count);
     localItemObject.put("page", page);
     return localItemObject;
 }

}
