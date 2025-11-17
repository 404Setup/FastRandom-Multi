package com.github.anopensaucedev.fasterrandom.util.math.random;

import com.google.common.annotations.VisibleForTesting;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.BitRandomSource;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import org.jetbrains.annotations.NotNull;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomGeneratorRandom implements BitRandomSource {
	private static final @NotNull RandomGeneratorFactory<RandomGenerator> RANDOM_GENERATOR_FACTORY = RandomGeneratorFactoryUtil.getRandomGeneratorFactory();
	private static final boolean isSplittableGenerator = RANDOM_GENERATOR_FACTORY.isSplittable();
	private static final int INT_BITS = 48;
	private static final long SEED_MASK = 0xFFFFFFFFFFFFL;
	private static final long MULTIPLIER = 25214903917L;
	private static final long INCREMENT = 11L;

	private long seed;
	private RandomGenerator randomGenerator;

	public RandomGeneratorRandom(long seed) {
		this.seed = seed;
		this.randomGenerator = RANDOM_GENERATOR_FACTORY.create(seed);
	}

	public RandomGeneratorRandom(long seed, RandomGenerator.SplittableGenerator randomGenerator) {
		this.seed = seed;
		this.randomGenerator = randomGenerator;
	}

	@Override
	public @NotNull RandomSource fork() {
		return isSplittableGenerator ?
				new RandomGeneratorRandom(seed, ((RandomGenerator.SplittableGenerator) this.randomGenerator).split()) :
				new RandomGeneratorRandom(this.nextLong());
	}

	@Override
	public @NotNull PositionalRandomFactory forkPositional() {
		return new Splitter(this.nextLong());
	}

	@Override
	public void setSeed(long seed) {
		this.seed = seed;
		this.randomGenerator = RANDOM_GENERATOR_FACTORY.create(seed);
	}

	@Override
	public int next(int bits) {
		// >>> instead of Mojang's >> fixes MC-239059
		return (int) ((seed * MULTIPLIER + INCREMENT & SEED_MASK) >>> INT_BITS - bits);
	}

	@Override
	public int nextInt() {
		return randomGenerator.nextInt();
	}

	@Override
	public int nextInt(int bound) {
		return randomGenerator.nextInt(bound);
	}

	@Override
	public long nextLong() {
		return randomGenerator.nextLong();
	}

	@Override
	public boolean nextBoolean() {
		return randomGenerator.nextBoolean();
	}

	@Override
	public float nextFloat() {
		return randomGenerator.nextFloat();
	}

	@Override
	public double nextDouble() {
		return randomGenerator.nextDouble();
	}

	@Override
	public double nextGaussian() {
		return randomGenerator.nextGaussian();
	}

	private record Splitter(long seed) implements PositionalRandomFactory {
		@SuppressWarnings("deprecation")
		@Override
		public @NotNull RandomSource at(int x, int y, int z) {
			return new RandomGeneratorRandom(Mth.getSeed(x, y, z) ^ this.seed);
		}

		@Override
		public @NotNull RandomSource fromHashOf(@NotNull String seed) {
			return new RandomGeneratorRandom((long) seed.hashCode() ^ this.seed);
		}

		//@Override (overriding will break older MC versions)
		public @NotNull RandomSource fromSeed(long seed) {
			return new RandomGeneratorRandom(seed);
		}

		@Override
		@VisibleForTesting
		public void parityConfigString(@NotNull StringBuilder info) {
			info.append("RandomGeneratorRandom$Splitter{").append(this.seed).append("}");
		}
	}
}
