package com.caffeine.mccourse.item;

import com.caffeine.mccourse.MCCourseMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;



public class CandiedToes extends Item
{

    public CandiedToes()
    {
        super( new Item.Properties().group(MCCourseMod.COURSE_TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(1.5f)
                        .effect( () -> new EffectInstance(Effects.GLOWING, 500, 2), 0.80f)
                        .build()));
    }
}