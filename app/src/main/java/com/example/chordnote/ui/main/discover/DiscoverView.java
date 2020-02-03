package com.example.chordnote.ui.main.discover;

import com.example.chordnote.data.network.model.Dynamic;
import com.example.chordnote.ui.base.MvpView;
import com.example.chordnote.ui.main.MainView;

import java.util.ArrayList;

public interface DiscoverView extends MainView {

    void setDynamicList(ArrayList<Dynamic> dynamics);

}
