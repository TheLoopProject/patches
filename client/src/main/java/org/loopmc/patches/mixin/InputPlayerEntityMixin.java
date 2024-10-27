package org.loopmc.patches.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Session;
import net.minecraft.client.entity.living.player.InputPlayerEntity;
import net.minecraft.client.entity.living.player.RemotePlayerEntity;
import net.minecraft.entity.living.player.PlayerEntity;
import net.minecraft.world.World;
import org.loopmc.patches.Patches;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InputPlayerEntity.class)
public class InputPlayerEntityMixin extends PlayerEntity {

	public InputPlayerEntityMixin(World world) {
		super(world);
	}

	@Inject(
		method = "<init>",
		at = @At(
			"TAIL"
		)
	)
	private void init(Minecraft game, World world, Session session, int par4, CallbackInfo ci) {
		if (session != null && session.username != null && !session.username.isEmpty()) {
			this.skin = "https://api.loopmc.org/v1/skins/getskin/" + session.username;
			System.out.println("Loading texture via Loop API " + this.skin);
		}
	}
}
