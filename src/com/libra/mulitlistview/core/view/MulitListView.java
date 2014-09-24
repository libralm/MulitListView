package com.libra.mulitlistview.core.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class MulitListView extends ListView {
	
	private OnItemClickListener listener;
	

	public MulitListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MulitListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MulitListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, 1);
		
	}

	@Override
	protected void dispatchSetPressed(boolean pressed) {
		// TODO Auto-generated method stub
		super.dispatchSetPressed(pressed);
		
	}
	
	@Override
	public void setOnScrollListener(OnScrollListener l) {
		// TODO Auto-generated method stub
		super.setOnScrollListener(l);
	}
	 
	 public interface OnItemClickListener{
		 void onItemClick(int position,View v);
	 }
	 
	 public void setPushListViewOnItemClickListener(OnItemClickListener listener){
		 this.listener = listener;
	 }
	 
	 public void itemClick(int position,View v,int type){
		 if(listener != null){
			 listener.onItemClick(position, v);
		 }
	 }
	 
}
