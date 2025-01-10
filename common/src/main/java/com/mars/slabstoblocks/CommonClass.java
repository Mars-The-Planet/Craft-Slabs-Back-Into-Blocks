package com.mars.slabstoblocks;

import com.google.common.collect.Lists;
import com.mars.deimos.config.DeimosConfig;
import com.mars.deimos.datagen.DeimosRecipeGenerator;
import net.minecraft.resources.ResourceLocation;

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
                        Lists.newArrayList(new ResourceLocation(set[0])),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "##"
                        ),
                        new ResourceLocation(set[1]), 1);
            } else if (current.contains("/")) {
                DeimosRecipeGenerator.createShapedRecipeJson(
                        Lists.newArrayList(
                                '#'
                        ),
                        Lists.newArrayList(new ResourceLocation(set[0])),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "# ",
                                " #"
                        ),
                        new ResourceLocation(set[1]), 1);
            } else {
                DeimosRecipeGenerator.createShapedRecipeJson(
                        Lists.newArrayList(
                                '#'
                        ),
                        Lists.newArrayList(new ResourceLocation(set[0])),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "#",
                                "#"
                        ),
                        new ResourceLocation(set[1]), 1);
            }
        }
    }
}