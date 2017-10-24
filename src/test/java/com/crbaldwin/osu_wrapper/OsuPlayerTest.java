package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.exceptions.OsuBeatmapException;
import com.crbaldwin.osu_wrapper.exceptions.OsuGamemodeException;
import com.crbaldwin.osu_wrapper.exceptions.OsuUserException;

import org.json.JSONException;

import java.io.IOException;
import java.util.Date;
import java.lang.Thread;
import java.text.DecimalFormat;

public class OsuPlayerTest {
    public static void main(String[] args) throws IOException, OsuUserException, OsuGamemodeException, JSONException, InterruptedException, OsuBeatmapException {
        Osu osu = new Osu("319e7d936f399ab7663781d5bf19858fdc04b2a8");
        OsuPlayer player = osu.getPlayer("charless", Osu.OsuGameMode.OSU);
        System.out.println(player.getTopPlays()[2].getPP());
    }
}