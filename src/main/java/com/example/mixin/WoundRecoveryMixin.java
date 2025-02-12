@Mixin(ServerPlayerEntity.class)
public abstract class WoundRecoveryMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        PlayerWoundAccessor accessor = (PlayerWoundAccessor) player;

        // 자연 회복 (틱당 최대 체력의 0.005%)
        accessor.setWoundAmount(accessor.getWoundAmount() - player.getMaxHealth() * 0.00005f);
    }

    @Inject(method = "consumeItem", at = @At("HEAD"))
    private void onConsumeItem(ItemStack stack, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        PlayerWoundAccessor accessor = (PlayerWoundAccessor) player;

        if (stack.getItem() == Items.GOLDEN_APPLE) {
            accessor.setWoundAmount(accessor.getWoundAmount() - player.getMaxHealth() * 0.3f);
        } else if (stack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
            accessor.setWoundAmount(0.0f);
        }
    }
}

