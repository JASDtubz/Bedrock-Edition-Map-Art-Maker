package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{
    Label l;
    TextField tf;
    Button b0, b1, b_;
    public Canvas c = new Canvas(256, 256);
    static Label l_;
    VBox vb;
    Scene scene;
    Stage stage;

    public static MapColor[][] mc = new MapColor[128][128];

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage s)
    {
        Init i = new Init();

        this.l = new Label("Location Of Image");
        this.tf = new TextField();
        this.b0 = new Button("Start");
        this.b1 = new Button("Start 2");
        this.b_ = new Button("Make Map");
        l_ = new Label("0%");

        this.b0.setTooltip(new Tooltip("This algorithm uses no stair technique and no impressionism dotting."));
        this.b1.setTooltip(new Tooltip("This algorithm uses stair technique but no impressionism dotting."));

        HBox hb = new HBox(5);
        hb.getChildren().addAll(this.b0, this.b1, this.b_);

        this.vb = new VBox(5);
        this.vb.getChildren().addAll(this.l, this.tf, hb, this.c, l_);

        this.scene = new Scene(this.vb, 800, 600);

        this.stage = s;
        this.stage.setTitle("Bedrock Map Art");
        this.stage.setScene(this.scene);
        this.stage.show();

        this.b0.setOnAction(e -> init(false));
        this.b1.setOnAction(e -> init(true));
        this.b_.setOnAction(e -> make());
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

        for (int x = 0; x < 128; x++) for (int y = 0; y < 128; y++)
        {
            MapColor mc = Main.mc[x][y];
            gc.setFill(Color.rgb(mc.r, mc.g, mc.b));
            gc.fillRect(x * 2, y * 2, 2, 2);
        }
    }

    public void assign(int x, int y, MapColor mc)
    {
        Main.mc[x][y] = mc;
        l_.setText(x / 127D * 100 + "%");
    }
}
