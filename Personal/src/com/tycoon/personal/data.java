package com.tycoon.personal;

import java.io.Serializable;
@SuppressWarnings("serial") //with this annotation we are going to hide compiler warning
public class data implements Serializable {

public data(int totalpersonal,int CurrentEngineersInWork,int CurrentDesignersInWork,int CurrentProgrammersInWork,int CurrentEngineers,int CurrentDesigners,int CurrentProgrammers){
    this.totalpersonal=totalpersonal;
    this.CurrentDesigners=CurrentDesigners;
    this.CurrentDesignersInWork=CurrentDesignersInWork;
    this.CurrentEngineersInWork=CurrentEngineersInWork;
    this.CurrentEngineers=CurrentEngineers;
    this.CurrentProgrammers=CurrentProgrammers;
    this.CurrentProgrammersInWork=CurrentProgrammersInWork;
}

public int gettotalpersonal() {
    return totalpersonal;
}
public void settotalpersonal(int totalpersonal) {

    this.totalpersonal = totalpersonal;
}

public int getCurrentDesigners() {
    return CurrentDesigners;
}
public void setCurrentDesigners(int CurrentDesigners) {
    this.CurrentDesigners = CurrentDesigners;
}

public int getCurrentDesignersInWorkrs() {
    return CurrentDesignersInWork;
}
public void setCurrentDesignersInWorkrs(int CurrentDesignersInWorkrs) {
    this.CurrentDesignersInWork = CurrentDesignersInWorkrs;
}

public int getCurrentEngineersInWork() {
    return CurrentEngineersInWork;
}
public void setCurrentEngineersInWork(int CurrentEngineersInWork) {
    this.CurrentEngineersInWork = CurrentEngineersInWork;
}

public int getCurrentEngineers() {
    return CurrentEngineers;
}
public void setCurrentEngineers(int CurrentEngineers) {
    this.CurrentEngineers = CurrentEngineers;
}

public int getCurrentProgrammersInWork() {
    return CurrentProgrammersInWork;
}
public void setCurrentProgrammersInWork(int CurrentProgrammers) {

    this.CurrentProgrammersInWork = CurrentProgrammers;
}

public int getCurrentProgrammers() {
    return CurrentProgrammers;
}
public void setCurrentProgrammers(int CurrentProgrammers) {

    this.CurrentProgrammers = CurrentProgrammers;
}


private int totalpersonal,CurrentEngineersInWork,CurrentDesignersInWork,CurrentProgrammersInWork,CurrentEngineers,CurrentDesigners,CurrentProgrammers;
}