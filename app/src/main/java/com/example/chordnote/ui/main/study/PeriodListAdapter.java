package com.example.chordnote.ui.main.study;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

import java.util.List;
import java.util.Map;

public class PeriodListAdapter extends SimpleExpandableListAdapter {
    public PeriodListAdapter(Context context, List<? extends Map<String, ?>> groupData, int groupLayout,
                             String[] groupFrom, int[] groupTo, List<? extends List<? extends Map<String, ?>>> childData, int childLayout, String[] childFrom, int[] childTo) {
        super(context, groupData, groupLayout, groupFrom, groupTo, childData, childLayout, childFrom, childTo);
    }


}
