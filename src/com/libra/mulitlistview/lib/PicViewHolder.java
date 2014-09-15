package com.libra.mulitlistview.lib;

import com.libra.mulitlistview.core.ViewHolder;
import com.libra.mulitlistview.core.listener.OnItemClickListener;

public class PicViewHolder extends ViewHolder {

	@Override
	public OnItemClickListener getOnItemClickListener(int columnPostion) {
		// TODO Auto-generated method stub
		return listeners[columnPostion];
	}

	@Override
	public void setOnItemClickListener(int count) {
		// TODO Auto-generated method stub
		listeners = new OnItemClickListener[count];
	}

}
