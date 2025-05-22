package com.github.anopensaucedev.fasterrandom;

import com.github.anopensaucedev.fasterrandom.util.math.random.RandomGeneratorRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FasterRandomUtil {
	public static final String MOD_ID = "fasterrandom";
	public static final String MOD_NAME = "Faster Random";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static RandomGeneratorRandom GLOBAL_LOCAL_INSTANCE;
}
