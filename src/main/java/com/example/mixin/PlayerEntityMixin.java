@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    private static final TrackedData<Float> WOUND_AMOUNT = DataTracker.registerData(PlayerEntity.class, TrackedDataHandlerRegistry.FLOAT);

    @Inject(method = "initDataTracker", at = @At("RETURN"))
    private void initWoundData(CallbackInfo ci) {
        this.dataTracker.startTracking(WOUND_AMOUNT, 0.0f);
    }

    public float getWoundAmount() {
        return this.dataTracker.get(WOUND_AMOUNT);
    }

    public void setWoundAmount(float value) {
        this.dataTracker.set(WOUND_AMOUNT, MathHelper.clamp(value, 0.0f, this.getMaxHealth() * 0.8f));
    }
}
