package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.exceptions.OsuBeatmapException;
import com.crbaldwin.osu_wrapper.exceptions.OsuGamemodeException;
import com.crbaldwin.osu_wrapper.exceptions.OsuUserException;
import com.crbaldwin.osu_wrapper.events.OsuListener;
import org.json.JSONException;

import java.io.IOException;
import java.util.Date;
import java.lang.Thread;
import java.text.DecimalFormat;

public class OsuBeatmapTest {
    public static void main(String[] args) throws IOException, OsuUserException, OsuGamemodeException, JSONException, InterruptedException, OsuBeatmapException {
        Osu osu = new Osu("319e7d936f399ab7663781d5bf19858fdc04b2a8");
        OsuBeatmap beatmap = osu.getBeatmap(252002);
        
        System.out.println(beatmap.getArtist());
    }
}