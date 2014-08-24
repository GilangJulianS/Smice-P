package com.gilang.smice_p;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;

public class TestView extends View {

	Picture picture;
	
	public TestView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public TestView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawPicture(picture);
	}
	
	public void setPicture(Picture picture){
		this.picture = picture;
	}

}
