package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.exceptions.OsuGamemodeException;
import com.crbaldwin.osu_wrapper.exceptions.OsuUserException;
import com.crbaldwin.osu_wrapper.util.API_Request;
import com.crbaldwin.osu_wrapper.events.OsuListener;
import com.crbaldwin.osu_wrapper.events.RankChangedEvent;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.lang.Thread;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class OsuPlayer {

    private final API_Request REQUEST = new API_Request();
    private final String GET_USER = "https://osu.ppy.sh/api/get_user?k=";
    private final String GET_USER_BEST = "https://osu.ppy.sh/api/get_user_best?k=";
    private final String GET_USER_RECENT = "https://osu.ppy.sh/api/get_user_recent?k=";

    //Osu User Variables
    private String username, country, profile_url, avatar_url, uname, key;
    private int user_id, pp_rank, pp_country_rank, playcount, count300, count100, count50, count_rank_ss, count_rank_s, count_rank_a, user_ID, rank_difference;
    private double pp_raw, accuracy, level, pp_difference;
    private long ranked_score, total_score;
    private Osu.OsuGameMode gmode;
    private long last_checked;
    private List<OsuListener> listeners = new ArrayList<OsuListener>();
    private Thread thread;



    /* Work on PPEventListener
     *  > Store Listeners
     *    ? 1 Listener per user / Store in listener OsuPlayer
     *    ? List of all listeners in Osu.java
     * 
     *  > Refresh rate of listeners
     *    ? 15 Seconds
     *    ? 30 Seconds
     *    ? 1 Minute
     *    ? 5 Minutes
     */
    
    OsuPlayer(String API_KEY, String name, Osu.OsuGameMode gameMode) throws OsuUserException, IOException, OsuGamemodeException, JSONException {
        //Setting necessary instance variables to call API in update().
        uname = name;
        user_ID = 0;
        gmode = gameMode;
        key = API_KEY;
        updateUser();
    }

    OsuPlayer(String API_KEY, int userID, Osu.OsuGameMode gameMode) throws OsuUserException, IOException, OsuGamemodeException, JSONException {
        //Setting necessary instance variables to call API in update().
        user_ID = userID;
        gmode = gameMode;
        key = API_KEY;
        updateUser();
    }

    private synchronized void check(OsuPlayer p, double PP_Required) throws JSONException, IOException, OsuGamemodeException, OsuUserException {
      if((new Date().getTime() - last_checked) / 1000 >= 2) {
        updateUser();
        if(pp_difference > PP_Required) {
          RankChangedEvent event = new RankChangedEvent(p);
          for(OsuListener list : listeners) {
            //
          }
        }
        if(rank_difference != pp_rank) {
          RankChangedEvent event = new RankChangedEvent(p);
          for(OsuListener list : listeners) {
            list.onPlayerRankChanged(event);
          }
        }
      }
    }
    
    public void addListener(OsuListener listener, double PP_Required) {
      listeners.add(listener);
      final OsuPlayer user = this;
      final double pp_req = PP_Required;
      
      if(thread == null) {
        thread = new Thread() {
          @Override
          public void run() {
            while (true) {
              try {
                check(user, pp_req);
                System.out.println(user.getUsername() + " running...");
              } catch (JSONException ex) {
                ex.printStackTrace();
              } catch (IOException ex) {
                ex.printStackTrace();
              } catch (OsuGamemodeException ex) {
                ex.printStackTrace();
              } catch (OsuUserException ex) {
                ex.printStackTrace();
              }
              try {
                Thread.sleep(1000);
              } catch (Exception ex) {
                ex.printStackTrace();
              }
            }
          }
        };
        thread.start();
      }
    }
    
    /*
    Check if user has played mode, and iterate what they have done for gamemode
    Line.69-85
     */
    private void updateUser() throws IOException, OsuGamemodeException, OsuUserException, JSONException {
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
            
            if(pp_difference == 0.0d) 
              pp_difference = pp_raw;
            else 
              pp_difference = pp_raw - pp_difference;
            
            if(rank_difference == 0)
              rank_difference = pp_rank;
            else
              rank_difference = pp_rank - rank_difference;
            
            profile_url = "https://osu.ppy.sh/u/" + user_id;
            avatar_url = "https://a.ppy.sh/" + user_id;
            
            last_checked = new Date().getTime();
        }
    }


    //Accessor Methods
    public void setRaw_PP(double pp) {
      pp_raw = pp;
    }
    
    public double getPPDiff() {
      return pp_difference;
    }
    
    public int getRankDiff() {
      return rank_difference;
    }
    
    public long getChecked() {
         return last_checked;
    }
    
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