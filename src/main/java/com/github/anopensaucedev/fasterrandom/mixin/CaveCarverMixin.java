package com.github.anopensaucedev.fasterrandom.mixin;

import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.carver.CaveCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CaveCarver.class)
public class CaveCarverMixin {

	@Redirect(method = "carveTunnels",at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;create(J)Lnet/minecraft/util/math/random/Random;"))
	public Random fasterrandom$replaceRandom(long seed){
		return new CheckedRandom(seed);
	}

}
