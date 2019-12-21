package com.example.dolphinwatch;

import java.time.LocalTime;

public class BigEyesForm {
    private LocalTime startTime, stopTime;
    private String place, equipment, visibility, sightingLocation, notes, observingArea, seaState, vessel, trawler, distanceEst;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigEyesForm(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalTime stopTime) {
        this.stopTime = stopTime;
    }


    public String getObservingArea() {
        return observingArea;
    }

    public void setObservingArea(String observingArea) {
        this.observingArea = observingArea;
    }

    public String getSeaState() {
        return seaState;
    }

    public void setSeaState(String seaState) {
        this.seaState = seaState;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getTrawler() {
        return trawler;
    }

    public void setTrawler(String trawler) {
        this.trawler = trawler;
    }

    public String getDistanceEst() {
        return distanceEst;
    }

    public void setDistanceEst(String distanceEst) {
        this.distanceEst = distanceEst;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getSightingLocation() {
        return sightingLocation;
    }

    public void setSightingLocation(String sightingLocation) {
        this.sightingLocation = sightingLocation;
    }
}
