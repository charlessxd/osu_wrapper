package com.crbaldwin.osu_wrapper;
import com.crbaldwin.osu_wrapper.exceptions.OsuGamemodeException;
import com.crbaldwin.osu_wrapper.exceptions.OsuUserException;
import com.crbaldwin.osu_wrapper.events.RankChangedEvent;
import com.crbaldwin.osu_wrapper.events.OsuListener;

public class OsuPlayerListenerTest implements OsuListener {
  public void onPlayerRankChanged(RankChangedEvent event) {
    System.out.println(event.getPlayer().getUsername());
  }
}