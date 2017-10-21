package com.crbaldwin.osu_wrapper.events;

import com.crbaldwin.osu_wrapper.OsuPlayer;

public class RankChangedEvent {
  private OsuPlayer player;
  private double ppDifference;
  private int rankChange;
  
  public RankChangedEvent(OsuPlayer osuPlayer) {
    player = osuPlayer;
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
}