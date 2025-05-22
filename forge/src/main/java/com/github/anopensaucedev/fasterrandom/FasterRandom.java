package com.github.anopensaucedev.fasterrandom;

import com.github.anopensaucedev.fasterrandom.util.math.random.RandomGeneratorRandom;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.ThreadLocalRandom;

@Mod(FasterRandomUtil.MOD_ID)
public class FasterRandom {
	public FasterRandom(FMLJavaModLoadingContext context) {
		FasterRandomUtil.GLOBAL_LOCAL_INSTANCE = new RandomGeneratorRandom(ThreadLocalRandom.current().nextLong());
	}
}
