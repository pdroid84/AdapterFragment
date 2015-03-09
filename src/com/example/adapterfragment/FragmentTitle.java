package com.example.adapterfragment;

import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentTitle extends Fragment implements OnItemClickListener{
	ListView lview;
	String[] title;
	String[] detail;
	int[] images = {R.drawable.meme1,R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,
			R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,R.drawable.meme9,R.drawable.meme10};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_title, container, false);
		lview = (ListView) view.findViewById(R.id.listView1);
		title = getResources().getStringArray(R.array.titles);
		detail = getResources().getStringArray(R.array.details);
		DebAdapter myadapter = new DebAdapter(getActivity(), title, detail, images);
		lview.setAdapter(myadapter);
		lview.setOnItemClickListener(this);
		return view;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Log.d("DEB", "Item clicked is "+position);
		Communicator comm;
		comm=(Communicator) getActivity();
		comm.sendPos(position);
		
	}
}

class MyHolder {
	TextView tview;
	TextView dview;
	ImageView iview;
	MyHolder (View v){
		tview = (TextView) v.findViewById(R.id.singleRowTextView1);
		dview = (TextView) v.findViewById(R.id.singleRowTextView2);
		iview = (ImageView) v.findViewById(R.id.singleRowImageView1);
	}
	
}
class DebAdapter extends ArrayAdapter<String> {
	Context c;
	String[] ttl;
	String[] dtl;
	int[] imgs;
	
	DebAdapter(Context context,String[] title, String[] detail,int[] images){
		super(context, R.layout.single_row_view, R.id.singleRowTextView1, title);
		// TODO Auto-generated constructor stub
		Log.d("DEB", "DebAdapter constructor is called");
		c = context;
		ttl=title;
		dtl=detail;
		imgs=images;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row;
		MyHolder myholder=null;
		row = convertView;
		if(row==null)
		{
			Log.d("DEB","The new object is created");
			LayoutInflater inflt = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflt.inflate(R.layout.single_row_view, parent, false);
			myholder = new MyHolder(row);
			row.setTag(myholder);
		}
		else
		{
			Log.d("DEB","The recycled object is used");
			myholder = (MyHolder) row.getTag();
		}
		myholder.tview.setText(ttl[position]);
		myholder.dview.setText(dtl[position]);
		myholder.iview.setImageResource(imgs[position]);
		return row;
	}
}
