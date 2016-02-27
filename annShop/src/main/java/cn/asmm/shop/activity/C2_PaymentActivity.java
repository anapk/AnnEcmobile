package cn.asmm.shop.activity;
//
//                       __
//                      /\ \   _
//    ____    ____   ___\ \ \_/ \           _____    ___     ___
//   / _  \  / __ \ / __ \ \    <     __   /\__  \  / __ \  / __ \
//  /\ \_\ \/\  __//\  __/\ \ \\ \   /\_\  \/_/  / /\ \_\ \/\ \_\ \
//  \ \____ \ \____\ \____\\ \_\\_\  \/_/   /\____\\ \____/\ \____/
//   \/____\ \/____/\/____/ \/_//_/         \/____/ \/___/  \/___/
//     /\____/
//     \/___/
//
//  Powered by BeeFramework
//

import java.util.ArrayList;

import android.content.res.Resources;

import com.umeng.analytics.MobclickAgent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.asmm.BeeFramework.activity.BaseActivity;
import cn.asmm.shop.R;
import cn.asmm.shop.adapter.C2_PaymentAdapter;
import cn.asmm.shop.protocol.PAYMENT;
import cn.asmm.shop.protocol.flowcheckOrderResponse;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class C2_PaymentActivity extends BaseActivity {
	
	private TextView title;
	private ImageView back;
	
	private ListView listView;
	
	private C2_PaymentAdapter paymentAdapter;
	
	private ArrayList<PAYMENT> list = new ArrayList<PAYMENT>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c2_payment);
		
		Intent intent = getIntent();
		String s = intent.getStringExtra("payment");

        if (null != s)
        {
            try{
                flowcheckOrderResponse response = new flowcheckOrderResponse();
                response.fromJson(new JSONObject(s));
                ArrayList<PAYMENT> payments=response.data.payment_list;
                if (null != payments && payments.size() > 0) {
                    list.clear();
                    list.addAll(payments);
                }

            } catch (JSONException e) {                
                e.printStackTrace();
            }
        }

		
		title = (TextView) findViewById(R.id.top_view_text);
        Resources resource = (Resources) getBaseContext().getResources();
        String pay=resource.getString(R.string.balance_pay);
		title.setText(pay);
		back = (ImageView) findViewById(R.id.top_view_back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				finish();
			}
		});
		
		listView = (ListView) findViewById(R.id.payment_list);
		
		paymentAdapter = new C2_PaymentAdapter(this, list);
		listView.setAdapter(paymentAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener()
        {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {				
				Intent intent = new Intent();
                PAYMENT payment = list.get(position);

                try
                {
                    intent.putExtra("payment",payment.toJson().toString());
                }
                catch (JSONException e)
                {

                }
				setResult(Activity.RESULT_OK, intent);  
	            finish(); 
			}
		});
		
		
	}
}
