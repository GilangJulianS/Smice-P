package com.gilang.smice_p;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SessionFragment extends Fragment{
	private List<String> listText = new ArrayList<String>();
		
	public SessionFragment(){	
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addDataList();
		View rootView;
		rootView = inflater.inflate(R.layout.session_fragment, container, false);
		ArrayAdapter<String> adapter = new MyListAdapter();
		ListView myListView = (ListView)rootView.findViewById(R.id.listViewSchedule);
		myListView.setAdapter(adapter);
		return rootView;
	}
	
	private void addDataList() {
		listText.add(new String("18.00"));
		listText.add("testing testing");
		listText.add("18.30");
		listText.add("testing testing lagi");
		listText.add("18.45");
		listText.add("testing testing terus");
	}
	private class MyListAdapter extends ArrayAdapter<String>{
		public MyListAdapter() {
			super((MainActivity)getActivity(), R.layout.odd_row, listText);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View text = convertView;
			if(text == null && position % 2 == 1){
				text = getActivity().getLayoutInflater().inflate(R.layout.odd_row, parent, false);
			}
			if(text == null && position % 2 == 0){
				text = getActivity().getLayoutInflater().inflate(R.layout.even_row, parent, false);
			}
			String curString = listText.get(position);
			TextView makeText = (TextView) text.findViewById(R.id.text);
			makeText.setText(curString);
			text.setBackgroundResource(R.layout.rounded_corner);
			return text;
		}
	}
}
