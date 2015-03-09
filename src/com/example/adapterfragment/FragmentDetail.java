package com.example.adapterfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentDetail extends Fragment {
	
	ListView lview;
	View view;
	String[] title;
	String[] detail;
	int[] images = {R.drawable.meme1,R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,
			R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,R.drawable.meme9,R.drawable.meme10};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view= inflater.inflate(R.layout.fragment_detail, container, false);
		title = getResources().getStringArray(R.array.titles);
		detail = getResources().getStringArray(R.array.details);
		return view;
	}
	public void showDetail (int pos){
		Log.d("DEB", "FragmentDEtail showDetail is called with pos "+pos);
		TextView tview=(TextView) getActivity().findViewById(R.id.textView1);
		TextView dview=(TextView) getActivity().findViewById(R.id.textView2);
		ImageView iview=(ImageView) getActivity().findViewById(R.id.imageView1);
		tview.setText(title[pos]);
		dview.setText(detail[pos]);
		iview.setImageResource(images[pos]);
	}

}
