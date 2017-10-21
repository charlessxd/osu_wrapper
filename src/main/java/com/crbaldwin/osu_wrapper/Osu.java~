package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.exceptions.OsuGamemodeException;
import com.crbaldwin.osu_wrapper.exceptions.OsuUserException;
import com.crbaldwin.osu_wrapper.util.API_Request;
import org.json.JSONObject;

import java.io.IOException;

public class Osu {

    private String key;

    enum OsuGameMode {
        OSU, TAIKO, CATCHTHEBEAT, MANIA
    }


    //319e7d936f399ab7663781d5bf19858fdc04b2a8
    public Osu(String API_KEY) {
        key = API_KEY;
    }

    //Default call, returns OsuPlayer for
    public OsuPlayer getPlayer(String username, OsuGameMode mode) throws IOException, OsuUserException, OsuGamemodeException {
        OsuPlayer player = new OsuPlayer(key, username, mode);
        return player;
    }

    public OsuPlayer getPlayer(int user_id, OsuGameMode mode) throws OsuUserException, IOException, OsuGamemodeException {
        OsuPlayer player = new OsuPlayer(key, user_id, mode);
        return player;
    }
}