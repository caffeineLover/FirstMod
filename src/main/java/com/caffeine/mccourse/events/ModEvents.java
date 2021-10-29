package com.caffeine.mccourse.events;


import com.caffeine.mccourse.block.ModBlocks;
import com.caffeine.mccourse.item.ModItems;
import com.caffeine.mccourse.util.Config;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.MinecraftVersion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jline.utils.Log;

import java.util.Collection;



public class ModEvents
{
    @SubscribeEvent
    public void onCopperedSheep(AttackEntityEvent event) {
        if (event.getPlayer().getHeldItemMainhand().getItem() == ModItems.COPPERED_APPLE.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof SheepEntity) {
                    PlayerEntity player = event.getPlayer();
                    player.getHeldItemMainhand().shrink(1);
                    target.addPotionEffect(new EffectInstance(Effects.GLOWING, Config.COPPERED_GLOW_DURATION.get()));
                    if (!player.world.isRemote()) {
                        String msg = TextFormatting.YELLOW + "Sheep is now glowing!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }



    @SubscribeEvent
    public void onCopperSheepDrops(LivingDropsEvent event)
    {
        LivingEntity entity = event.getEntityLiving();
        if( entity instanceof SheepEntity ) {
            World world = entity.getEntityWorld();
            // What would normally drop from a sheep?
            Collection<ItemEntity> drops = event.getDrops();
            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if( entity.isPotionActive(Effects.GLOWING))
            {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ModItems.COPPER_INGOT.get())));
            }
        }
    }


    @SubscribeEvent
    public void jumpForDiamonds(LivingEvent.LivingJumpEvent event)
    {
        Logger log = LogManager.getLogger();
        log.debug("Player has jumped");

        LivingEntity entity = event.getEntityLiving();

        if( ! (entity instanceof PlayerEntity) ) {
            log.debug("A non-player entity jumped, so I'm returning.");
            return;
        }

        World world = entity.world;
        if( world.isRemote )
        {
            log.debug("World is remote.  Can't run event.");
            return;
        }

        log.debug(("Changing block to diamond block."));
        BlockPos pos = new BlockPos(entity.getPositionVec()).add(0,-1,0);
        world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
    }

}