
package cn.asmm.shop.protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;

@Table(name = "REGION_DATA")
public class REGION_DATA  extends Model
{

     @Column(name = "more")
     public int more;

     public ArrayList<REGIONS>   regions = new ArrayList<REGIONS>();

     public void  fromJson(JSONObject jsonObject)  throws JSONException
     {
          if(null == jsonObject){
            return ;
           }

          JSONArray subItemArray;

          this.more = jsonObject.optInt("more");

          subItemArray = jsonObject.optJSONArray("regions");
          if(null != subItemArray)
           {
              for(int i = 0;i < subItemArray.length();i++)
               {
                  JSONObject subItemObject = subItemArray.getJSONObject(i);
                  REGIONS subItem = new REGIONS();
                  subItem.fromJson(subItemObject);
                  this.regions.add(subItem);
               }
           }

          return ;
     }

     public JSONObject  toJson() throws JSONException 
     {
          JSONObject localItemObject = new JSONObject();
          JSONArray itemJSONArray = new JSONArray();
          localItemObject.put("more", more);

          for(int i =0; i< regions.size(); i++)
          {
              REGIONS itemData =regions.get(i);
              JSONObject itemJSONObject = itemData.toJson();
              itemJSONArray.put(itemJSONObject);
          }
          localItemObject.put("regions", itemJSONArray);
          return localItemObject;
     }

}
