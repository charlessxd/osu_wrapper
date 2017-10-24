package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.exceptions.OsuBeatmapException;
import org.json.JSONObject;

import java.io.IOException;

public class OsuPlay {
    
    private OsuBeatmap beatmap;
    private double pp;
    private int beatmap_id, score, maxcombo, count300, count100, count50, countmiss, countkatu, countgeki, enabled_mods, user_id;
    private boolean perfect;
    
    
    OsuPlay(JSONObject play, Osu osu) throws IOException, OsuBeatmapException {
        beatmap_id = play.getInt("beatmap_id");
        beatmap = osu.getBeatmap(beatmap_id);

        score = play.getInt("score");
        maxcombo = play.getInt("maxcombo");
        count300 = play.getInt("count300");
        count100 = play.getInt("count100");
        count50 = play.getInt("count50");
        countmiss = play.getInt("countmiss");
        countkatu = play.getInt("countkatu");
        countgeki = play.getInt("countgeki");
        perfect = (play.getInt("perfect") == 1);
        enabled_mods = play.getInt("enabled_mods");
        user_id = play.getInt("user_id");
        pp = play.getDouble("pp");
    }
    
    public int getBeatmapID() {
        return beatmap_id;
    }
    
    public OsuBeatmap getOsuBeatmap() {
        return beatmap;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getMaxcombo() {
        return maxcombo;
    }
    
    public int getCount300() {
        return count300;
    }
    
    public int getCount100() {
        return count100;
    }
    
    public int getCount50() {
        return count50;
    }
    
    public int getCountMiss() {
        return countmiss;
    }
    
    public int getCountKatu() {
        return countkatu;
    }

    public int getCountGeki() {
        return countgeki;
    }

    public boolean getPerfect() {
        return perfect;
    }
    
    public int getEnabledMods() {
        return enabled_mods;
    }
    
    public int getUserID() {
        return user_id;
    }
    
    public double getPP() {
        return pp;
    }
}