# osu_wrapper
Java API Wrapper for Official Osu! API


https://github.com/ppy/osu-api/wiki

## OsuPlayer Usage Example | OsuPlayerTest.java
```java
public class OsuPlayerTest {
    public static void main(String[] args) throws IOException, OsuUserException, OsuGamemodeException, JSONException, InterruptedException, OsuBeatmapException {
        Osu osu = new Osu("<api-key>");
        OsuPlayer player = osu.getPlayer("cookiezi", Osu.OsuGameMode.OSU);
        System.out.println(player.getPPRaw());
    }
}
```

## OsuPlayerListener Usage Example | OsuPlayerListener.java & ExampleMain
```java
public class OsuPlayerListenerTest extends OsuListener {
    public void onPPGained(PPGainedEvent event) {
        System.out.println(event.getPlayer().getUsername() + " changed by " + event.getRankChangeString());
    }
}

public class ExampleMain throws IOException, OsuUserException, OsuGamemodeException, JSONException, InterruptedException, OsuBeatmapException {
    public static void main(String[] args) {
        Osu osu = new Osu("<api-key>");
        OsuPlayer player = osu.getPlayer("cookiezi", Osu.OsuGameMode.OSU); //Notifies for all gamemodes.
        player.addListener(new OsuPlayerListener());
    }
}
```
