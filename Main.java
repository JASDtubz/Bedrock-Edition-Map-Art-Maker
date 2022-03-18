package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{
    boolean bool;

    Label l;
    TextField tf;
    Button b0, b1, b_;
    public Canvas c = new Canvas(256, 256);
    Canvas c0 = new Canvas(256, 256);
    static Label l_ = new Label();
    VBox vb;

    public static MapColor[][] mc = new MapColor[128][128];

    public static void main(String[] q) { launch(); }

    @Override
    public void start(Stage s)
    {
        this.l = new Label("Location Of Image");
        this.tf = new TextField();
        this.b0 = new Button("Start");
        this.b1 = new Button("Start 2");
        this.b_ = new Button("Make Map");
        Button bx = new Button("Dither 1");
        Button by = new Button("Dither 2");
        Main.l_ = new Label("0%");

        Button[][] bb = new Button[8][8];
        VBox[] vbv = new VBox[8];
        HBox square = new HBox();
        HBox canvas = new HBox(10);

        this.b0.setTooltip(new Tooltip("This algorithm uses no stair technique."));
        this.b1.setTooltip(new Tooltip("This algorithm uses stair technique."));

        HBox hb = new HBox(5);
        hb.getChildren().addAll(this.b0, this.b1, this.b_, bx, by);

        for (int i = 0; i < 8; i++)
        {
            vbv[i] = new VBox();

            for (int j = 0; j < 8; j++)
            {
                int i_ = i;
                int j_ = j;

                bb[i][j] = new Button("   ");
                bb[i][j].setOnAction(e -> this.chunk(i_, j_));
                bb[i][j].setTooltip(new Tooltip(i + ", " + j));
                vbv[i].getChildren().add(bb[i][j]);
            }
        }

        for (int i = 0; i < 8; i++) { square.getChildren().add(vbv[i]); }

        canvas.getChildren().addAll(this.c, square, this.c0);

        Button button = new Button("Function");
        button.setOnAction(q -> this.function());

        this.vb = new VBox(5);
        this.vb.getChildren().addAll(this.l, this.tf, hb, canvas, Main.l_, button);

        s.setTitle("Bedrock Map Art");
        s.getIcons().add(new Image("file:src/main/resources/loshun_upsized.png"));
        s.setOnCloseRequest(e -> System.exit(~0 >>> 1));
        s.setScene(new Scene(this.vb, 800, 600));
        s.show();

        this.b0.setOnAction(e -> this.init(false));
        this.b1.setOnAction(e -> this.init(true));
        this.b_.setOnAction(e -> this.make());
        bx.setOnAction(e -> this.dither1());
        by.setOnAction(e -> this.dither2());
    }

    public void init(boolean b)
    {
        String s;

        this.bool = b;

        try { s = this.tf.getText(); }
        catch (Exception ignored)
        {
            Main.l_.setText("No Text Present");
            return;
        }

        Main.l_.setText("0%");

        Init i = new Init();
        i.init(s, b);
    }

    public void make()
    {
        GraphicsContext gc = this.c.getGraphicsContext2D();

        for (int x = 0; x < 128; x++)
        {
            for (int y = 0; y < 128; y++)
            {
                MapColor mc = Main.mc[x][y];
                gc.setFill(Color.rgb(mc.r, mc.g, mc.b));
                gc.fillRect(x * 2, y * 2, 2, 2);
            }
        }
    }

    public static void assign(int x, int y, MapColor mc)
    {
        Main.mc[x][y] = mc;
        Main.l_.setText(x / 127.0 * 100 + "%");
    }

    public void chunk(int x, int y)
    {
        if (Main.mc[0][0] != null)
        {
            GraphicsContext gc = this.c0.getGraphicsContext2D();
            StringBuilder sb = new StringBuilder();

            for (int i = x * 16; i < (x + 1) * 16; i++)
            {
                for (int j = y  * 16; j < (y + 1) * 16; j++)
                {
                    MapColor mc = Main.mc[i][j];
                    sb.append(mc.name).append(" | ");
                    gc.setFill(Color.rgb(mc.r, mc.g, mc.b));
                    gc.fillRect(i % 16 * 16, j % 16 * 16, 16, 16);
                }

                sb.append("\n");
            }

            try
            {
                File f = new File("Blocks.txt");
                FileWriter fw = new FileWriter(f);

                if (f.createNewFile()) { fw.write(""); }

                fw.write(sb.toString());
                fw.close();
            }
            catch (IOException ignored) { return; }

            gc.setFill(Color.BLACK);

            for (int i = 1; i < 16; i++)
            {
                gc.fillRect(i * 16 - 1, 0, 3, 256);
                gc.fillRect(0, i * 16 - 1, 256, 3);
            }

            gc.setFill(Color.WHITE);

            for (int i = 1; i < 16; i++)
            {
                gc.fillRect(i * 16, 0, 1, 256);
                gc.fillRect(0, i * 16, 256, 1);
            }
        }
    }

    void function()
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int n = 0;

        for (int i = -64; i < 320; i++)
        {
            sb.append("fill ~ " + i + " ~ ~-127 " + i + " ~-128 air\n");
            n++;
        }

        for (int i = -127; i < 1; i++)
        {
            int z = 128;

            for (int j = -127; j < 1; j++)
            {
                String s = Main.mc[i + 127][j + 127].name.contains("+") || Main.mc[i + 127][j + 127].name.contains("-")
                    ? Main.mc[i + 127][j + 127].name.substring(0, Main.mc[i + 127][j + 127].name.length() - 1)
                    : Main.mc[i + 127][j + 127].name;

                if (j == -127)
                {
                    if (n < 10000)
                    {
                        sb.append("fill ~" + i + " 128 ~" + j + " ~" + i + " 128 ~" + j + " " + this.translate(s) + "\n");

                        if (Main.mc[i + 127][j + 127].name.contains("+"))
                        {
                            sb.append("fill ~" + i + " 130 ~" + (j - 1) + " ~" + i + " 130 ~" + (j - 1) + " " + "bedrock\n");
                        }
                        else if (Main.mc[i + 127][j + 127].name.contains("-"))
                        {
                            sb.append("fill ~" + i + " 126 ~" + (j - 1) + " ~" + i + " 126 ~" + (j - 1) + " " + "bedrock\n");
                        }
                        else
                        {
                            sb.append("fill ~" + i + " 128 ~" + (j - 1) + " ~" + i + " 128 ~" + (j - 1) + " " + "bedrock\n");
                        }
                    }
                    else
                    {
                        sb2.append("fill ~" + i + " 128 ~" + j + " ~" + i + " 128 ~" + j + " " + this.translate(s) + "\n");

                        if (Main.mc[i + 127][j + 127].name.contains("+"))
                        {
                            sb2.append("fill ~" + i + " 130 ~" + (j - 1) + " ~" + i + " 130 ~" + (j - 1) + " " + "bedrock\n");
                        }
                        else if (Main.mc[i + 127][j + 127].name.contains("-"))
                        {
                            sb2.append("fill ~" + i + " 126 ~" + (j - 1) + " ~" + i + " 126 ~" + (j - 1) + " " + "bedrock\n");
                        }
                        else
                        {
                            sb2.append("fill ~" + i + " 128 ~" + (j - 1) + " ~" + i + " 128 ~" + (j - 1) + " " + "bedrock\n");
                        }
                    }

                    n += 2;
                }
                else
                {
                    if (Main.mc[i + 127][j + 127].name.contains("+")) { z -= 2; }
                    else if (Main.mc[i + 127][j + 127].name.contains("-")) { z += 2; }

                    if (n < 10000)
                    {
                        if (s.equals("Dripleaf") || s.equals("Glow Lichen"))
                        {
                            sb.append("fill ~" + i + " " + (z - 1) + " ~" + j + " ~" + i + " " + (z - 1) + " ~" + j + " dirt\n");
                            n++;
                        }
                    
                        sb.append("fill ~" + i + " " + z + " ~" + j + " ~" + i + " " + z + " ~" + j + " " + this.translate(s) + "\n");
                    }
                    else
                    {
                        if (s.equals("Dripleaf") || s.equals("Glow Lichen"))
                        {
                            sb2.append("fill ~" + i + " " + (z - 1) + " ~" + j + " ~" + i + " " + (z - 1) + " ~" + j + " dirt\n");
                            n++;
                        }
                    
                        sb2.append("fill ~" + i + " " + z + " ~" + j + " ~" + i + " " + z + " ~" + j + " " + this.translate(s) + "\n");
                    }

                    n++;
                }
            }
        }

        try
        {
            File f1 = new File("make1.mcfunction");
            FileWriter fw1 = new FileWriter(f1);

            if (f1.createNewFile()) { fw1.write(""); }

            fw1.write(sb.toString());
            fw1.close();

            File f2 = new File("make2.mcfunction");
            FileWriter fw2 = new FileWriter(f2);

            if (f2.createNewFile()) { fw2.write(""); }

            fw2.write(sb2.toString());
            fw2.close();
        }
        catch (IOException ignored) { }
    }

    String translate(String s)
    {
        switch (s)
        {
            case "Fire": return "tnt";
            case "Red / Nether Wart": return "brick_block";
            case "Netherrack": return "netherrack";
            case "Pink": return "wool 6";
            case "Crimson Nylium": return "crimson_nylium";
            case "Boron": return "element_5";
            case "Lanthanum": return "element_57";
            case "Crimson Planks": return "crimson_planks";
            case "Orange / Terracotta / Copper": return "hardened_clay";
            case "Fluorine": return "element_9";
            case "Yellow / Hay": return "sponge";
            case "Gold": return "gold_block";
            case "Sand / End Stone": return "end_stone";
            case "Lime": return "wool 5";
            case "Green / Moss / Kelp": return "moss_block";
            case "Grass": return "grass";
            case "Emerald": return "emerald_block";
            case "Leaves": return "leaves";
            case "Hydrogen": return "element_1";
            case "Slime": return "slime";
            case "Light Blue": return "wool 3";
            case "Cyan / Warped Stem / Prismarine": return "wool 9";
            case "Blue": return "wool 11";
            case "Dark Prismarine": return "diamond_block";
            case "Lapis Lazuli": return "lapis_block";
            case "Warped Wart / Oxidized Copper": return "warped_wart_block";
            case "Warped Nylium": return "warped_nylium";
            case "Ice": return "packed_ice";
            case "Lithium": return "element_3";
            case "Beryllium": return "element_4";
            case "Weathered Copper": return "waxed_weathered_copper";
            case "Magenta / Purpur": return "purpur_block";
            case "Purple / Amethyst": return "amethyst_block";
            case "Helium": return "element_2";
            case "Actinium": return "element_89";
            case "Black / Blackstone": return "blackstone";
            case "???": return "element_0";
            case "Sculk Sensor": return "sculk";
            case "Gray": return "wool 7";
            case "Light Gray": return "wool 8";
            case "Iron": return "iron_block";
            case "Stone": return "stone";
            case "Scandium": return "element_21";
            case "Stone Bricks": return "stonebrick";
            case "Deepslate": return "deepslate";
            case "White / Snow": return "snow";
            case "Quartz": return "quartz_block";
            case "Cobweb": return "web";
            case "Calcite": return "calcite";
            case "Brown / Soul Sand": return "wool 12";
            case "Planks": return "planks";
            case "Dirt": return "dirt";
            case "Aluminum": return "element_13";
            case "Exposed Copper": return "waxed_exposed_copper";
            case "Raw Iron": return "raw_iron_block";
            case "Tuff": return "tuff";
            case "Dripstone": return "dripstone_block";
            case "Spruce Leaves": return "leaves 1";
            case "Birch Leaves": return "leaves 2";
            case "Glow Lichen": return "glow_lichen";
            case "Spruce Planks": return "planks 1";
            default: return "air";
        }
    }

    public void dither1()
    {
        for (int y = 0; y < 128; y++)
        {
            for (int x = 0; x < 128; x++)
            {
                Main.mc[x][y] = new MapColor(Main.mc[x][y].r_, Main.mc[x][y].g_, Main.mc[x][y].b_, this.bool);
                double rr = Main.mc[x][y].r_ - Main.mc[x][y].r;
                double gg = Main.mc[x][y].g_ - Main.mc[x][y].g;
                double bb = Main.mc[x][y].b_ - Main.mc[x][y].b;
                double d = 0;

                try
                {
                    try
                    {
                        d = Main.mc[x + 1][y].r_ + rr * 0.4375;
                        
                        if (d > 255) { Main.mc[x + 1][y].r_ = 255; }
                        else if (d < 0) { Main.mc[x + 1][y].r_ = 0; }
                        else { Main.mc[x + 1][y].r_ = d; }
                        
                        d = Main.mc[x + 1][y].g_ + gg * 0.4375;
                        
                        if (d > 255) { Main.mc[x + 1][y].g_ = 255; }
                        else if (d < 0) { Main.mc[x + 1][y].g_ = 0; }
                        else { Main.mc[x + 1][y].g_ = d; }
                        
                        d = Main.mc[x + 1][y].b_ + bb * 0.4375;
                        
                        if (d > 255) { Main.mc[x + 1][y].b_ = 255; }
                        else if (d < 0) { Main.mc[x + 1][y].b_ = 0; }
                        else { Main.mc[x + 1][y].b_ = d; }

                        //above is left : below is down left

                        d = Main.mc[x + 1][y + 1].r_ + rr * 0.0625;
                        
                        if (d > 255) { Main.mc[x + 1][y + 1].r_ = 255; }
                        else if (d < 0) { Main.mc[x + 1][y + 1].r_ = 0; }
                        else { Main.mc[x + 1][y + 1].r_ = d; }
                        
                        d = Main.mc[x + 1][y + 1].g_ + gg * 0.0625;
                        
                        if (d > 255) { Main.mc[x + 1][y + 1].g_ = 255; }
                        else if (d < 0) { Main.mc[x + 1][y + 1].g_ = 0; }
                        else { Main.mc[x + 1][y + 1].g_ = d; }
                        
                        d = Main.mc[x + 1][y + 1].b_ + bb * 0.0625;
                        
                        if (d > 255) { Main.mc[x + 1][y + 1].b_ = 255; }
                        else if (d < 0) { Main.mc[x + 1][y + 1].b_ = 0; }
                        else { Main.mc[x + 1][y + 1].b_ = d; }
                    }
                    catch (Exception ignore) { }

                    d = Main.mc[x - 1][y + 1].r_ + rr * 0.1875;
                    
                    if (d > 255) { Main.mc[x - 1][y + 1].r_ = 255; }
                    else if (d < 0) { Main.mc[x - 1][y + 1].r_ = 0; }
                    else { Main.mc[x - 1][y + 1].r_ = d; }
                    
                    d = Main.mc[x - 1][y + 1].g_ + gg * 0.1875;
                    
                    if (d > 255) { Main.mc[x - 1][y + 1].g_ = 255; }
                    else if (d < 0) { Main.mc[x - 1][y + 1].g_ = 0; }
                    else { Main.mc[x - 1][y + 1].g_ = d; }
                    
                    d = Main.mc[x - 1][y + 1].b_ + bb * 0.1875;
                    
                    if (d > 255) { Main.mc[x - 1][y + 1].b_ = 255; }
                    else if (d < 0) { Main.mc[x - 1][y + 1].b_ = 0; }
                    else { Main.mc[x - 1][y + 1].b_ = d; }

                    //above is down right : below is down
                    
                    d = Main.mc[x][y + 1].r_ + rr * 0.3125;
                    
                    if (d > 255) { Main.mc[x][y + 1].r_ = 255; }
                    else if (d < 0) { Main.mc[x][y + 1].r_ = 0; }
                    else { Main.mc[x][y + 1].r_ = d; }
                    
                    d = Main.mc[x][y + 1].g_ + gg * 0.3125;
                    
                    if (d > 255) { Main.mc[x][y + 1].g_ = 255; }
                    else if (d < 0) { Main.mc[x][y + 1].g_ = 0; }
                    else { Main.mc[x][y + 1].g_ = d; }
                    
                    d = Main.mc[x][y + 1].b_ + bb * 0.3125;
                    
                    if (d > 255) { Main.mc[x][y + 1].b_ = 255; }
                    else if (d < 0) { Main.mc[x][y + 1].b_ = 0; }
                    else { Main.mc[x][y + 1].b_ = d; }
                }
                catch (Exception ignore) { }
            }
        }

        this.make();
    }

    public void dither2()
    {
    }
}
