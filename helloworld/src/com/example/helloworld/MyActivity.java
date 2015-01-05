package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity{

	private TextView myTextView;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.myactivity);
		myTextView = (TextView)findViewById(R.id.myTextView2);
		button = (Button)findViewById(R.id.myButton2);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				intent.setData(Uri.parse("http://www.baidu.com"));
//				Intent intent = new Intent(Intent.ACTION_DIAL);
//				intent.setData(Uri.parse("tel:10086"));
//				startActivity(intent);
//				Intent intent = new Intent(MyActivity.this, ThirdActivity.class);
				Intent intent = new Intent();
				intent.putExtra("testResult", "haha this is previous activity data");
				setResult(RESULT_OK,intent);
				finish();
//				startActivity(intent);
			}
		});
		myTextView.setText(R.string.other);
	}

	
}
