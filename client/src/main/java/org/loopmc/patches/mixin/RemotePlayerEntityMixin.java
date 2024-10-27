package org.loopmc.patches.mixin;

import net.minecraft.client.entity.living.player.RemotePlayerEntity;
import net.minecraft.entity.living.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RemotePlayerEntity.class)
public class RemotePlayerEntityMixin extends PlayerEntity {

	public RemotePlayerEntityMixin(World world) {
		super(world);
	}

	@Inject(
		method = "<init>",
		at = @At(
			"TAIL"
		)
	)
	private void init(World world, String name, CallbackInfo ci) {
		if (name != null && !name.isEmpty()) {
			this.skin = "https://api.loopmc.org/v1/skins/getskin/" + name;
			//this.cape = "https://api.loopmc.org/v1/skins/getcape/" + name;
			//this.cloak = this.cape;
			System.out.println("Loading texture via Loop API " + this.skin);
		}
	}

}
