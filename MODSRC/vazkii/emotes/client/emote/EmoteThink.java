package vazkii.emotes.client.emote;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.emotes.client.emote.base.EmoteBase;
import vazkii.emotes.client.emote.base.ModelAccessor;

public class EmoteThink extends EmoteBase {

	public EmoteThink(EntityPlayer player, ModelBiped model) {
		super(player, model);
	}

	@Override
	public Timeline getTimeline(EntityPlayer player, ModelBiped model) {
		Timeline timeline = Timeline.createSequence()
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.HEAD_X, 150F).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Y, 150F).target(0F))
				.push(Tween.to(model, ModelAccessor.HEAD_Z, 150F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 400F).target(-pi + 0.8F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 400F).target(0.4F))
			.end()
			.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 150F).target(0.3F).repeatYoyo(5, 0F))
			.beginParallel()
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_X, 300F).target(0F))
				.push(Tween.to(model, ModelAccessor.RIGHT_ARM_Z, 300F).target(0F))
			.end();
		
		return timeline;
	}

	@Override
	public boolean usesBodyPart(int part) {
		return part == ModelAccessor.HEAD || part == ModelAccessor.RIGHT_ARM;
	}
	
}