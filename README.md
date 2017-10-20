# osu_wrapper
Java API Wrapper for Official Osu! API


https://github.com/ppy/osu-api/wiki

##OsuPlayer Usage Example | OsuPlayerTest.java
```java
public class OsuPlayerTest {
    public static void main(String[] args) throws IOException {
        Osu osu = new Osu("319e7d936f399ab7663781d5bf19858fdc04b2a8");
        try {
            OsuPlayer player = osu.getPlayer("cookiezi", Osu.OsuGameMode.OSU);
            System.out.println(player.getPPRaw());
        } catch (OsuUserException e) {
            e.printStackTrace();
        } catch (OsuGamemodeException e) {
            e.printStackTrace();
        }
    }
}
```
