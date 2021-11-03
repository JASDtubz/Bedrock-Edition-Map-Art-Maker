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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{
    Label l;
    TextField tf;
    Button b0, b1, b_;
    public Canvas c = new Canvas(256, 256);
    Canvas c0 = new Canvas(256, 256);
    static Label l_ = new Label();
    VBox vb;
    Scene scene;
    Stage stage;

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
        Main.l_ = new Label("0%");

        Button[][] bb = new Button[8][8];
        VBox[] vbv = new VBox[8];
        HBox square = new HBox();
        HBox canvas = new HBox(10);

        this.b0.setTooltip(new Tooltip("This algorithm uses no stair technique and no impressionism dotting."));
        this.b1.setTooltip(new Tooltip("This algorithm uses stair technique but no impressionism dotting."));

        HBox hb = new HBox(5);
        hb.getChildren().addAll(this.b0, this.b1, this.b_);

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

        this.vb = new VBox(5);
        this.vb.getChildren().addAll(this.l, this.tf, hb, canvas, Main.l_);

        this.scene = new Scene(this.vb, 800, 600);

        this.stage = s;
        this.stage.setTitle("Bedrock Map Art");
        this.stage.setScene(this.scene);
        this.stage.show();

        this.b0.setOnAction(e -> this.init(false));
        this.b1.setOnAction(e -> this.init(true));
        this.b_.setOnAction(e -> this.make());
    }

    public void init(boolean b)
    {
        String s;

        try { s = this.tf.getText(); }
        catch (Exception ignored) { return; }

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
}
