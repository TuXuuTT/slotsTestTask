package com.automation.businessEntities;

import java.util.List;

public class SlotsMachineDTO {

    private String lastWin;

    private String totalSpinsLeft;

    private String bet;

    private List<String> reelsStates;

    public String getLastWin() {
        return lastWin;
    }

    public void setLastWin(String lastWin) {
        this.lastWin = lastWin;
    }

    public String getTotalSpinsLeft() {
        return totalSpinsLeft;
    }

    public void setTotalSpinsLeft(String totalSpinsLeft) {
        this.totalSpinsLeft = totalSpinsLeft;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public List<String> getReelsStates() {
        return reelsStates;
    }

    public void setReelsStates(List<String> reelsStates) {
        this.reelsStates = reelsStates;
    }
}
