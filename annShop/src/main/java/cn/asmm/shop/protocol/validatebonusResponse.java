
package cn.asmm.shop.protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;

@Table(name = "validatebonusResponse")
public class validatebonusResponse  extends Model
{

     @Column(name = "status")
     public STATUS   status;

     @Column(name = "data")
     public VALIDATE_BONUS_DATA   data;

     public void  fromJson(JSONObject jsonObject)  throws JSONException
     {
          if(null == jsonObject){
            return ;
           }

          JSONArray subItemArray;
          STATUS  status = new STATUS();
          status.fromJson(jsonObject.optJSONObject("status"));
          this.status = status;
          VALIDATE_BONUS_DATA  data = new VALIDATE_BONUS_DATA();
          data.fromJson(jsonObject.optJSONObject("data"));
          this.data = data;
          return ;
     }

     public JSONObject  toJson() throws JSONException 
     {
          JSONObject localItemObject = new JSONObject();
          JSONArray itemJSONArray = new JSONArray();
          if(null != status)
          {
            localItemObject.put("status", status.toJson());
          }
          if(null != data)
          {
            localItemObject.put("data", data.toJson());
          }
          return localItemObject;
     }

}
