package linesweeping.linesegment;

import linesweeping.Point;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 라인 스위핑은 선분 교차 문제 또는 최근접 쌍 문제 등을 해결하는데 효율적인 알고리즘입니다.
 * 다음 예제는 선분 교차 문제를 해결합니다.
 * 예제에 주어진 선분들은 (x1, y1), (x2, y2)로 표현되며 각 선분들은 시작점과 끝점을 가지고 있습니다.
 */
public class LineSegmentIntersection {

    /**
     * doIntersect()는 두 개의 선분이 교차하는지 검사합니다.
     * 함수는 크게 3가지 경우를 검사하고 있습니다.
     */
    public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        /**
         * 두 선분이 서로 다른 방향으로 교차하는 경우
         */
        if (o1 != o2 && o3 != o4) {
            return true;
        }

        /**
         * 두 선분이 평행한 경우
         */
        if (o1 == 0 && onSegment(p1, p2, q1)) {
            return true;
        }

        if (o2 == 0 && onSegment(p1, q2, q1)) {
            return true;
        }

        if (o3 == 0 && onSegment(p2, p1, q2)) {
            return true;
        }

        if (o4 == 0 && onSegment(p2, q1, q2)) {
            return true;
        }

        /**
         * 나머지 경우는 교차하지 않음.
         */
        return false;
    }


    /**
     * orientation()은 세 점의 방향을 검사합니다.
     */
    public static int orientation(Point p, Point q, Point r) {
        /**
         * 세 점이 직선상에 있는 경우 0을 반환합니다.
         */
        int val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val == 0) return 0;

        /**
         * 세 점이 시계 방향 또는 반시계 방향으로 배열된 상태라면 1 또는 2를 반환합니다.
         */
        return val > 0 ? 1 : 2;
    }


    /**
     * onSegment()는 선분과 점의 관계를 검사합니다.
     * 주어진 선분(p, q)와 점(r)의 관계를 확인하여 점(r)이 선분(p, q) 위에 있는지 판단합니다.
     * 이 함수는 선분 교차를 확인하기 위해 doIntersect()에서 사용되며, 각 선분의 끝점이 다른 선분 위에 있는지를 확인합니다.
     */
    public static boolean onSegment(Point p, Point q, Point r) {
        return q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX())
                && q.getY() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY());
    }

    public static void main(String[] args) {
        List<LineSegment> segments = new ArrayList<>();
        segments.add(new LineSegment(new Point(1,1), new Point(10,1)));
        segments.add(new LineSegment(new Point(1,2), new Point(10,2)));
        segments.add(new LineSegment(new Point(10,1), new Point(10,10)));
        segments.add(new LineSegment(new Point(1,3), new Point(10,3)));

        /**
         * 시작점과 끝점을 기준으로 선분들을 정렬합니다.
         */
        segments.sort(Comparator.comparingInt(a -> a.getStart().getX()));

        for(int i = 0; i < segments.size(); i++) {
            LineSegment current = segments.get(i);
            for (int j = i + 1; j < segments.size(); j++) {
                LineSegment other = segments.get(j);
                if (doIntersect(current.getStart(), current.getEnd(), other.getStart(), other.getEnd())) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
}
