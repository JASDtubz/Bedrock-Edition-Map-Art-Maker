import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Init
{
    public void init(String s, boolean b0)
    {
        Main m = new Main();
        
        int h, w;
        double d;
        double d_;

        File f = new File(s);
        BufferedImage bi;

        try { bi = ImageIO.read(f); }
        catch (IOException ignored)
        {
            m.l_.setText("Cannot Read File.");
            return;
        }

        assert bi != null;
        
        try
        {
            h = bi.getHeight();
            w = bi.getWidth();
        }
        catch (Exception ignored)
        {
            m.l_.setText("Cannot Get Dimensions");
            return;
        }

        if (h >= 128) { d = (double) h / 128; }
        else
        {
            m.l_.setText("Image height to small.");
            return;
        }

        if (w >= 128) { d_ = (double) w / 128; }
        else
        {
            m.l_.setText("Image width to small");
            return;
        }

        for (double x = 0; x < w; x += d_)
        {
            for (double y = 0; y < h; y += d)
            {
                int length = 0;
                int[][] colors = new int[3][1];

                for (int z = (int) x; z < x + Math.floor(d_); z++)
                {
                    for (int a = (int) y; a < y + Math.floor(d); a++)
                    {
                        length++;
                        int i = bi.getRGB(z, a);
                        Color c = new Color(i, true);
                        
                        int[][] temp = new int[3][length];
                        
                        System.arraycopy(colors[0], 0, temp[0], 0, length - 1);
                        System.arraycopy(colors[1], 0, temp[1], 0, length - 1);
                        System.arraycopy(colors[2], 0, temp[2], 0, length - 1);
                        
                        colors = new int[3][length];
                        
                        System.arraycopy(temp[0], 0, colors[0], length);
                        System.arraycopy(temp[1], 0, colors[1], length);
                        System.arraycopy(temp[2], 0, colors[2], length);

                        int r_ = c.getRed();
                        int g_ = c.getGreen();
                        int b_ = c.getBlue();

                        colors[0][length - 1] = r_;
                        colors[1][length - 1] = g_;
                        colors[2][length - 1] = b_;
                    }
                }

                int rr = 0;
                int gg = 0;
                int bb = 0;

                for (int xx = 0; xx < length; xx++)
                {
                    rr += colors[0][xx];
                    gg += colors[1][xx];
                    bb += colors[2][xx];
                }

                int ra = rr / length;
                int ga = gg / length;
                int ba = bb / length;

                int x_ = (int) Math.ceil(x / d_);
                int y_ = (int) Math.ceil(y / d);

                MapColor mc = new MapColor(ra, ga, ba, b0);

                m.assign(x_, y_, mc);
                System.out.println(x_ + " " + y_ + " " + mc.name);
            }
        }
    }
}
