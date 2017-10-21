package com.crbaldwin.osu_wrapper.events;

import java.util.*;

public interface OsuListener {
  void onPlayerRankChanged(RankChangedEvent event);
}