package com.github.anopensaucedev.fasterrandom.mixin;

import com.github.anopensaucedev.fasterrandom.FasterRandom;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

	@Redirect(method = "tickRainSplashing",at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;create(J)Lnet/minecraft/util/math/random/Random;"))
	public Random fasterrandom$replaceRandom(long seed){
		return FasterRandom.GLOBAL_LOCAL_INSTANCE;
	}

	//TODO: fix rain, generates way more particles this way.
	@Redirect(method = "renderWeather",at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;create(J)Lnet/minecraft/util/math/random/Random;"))
	public Random fasterrandom$replaceRandom2(long seed){
		return FasterRandom.GLOBAL_LOCAL_INSTANCE;
	}

	@Redirect(method = "renderStars(Lnet/minecraft/client/render/BufferBuilder;)Lnet/minecraft/client/render/BufferBuilder$BuiltBuffer;",at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;create(J)Lnet/minecraft/util/math/random/Random;"))
	public Random fasterrandom$replaceRandom3(long seed){
		return FasterRandom.GLOBAL_LOCAL_INSTANCE;
	}



}
