package abilliontrillionstars.movesthemind;

import abilliontrillionstars.movesthemind.casting.MovesthemindPatterns;
import at.petrak.hexcasting.common.lib.HexRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Movesthemind.MOD_ID)
public class Movesthemind {
    public static final String MOD_ID = "movesthemind";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public Movesthemind(IEventBus modBus, ModContainer container) {
        // 1.21 / Hex 0.12: actions live in the hexcasting:action registry, flushed from a RegisterEvent.
        modBus.addListener((RegisterEvent event) ->
            event.register(HexRegistries.ACTION, helper ->
                MovesthemindPatterns.register((entry, id) -> helper.register(id, entry))));
        LOGGER.info("Hello NeoForge world!");
    }
}
