@Mixin(LivingEntity.class)
public abstract class DamageHandlerMixin {
    @Inject(method = "damage", at = @At("HEAD"))
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> ci) {
        if ((Object) this instanceof PlayerEntity player) {
            if (source.getAttacker() instanceof PlayerEntity) {
                return; // PvP는 적용 안 함
            }
            PlayerWoundAccessor accessor = (PlayerWoundAccessor) player;
            accessor.setWoundAmount(accessor.getWoundAmount() + amount * 0.2f);
        }
    }
}