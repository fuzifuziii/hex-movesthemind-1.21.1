package abilliontrillionstars.movesthemind.casting;

import net.minecraft.server.level.ServerPlayer;

public class FakeplayerUtils
{
    public static boolean canBid(ServerPlayer caster, ServerPlayer target)
    {
        String username = getUsernameString(caster);
        String targetname = getUsernameString(target);
        // let the owner of a fakeplayer control it TODO needs edited when adding polyamory
        if(getFakeName(username).equals(targetname) || getFakeName(username).toLowerCase().equals(targetname))
            return true;
        // let a fakeplayer (or real player) control itself
        return caster.getStringUUID().equals(target.getStringUUID());
    }

    public static String getFakeName(String username)
    {
        // this should return the same name when used with a fakeplayer's name
        while(username.length() < 16)
            username = username.concat("_"); // pad the string to 16 characters
        username = username.substring(0,12).concat("_bot");
        return username;
    }

    public static String getUsernameString(ServerPlayer player)
    {
        // 1.21: Component.toString() is no longer a parseable '{name}' literal; the profile name is the username.
        return player.getGameProfile().getName();
    }
}
