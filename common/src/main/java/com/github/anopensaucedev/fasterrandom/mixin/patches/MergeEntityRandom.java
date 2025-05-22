package com.github.anopensaucedev.fasterrandom.mixin.patches;

import com.github.anopensaucedev.fasterrandom.FasterRandomUtil;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public class MergeEntityRandom {

	@Final
	@Shadow
	protected final RandomSource random = FasterRandomUtil.GLOBAL_LOCAL_INSTANCE;

}
