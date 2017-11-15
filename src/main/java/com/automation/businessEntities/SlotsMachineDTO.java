package com.automation.businessEntities;

import java.util.List;

public class SlotsMachineDTO {

    private int lastWin;

    private int totalSpinsLeft;

    private int bet;

    private List<String> reelsStates;

    private String backgroundViewId;
    private String iconsViewId;
    private String machineViewId;

    public int getLastWin() {
        return lastWin;
    }

    public void setLastWin(int lastWin) {
        this.lastWin = lastWin;
    }

    public int getTotalSpinsLeft() {
        return totalSpinsLeft;
    }

    public void setTotalSpinsLeft(int totalSpinsLeft) {
        this.totalSpinsLeft = totalSpinsLeft;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public List<String> getReelsStates() {
        return reelsStates;
    }

    public void setReelsStates(List<String> reelsStates) {
        this.reelsStates = reelsStates;
    }

    public String getBackgroundViewId() {
        return backgroundViewId;
    }

    public void setBackgroundViewId(String backgroundViewId) {
        this.backgroundViewId = backgroundViewId;
    }

    public String getIconsViewId() {
        return iconsViewId;
    }

    public void setIconsViewId(String iconsViewId) {
        this.iconsViewId = iconsViewId;
    }

    public String getMachineViewId() {
        return machineViewId;
    }

    public void setMachineViewId(String machineViewId) {
        this.machineViewId = machineViewId;
    }


}
