package com.libra.mulitlistview.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
 * @param <T> HolderView
 */
public abstract class BaseMulitiAdapter<T> extends BaseAdapter {
	
	/**
	 * 
	 *typeMap key 表示view的type，Integer表示resourceId的
	 */
	private Map<Integer,Integer> mTypeViewMap;
	
	private Context context;
	
	/**
	 * key:表示view的type，value表示数据
	 */
	private Map<Integer,TypeData> mTypeDataMap;
	
	/**
	 * 每个item的类型.Integer类型；
	 */
	private List<Integer> mPositionTypeList;
	
	private int mPositionCount;
	
	public BaseMulitiAdapter(Context context, Map<Integer,Integer> typeViewMap,Map<Integer,Object[]> typeData){
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

	@SuppressLint("UseSparseArrays") private void initTypeDataMap(Map<Integer, Object[]> typeData) {
		// TODO Auto-generated method stub
		mTypeDataMap = new HashMap<Integer, BaseMulitiAdapter<T>.TypeData>();
		Set<Integer> keySet = typeData.keySet();
		for (Integer integer : keySet) {
			TypeData mTypeData = new TypeData();
			mTypeData.mData = typeData.get(integer);
			mTypeDataMap.put(integer, mTypeData);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mPositionCount;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public final int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if(mPositionTypeList != null) return mPositionTypeList.get(position);
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
		if(convertView ==null){
			int layourResId = mTypeViewMap.get(mType);
			convertView = LayoutInflater.from(context).inflate(layourResId, parent, false);
			onFinishInflater(mType,convertView,position,parent);
			setTypeDateColumn(convertView, mType);
		}
		if(convertView.getTag() == null){
			T tag = onSetTag(convertView, mType);
			convertView.setTag(tag);
		}
		@SuppressWarnings("unchecked")
		T holder = (T) convertView.getTag();
		int typePosition = typeData.getmApterPositiongetTypePosition(position);
		onFillDate(holder,mType,typeData.mData[typePosition]);
		return convertView;
	}

	private void setTypeDateColumn(View convertView, int mType) {
		if(mTypeDataMap.get(mType).mViewColumn == -1){
			if(convertView instanceof ViewGroup){
				mTypeDataMap.get(mType).mViewColumn = ((ViewGroup) convertView).getChildCount();
			} else{
				mTypeDataMap.get(mType).mViewColumn = 1;
			}
		}
	}
	
	/**
	 * 加载数据
	 * @param holder
	 * @param type
	 * @param data
	 */
	abstract void onFillDate(T holder,int type,Object data);
	
	/**
	 * 设置holderview
	 * @param convertView
	 * @param type
	 * @return
	 */
	abstract T onSetTag(View convertView,int type);
	
	/**
	 * 布局加载完成
	 * @param type
	 * @param convertView
	 * @param position
	 * @param parent
	 */
	abstract void onFinishInflater(int type, View convertView, int position, ViewGroup parent);

	class TypeData{
		
		Object[] mData;
		
		int mViewColumn = -1;
		
		private int mMaxAdapterPosition = -1;
		
		private int mtypePositionCounter;
		
		/**
		 * key:表示View的type value:getview()传过来的position以及这个类型所实际的position
		 */
		@SuppressLint("UseSparseArrays") private Map<Integer, Integer> mApterPositiongetTypePosition = new HashMap<Integer, Integer>();

		public Integer getmApterPositiongetTypePosition(int adapterPosition) {
			setApterPositiongetTypePosition(adapterPosition);
			return mApterPositiongetTypePosition.get(adapterPosition);
		}

		private void setApterPositiongetTypePosition(int adapterPosition) {
			if(adapterPosition > mMaxAdapterPosition){
				mMaxAdapterPosition = adapterPosition;				
				int curPosition = ++mtypePositionCounter;
				mApterPositiongetTypePosition.put(adapterPosition, curPosition);
			}
		}
	}
}
