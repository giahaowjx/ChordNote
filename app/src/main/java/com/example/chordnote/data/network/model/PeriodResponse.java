package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeriodResponse extends CommonResponse {
    public PeriodResponse() {
    }

    @Expose
    @SerializedName("period")
    private Period period;

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
