package org.watson.demo.movement.jump;

import org.watson.demo.game.Board;
import org.watson.demo.math.BezierCurve;
import org.watson.demo.math.Point;

import java.util.LinkedList;

public class JumpCurveCalulator {
    public LinkedList<Point> getJumpMovements(Board board, float x, float y) {
        float halfWayForControl = (x + (x + (board.getWidth()) / 3)) / 2;
        return new BezierCurve().getCalculatedPoints(
                new Point(x, y),
                new Point(x + (board.getWidth() / 3), y),
                new Point(halfWayForControl, board.getHeight() / 2),
                new Point(halfWayForControl, board.getHeight() / 2));
    }
}
