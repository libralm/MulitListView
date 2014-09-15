package com.libra.mulitlistview.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.libra.mulitlistview.core.BaseMulitiAdapter;
import com.libra.mulitlistview.core.ViewHolder;

public class ViewPagerListViewAdapter extends BaseMulitiAdapter {
	
	public final int TYPE_0 = 0;
	
	public final int TYPE_1 = 1;

	public ViewPagerListViewAdapter(Context context,
			Map<Integer, Integer> typeViewMap, Map<Integer, Object[]> typeData) {
		super(context, typeViewMap, typeData);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onFillDate(ViewHolder holder, int type, Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ViewHolder onSetTag(View convertView, int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case TYPE_0:
			
			break;
		case TYPE_1:
			
			break;
		default:
			break;
		}
				
		return null;
	}

	@Override
	public void onFinishInflater(int type, View convertView, int position,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Integer> onSetTypeList(int mPositionCounter) {
		// TODO Auto-generated method stub
		List<Integer> mTypeList = new ArrayList<Integer>(mPositionCounter);
		for (int i = 0; i < mPositionCounter; i++) {
		}
		return null;
	}

	
}
