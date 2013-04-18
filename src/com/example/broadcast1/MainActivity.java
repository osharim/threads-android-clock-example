package com.example.broadcast1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	public TextView text1;
	public EditText input;
	public boolean start;
	private  Handler bridge;
	public  Thread daemon;
 
		 
		 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		text1=(TextView)findViewById(R.id.textView1);
		input=(EditText)findViewById(R.id.editText1);
		start = false;
 
	 
		bridge = new Handler() {
			  @Override
			  public void handleMessage(Message msg) {
			    
				   String text = String.valueOf(msg.obj);
		           text1.setText(text);
 
			  }
			 };
		
 
	    
	    daemon = new Thread(new Runnable() {
	        @Override
	        public void run() {
	        	
	        	
	     	   for(int a=1;a<9999;a++){
		    
	     			 
	  		         Message msg = new Message();
	  		         msg.obj = a;
	  		       bridge.sendMessage(msg);
	  		  
	  		       delay();
	  		    // daemon.sleep(1000); 
  		   
  		   }
	         
	        }
	       }); 
	    daemon.start();
	    
	    
	    
	    
	    
	  
	    
	   /* try {
            Thread.sleep(500);
    } catch (InterruptedException e) { 
    	
    	
    }*/
		
	    
	  //  new Thread(new Client()).start();
	    

	    
	    
	}
	
 
	   private  void delay() {

	         try {

	        	 daemon.sleep(1000);

	         } catch (InterruptedException e) {                   

	                e.printStackTrace();

	         }

	   }
  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}


