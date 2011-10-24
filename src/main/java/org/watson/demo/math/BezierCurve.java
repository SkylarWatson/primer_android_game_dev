package org.watson.demo.math;

import java.util.LinkedList;

public class BezierCurve {
    public LinkedList<Point> getCalculatedPoints(Point p1, Point p2, Point c1, Point c2) {
        LinkedList<Point> points = new LinkedList<Point>();
        for(float t = 0; t <= 1; t+=.005) {
            double px = Math.pow(1-t, 3) * p1.getX() + 3 * Math.pow(1-t, 2) * t * c1.getX() + 3 * (1-t) * Math.pow(t, 2) * c2.getX() + Math.pow(t, 3) * p2.getX();
            double py = Math.pow(1-t, 3) * p1.getY() + 3 * Math.pow(1-t, 2) * t * c1.getY() + 3 * (1-t) * Math.pow(t, 2) * c2.getY() + Math.pow(t, 3) * p2.getY();
            points.add(new Point(px, py));
        }

        return points;
    }
}