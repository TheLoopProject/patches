package org.loopmc.patches.mixin;

import net.minecraft.entity.living.LivingEntity;
import net.minecraft.entity.living.player.PlayerEntity;
import net.minecraft.world.World;
import org.loopmc.patches.Patches;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin extends LivingEntity {
	public PlayerEntityMixin(World world) {
		super(world);
	}

	@Shadow
	public String cape;
	@Shadow
	public String name;

	/**
	 * @author WorldWidePixel
	 * @reason Fun!
	 */
	@Overwrite
	public void registerCloak() {
		this.cape = "https://api.loopmc.org/v1/skins/teamcapes/" + name;
		// I'm a lazy person and like to dev in style :)
		if (name.equalsIgnoreCase("player")) {
			this.cape = "https://api.loopmc.org/textures/skins/capes/internal/loop_team.png";
		}
		this.cloak = this.cape;
		Patches.LOGGER.log("Loading cape from " + this.cape);
	}
}
