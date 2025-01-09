package com.mars.slabstoblocks;

import com.google.common.collect.Lists;
import com.mars.deimos.config.DeimosConfig;
import com.mars.deimos.datagen.DeimosRecipeGenerator;
import com.mars.slabstoblocks.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.SurfaceSystem;

import java.util.List;

public class CommonClass {
    public static void init() {
        DeimosConfig.init("slabstoblocks", SlabsConfig.class);

        for (int i = 0; i < SlabsConfig.slabBlockList.size(); i++) {
            String current = SlabsConfig.slabBlockList.get(i);
            String[] set = ((current).replaceAll("\\s","")).split(",");
            if (current.contains("-")){
                DeimosRecipeGenerator.createShapedRecipeJson(
                        Lists.newArrayList(
                                '#'
                        ),
                        Lists.newArrayList(ResourceLocation.parse(set[0])),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "##"
                        ),
                        ResourceLocation.parse(set[1]), 1);
            } else if (current.contains("/")) {
                DeimosRecipeGenerator.createShapedRecipeJson(
                        Lists.newArrayList(
                                '#'
                        ),
                        Lists.newArrayList(ResourceLocation.parse(set[0])),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "# ",
                                " #"
                        ),
                        ResourceLocation.parse(set[1]), 1);
            } else {
                DeimosRecipeGenerator.createShapedRecipeJson(
                        Lists.newArrayList(
                                '#'
                        ),
                        Lists.newArrayList(ResourceLocation.parse(set[0])),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "#",
                                "#"
                        ),
                        ResourceLocation.parse(set[1]), 1);
            }
        }
    }
}
