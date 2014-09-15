package com.libra.mulitlistview.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.libra.mulitlistview.core.listener.OnItemClickListener;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 
 * @author liaomin
 * 
 */
public abstract class BaseMulitiAdapter extends BaseAdapter {

	/**
	 * typeMap key 表示view的type，Integer表示resourceId的
	 */
	private Map<Integer, Integer> mTypeViewMap;

	private Context context;

	/**
	 * key:表示view的type，value表示数据
	 */
	private Map<Integer, TypeData> mTypeDataMap;

	/**
	 * 每个item的类型.Integer类型；
	 */
	private List<Integer> mPositionTypeList;

	private int mPositionCount;

	public BaseMulitiAdapter(Context context,
			Map<Integer, Integer> typeViewMap, Map<Integer, Object[]> typeData) {
		this.context = context;
		mTypeViewMap = typeViewMap;
		initPositionCount(typeData);
		initTypeDataMap(typeData);
	}


	private void initPositionCount(Map<Integer, Object[]> typeData) {
		// TODO Auto-generated method stub
		Set<Integer> keySet = typeData.keySet();
		for (Integer integer : keySet) {
			Object[] datas = typeData.get(integer);
			mPositionCount += datas.length;
		}
	}

	@SuppressLint("UseSparseArrays")
	private void initTypeDataMap(Map<Integer, Object[]> typeData) {
		// TODO Auto-generated method stub
		mTypeDataMap = new HashMap<Integer, TypeData>();
		Set<Integer> keySet = typeData.keySet();
		for (Integer integer : keySet) {
			TypeData mTypeData = new TypeData();
			mTypeData.setmData(typeData.get(integer));
			mTypeDataMap.put(integer, mTypeData);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		setPositionTypeList(mPositionCount);
		return mPositionCount;
	}

	private void setPositionTypeList(int mPositionCount) {
		// TODO Auto-generated method stub
		onSetTypeList(mPositionCount);
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if (mPositionTypeList != null)
			return mPositionTypeList.get(position);
		return super.getItemViewType(position);
	}

	@Override
	public final int getViewTypeCount() {
		// TODO Auto-generated method stub
		return mTypeViewMap.size();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		int mType = getItemViewType(position);
		TypeData typeData = mTypeDataMap.get(mType);
		if (convertView == null) {
			int layourResId = mTypeViewMap.get(mType);
			convertView = LayoutInflater.from(context).inflate(layourResId,
					parent, false);
			onFinishInflater(mType, convertView, position, parent);
			setTypeDateColumn(convertView, mType);
		}
		if (convertView.getTag() == null) {
			ViewHolder tag = onSetTag(convertView, mType);
			convertView.setTag(tag);
		}
		@SuppressWarnings("unchecked")
		ViewHolder holder = (ViewHolder) convertView.getTag();
		int typePosition = typeData.getmApterPositiongetTypePosition(position);
		setOnItemClick(holder,convertView, typePosition, typeData);
		onFillDate(holder, mType, typeData.getmData()[typePosition]);
		return convertView;
	}

	@SuppressLint("NewApi")
	private void setOnItemClick(ViewHolder viewHolder, View convertView, int typePosition,
			TypeData typeData) {
		if (convertView instanceof ViewGroup) {
			int childCount = ((ViewGroup) convertView).getChildCount();
			for (int i = 0; i < childCount; i++) {
				View childView = ((ViewGroup) convertView).getChildAt(i);
				OnItemClickListener listener = viewHolder.getOnItemClickListener(i);
				if (!childView.hasOnClickListeners()) {
					childView.setOnClickListener(listener);
				} else {
					listener.setRow(typePosition);
				}
			}
		}
	}

	private void setTypeDateColumn(View convertView, int mType) {
		if (mTypeDataMap.get(mType).getmViewColumn() == -1) {
			if (convertView instanceof ViewGroup) {
				mTypeDataMap.get(mType).setmViewColumn(((ViewGroup) convertView)
						.getChildCount());
			} else {
				mTypeDataMap.get(mType).setmViewColumn(1);
			}
		}
	}

	/**
	 * 加载数据
	 * 
	 * @param holder
	 * @param type
	 * @param data
	 */
	public abstract void onFillDate(ViewHolder holder, int type, Object data);

	/**
	 * 设置ViewHolder
	 * 
	 * @param convertView
	 * @param type
	 * @return
	 */
	public abstract ViewHolder onSetTag(View convertView, int type);

	/**
	 * 布局加载完成
	 * 
	 * @param type
	 * @param convertView
	 * @param position
	 * @param parent
	 */
	public abstract void onFinishInflater(int type, View convertView,
			int position, ViewGroup parent);

	/**
	 * 设置每行的布局类型
	 * 
	 * @param mPositionCounter
	 * @return
	 */
	public abstract List<Integer> onSetTypeList(int mPositionCounter);

	

	
}
