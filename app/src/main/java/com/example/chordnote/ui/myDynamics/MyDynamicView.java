package com.example.chordnote.ui.mydynamics;

import com.example.chordnote.data.network.model.Dynamic;
import com.example.chordnote.ui.base.MvpView;

import java.util.ArrayList;

public interface MyDynamicView extends MvpView {

    void setDynamicList(ArrayList<Dynamic> dynamics);

}
