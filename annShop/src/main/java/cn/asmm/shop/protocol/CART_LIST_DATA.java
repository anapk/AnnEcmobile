
package cn.asmm.shop.protocol;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;
import cn.asmm.shop.protocol.GOODS_LIST;
import cn.asmm.shop.protocol.TOTAL;

@Table(name = "CART_LIST_DATA")
public class CART_LIST_DATA  extends Model
{

     @Column(name = "total")
     public TOTAL total;

     public ArrayList<GOODS_LIST>   goods_list = new ArrayList<GOODS_LIST>();

     public void  fromJson(JSONObject jsonObject)  throws JSONException
     {
          if(null == jsonObject){
            return ;
           }

          JSONArray subItemArray;
          TOTAL  total = new TOTAL();
          total.fromJson(jsonObject.optJSONObject("total"));
          this.total = total;

          subItemArray = jsonObject.optJSONArray("goods_list");
          if(null != subItemArray)
           {
              for(int i = 0;i < subItemArray.length();i++)
               {
                  JSONObject subItemObject = subItemArray.getJSONObject(i);
                  GOODS_LIST subItem = new GOODS_LIST();
                  subItem.fromJson(subItemObject);
                  this.goods_list.add(subItem);
               }
           }

          return ;
     }

     public JSONObject  toJson() throws JSONException 
     {
          JSONObject localItemObject = new JSONObject();
          JSONArray itemJSONArray = new JSONArray();
          if(null != total)
          {
            localItemObject.put("total", total.toJson());
          }

          for(int i =0; i< goods_list.size(); i++)
          {
              GOODS_LIST itemData =goods_list.get(i);
              JSONObject itemJSONObject = itemData.toJson();
              itemJSONArray.put(itemJSONObject);
          }
          localItemObject.put("goods_list", itemJSONArray);
          return localItemObject;
     }

}
