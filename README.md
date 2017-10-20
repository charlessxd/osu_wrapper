# osu_wrapper
Java API Wrapper for Official Osu! API


https://github.com/ppy/osu-api/wiki

##OsuPlayer Usage Example | OsuPlayerTest.java
```java
public class OsuPlayerTest {
    public static void main(String[] args) throws IOException, OsuUserException, OsuGamemodeException {
        Osu osu = new Osu("Osu! API Key Here");
        OsuPlayer player = osu.getPlayer("cookiezi", Osu.OsuGameMode.OSU);
        System.out.println(player.getPPRaw());
    }
}
```
