package com.github.anopensaucedev.fasterrandom;

import com.github.anopensaucedev.fasterrandom.util.math.random.RandomGeneratorRandom;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

import java.util.concurrent.ThreadLocalRandom;

@Mod(FasterRandomUtil.MOD_ID)
public class FasterRandom {
	public FasterRandom(IEventBus modEventBus, ModContainer modContainer) {
		FasterRandomUtil.GLOBAL_LOCAL_INSTANCE = new RandomGeneratorRandom(ThreadLocalRandom.current().nextLong());
	}

}
