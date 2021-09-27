package sample;

public class MapColor
{
    public final int r, g, b;
    public final String name;

    public MapColor(int r, int g, int b)
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
        final MapColor basalt = new MapColor("Basalt", 78, 78, 78);
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

        final MapColor[] mc =
        {
            fire, red, netherrack, pink, crimsonNylium, boron, lanthanum, crimsonPlanks, orange, fluorine, yellow, gold,
            sand, lime, green, grass, emerald, leaves, hydrogen, slime, dripleaf, lightBlue, cyan, blue, darkPrismarine,
            lapisLazuli, warpedWart, warpedNylium, ice, lithium, beryllium, weatheredCopper, magenta, purple, helium,
            actinium, black, unknown, sculkSensor, gray, lightGray, iron, stone, scandium, stoneBricks, basalt,
            deepslate, white, quartz, cobweb, calcite, brown, planks, dirt, aluminum, exposedCopper, rawIron, tuff,
            dripstone
        };

        int i;
        int i_ = 256;
        int ii = 0;

        for (var x = 0; x < mc.length; x++)
        {
            i = (Math.abs(r - mc[x].r) + Math.abs(g - mc[x].g) + Math.abs(b - mc[x].b)) / 3;
            
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

    public MapColor(int r, int g, int b, boolean b_)
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
        final MapColor basalt = new MapColor("Basalt", 78, 78, 78);
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

        final MapColor[] mc =
        {
            fire0, fire1, red0, red1, netherrack0, netherrack1, pink0, pink1, crimsonNylium0, crimsonNylium1, boron0,
            boron1, lanthanum0, lanthanum1, crimsonPlanks0, crimsonPlanks1, orange0, orange1, fluorine0, fluorine1,
            yellow0, yellow1, gold0, gold1, sand0, sand1, lime0, lime1, green0, green1, grass0, grass1, emerald0,
            emerald1,
            fire, red, netherrack, pink, crimsonNylium, boron, lanthanum, crimsonPlanks, orange, fluorine, yellow, gold,
            sand, lime, green, grass, emerald, leaves, hydrogen, slime, dripleaf, lightBlue, cyan, blue, darkPrismarine,
            lapisLazuli, warpedWart, warpedNylium, ice, lithium, beryllium, weatheredCopper, magenta, purple, helium,
            actinium, black, unknown, sculkSensor, gray, lightGray, iron, stone, scandium, stoneBricks, basalt,
            deepslate, white, quartz, cobweb, calcite, brown, planks, dirt, aluminum, exposedCopper, rawIron, tuff,
            dripstone
        };

        int i;
        int i_ = 256;
        int ii = 0;

        for (var x = 0; x < mc.length; x++)
        {
            i = (Math.abs(r - mc[x].r) + Math.abs(g - mc[x].g) + Math.abs(b - mc[x].b)) / 3;
            
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
}
