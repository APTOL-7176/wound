@Environment(EnvType.CLIENT)
public class WoundHudRenderer implements HudRenderCallback {
    @Override
    public void onHudRender(MatrixStack matrices, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        PlayerWoundAccessor accessor = (PlayerWoundAccessor) client.player;
        float woundPercent = (accessor.getWoundAmount() / client.player.getMaxHealth()) * 100;

        String text = String.format("Wound: %.1f%%", woundPercent);
        client.textRenderer.draw(matrices, text, 10, 10, 0xFF0000);
    }
}