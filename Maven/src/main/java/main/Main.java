/*
    Copyright Loshun Ltd. 2022
    Updated Tuesday, May 31
    Version 1.2.1
*/

package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    boolean bool;
    static int i = 0;

    Label l;
    TextField tf;
    Button b0, b1, b_;
    public Canvas c = new Canvas(256, 256);
    Canvas c0 = new Canvas(256, 256);
    static Label l_ = new Label();
    VBox vb;
    boolean[] b = new boolean[63];

    public static MapColor[][] mc = new MapColor[128][128];
    MapColor[] mcl = new MapColor[0];

    @Version(required = true)
    public Main() { }

    @Version(required = true)
    public static void main(String[] q) { launch(); }

    @Version(required = true, lastEdited = 1.1)
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
        Button bz = new Button("Dither 3");
        Main.l_ = new Label("0%");

        Button[][] bb = new Button[8][8];
        VBox[] vbv = new VBox[8];
        HBox square = new HBox();
        HBox canvas = new HBox(10);

        this.b0.setTooltip(new Tooltip("This algorithm uses no stair technique."));
        this.b1.setTooltip(new Tooltip("This algorithm uses stair technique."));

        HBox hb = new HBox(5);
        hb.getChildren().addAll(this.b0, this.b1, this.b_, bx, by, bz);

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

        Button button1 = new Button("Block List");
        button1.setOnAction(q -> this.blockList());

        HBox buttons = new HBox(5);
        buttons.getChildren().addAll(button, button1);

        java.util.Arrays.fill(this.b, true);

        this.vb = new VBox(5);
        this.vb.getChildren().addAll(this.l, this.tf, hb, canvas, Main.l_, buttons);

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
        bz.setOnAction(e -> this.dither3());
    }

    @Version(lastEdited = 1.1)
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

        this.mcl = MapColor.filter(MapColor.getColors(this.bool), this.b);

        Main.l_.setText("0%");

        new Init().init(s, this.mcl);
    }

    @Version(lastEdited = 1.1)
    public void make()
    {
        GraphicsContext gc = this.c.getGraphicsContext2D();

        BufferedImage bf = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bf.createGraphics();

        for (int x = 0; x < 128; x++)
        {
            for (int y = 0; y < 128; y++)
            {
                MapColor mc = Main.mc[x][y];
                gc.setFill(javafx.scene.paint.Color.rgb(mc.r, mc.g, mc.b));
                gc.fillRect(x * 2, y * 2, 2, 2);

//                g2d.setColor(new java.awt.Color(mc.r, mc.g, mc.b, 255));
//                g2d.fillRect(x * 2, y * 2, 2, 2);
            }
        }

//        g2d.dispose();
//        try { javax.imageio.ImageIO.write(bf, "png", new File(Main.i + ".png")); }
//        catch (Exception ignore) { System.out.println("What the Fuck?"); }

        Main.i++;
    }

    @Version
    public static void assign(int x, int y, MapColor mc)
    {
        Main.mc[x][y] = mc;
        Main.l_.setText(x / 127.0 * 100 + "%");
    }

    @Version(lastEdited = 1.0)
    public void chunk(int x, int y)
    {
        if (Main.mc[0][0] != null)
        {
            GraphicsContext gc = this.c0.getGraphicsContext2D();
            StringBuilder sb = new StringBuilder();

            for (int i = x * 16; i < (x + 1) * 16; i++)
            {
                for (int j = y * 16; j < (y + 1) * 16; j++)
                {
                    MapColor mc = Main.mc[i][j];
                    gc.setFill(javafx.scene.paint.Color.rgb(mc.r, mc.g, mc.b));
                    gc.fillRect(i % 16 * 16, j % 16 * 16, 16, 16);
                }
            }

            for (int i = y * 16; i < (y + 1) * 16; i++)
            {
                for (int j = x * 16; j < (x + 1) * 16; j++) { sb.append(Main.mc[j][i].name).append(" | "); }

                sb.append("\n");
            }

            try
            {
                File f = new File("Blocks.txt");
                FileWriter fw = new FileWriter(f);

                f.createNewFile();

                fw.write(sb.toString());
                fw.close();
            }
            catch (Exception ignored) { return; }

            gc.setFill(javafx.scene.paint.Color.BLACK);

            for (int i = 1; i < 16; i++)
            {
                gc.fillRect(i * 16 - 1, 0, 3, 256);
                gc.fillRect(0, i * 16 - 1, 256, 3);
            }

            gc.setFill(javafx.scene.paint.Color.WHITE);

            for (int i = 1; i < 16; i++)
            {
                gc.fillRect(i * 16, 0, 1, 256);
                gc.fillRect(0, i * 16, 256, 1);
            }
        }
    }

    @Version(addedIn = 1, lastEdited = 1.0)
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
            int w = 128;
            int v = 128;

            for (int j = -127; j < 1; j++)
            {
                if (Main.mc[i + 127][j + 127].name.contains("+")) { w -= 2; }
                else if (Main.mc[i + 127][j + 127].name.contains("-")) { v += 2; }

                if (j == 0)
                {
                    if (v > 319) { z -= v - 316; }
                    else if (w < -64) { z += -64 - w; }
                }
            }

            for (int j = -127; j < 1; j++)
            {
                String s = Main.mc[i + 127][j + 127].name.contains("+") || Main.mc[i + 127][j + 127].name.contains("-")
                    ? Main.mc[i + 127][j + 127].name.substring(0, Main.mc[i + 127][j + 127].name.length() - 1)
                    : Main.mc[i + 127][j + 127].name;

                if (j == -127)
                {
                    if (n < 9997)
                    {
                        if (s.equals("Dripleaf") || s.equals("Glow Lichen"))
                        {
                            sb.append("setblock ~" + i + " " + (z - 1) + " ~" + j + " dirt\n");
                            n++;
                        }

                        sb.append("setblock ~" + i + " " + z + " ~" + j + " " + this.translate(s) + "\n");

                        if (Main.mc[i + 127][j + 127].name.contains("+"))
                        {
                            sb.append("setblock ~" + i + " " + (z + 2) + " ~" + (j - 1) + " bedrock\n");
                        }
                        else if (Main.mc[i + 127][j + 127].name.contains("-"))
                        {
                            sb.append("setblock ~" + i + " " + (z - 2) + " ~" + (j - 1) + " bedrock\n");
                        }
                        else
                        {
                            sb.append("setblock ~" + i + " " + z + " ~" + (j - 1) + " bedrock\n");
                        }
                    }
                    else
                    {
                        if (s.equals("Dripleaf") || s.equals("Glow Lichen"))
                        {
                            sb2.append("setblock ~" + i + " " + (z - 1) + " ~" + j + " dirt\n");
                            n++;
                        }

                        sb2.append("setblock ~" + i + " " + z + " ~" + j + " " + this.translate(s) + "\n");

                        if (Main.mc[i + 127][j + 127].name.contains("+"))
                        {
                            sb2.append("setblock ~" + i + " " + (z + 2) + " ~" + (j - 1) + " bedrock\n");
                        }
                        else if (Main.mc[i + 127][j + 127].name.contains("-"))
                        {
                            sb2.append("setblock ~" + i + " " + (z - 2) + " ~" + (j - 1) + " bedrock\n");
                        }
                        else
                        {
                            sb2.append("setblock ~" + i + " " + z + " ~" + (j - 1) + " bedrock\n");
                        }
                    }

                    n += 2;
                }
                else
                {
                    if (Main.mc[i + 127][j + 127].name.contains("+")) { z -= 2; }
                    else if (Main.mc[i + 127][j + 127].name.contains("-")) { z += 2; }

                    if (n < 9998)
                    {
                        if (s.equals("Dripleaf") || s.equals("Glow Lichen"))
                        {
                            sb.append("setblock ~" + i + " " + (z - 1) + " ~" + j + " dirt\n");
                            n++;
                        }

                        sb.append("setblock ~" + i + " " + z + " ~" + j + " " + this.translate(s) + "\n");
                    }
                    else
                    {
                        if (s.equals("Dripleaf") || s.equals("Glow Lichen"))
                        {
                            sb2.append("setblock ~" + i + " " + (z - 1) + " ~" + j + " dirt\n");
                            n++;
                        }

                        sb2.append("setblock ~" + i + " " + z + " ~" + j + " " + this.translate(s) + "\n");
                    }

                    n++;
                }

                if (z > 319) { System.err.println("greater"); }
                else if (z < -64) { System.err.println("less"); }
            }
        }

        try
        {
            File f1 = new File("make1.mcfunction");
            FileWriter fw1 = new FileWriter(f1);

            f1.createNewFile();

            fw1.write(sb.toString());
            fw1.close();

            File f2 = new File("make2.mcfunction");
            FileWriter fw2 = new FileWriter(f2);

            f2.createNewFile();

            fw2.write(sb2.toString());
            fw2.close();
        }
        catch (Exception ignored) { }

        System.out.println("done");
    }

    @Version(addedIn = 1, lastEdited = 1.0)
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
            case "Dripleaf": return "big_dripleaf";
            case "Mud": return "mud";
            default: return "air";
        }
    }

    @Version(addedIn = 1, lastEdited = 1.0)
    private void dither1()
    {
        for (int y = 0; y < 128; y++)
        {
            for (int x = 0; x < 128; x++)
            {
                Main.mc[x][y] = new MapColor(Main.mc[x][y].r_, Main.mc[x][y].g_, Main.mc[x][y].b_, this.mcl);
                final double rr = Main.mc[x][y].r_ - Main.mc[x][y].r;
                final double gg = Main.mc[x][y].g_ - Main.mc[x][y].g;
                final double bb = Main.mc[x][y].b_ - Main.mc[x][y].b;

                double one = 1.0 / 16;
                double three = 3.0 / 16;
                double five = 5.0 / 16;
                double seven = 7.0 / 16;

//                if (x == 0)
//                {
//                    one = 1.0 / 13;
//                    five = 5.0 / 13;
//                    seven = 7.0 / 13;
//                }
//
//                if (x == 0 && y == 127) { seven = 7.0 / 7; }
//
//                if (x == 127)
//                {
//                    three = 3.0 / 8;
//                    five = 5.0 / 8;
//                }

                try
                {
                    Main.mc[x + 1][y].r_ = this.numChecker(Main.mc[x + 1][y].r_ + rr * seven);
                    Main.mc[x + 1][y].g_ = this.numChecker(Main.mc[x + 1][y].g_ + gg * seven);
                    Main.mc[x + 1][y].b_ = this.numChecker(Main.mc[x + 1][y].b_ + bb * seven);

                    Main.mc[x + 1][y + 1].r_ = this.numChecker(Main.mc[x + 1][y + 1].r_ + rr * one);
                    Main.mc[x + 1][y + 1].g_ = this.numChecker(Main.mc[x + 1][y + 1].g_ + gg * one);
                    Main.mc[x + 1][y + 1].b_ = this.numChecker(Main.mc[x + 1][y + 1].b_ + bb * one);
                }
                catch (Exception ignore) { }

                try
                {
                    Main.mc[x][y + 1].r_ = this.numChecker(Main.mc[x][y + 1].r_ + rr * five);
                    Main.mc[x][y + 1].g_ = this.numChecker(Main.mc[x][y + 1].g_ + gg * five);
                    Main.mc[x][y + 1].b_ = this.numChecker(Main.mc[x][y + 1].b_ + bb * five);

                    Main.mc[x - 1][y + 1].r_ = this.numChecker(Main.mc[x - 1][y + 1].r_ + rr * three);
                    Main.mc[x - 1][y + 1].g_ = this.numChecker(Main.mc[x - 1][y + 1].g_ + gg * three);
                    Main.mc[x - 1][y + 1].b_ = this.numChecker(Main.mc[x - 1][y + 1].b_ + bb * three);
                }
                catch (Exception ignore) { }
            }
        }

        this.make();
    }

    @Version(addedIn = 1, lastEdited = 1.0)
    private void dither2()
    {
        for (int y = 0; y < 128; y++)
        {
            for (int x = 0; x < 128; x++)
            {
                Main.mc[x][y] = new MapColor(Main.mc[x][y].r_, Main.mc[x][y].g_, Main.mc[x][y].b_, this.mcl);
                final double rr = Main.mc[x][y].r_ - Main.mc[x][y].r;
                final double gg = Main.mc[x][y].g_ - Main.mc[x][y].g;
                final double bb = Main.mc[x][y].b_ - Main.mc[x][y].b;

                final double one = 1.0 / 48;
                final double three = 3.0 / 48;
                final double five = 5.0 / 48;
                final double seven = 7.0 / 48;

                try
                {
                    Main.mc[x + 2][y].r_ = this.numChecker(Main.mc[x + 2][y].r_ + rr * five);
                    Main.mc[x + 2][y].g_ = this.numChecker(Main.mc[x + 2][y].g_ + gg * five);
                    Main.mc[x + 2][y].b_ = this.numChecker(Main.mc[x + 2][y].b_ + bb * five);

                    Main.mc[x + 2][y + 1].r_ = this.numChecker(Main.mc[x + 2][y + 1].r_ + rr * three);
                    Main.mc[x + 2][y + 1].g_ = this.numChecker(Main.mc[x + 2][y + 1].g_ + gg * three);
                    Main.mc[x + 2][y + 1].b_ = this.numChecker(Main.mc[x + 2][y + 1].b_ + bb * three);

                    Main.mc[x + 2][y + 2].r_ = this.numChecker(Main.mc[x + 2][y + 2].r_ + rr * one);
                    Main.mc[x + 2][y + 2].g_ = this.numChecker(Main.mc[x + 2][y + 2].g_ + gg * one);
                    Main.mc[x + 2][y + 2].b_ = this.numChecker(Main.mc[x + 2][y + 2].b_ + bb * one);
                }
                catch (Exception ignore) { }

                try
                {
                    Main.mc[x + 1][y].r_ = this.numChecker(Main.mc[x + 1][y].r_ + rr * seven);
                    Main.mc[x + 1][y].g_ = this.numChecker(Main.mc[x + 1][y].g_ + gg * seven);
                    Main.mc[x + 1][y].b_ = this.numChecker(Main.mc[x + 1][y].b_ + bb * seven);

                    Main.mc[x + 1][y + 1].r_ = this.numChecker(Main.mc[x + 1][y + 1].r_ + rr * five);
                    Main.mc[x + 1][y + 1].g_ = this.numChecker(Main.mc[x + 1][y + 1].g_ + gg * five);
                    Main.mc[x + 1][y + 1].b_ = this.numChecker(Main.mc[x + 1][y + 1].b_ + bb * five);

                    Main.mc[x + 1][y + 2].r_ = this.numChecker(Main.mc[x + 1][y + 2].r_ + rr * three);
                    Main.mc[x + 1][y + 2].g_ = this.numChecker(Main.mc[x + 1][y + 2].g_ + gg * three);
                    Main.mc[x + 1][y + 2].b_ = this.numChecker(Main.mc[x + 1][y + 2].b_ + bb * three);
                }
                catch (Exception ignore) { }

                try
                {
                    Main.mc[x][y + 1].r_ = this.numChecker(Main.mc[x][y + 1].r_ + rr * seven);
                    Main.mc[x][y + 1].g_ = this.numChecker(Main.mc[x][y + 1].g_ + gg * seven);
                    Main.mc[x][y + 1].b_ = this.numChecker(Main.mc[x][y + 1].b_ + bb * seven);

                    Main.mc[x - 1][y + 1].r_ = this.numChecker(Main.mc[x - 1][y + 1].r_ + rr * five);
                    Main.mc[x - 1][y + 1].g_ = this.numChecker(Main.mc[x - 1][y + 1].g_ + gg * five);
                    Main.mc[x - 1][y + 1].b_ = this.numChecker(Main.mc[x - 1][y + 1].b_ + bb * five);

                    Main.mc[x - 2][y + 1].r_ = this.numChecker(Main.mc[x - 2][y + 1].r_ + rr * three);
                    Main.mc[x - 2][y + 1].g_ = this.numChecker(Main.mc[x - 2][y + 1].g_ + gg * three);
                    Main.mc[x - 2][y + 1].b_ = this.numChecker(Main.mc[x - 2][y + 1].b_ + bb * three);
                }
                catch (Exception ignore) { }

                try
                {
                    Main.mc[x][y + 2].r_ = this.numChecker(Main.mc[x][y + 2].r_ + rr * five);
                    Main.mc[x][y + 2].g_ = this.numChecker(Main.mc[x][y + 2].g_ + gg * five);
                    Main.mc[x][y + 2].b_ = this.numChecker(Main.mc[x][y + 2].b_ + bb * five);

                    Main.mc[x - 1][y + 2].r_ = this.numChecker(Main.mc[x - 1][y + 2].r_ + rr * three);
                    Main.mc[x - 1][y + 2].g_ = this.numChecker(Main.mc[x - 1][y + 2].g_ + gg * three);
                    Main.mc[x - 1][y + 2].b_ = this.numChecker(Main.mc[x - 1][y + 2].b_ + bb * three);

                    Main.mc[x - 2][y + 2].r_ = this.numChecker(Main.mc[x - 2][y + 2].r_ + rr * one);
                    Main.mc[x - 2][y + 2].g_ = this.numChecker(Main.mc[x - 2][y + 2].g_ + gg * one);
                    Main.mc[x - 2][y + 2].b_ = this.numChecker(Main.mc[x - 2][y + 2].b_ + bb * one);
                }
                catch (Exception ignore) { }
            }
        }

        this.make();
    }

    @Version(addedIn = 1.1, lastEdited = 1.1)
    void dither3()
    {
        for (int y = 0; y < 128; y++)
        {
            for (int x = 0; x < 128; x++)
            {
                Main.mc[x][y] = new MapColor(Main.mc[x][y].r_, Main.mc[x][y].g_, Main.mc[x][y].b_, this.mcl);
                double rr = Main.mc[x][y].r_ - Main.mc[x][y].r;
                double gg = Main.mc[x][y].g_ - Main.mc[x][y].g;
                double bb = Main.mc[x][y].b_ - Main.mc[x][y].b;
                double d;

                try
                {
                    d = Main.mc[x + 1][y].r_ + rr * 0.5;

                    if (d > 255) { Main.mc[x + 1][y].r_ = 255; }
                    else if (d < 0) { Main.mc[x + 1][y].r_ = 0; }
                    else { Main.mc[x + 1][y].r_ = d; }

                    d = Main.mc[x + 1][y].g_ + gg * 0.5;

                    if (d > 255) { Main.mc[x + 1][y].g_ = 255; }
                    else if (d < 0) { Main.mc[x + 1][y].g_ = 0; }
                    else { Main.mc[x + 1][y].g_ = d; }

                    d = Main.mc[x + 1][y].b_ + bb * 0.5;

                    if (d > 255) { Main.mc[x + 1][y].b_ = 255; }
                    else if (d < 0) { Main.mc[x + 1][y].b_ = 0; }
                    else { Main.mc[x + 1][y].b_ = d; }
                }
                catch (Exception ignore) { }

                try
                {
                    d = Main.mc[x][y + 1].r_ + rr * 0.5;

                    if (d > 255) { Main.mc[x][y + 1].r_ = 255; }
                    else if (d < 0) { Main.mc[x][y + 1].r_ = 0; }
                    else { Main.mc[x][y + 1].r_ = d; }

                    d = Main.mc[x][y + 1].g_ + gg * 0.5;

                    if (d > 255) { Main.mc[x][y + 1].g_ = 255; }
                    else if (d < 0) { Main.mc[x][y + 1].g_ = 0; }
                    else { Main.mc[x][y + 1].g_ = d; }

                    d = Main.mc[x][y + 1].b_ + bb * 0.5;

                    if (d > 255) { Main.mc[x][y + 1].b_ = 255; }
                    else if (d < 0) { Main.mc[x][y + 1].b_ = 0; }
                    else { Main.mc[x][y + 1].b_ = d; }
                }
                catch (Exception ignore) { }
            }
        }

        this.make();
    }

    @Version(addedIn = 1.0, lastEdited = 1.0)
    private double numChecker(double d)
    {
        if (d > 255) { return 255; }
        else if (d < 0) { return 0; }
        else { return d; }
    }

    @Version(addedIn = 1.1, lastEdited = 1.1)
    void blockList()
    {
        String[] s = MapColor.getNames();
        CheckBox[] cb = new CheckBox[s.length];

        for (int i = 0; i < s.length; i++)
        {
            final int j = i;

            cb[i] = new CheckBox(s[i]);
            cb[i].setSelected(this.b[i]);
            cb[i].setOnAction(q -> this.b[j] = !this.b[j]);
        }

        VBox vb = new VBox(10);
        vb.getChildren().addAll(cb);

        ScrollPane sp = new ScrollPane();
        sp.setContent(vb);

        Stage stage = new Stage(javafx.stage.StageStyle.UTILITY);
        stage.setTitle("Block Selection");
        stage.getIcons().add(new Image("file:src/main/resources/loshun_upsized.png"));
        stage.setScene(new Scene(sp, 400, 600));
        stage.show();
    }
}
