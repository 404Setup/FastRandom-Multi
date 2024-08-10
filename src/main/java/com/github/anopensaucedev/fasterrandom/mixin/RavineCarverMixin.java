package com.github.anopensaucedev.fasterrandom.mixin;

import com.github.anopensaucedev.fasterrandom.FasterRandom;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.carver.RavineCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RavineCarver.class)
public class RavineCarverMixin {

	@Redirect(method = "carveRavine",at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;create(J)Lnet/minecraft/util/math/random/Random;"))
	public Random fasterrandom$replaceRandom(long seed){
		return new CheckedRandom(seed);
	}


}
