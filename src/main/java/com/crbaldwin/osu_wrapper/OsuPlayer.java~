package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.exceptions.OsuGamemodeException;
import com.crbaldwin.osu_wrapper.exceptions.OsuUserException;
import com.crbaldwin.osu_wrapper.util.API_Request;
import org.json.JSONObject;

import java.io.IOException;

public class OsuPlayer {

    private final API_Request REQUEST = new API_Request();
    private final String GET_USER = "https://osu.ppy.sh/api/get_user?k=";
    private final String GET_USER_BEST = "https://osu.ppy.sh/api/get_user_best?k=";
    private final String GET_USER_RECENT = "https://osu.ppy.sh/api/get_user_recent?k=";

    //Osu User Variables
    private String username, country, profile_url, avatar_url, uname, key;
    private int user_id, pp_rank, pp_country_rank, playcount, count300, count100, count50, count_rank_ss, count_rank_s, count_rank_a, user_ID;
    private double pp_raw, accuracy, level;
    private long ranked_score, total_score;
    private Osu.OsuGameMode gmode;



    OsuPlayer(String API_KEY, String name, Osu.OsuGameMode gameMode) throws OsuUserException, IOException, OsuGamemodeException {
        //Setting necessary instance variables to call API in update().
        uname = name;
        user_ID = 0;
        gmode = gameMode;
        key = API_KEY;
        updateUser();
    }

    OsuPlayer(String API_KEY, int userID, Osu.OsuGameMode gameMode) throws OsuUserException, IOException, OsuGamemodeException {
        //Setting necessary instance variables to call API in update().
        user_ID = userID;
        gmode = gameMode;
        key = API_KEY;
        updateUser();
    }


    /*
    Check if user has played mode, and iterate what they have done for gamemode
    Line.69-85
     */
    private void updateUser() throws IOException, OsuGamemodeException, OsuUserException {
        JSONObject user;
        if(gmode == Osu.OsuGameMode.OSU) {
            user = REQUEST.callApi(GET_USER + key + "&u=" + (user_ID == 0 ? uname : user_ID) + "&m=0");
        }
        else if(gmode == Osu.OsuGameMode.TAIKO) {
            user = REQUEST.callApi(GET_USER + key + "&u=" + (user_ID == 0 ? uname : user_ID) + "&m=1");
        }
        else if(gmode == Osu.OsuGameMode.CATCHTHEBEAT) {
            user = REQUEST.callApi(GET_USER + key + "&u=" + (user_ID == 0 ? uname : user_ID) + "&m=2");
        }
        else if(gmode == Osu.OsuGameMode.MANIA) {
            user = REQUEST.callApi(GET_USER + key + "&u=" + (user_ID == 0 ? uname : user_ID) + "&m=3");
        }
        else {
            throw new OsuGamemodeException("[Osu] Invalid Gamemode");
        }

        if(user == null) {
            throw new OsuUserException("[Osu] User not found");
        } else {
            user_id = user.getInt("user_id");
            username = user.getString("username");
            count300 = user.getInt("count300");
            count100 = user.getInt("count100");
            count50 = user.getInt("count50");
            playcount = user.getInt("playcount");
            ranked_score = user.getLong("ranked_score");
            total_score = user.getLong("total_score");
            pp_rank = user.getInt("pp_rank");
            level = user.getDouble("level");
            pp_raw = user.getDouble("pp_raw");
            accuracy = user.getDouble("accuracy");
            count_rank_ss = user.getInt("count_rank_ss");
            count_rank_s = user.getInt("count_rank_s");
            count_rank_a = user.getInt("count_rank_a");
            country = user.getString("country");
            pp_country_rank = user.getInt("pp_country_rank");

            profile_url = "https://osu.ppy.sh/u/" + user_id;
            avatar_url = "https://a.ppy.sh/" + user_id;
        }
    }


    //Accessor Methods
    public int getUserID() {
        return user_id;
    }

    public String getUsername() {
        return username;
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

    public int getPlaycount() {
        return playcount;
    }

    public long getRankedScore() {
        return ranked_score;
    }

    public long getTotalScore() {
        return total_score;
    }

    public int getPPRank() {
        return pp_rank;
    }

    public double getLevel() {
        return level;
    }

    public double getPPRaw() {
        return pp_raw;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public int getCountRankSS() {
        return count_rank_ss;
    }

    public int getCountRankS() {
        return count_rank_s;
    }

    public int getCountRankA() {
        return count_rank_a;
    }

    public String getCountry() {
        return country;
    }

    public int getPPCountryRank() {
        return pp_country_rank;
    }

    public String getProfileUrl() {
        return profile_url;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }
}