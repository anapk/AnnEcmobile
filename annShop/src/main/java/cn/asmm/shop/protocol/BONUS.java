package cn.asmm.shop.protocol;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.asmm.activeandroid.Model;
import cn.asmm.activeandroid.annotation.Column;
import cn.asmm.activeandroid.annotation.Table;

@Table(name = "BONUS")
public class BONUS
{
    @Column(name = "type_id")
    public int type_id;

    @Column(name = "type_name")
    public String type_name;

    @Column(name = "type_money")
    public String type_money;

    @Column(name = "bonus_id")
    public String bonus_id;

    @Column(name = "bonus_money_formated")
    public String bonus_money_formated;

    public void fromJson(JSONObject jsonObject)  throws JSONException
    {
        if(null == jsonObject){
            return ;
        }

        JSONArray subItemArray;

        this.type_id = jsonObject.optInt("type_id");
        this.type_name = jsonObject.optString("type_name");
        this.type_money = jsonObject.optString("type_money");
        this.bonus_id   = jsonObject.optString("bonus_id");
        this.bonus_money_formated = jsonObject.optString("bonus_money_formated");
        return ;
    }

    public JSONObject  toJson() throws JSONException
    {
        JSONObject localItemObject = new JSONObject();
        JSONArray itemJSONArray = new JSONArray();
        localItemObject.put("type_id", type_id);
        localItemObject.put("type_name", type_name);
        localItemObject.put("type_money", type_money);
        localItemObject.put("bonus_id", bonus_id);
        localItemObject.put("bonus_money_formated", bonus_money_formated);
        return localItemObject;
    }


}
