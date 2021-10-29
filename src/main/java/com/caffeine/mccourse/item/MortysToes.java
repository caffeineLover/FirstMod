package com.caffeine.mccourse.item;

import com.caffeine.mccourse.MCCourseMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MortysToes extends Item
{

    public MortysToes()
    {
        super( new Item.Properties().group(MCCourseMod.COURSE_TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(1.5f)
                        .effect( () -> new EffectInstance(Effects.GLOWING, 300, 1), 0.5f)
                        .build()));
    }
}
