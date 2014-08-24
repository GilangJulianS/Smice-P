package com.gilang.smice_p;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;
import com.nikkoaiello.mobile.android.PinchImageView;

public class MapFragment extends Fragment {

	PinchImageView mapView;
	
	public MapFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.map_fragment, container,
				false);
		
		mapView = (PinchImageView) rootView.findViewById(R.id.mapView);
		mapView.setBackgroundColor(Color.WHITE);
        // Parse the SVG file from the resource
        SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.android);
        // Get a drawable from the parsed SVG and set it as the drawable for the ImageView
        mapView.setImageDrawable(svg.createPictureDrawable());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Disable hardware acceleration
            mapView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        // Set the ImageView as the content view for the Activity
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
	}
	
}
