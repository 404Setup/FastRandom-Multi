package com.github.anopensaucedev.fasterrandom.mixin;

import com.github.anopensaucedev.fasterrandom.FasterRandom;
import com.github.anopensaucedev.fasterrandom.util.math.random.RandomGeneratorRandom;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {

	@Final
	@Shadow
	protected final Random random = FasterRandom.GLOBAL_LOCAL_INSTANCE;

}
