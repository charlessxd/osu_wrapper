package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.Osu;
import com.crbaldwin.osu_wrapper.exceptions.OsuBeatmapException;
import com.crbaldwin.osu_wrapper.util.API_Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONException;


public class OsuBeatmap {
    
    /* See also:
     * > https://github.com/ppy/osu-api/wiki
     * >> /api/get_beatmaps
     * for details on variables
     */
    
    private final String GET_BEATMAPS = "https://osu.ppy.sh/api/get_beatmaps?k=";
    private final API_Request REQUEST = new API_Request();
    
    private int approved, beatmap_id, beatmapset_id, bpm, hit_length,genre_id, language_id, total_length, mode, favourite_count, playcount, passcount, max_combo;
    private double difficultyrating, diff_size, diff_overall, diff_approach, diff_drain;
    private String artist, creator, source, title, version, key;
    private String[] tags;
    private Osu osu;
    private Date approved_date, last_update;
    
    OsuBeatmap(int beatmap_id, Osu osu) throws IOException, JSONException, OsuBeatmapException {
        key = osu.getAPIKey();
        this.osu = osu;
        this.beatmap_id = beatmap_id;
        updateMap();
    }

    private void updateMap() throws IOException, JSONException, OsuBeatmapException {
        JSONObject map = REQUEST.callApiObject(GET_BEATMAPS+key+"&b="+beatmap_id);

        if(map == null) {
            throw new OsuBeatmapException("[Osu] Beatmap not found");
        }

        approved = map.getInt("approved");
        artist = map.getString("artist");
        beatmap_id = map.getInt("beatmap_id");
        beatmapset_id = map.getInt("beatmapset_id");
        bpm = map.getInt("bpm");
        creator = map.getString("creator");
        difficultyrating = map.getDouble("difficultyrating");
        diff_size = map.getDouble("diff_size");
        diff_overall = map.getDouble("diff_overall");
        diff_approach = map.getDouble("diff_approach");
        diff_drain = map.getDouble("diff_drain");
        hit_length = map.getInt("hit_length");
        source = map.getString("source");
        genre_id = map.getInt("genre_id");
        language_id = map.getInt("language_id");
        title = map.getString("title");
        total_length = map.getInt("total_length");
        version = map.getString("version");
        mode = map.getInt("mode");
        tags = map.getString("tags").split("\\s+");
        favourite_count = map.getInt("favourite_count");
        playcount = map.getInt("playcount");
        passcount = map.getInt("passcount");
        max_combo = map.getInt("max_combo");

    }

    public int getApproved() {
        return approved;
    }

    public String getArtist() {
        return artist;
    }

    public int getBeatmapID() {
        return beatmap_id;
    }

    public int getBeatmapSetID() {
        return beatmapset_id;
    }

    public int getBPM() {
        return bpm;
    }

    public String getCreator() {
        return creator;
    }

    public double getDifficultyrating() {
        return difficultyrating;
    }

    public double getDiffSize() {
        return diff_size;
    }

    public double getDiffOverall() {
        return diff_overall;
    }

    public double getDiffApproach() {
        return diff_approach;
    }

    public double getDiffDrain() {
        return diff_drain;
    }

    public int getHitLength() {
        return hit_length;
    }

    public String getSource() {
        return source;
    }

    public int getGenreID() {
        return genre_id;
    }

    public int getLanguageID() {
        return language_id;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalLength() {
        return total_length;
    }

    public String getVersion() {
        return version;
    }

    public int getMode() {
        return mode;
    }

    public String[] getTags() {
        return tags;
    }

    public int getFavouriteCount() {
        return favourite_count;
    }

    public int getPlaycount() {
        return playcount;
    }

    public int getPasscount() {
        return passcount;
    }

    public int getMaxCombo() {
        return max_combo;
    }
}