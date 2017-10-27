# osu_wrapper
Java API Wrapper for Official Osu! API

https://github.com/ppy/osu-api/wiki

## TO DO

### Event Listeners
1. Add PPLostEvent
2. Add TopPlayChangedEvent

### Misc.
1. Change the API Call method?

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

## OsuBeatmap Usage Example | OsuBeatmapTest.java
```java
public class OsuBeatmapTest {
    public static void main(String[] args) throws IOException, OsuUserException, OsuGamemodeException, JSONException, InterruptedException, OsuBeatmapException {
        Osu osu = new Osu("<api-key>");
        OsuBeatmap beatmap = osu.getBeatmap(252002);
        
        System.out.println(beatmap.getArtist());
    }
}
```
