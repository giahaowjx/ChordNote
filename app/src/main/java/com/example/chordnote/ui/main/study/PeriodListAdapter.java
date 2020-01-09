package com.example.chordnote.ui.main.study;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Chapter;
import com.example.chordnote.data.network.model.Period;

import java.util.List;
import java.util.Map;

public class PeriodListAdapter extends BaseExpandableListAdapter {

    private Context context;
    public List<Chapter> groupString;

    public PeriodListAdapter(Context context, List<Chapter> groupString) {
        this.context = context;
        this.groupString = groupString;
    }

    @Override
    public int getGroupCount(){
        return groupString.size();
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return groupString.get(groupPosition).getPeriodTitleList().size();
    }

    // 获取指定的分组数据
    @Override
    public Object getGroup(int groupPosition){
        return groupString.get(groupPosition);
    }

    // 获取指定分组中的指定子项数据
    @Override
    public Object getChild(int groupPosition, int childPosition){
        return groupString.get(groupPosition).getPeriodTitleList().get(childPosition);
    }

    // 获取指定分组的id
    @Override
    public long getGroupId(int groupPosition){
        return groupPosition;
    }

    // 获取子项id
    @Override
    public long getChildId(int groupPosition, int childPosition){
        return childPosition;
    }

    public int getPeriodId(int groupPosition, int childPosition){
        if (groupString != null) {
            return groupString.get(groupPosition).getPeriodIdList()[childPosition];
        }
        return 0;
    }

    @Override
    public boolean hasStableIds(){
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){
        GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.group, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.groupto = convertView.findViewById(R.id.groupto);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }
        groupViewHolder.groupto.setText(groupString.get(groupPosition).getTitle());
        return convertView;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
        ChildViewHolder childViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.child, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.childto = convertView.findViewById(R.id.childto);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.childto.setText(groupString.get(groupPosition).getPeriodTitleList().get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition){
        return true;
    }

    public static class GroupViewHolder{
        TextView groupto;
    }

    public static class ChildViewHolder{
        TextView childto;
    }
}
