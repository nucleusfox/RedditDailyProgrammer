/******************************************************************************
 *  Class: DragonCurveGraphic
 *  Author: nucleusfox
 *
 *  Dragon Curve Graphic
 *  Accepts the number G and prints and draws the dragon curve Gth generation.
 ******************************************************************************/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Line2D;

import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DragonCurveGraphic {

    static class Dragon extends JComponent {
        public final int BEND_STEP = 15;
        public ArrayList<Line2D.Double> lines;

        Dragon(int width, int height) {
            super();
            setPreferredSize(new Dimension(width,height));
            lines = new ArrayList<>();
        }


        public void bear(short[] dragon, int startX, int startY) {
            lines.add(new Line2D.Double(startX, startY, startX, startY-BEND_STEP));
            int[] currentPoint = new int[]{startX, startY-BEND_STEP};
            int[] currentVector = new int[]{0, -1};

            for (short d : dragon) {
                if (d == 1) currentVector = RotatingMatrix.rotateLeft(currentVector);
                else currentVector = RotatingMatrix.rotateRight(currentVector);

                Line2D.Double line = new Line2D.Double(
                        currentPoint[0],
                        currentPoint[1],
                        currentPoint[0] + currentVector[0]*BEND_STEP,
                        currentPoint[1] + currentVector[1]*BEND_STEP
                );
                currentPoint[0] += currentVector[0] *BEND_STEP;
                currentPoint[1] += currentVector[1]*BEND_STEP;

                lines.add(line);
                repaint();

            }
        }
        public void paintComponent(Graphics g) {

            g.setColor(Color.white);
            g.fillRect(0, 0, getWidth(), getHeight());
            int color = 0;
            int colorLength = 0;

            for (Line2D.Double line : lines) {
                int r = color / 7;
                switch(r) {
                    case 0 : g.setColor(Color.yellow); break;
                    case 1 : g.setColor(Color.orange); break;
                    case 2 : g.setColor(Color.red); break;
                    case 3 : g.setColor(Color.magenta); break;
                    case 4 : g.setColor(Color.blue); break;
                    case 5 : g.setColor(Color.cyan); break;
                    case 6 : g.setColor(Color.green); break;
                }
                colorLength ++;
                color += colorLength / 10;
                colorLength = colorLength % 11;
                color = color % 200;


                g.drawLine(
                        (int)line.getX1(),
                        (int)line.getY1(),
                        (int)line.getX2(),
                        (int)line.getY2()
                );
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the generation number.");
        int G = new Scanner(System.in).nextInt();
        short[] dragonSequence = E359.getSequence(G);
        E359.printSequence(dragonSequence);

        Runnable rd = new Runnable() {
            public void run() {
                int width = 1600, height = 1000;
                Dragon dragon = new Dragon(width, height);
                dragon.bear(dragonSequence, width*5/7, height*3/7);

                JOptionPane.showMessageDialog(null, dragon);
            }
        };
        SwingUtilities.invokeLater(rd);
    }

}

