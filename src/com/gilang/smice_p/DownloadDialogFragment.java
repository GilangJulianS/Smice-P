package com.gilang.smice_p;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class DownloadDialogFragment extends DialogFragment {

	private EditText mEditText;

    public DownloadDialogFragment() {
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	getDialog().setTitle("Downloading...");
        View view = inflater.inflate(R.layout.dialog_download, container);
        getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
			
			@Override
			public void onDismiss(DialogInterface dialog) {
				Toast.makeText(getActivity(), "File successfully downloaded", Toast.LENGTH_SHORT).show();
			}
		});
        final Thread t = new Thread(){

        	   @Override
        	   public void run(){
        	 
        	      int jumpTime = 0;
        	      while(jumpTime < 100){
        	         try {
        	            sleep(200);
        	            jumpTime += 5;
        	         } catch (InterruptedException e) {
        	           e.printStackTrace();
        	         }
        	      }
        	      getDialog().dismiss();
        	   }};
        	   t.start();
        return view;
        
    }
    
}
