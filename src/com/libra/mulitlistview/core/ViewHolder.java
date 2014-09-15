package com.libra.mulitlistview.core;

import com.libra.mulitlistview.core.listener.OnItemClickListener;

public abstract class ViewHolder {
	
	private int mType;
	
	protected OnItemClickListener[] listeners;

	public abstract OnItemClickListener getOnItemClickListener(int columnPostion);
	
	public abstract void setOnItemClickListener(int count);
}
