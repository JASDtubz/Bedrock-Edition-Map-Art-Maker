package sample;

public class MapColor
{
    public final int r, g, b;
    public final String name;

    public MapColor(int r, int g, int b, boolean b_)
    {
        final MapColor[] mc = this.getColors(b_);

        double i;
        double i_ = 256;
        int ii = 0;

        for (var x = 0; x < mc.length; x++)
        {
            i = ((double) Math.abs(r - mc[x].r) + Math.abs(g - mc[x].g) + Math.abs(b - mc[x].b)) / 3;
            if (i < i_)
            {
                i_ = i;
                ii = x;
            }
        }

        this.name = mc[ii].name;
        this.r = mc[ii].r;
        this.g = mc[ii].g;
        this.b = mc[ii].b;
    }

    private MapColor(String name, int r, int g, int b)
    {
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    private MapColor[] getColors(boolean bool)
    {
        final MapColor fire = new MapColor("Fire", 217, 0, 0);
        final MapColor red = new MapColor("Red / Nether Wart", 130, 43, 43);
        final MapColor netherrack = new MapColor("Netherrack", 92, 1, 0);
        final MapColor pink = new MapColor("Pink", 200, 105, 136);
        final MapColor crimsonNylium = new MapColor("Crimson Nylium", 143, 26, 26);
        final MapColor boron = new MapColor("Boron", 154, 111, 109);
        final MapColor lanthanum = new MapColor("Lanthanum", 200, 132, 189);
        final MapColor crimsonPlanks = new MapColor("Crimson Planks", 125, 53, 82);
        final MapColor orange = new MapColor("Orange / Terracotta / Copper", 183, 107, 43);
        final MapColor fluorine = new MapColor("Fluorine", 210, 167, 70);
        final MapColor yellow = new MapColor("Yellow / Hay", 192, 192, 43);
        final MapColor gold = new MapColor("Gold", 212, 202, 65);
        final MapColor sand = new MapColor("Sand / End Stone", 209, 198, 138);
        final MapColor lime = new MapColor("Lime", 106, 171, 20);
        final MapColor green = new MapColor("Green / Moss / Kelp", 86, 106, 43);
        final MapColor grass = new MapColor("Grass", 122, 158, 73);
        final MapColor emerald = new MapColor("Emerald", 0, 182, 49);
        final MapColor leaves = new MapColor("Leaves", 54, 78, 21);
        final MapColor hydrogen = new MapColor("Hydrogen", 102, 150, 57);
        final MapColor slime = new MapColor("Slime", 108, 151, 47);
        final MapColor dripleaf = new MapColor("Dripleaf", 0, 102, 0);
        final MapColor lightBlue = new MapColor("Light Blue", 87, 130, 184);
        final MapColor cyan = new MapColor("Cyan / Warped Stem / Prismarine", 64, 108, 130);
        final MapColor blue = new MapColor("Blue", 43, 64, 151);
        final MapColor darkPrismarine = new MapColor("Dark Prismarine", 78, 186, 181);
        final MapColor lapisLazuli = new MapColor("Lapis Lazuli", 62, 108, 215);
        final MapColor warpedWart = new MapColor("Warped Wart / Oxidized Copper", 18, 106, 113);
        final MapColor warpedNylium = new MapColor("Warped Nylium", 14, 131, 113);
        final MapColor ice = new MapColor("Ice", 136, 136, 217);
        final MapColor lithium = new MapColor("Lithium", 73, 106, 196);
        final MapColor beryllium = new MapColor("Beryllium", 43, 141, 165);
        final MapColor weatheredCopper = new MapColor("Weathered Copper", 49, 120, 118);
        final MapColor magenta = new MapColor("Magenta / Purpur", 151, 64, 184);
        final MapColor purple = new MapColor("Purple / Amethyst", 108, 53, 151);
        final MapColor helium = new MapColor("Helium", 176, 106, 214);
        final MapColor actinium = new MapColor("Actinium", 109, 65, 174);
        final MapColor black = new MapColor("Black / Blackstone", 21, 21, 21);
        final MapColor unknown = new MapColor("???", 0, 0, 0);
        final MapColor sculkSensor = new MapColor("Sculk Sensor", 11, 15, 19);
        final MapColor gray = new MapColor("Gray", 64, 64, 64);
        final MapColor lightGray = new MapColor("Light Gray", 130, 130, 130);
        final MapColor iron = new MapColor("Iron", 142, 142, 142);
        final MapColor stone = new MapColor("Stone", 95, 95, 95);
        final MapColor scandium = new MapColor("Scandium", 111, 111, 111);
        final MapColor stoneBricks = new MapColor("Stone Bricks", 139, 142, 156);
        //final MapColor basalt = new MapColor("Basalt", 78, 78, 78);
        final MapColor deepslate = new MapColor("Deepslate", 85, 85, 85);
        final MapColor white = new MapColor("White / Snow", 217, 217, 217);
        final MapColor quartz = new MapColor("Quartz", 217, 214, 209);
        final MapColor cobweb = new MapColor("Cobweb", 169, 169, 169);
        final MapColor calcite = new MapColor("Calcite", 178, 150, 136);
        final MapColor brown = new MapColor("Brown / Soul Sand", 87, 64, 43);
        final MapColor planks = new MapColor("Planks", 122, 101, 61);
        final MapColor dirt = new MapColor("Dirt", 128, 93, 65);
        final MapColor aluminum = new MapColor("Aluminum", 152, 145, 120);
        final MapColor exposedCopper = new MapColor("Exposed Copper", 115, 91, 83);
        final MapColor rawIron = new MapColor("Raw Iron", 184, 148, 125);
        final MapColor tuff = new MapColor("Tuff", 48, 35, 30);
        final MapColor dripstone = new MapColor("Dripstone", 64, 42, 30);

        final MapColor fire0 = new MapColor(fire.name + "-", 252, 0, 0);
        final MapColor red0 = new MapColor(red.name + "-", 151, 50, 50);
        final MapColor netherrack0 = new MapColor(red.name + "-", 111, 2, 0);
        final MapColor pink0 = new MapColor(pink.name + "-", 239, 126, 163);
        final MapColor crimsonNylium0 = new MapColor(crimsonNylium.name + "-", 187, 47, 48);
        final MapColor boron0 = new MapColor(boron.name + "-", 184, 133, 130);
        final MapColor lanthanum0 = new MapColor(lanthanum.name + "-", 236, 156, 223);
        final MapColor crimsonPlanks0 = new MapColor(crimsonPlanks.name + "-", 146, 62, 96);
        final MapColor orange0 = new MapColor(orange.name + "-", 213, 126, 50);
        final MapColor fluorine0 = new MapColor(fluorine.name + "-", 246, 196, 83);
        final MapColor yellow0 = new MapColor(yellow.name + "-", 226, 226, 50);
        final MapColor gold0 = new MapColor(gold.name + "-", 247, 235, 76);
        final MapColor sand0 = new MapColor(sand.name + "-", 244, 230, 161);
        final MapColor lime0 = new MapColor(lime.name + "-", 126, 202, 25);
        final MapColor green0 = new MapColor(green.name + "-", 101, 126, 50);
        final MapColor grass0 = new MapColor(grass.name + "-", 144, 186, 87);
        final MapColor emerald0 = new MapColor(emerald.name + "-", 0, 214, 57);
        final MapColor leaves0 = new MapColor(leaves.name + "-", 62, 91, 24);
        final MapColor hydrogen0 = new MapColor(hydrogen.name + "-", 121, 176, 67);
        final MapColor slime0 = new MapColor(slime.name + "-", 126, 176, 55);
        final MapColor dripleaf0 = new MapColor(dripleaf.name + "-", 0, 123, 0);
        final MapColor lightBlue0 = new MapColor(lightBlue.name + "-", 101, 151, 213);
        final MapColor cyan0 = new MapColor(cyan.name + "-", 75, 126, 151);
        final MapColor blue0 = new MapColor(blue.name + "-", 50, 75, 176);
        final MapColor darkPrismarine0 = new MapColor(darkPrismarine.name + "-", 91, 216, 210);
        final MapColor lapisLazuli0 = new MapColor(lapisLazuli.name + "-", 73, 126, 252);
        final MapColor warpedWart0 = new MapColor(warpedWart.name + "-", 20, 178, 131);
        final MapColor warpedNylium0 = new MapColor(warpedNylium.name + "-", 22, 125, 132);
        final MapColor ice0 = new MapColor(ice.name + "-", 158, 158, 252);
        final MapColor lithium0 = new MapColor(lithium.name + "-", 85, 123, 226);
        final MapColor beryllium0 = new MapColor(beryllium.name + "-", 50, 163, 191);
        final MapColor weatheredCopper0 = new MapColor(weatheredCopper.name + "-", 57, 140, 138);
        final MapColor magenta0 = new MapColor(magenta.name + "-", 176, 75, 213);
        final MapColor purple0 = new MapColor(purple.name + "-", 126, 62, 176);
        final MapColor helium0 = new MapColor(helium.name + "-", 204, 123, 249);
        final MapColor actinium0 = new MapColor(actinium.name + "-", 126, 75, 202);
        final MapColor black0 = new MapColor(black.name + "-", 25, 25, 25);
        final MapColor sculkSensor0 = new MapColor(sculkSensor.name + "-", 13, 18, 23);
        final MapColor gray0 = new MapColor(gray.name + "-", 75, 75, 75);
        final MapColor lightGray0 = new MapColor(lightGray.name + "-", 151, 151, 151);
        final MapColor iron0 = new MapColor(iron.name + "-", 165, 165, 165);
        final MapColor stone0 = new MapColor(stone.name + "-", 111, 111, 111);
        final MapColor scandium0 = new MapColor(scandium.name + "-", 128, 128, 128);
        final MapColor stoneBricks0 = new MapColor(stoneBricks.name + "-", 162, 166, 182);
        final MapColor deepslate0 = new MapColor(deepslate.name + "-", 99, 99, 99);
        final MapColor white0 = new MapColor(white.name + "-", 252, 252, 252);
        final MapColor quartz0 = new MapColor(quartz.name + "-", 252, 249, 242);
        final MapColor cobweb0 = new MapColor(cobweb.name + "-", 197, 197, 197);
        final MapColor calcite0 = new MapColor(calcite.name + "-", 207, 175, 159);
        final MapColor brown0 = new MapColor(brown.name + "-", 101, 75, 50);
        final MapColor planks0 = new MapColor(planks.name + "-", 141, 118, 71);
        final MapColor dirt0 = new MapColor(dirt.name + "-", 149, 108, 76);
        final MapColor aluminum0 = new MapColor(aluminum.name + "-", 176, 168, 138);
        final MapColor exposedCopper0 = new MapColor(exposedCopper.name + "-", 133, 106, 97);
        final MapColor rawIron0 = new MapColor(rawIron.name + "-", 213, 173, 145);
        final MapColor tuff0 = new MapColor(tuff.name + "-", 56, 41, 35);
        final MapColor dripstone0 = new MapColor(dripstone.name + "-", 75, 49, 35);

        final MapColor fire1 = new MapColor(fire.name + "+", 178, 0, 0);
        final MapColor red1 = new MapColor(red.name + "+", 107, 36, 36);
        final MapColor netherrack1 = new MapColor(netherrack.name + "+", 78, 1, 0);
        final MapColor pink1 = new MapColor(pink.name + "+", 168, 88, 115);
        final MapColor crimsonNylium1 = new MapColor(crimsonNylium.name + "+", 131, 33, 34);
        final MapColor boron1 = new MapColor(boron.name + "+", 129, 94, 92);
        final MapColor lanthanum1 = new MapColor(lanthanum.name + "+", 167, 110, 158);
        final MapColor crimsonPlanks1 = new MapColor(crimsonPlanks.name + "+", 103, 43, 67);
        final MapColor orange1 = new MapColor(orange.name + "+", 150, 88, 36);
        final MapColor fluorine1 = new MapColor(fluorine.name + "+", 174, 138, 58);
        final MapColor yellow1 = new MapColor(yellow.name + "+", 159, 159, 36);
        final MapColor gold1 = new MapColor(gold.name + "+", 174, 166, 53);
        final MapColor sand1 = new MapColor(sand.name + "+", 172, 162, 114);
        final MapColor lime1 = new MapColor(lime.name + "+", 88, 142, 17);
        final MapColor green1 = new MapColor(green.name + "+", 71, 88, 36);
        final MapColor grass1 = new MapColor(grass.name + "+", 102, 130, 61);
        final MapColor emerald1 = new MapColor(emerald.name + "+", 0, 151, 40);
        final MapColor leaves1 = new MapColor(leaves.name + "+", 44, 63, 17);
        final MapColor hydrogen1 = new MapColor(hydrogen.name + "+", 85, 125, 47);
        final MapColor slime1 = new MapColor(slime.name + "+", 88, 124, 39);
        final MapColor dripleaf1 = new MapColor(dripleaf.name + "+", 0, 86, 0);
        final MapColor lightBlue1 = new MapColor(lightBlue.name + "+", 71, 107, 150);
        final MapColor cyan1 = new MapColor(cyan.name + "+", 52, 88, 107);
        final MapColor blue1 = new MapColor(blue.name + "+", 36, 52, 124);
        final MapColor darkPrismarine1 = new MapColor(darkPrismarine.name + "+", 63, 152, 148);
        final MapColor lapisLazuli1 = new MapColor(lapisLazuli.name + "+", 51, 89, 178);
        final MapColor warpedWart1 = new MapColor(warpedWart.name + "+", 14, 126, 92);
        final MapColor warpedNylium1 = new MapColor(warpedNylium.name + "+", 15, 87, 93);
        final MapColor ice1 = new MapColor(ice.name + "+", 111, 111, 178);
        final MapColor lithium1 = new MapColor(lithium.name + "+", 60, 87, 160);
        final MapColor beryllium1 = new MapColor(beryllium.name + "+", 36, 116, 134);
        final MapColor weatheredCopper1 = new MapColor(weatheredCopper.name + "+", 40, 99, 97);
        final MapColor magenta1 = new MapColor(magenta.name + "+", 124, 52, 150);
        final MapColor purple1 = new MapColor(purple.name + "+", 88, 43, 124);
        final MapColor helium1 = new MapColor(helium.name + "+", 143, 87, 176);
        final MapColor actinium1 = new MapColor(actinium.name + "+", 89, 53, 142);
        final MapColor black1 = new MapColor(black.name + "+", 17, 17, 17);
        final MapColor sculkSensor1 = new MapColor(sculkSensor.name + "+", 9, 12, 16);
        final MapColor gray1 = new MapColor(gray.name + "+", 52, 52, 52);
        final MapColor lightGray1 = new MapColor(lightGray.name + "+", 107, 107, 107);
        final MapColor iron1 = new MapColor(iron.name + "+", 116, 116, 116);
        final MapColor stone1 = new MapColor(stone.name + "+", 78, 78, 78);
        final MapColor scandium1 = new MapColor(scandium.name + "+", 90, 90, 90);
        final MapColor stoneBricks1 = new MapColor(stoneBricks.name + "+", 114, 117, 127);
        final MapColor deepslate1 = new MapColor(deepslate.name + "+", 69, 69, 69);
        final MapColor white1 = new MapColor(white.name + "+", 178, 178, 178);
        final MapColor quartz1 = new MapColor(quartz.name + "+", 178, 175, 170);
        final MapColor cobweb1 = new MapColor(cobweb.name + "+", 138, 138, 138);
        final MapColor calcite1 = new MapColor(calcite.name + "+", 145, 123, 112);
        final MapColor brown1 = new MapColor(brown.name + "+", 71, 52, 36);
        final MapColor planks1 = new MapColor(planks.name + "+", 99, 83, 49);
        final MapColor dirt1 = new MapColor(dirt.name + "+", 105, 75, 53);
        final MapColor aluminum1 = new MapColor(aluminum.name + "+", 125, 119, 98);
        final MapColor exposedCopper1 = new MapColor(exposedCopper.name + "+", 94, 74, 68);
        final MapColor rawIron1 = new MapColor(rawIron.name + "+", 150, 122, 102);
        final MapColor tuff1 = new MapColor(tuff.name + "+", 40, 28, 24);
        final MapColor dripstone1 = new MapColor(dripstone.name + "+", 52, 35, 24);

        if (!bool)
        {
            return new MapColor[]
            {
                fire, red, netherrack, pink, crimsonNylium, boron, lanthanum, crimsonPlanks, orange, fluorine, yellow,
                gold, sand, lime, green, grass, emerald, leaves, hydrogen, slime, dripleaf, lightBlue, cyan, blue,
                darkPrismarine, lapisLazuli, warpedWart, warpedNylium, ice, lithium, beryllium, weatheredCopper,
                magenta, purple, helium, actinium, black, unknown, sculkSensor, gray, lightGray, iron, stone, scandium,
                stoneBricks, /*basalt,*/ deepslate, white, quartz, cobweb, calcite, brown, planks, dirt, aluminum,
                exposedCopper, rawIron, tuff, dripstone
            };
        }
        else
        {
            return new MapColor[]
            {
                fire0, fire1, red0, red1, netherrack0, netherrack1, pink0, pink1, crimsonNylium0, crimsonNylium1,
                boron0, boron1, lanthanum0, lanthanum1, crimsonPlanks0, crimsonPlanks1, orange0, orange1, fluorine0,
                fluorine1, yellow0, yellow1, gold0, gold1, sand0, sand1, lime0, lime1, green0, green1, grass0, grass1,
                emerald0, emerald1, leaves0, leaves1, hydrogen0, hydrogen1, slime0, slime1, dripleaf0, dripleaf1,
                lightBlue0, lightBlue1, cyan0, cyan1, blue0, blue1, darkPrismarine0, darkPrismarine1, lapisLazuli0,
                lapisLazuli1, warpedWart0, warpedWart1, warpedNylium0, warpedNylium1, ice0, ice1, lithium0, lithium1,
                beryllium0, beryllium1, weatheredCopper0, weatheredCopper1, magenta0, magenta1, purple0, purple1,
                helium0, helium1, actinium0, actinium1, black0, black1, sculkSensor0, sculkSensor1, gray0, gray1,
                lightGray0, lightGray1, iron0, iron1, stone0, stone1, scandium0, scandium1, stoneBricks0, stoneBricks1,
                deepslate0, deepslate1, white0, white1, quartz0, quartz1, cobweb0, cobweb1, calcite0, calcite1, brown0,
                brown1, planks0, planks1, dirt0, dirt1, aluminum0, aluminum1, exposedCopper0, exposedCopper1, rawIron0,
                rawIron1, tuff0, tuff1, dripstone0, dripstone1,
                fire, red, netherrack, pink, crimsonNylium, boron, lanthanum, crimsonPlanks, orange, fluorine, yellow,
                gold, sand, lime, green, grass, emerald, leaves, hydrogen, slime, dripleaf, lightBlue, cyan, blue,
                darkPrismarine, lapisLazuli, warpedWart, warpedNylium, ice, lithium, beryllium, weatheredCopper,
                magenta, purple, helium, actinium, black, unknown, sculkSensor, gray, lightGray, iron, stone, scandium,
                stoneBricks, /*basalt,*/ deepslate, white, quartz, cobweb, calcite, brown, planks, dirt, aluminum,
                exposedCopper, rawIron, tuff, dripstone
            };
        }
    }
}
