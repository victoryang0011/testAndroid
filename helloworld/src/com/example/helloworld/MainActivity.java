package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


/*
 * 1.一个activity就是一个类，并且这个类要继承activity
 * 2.要重写onCreate方法
 * 3.每一个activity都需要在Androidmanifest.xml文件中进行配置
 * 4.为activity添加必要的控件
 * */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MainActivity", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        if(isFirstRun)
        {
        	
        }else{
        	
        }
        Log.i("yang", "this is a main activity");
        
        setContentView(R.layout.activity_main);
//        TextView textView =  (TextView)findViewById(R.id.myTextView);
        Button button =  (Button)findViewById(R.id.myButton);
        Button toastButton =  (Button)findViewById(R.id.Button01);
//        textView.setText("我的第一个textview");
        button.setText("我的第一个button");
        toastButton.setOnClickListener(new ToastTestListener());
        button.setOnClickListener(new MyButtonListener());
        
    }


    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.item1:
			Toast.makeText(MainActivity.this, "author:VictorYang;any questions pls contact :victoryang0011@gmail.com", Toast.LENGTH_LONG).show();
			break;
		case R.id.action_settings:
			Toast.makeText(MainActivity.this, "新功能马上上线，请稍等", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
		return true;
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		switch (requestCode) {
		case 1:
			if(resultCode == RESULT_OK)
			{
				String resultData = intent.getStringExtra("testResult");
				Log.i("yang", resultData);
			}
			break;

		default:
			break;
		}
	}

	class MyButtonListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
//			Intent intent = new Intent("com.example.activitytest.ACTION_START");
//			Intent intent = new Intent(Intent.ACTION_VIEW);
//			intent.setData(Uri.parse("http://www.baidu.com"));
//			intent.addCategory("myselfDefinedCategory");
			Intent intent = new Intent(MainActivity.this, MyActivity.class);
//			intent.putExtra("testString","haha,this is the String for testing intent");
//			startActivity(intent);
			startActivityForResult(intent, 1);
		}
		
	}
    
    class ToastTestListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this, "奋斗奋斗奋斗吧", Toast.LENGTH_LONG).show();
		}
    	
    }
    
    
}
