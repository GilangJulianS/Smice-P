package com.gilang.smice_p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class DownloadFragment extends Fragment{

	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<List<String>>> listDataChild;
    
	public DownloadFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.download_page, container,
				false);
		 // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView1);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild, getFragmentManager());
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
		return rootView;
	}
	
	/*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<List<String>>>();
        
        listDataHeader.add("Test document 1");
        listDataHeader.add("Test document 2");
        
        List<List<String>> item1 = new LinkedList<List<String>>();
        List<String> subItem1 = new LinkedList<String>();
        subItem1.add("Item description 1 here");
        subItem1.add("http://virtuo-id.com");
        item1.add(subItem1);
        
        List<List<String>> item2 = new LinkedList<List<String>>();
        List<String> subItem2 = new LinkedList<String>();
        subItem2.add("Item description 2 here");
        subItem2.add("http://virtuo-id.com");
        item2.add(subItem2);
 
        listDataChild.put(listDataHeader.get(0), item1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), item2);
        
    }
    
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((ActionBarActivity) getActivity()).getSupportActionBar().setTitle(R.string.download_page_title);
		
	}

}
