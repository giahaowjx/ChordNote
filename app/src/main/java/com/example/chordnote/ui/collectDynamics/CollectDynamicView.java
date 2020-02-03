package com.example.chordnote.ui.collectdynamics;

import com.example.chordnote.data.network.model.Dynamic;
import com.example.chordnote.ui.base.MvpView;

import java.util.ArrayList;

public interface CollectDynamicView extends MvpView {

    void setDynamicList(ArrayList<Dynamic> dynamics);

}
