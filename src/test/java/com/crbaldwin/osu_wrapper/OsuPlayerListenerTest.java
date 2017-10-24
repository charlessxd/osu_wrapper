package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.events.PPGainedEvent;
import com.crbaldwin.osu_wrapper.events.OsuListener;

public class OsuPlayerListenerTest extends OsuListener {
    public void onPPGained(PPGainedEvent event) {
        System.out.println(event.getPlayer().getUsername() + " changed by " + event.getRankChangeString());
    }
}