package com.libra.mulitlistview.core;

import java.util.HashMap;
import java.util.Map;


import android.annotation.SuppressLint;


class TypeData {

	private Object[] mData;

	private int mViewColumn = -1;

	public Object[] getmData() {
		return mData;
	}

	public void setmData(Object[] mData) {
		this.mData = mData;
	}

	public int getmViewColumn() {
		return mViewColumn;
	}

	public void setmViewColumn(int mViewColumn) {
		this.mViewColumn = mViewColumn;
		
	}

	private int mMaxAdapterPosition = -1;

	private int mtypePositionCounter;
	
	/**
	 * key:表示View的type value:getview()传过来的position以及这个类型所实际的position
	 */
	@SuppressLint("UseSparseArrays")
	private Map<Integer, Integer> mApterPositiongetTypePosition = new HashMap<Integer, Integer>();

	public Integer getmApterPositiongetTypePosition(int adapterPosition) {
		setApterPositiongetTypePosition(adapterPosition);
		return mApterPositiongetTypePosition.get(adapterPosition);
	}

	private void setApterPositiongetTypePosition(int adapterPosition) {
		if (adapterPosition > mMaxAdapterPosition) {
			mMaxAdapterPosition = adapterPosition;
			int curPosition = ++mtypePositionCounter;
			mApterPositiongetTypePosition.put(adapterPosition, curPosition);
		}
	}
}