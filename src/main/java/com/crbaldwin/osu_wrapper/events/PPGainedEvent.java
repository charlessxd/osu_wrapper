package com.crbaldwin.osu_wrapper.events;

import com.crbaldwin.osu_wrapper.OsuPlayer;

public class PPGainedEvent {
    private OsuPlayer player;
    private double ppDifference;
    private int rankChange;

    public PPGainedEvent(OsuPlayer player) {
        this.player = player;
        ppDifference = player.getPPDiff();
        rankChange = player.getRankDiff();
    }

    public OsuPlayer getPlayer() {
        return player;
    }

    public double getPPDiff() {
        return ppDifference;
    }

    public int getRankChange() {
        return rankChange;
    }

    public String getRankChangeString() {
        String change = "";
        if(rankChange < 0) {
            change = "+" + (rankChange * -1);
        }
        else if(rankChange > 0) {
            change = "-" + rankChange;
        }
        else
            change = "0";
        return change;
    }
}