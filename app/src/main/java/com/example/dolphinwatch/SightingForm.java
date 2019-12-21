package com.example.dolphinwatch;

import java.sql.Time;
import java.time.LocalTime;

public class SightingForm {
    private LocalTime time;
    private String azimuth, reticulesFromHorizon, dolphinLocation, minGroupSize, EstimatedGroupSize, behaviouralState, behaviouralEvent, seaState, notes;
    private boolean calves;

    public SightingForm(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(String azimuth) {
        this.azimuth = azimuth;
    }

    public String getReticulesFromHorizon() {
        return reticulesFromHorizon;
    }

    public void setReticulesFromHorizon(String reticulesFromHorizon) {
        this.reticulesFromHorizon = reticulesFromHorizon;
    }

    public String getDolphinLocation() {
        return dolphinLocation;
    }

    public void setDolphinLocation(String dolphinLocation) {
        this.dolphinLocation = dolphinLocation;
    }

    public String getMinGroupSize() {
        return minGroupSize;
    }

    public void setMinGroupSize(String minGroupSize) {
        this.minGroupSize = minGroupSize;
    }

    public String getEstimatedGroupSize() {
        return EstimatedGroupSize;
    }

    public void setEstimatedGroupSize(String estimatedGroupSize) {
        EstimatedGroupSize = estimatedGroupSize;
    }

    public String getBehaviouralState() {
        return behaviouralState;
    }

    public void setBehaviouralState(String behaviouralState) {
        this.behaviouralState = behaviouralState;
    }

    public String getSeaState() {
        return seaState;
    }

    public void setSeaState(String seaState) {
        this.seaState = seaState;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isCalves() {
        return calves;
    }

    public void setCalves(boolean calves) {
        this.calves = calves;
    }

    public String getBehaviouralEvent() {
        return behaviouralEvent;
    }

    public void setBehaviouralEvent(String behaviouralEvent) {
        this.behaviouralEvent = behaviouralEvent;
    }
}
