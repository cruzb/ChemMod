package com.bradcruz.chemmod.block.machine.mixer;

import com.bradcruz.chemmod.Main;
import com.bradcruz.chemmod.ModGUIs;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiMachineMixer extends GuiContainer {

    private static final ResourceLocation TEXTURES = new ResourceLocation(Main.MODID + ":textures/gui/machine_mixer.png");
    private final InventoryPlayer player;
    private final TileEntityMachineMixer tileEntity;

    public GuiMachineMixer(InventoryPlayer player, TileEntityMachineMixer tileEntity) {
        super(new ContainerMachineMixer(player, tileEntity));
        this.player = player;
        this.tileEntity = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.tileEntity.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) + 3, 8, ModGUIs.GUI_FONT_COLOR);
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, ModGUIs.GUI_FONT_COLOR);
                                                                                                            //this seperation is minecraft convention
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1f,1f,1f,1f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if(TileEntityMachineMixer.isActive(tileEntity)) {
            int k = this.getBurnLeftScaled(13); //fire anim 13 tall
            this.drawTexturedModalRect(this.guiLeft + 15, this.guiTop + 37 + 12 - k, 176, 12-k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(40);
        this.drawTexturedModalRect(this.guiLeft + 62, this.guiTop + 34, 176, 14, l + 1, 16);

    }


    private int getBurnLeftScaled(int pixels) {
        int i = this.tileEntity.getField(1);
        if(i  == 0) i = 200;
        return this.tileEntity.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels) {
        int i = this.tileEntity.getField(2);
        int j = this.tileEntity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
