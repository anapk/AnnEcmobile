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
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.asmm.BeeFramework.activity.BaseActivity;
import cn.asmm.BeeFramework.model.BusinessResponse;
import cn.asmm.BeeFramework.view.ToastView;
import cn.asmm.androidquery.callback.AjaxStatus;
import cn.asmm.maxwin.view.XListView;
import cn.asmm.maxwin.view.XListView.IXListViewListener;
import cn.asmm.shop.R;
import cn.asmm.shop.adapter.B5_ProductCommentAdapter;
import cn.asmm.shop.model.CommentModel;
import cn.asmm.shop.model.ProtocolConst;
import cn.asmm.shop.protocol.ApiInterface;

public class B5_ProductCommentActivity extends BaseActivity implements IXListViewListener, BusinessResponse {

	private TextView title;
	private ImageView back;
	
	private XListView xlistView;
	private B5_ProductCommentAdapter commentAdapter;
    private View null_paView;
	private int goods_id;
	
	private CommentModel commentModel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b5_product_comment);
		
		Intent intent = getIntent();
		goods_id = intent.getIntExtra("id", 0);
		
		title = (TextView) findViewById(R.id.top_view_text);
        Resources resource = (Resources) getBaseContext().getResources();
        String com=resource.getString(R.string.gooddetail_commit);
		title.setText(com);
		back = (ImageView) findViewById(R.id.top_view_back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				finish();
			}
		});
        null_paView = findViewById(R.id.null_pager);
		xlistView = (XListView) findViewById(R.id.comment_list);
		xlistView.setPullLoadEnable(true);
		xlistView.setRefreshTime();
		xlistView.setXListViewListener(this,1);
		
		commentModel = new CommentModel(this);
		commentModel.addResponseListener(this);
		commentModel.getCommentList(goods_id);

		
	}

	@Override
	public void onRefresh(int id) {				
		commentModel.getCommentList(goods_id);
	}

	@Override
	public void onLoadMore(int id) {		
		commentModel.getCommentsMore(goods_id);
	}
	
	public void setComment() {
		
		if(commentModel.comment_list.size() > 0) {
			xlistView.setVisibility(View.VISIBLE);
			if(commentAdapter == null) {
				commentAdapter = new B5_ProductCommentAdapter(this, commentModel.comment_list);
				xlistView.setAdapter(commentAdapter);
			} else {
				commentAdapter.list = commentModel.comment_list;
				commentAdapter.notifyDataSetChanged();
			}
			
		} else {
            null_paView.setVisibility(View.VISIBLE);
            xlistView.setVisibility(View.GONE);
		}
		
	}

	@Override
	public void OnMessageResponse(String url, JSONObject jo, AjaxStatus status)
			throws JSONException {		
		if(url.endsWith(ApiInterface.COMMENTS)) {
			xlistView.setRefreshTime();
			xlistView.stopRefresh();
			xlistView.stopLoadMore();
			if(commentModel.paginated.more == 0) {
				xlistView.setPullLoadEnable(false);
			} else {
				xlistView.setPullLoadEnable(true);
			}
			setComment();
		}
		
	}
}
