package com.caffeine.mccourse.item;

import com.caffeine.mccourse.MCCourseMod;
import com.caffeine.mccourse.util.Registration;
import net.minecraft.client.particle.BreakingParticle;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.ArmorDyeRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item>  HANNAH_INGOT =
            Registration.ITEMS.register("hannah_ingot",
                    () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item>  MORTY_INGOT =
            Registration.ITEMS.register("morty_ingot",
                    () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item>  PAPA_INGOT =
            Registration.ITEMS.register("papa_ingot", () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item>  MAMA_INGOT =
            Registration.ITEMS.register("mama_ingot", () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item>  COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item>  COPPER_WIRE =
            Registration.ITEMS.register("copper_wire", () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));


    ///////
    ////// Food Items
    //////

    // We don't pass anything in because we've already done that in the CopperedApple class.
    public static final RegistryObject<Item>  CANDIED_TOES =
            Registration.ITEMS.register("candied_toes", () -> new CandiedToes());

    public static final RegistryObject<Item>  MORTYS_TOES =
            Registration.ITEMS.register("mortys_toes", () -> new MortysToes());

    public static final RegistryObject<Item>  COPPERED_APPLE =
            Registration.ITEMS.register("coppered_apple", () -> new CopperedApple());


    ///////
    //////  Tools
    /////

    public static final RegistryObject<Item> COPPER_SHOVEL =
            Registration.ITEMS.register("copper_shovel", ()-> new ShovelItem(ModItemTier.COPPER, 0, 0,
                new Item.Properties()
                    .defaultMaxDamage(150)
                    .addToolType(ToolType.SHOVEL, 2)
                    .group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_SWORD =
            Registration.ITEMS.register("copper_sword", ()-> new SwordItem(ModItemTier.COPPER, 2, 0,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_PICKAXE =
            Registration.ITEMS.register("copper_pickaxe", ()-> new PickaxeItem(ModItemTier.COPPER, 0, 0,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.PICKAXE, 2)
                            .group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_HOE =
            Registration.ITEMS.register("copper_hoe", ()-> new HoeItem(ModItemTier.COPPER, 0, 0,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.HOE, 2)
                            .group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_AXE =
            Registration.ITEMS.register("copper_axe", ()-> new AxeItem(ModItemTier.COPPER, 2.5f, -3f,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.AXE, 2)
                            .group(MCCourseMod.COURSE_TAB)));



    public static final RegistryObject<Item> COPPER_HELMET = Registration.ITEMS.register("copper_helmet",
            () -> new ArmorItem(modArmorMaterial.COPPER, EquipmentSlotType.HEAD,
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_CHESTPLATE = Registration.ITEMS.register("copper_chestplate",
            () -> new ArmorItem(modArmorMaterial.COPPER, EquipmentSlotType.CHEST,
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_LEGGINGS = Registration.ITEMS.register("copper_leggings",
            () -> new ArmorItem(modArmorMaterial.COPPER, EquipmentSlotType.LEGS,
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_BOOTS = Registration.ITEMS.register("copper_boots",
            () -> new ArmorItem(modArmorMaterial.COPPER, EquipmentSlotType.FEET,
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static void register() { }


    ////
    ////   Armor
    ////
    public enum modArmorMaterial implements IArmorMaterial
    {
        COPPER(50, new int[] { 2, 7, 5, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                Ingredient.fromStacks( new ItemStack(ModItems.COPPER_INGOT.get() )),
                MCCourseMod.MOD_ID + ":copper", 0, 0.1f);

        private final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundevent;
        private final Ingredient repairIngredient;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        modArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability,
                         SoundEvent soundEvent, Ingredient repairMaterial, String name, float toughness, float knockbackResistance)
        {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundevent = soundEvent;
            this.repairIngredient = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }

        @Override public int getDurability(EquipmentSlotType slotIn)            { return durability;                                    }
        @Override public int getDamageReductionAmount(EquipmentSlotType slotIn) { return damageReductionAmountArray[slotIn.getIndex()]; }
        @Override public int getEnchantability()                                { return enchantability;                                }
        @Override public SoundEvent getSoundEvent()                             { return soundevent;                                    }
        @Override public Ingredient getRepairMaterial()                         { return repairIngredient;                              }
        @Override public String getName()                                       { return name;                                          }
        @Override public float getToughness()                                   { return toughness;                                     }
        @Override public float func_230304_f_()                                 { return knockbackResistance;                           }
    }





     public enum ModItemTier implements IItemTier
     {
         COPPER(2, 150, 2.5f, 0, 15,
                 Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())));

         private final int harvestLevel;
         private final int maxUses;
         private final float efficiency;
         private final float attackDamage;
         private final int enchantability;
         private final Ingredient repairMaterial;

         ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial)
         {
             this.harvestLevel = harvestLevel;
             this.maxUses = maxUses;
             this.efficiency = efficiency;
             this.attackDamage = attackDamage;
             this.enchantability = enchantability;
             this.repairMaterial = repairMaterial;
         }

         @Override public int getHarvestLevel()          { return harvestLevel;   }
         @Override public int getMaxUses()               { return maxUses;        }
         @Override public float getEfficiency()          { return efficiency;     }
         @Override public float getAttackDamage()        { return attackDamage;   }
         @Override public int getEnchantability()        { return enchantability; }
         @Override public Ingredient getRepairMaterial() { return repairMaterial; }
     }
}
