package com.example.adapterfragment;

import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void sendPos(int pos) {
		// TODO Auto-generated method stub
		Log.d("DEB","Main Activity's sendPos is called");
		FragmentManager mgr = getFragmentManager();
		FragmentDetail frgD = (FragmentDetail) mgr.findFragmentById(R.id.fragment2);
		if(frgD!=null && frgD.isVisible())
		{
			Log.d("DEB", "In landscape mode");
			frgD.showDetail(pos);
		}
		else
		{
			Log.d("DEB", "In potrait mode");
			Intent intent = new Intent(this, DetailActivity.class);
			intent.putExtra("position", pos);
			startActivity(intent);
		}
		
	}
}
