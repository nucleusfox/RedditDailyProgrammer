/******************************************************************************
 *  Class: DragonCurveGraphic
 *  Author: nucleusfox
 *
 *  Dragon Curve Graphic
 *  Accepts the number G and prints and draws the dragon curve Gth generation.
 ******************************************************************************/

import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DragonCurveGraphic {
    private static  Color[] PALETTE = new Color[]{
        new Color(119,9,167),
//        new Color(119,9,167),
        new Color(226,0,138),
        new Color(234,3,14),
        new Color(226,88,0),
        new Color(102,203,111),
        new Color(102,203,111),
        new Color(134,203,106),
        new Color(134,203,106),
        new Color(134,203,106),
        new Color(134,203,106),
        new Color(134,203,106),
        new Color(134,203,106),
        new Color(148,221,11),
        new Color(148,221,11),
        new Color(182,221,7),
        new Color(182,221,7),
        new Color(221,208,13),
        new Color(221,208,13),
        new Color(221,195,8),
//        new Color(221,195,8),
        new Color(226,88,0),
//        new Color(234,3,14),
        new Color(226,0,138),
        new Color(119,9,167)
    };

    static class Dragon extends JComponent {
        public final int BEND_STEP = 15;
        public double SIZE_COEFFICIENT = 1;
        private int shiftX = 0;
        private int shiftY = 0;

        public ArrayList<Line2D.Double> lines;

        Dragon(int width, int height, int generation) {
            super();
            if (generation > 10) SIZE_COEFFICIENT = 1.5;
            if (generation > 12) SIZE_COEFFICIENT = 2;
            if (generation > 14) {
                SIZE_COEFFICIENT = 3;
                shiftX += width/2;
                shiftY += height*1.5;
            }
            if (generation > 17) SIZE_COEFFICIENT = 5;
            int w = (int) Math.round(width*SIZE_COEFFICIENT);
            int h = (int) Math.round(height*SIZE_COEFFICIENT);
            setPreferredSize(new Dimension(w,h));
            lines = new ArrayList<>();
        }


        public void bear(short[] dragon, int startX, int startY) {
            lines.add(new Line2D.Double(startX+shiftX, startY+shiftY, startX+shiftX, startY-BEND_STEP/SIZE_COEFFICIENT+shiftY));
            double[] currentPoint = new double[]{startX+shiftX, startY-BEND_STEP/SIZE_COEFFICIENT+shiftY};
            double[] currentVector = new double[]{0, -1};

            for (short d : dragon) {
                if (d == 1) currentVector = RotatingMatrix.rotateLeft(currentVector);
                else currentVector = RotatingMatrix.rotateRight(currentVector);

                Line2D.Double line = new Line2D.Double(
                        currentPoint[0],
                        currentPoint[1],
                        currentPoint[0] + currentVector[0]*BEND_STEP/SIZE_COEFFICIENT,
                        currentPoint[1] + currentVector[1]*BEND_STEP/SIZE_COEFFICIENT
                );
                currentPoint[0] += currentVector[0]*BEND_STEP/SIZE_COEFFICIENT;
                currentPoint[1] += currentVector[1]*BEND_STEP/SIZE_COEFFICIENT;

                lines.add(line);
                repaint();

            }
        }
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, getWidth(), getHeight());
            int color = 0;
            int colorLength = 0;
            int index = 0;
            int generation = 1;

            for (Line2D.Double line : lines) {
                int r = color / 7;
                double k = generation / PALETTE.length;
                double indexDouble = (double) index;
                double i = indexDouble / k;
                if (generation < PALETTE.length*2) i = 5;
                if (i >= PALETTE.length) i = PALETTE.length-1;
                System.out.print("i = " + i + " ");
                g.setColor(PALETTE[(int)i]);
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

                System.out.println("index = " + index + ", generation = " + generation);
                index++;
                if (index == generation) {
                    generation *= 2;
                    index = 0;
                }

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
                Dragon dragon = new Dragon(width, height, G);
                dragon.bear(dragonSequence, width*5/7, height*3/7);

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    return;
                }

                JFrame frame = new JFrame("Dragon Curve " + G);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                JScrollPane scrollPane = new JScrollPane(dragon);
                frame.add(scrollPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        };


        SwingUtilities.invokeLater(rd);
    }

}

