package com.gilang.smice_p;

import java.lang.reflect.Type;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainDataFragment extends Fragment {
	
	Button button1;
	TextView text1;
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static MainDataFragment newInstance(int sectionNumber) {
		MainDataFragment fragment = new MainDataFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public MainDataFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		TextView textView = (TextView) rootView
				.findViewById(R.id.section_label);
		textView.setText(Integer.toString(getArguments().getInt(
				ARG_SECTION_NUMBER)));
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		button1 = (Button)getView().findViewById(R.id.button1);
		button1.setText("Test Button");
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				testVolley();
			}
		});
		
		text1 = (TextView)getView().findViewById(R.id.textView1);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}
	
	public void testVolley(){
		RequestQueue queue = Volley.newRequestQueue(getActivity());
		String url = "http://virtuo-id.com/smiceptest";
		JsonObjectRequest jsObjReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response){
				DataContainer dataCon;
				Gson g = new Gson();
				dataCon = g.fromJson(response.toString(), DataContainer.class);
				StringBuilder sb = new StringBuilder();
				for(Data d : dataCon.getData()){
					sb.append(d.toString() + "\n");
				}
				text1.setText(sb.toString());
				
			}
		}, new Response.ErrorListener(){
			@Override
			public void onErrorResponse(VolleyError error){
				System.out.println(error.toString());
			}
		});
		queue.add(jsObjReq);
	}

}
