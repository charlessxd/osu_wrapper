package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.events.RankChangedEvent;
import com.crbaldwin.osu_wrapper.events.OsuListener;

public class OsuPlayerListenerTest implements OsuListener {
  public void onPlayerRankChanged(RankChangedEvent event) {
    System.out.println("Called from class: " + event.getPlayer().getPPRank());
  }
}