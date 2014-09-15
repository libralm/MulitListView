package com.libra.mulitlistview.core.listener;

import com.libra.mulitlistview.core.view.MulitListView;

import android.view.View;
import android.widget.ListView;

public class OnItemClickListener implements View.OnClickListener {

	private int row;
	
	private MulitListView listView;
	
	private int mType;

	public OnItemClickListener(MulitListView listView, int type) {
		super();
		this.listView = listView;
		mType = type;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		onItemClick(row, v,mType);
	}

	public void onItemClick(int row, View v, int mType) {
		if(listView != null){
			listView.itemClick(row, v, mType);
		}
	}
}
