package com.joebalogna.dampsmod.item.custom;

import com.joebalogna.dampsmod.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItem extends Item {
    //If constructor is gray, it means I probably forgot to register the item or accidentally used wrong constructor
        //Like using Item constructor instead of DowsingRodItem constructor.
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.dampsmod.dowsing_rod.tooltip.shift"));
        }else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.dampsmod.dowsing_rod.tooltip"));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()) { //Checks if we're on the client side (not server side)
            BlockPos positionClicked = pContext.getClickedPos(); //Get the position the player clicked
            Player player = pContext.getPlayer(); //Get the player who clicked
            boolean foundBlock = false;

            //Checks all blocks under the block clicked, from top to bottom. If block is at y=50, it checks 50+64 blocks
                // below. If block is at y=-30, it checks -30+64 blocks below.
            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                //Moves blockBelow to i-blocks below the block clicked
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock) {
                //Translatable component can be translated in lang file
                player.sendMessage(new TranslatableComponent("item.dampsmod.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }
        //Damage item by 1, and break it if durability reaches 0.
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.getName().getString() +
                " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) {
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).
                is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
    }
}
