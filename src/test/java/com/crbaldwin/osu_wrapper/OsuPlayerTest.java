package com.crbaldwin.osu_wrapper;

import com.crbaldwin.osu_wrapper.exceptions.OsuGamemodeException;
import com.crbaldwin.osu_wrapper.exceptions.OsuUserException;

import java.io.IOException;

public class OsuPlayerTest {
    public static void main(String[] args) throws IOException {
        Osu osu = new Osu("319e7d936f399ab7663781d5bf19858fdc04b2a8");
        try {
            OsuPlayer player = osu.getPlayer("cookiezi", Osu.OsuGameMode.OSU);
            System.out.println(player.getAvatarUrl());
        } catch (OsuUserException e) {
            e.printStackTrace();
        } catch (OsuGamemodeException e) {
            e.printStackTrace();
        }
    }
}
