package com.github.anopensaucedev.fasterrandom;

import com.github.anopensaucedev.fasterrandom.util.math.random.RandomGeneratorRandom;
import net.fabricmc.api.ModInitializer;

import java.util.concurrent.ThreadLocalRandom;

public class FasterRandom implements ModInitializer {
	@Override
	public void onInitialize() {
		FasterRandomUtil.GLOBAL_LOCAL_INSTANCE = new RandomGeneratorRandom(ThreadLocalRandom.current().nextLong());
	}

}
