package linesweeping.closestpair;

import linesweeping.Point;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClosestPairProblem {

    /**
     * 두 점 사이의 유클리드 거리를 계산합니다.
     * 유클리드 거리란 2차원 또는 다차원 공간에서 두 점 사이의 직선 거리를 의미합니다.
     */
    public static double euclideanDistance(Point p1, Point p2) {
        int dx = p1.getX() - p2.getX();
        int dy = p1.getY() - p2.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * 최근접 쌍을 찾는 함수입니다.
     */
    public static double closestPair(List<Point> points) {
        /**
         * x 좌표를 기준으로 점들을 정렬합니다.
         */
        points.sort(Comparator.comparingInt(Point::getX));
        /**
         * 재귀함수를 호출합니다.
         */
        return closestPairRecursive(points, 0, points.size() - 1);
    }

    /**
     * 재귀적으로 최근접 쌍을 찾습니다.
     */
    public static double closestPairRecursive(List<Point> points, int left, int right) {
        /**
         * 하나의 점만 존재하는 경우, 무한대로 설정하여 해당 점이 최근접 쌍이 아님을 표시하는 기저 사례를 설정합니다.
         */
        if (right - left == 0) return Double.POSITIVE_INFINITY;

        /**
         * 중앙을 기준으로 점들을 두 그룹으로 분할하고 각 그룹에서 최근접 쌍의 거리를 계산합니다.
         */
        int mid = (left + right) / 2;
        double leftMinDist = closestPairRecursive(points, left, mid);
        double rightMinDist = closestPairRecursive(points, mid + 1, right);

        /**
         * 두 그룹의 거리 중 최소값을 구합니다.
         */
        double minDist = Math.min(leftMinDist, rightMinDist);

        /**
         * 중앙부근에서 최근접 쌍을 찾는 라인 스위핑을 위해 포함될 점들을 선택합니다.
         */
        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int dx = points.get(i).getX() - points.get(mid).getX();
            /**
             * 중앙과 x 좌표의 차이가 최근접 쌍 거리보다 작은 점플을 포함합니다.
             */
            if (Math.abs(dx) < minDist) {
                strip.add(points.get(i));
            }
        }

        /**
         * y 좌표를 기준으로 점들을 정렬합니다.
         */
        strip.sort(Comparator.comparingInt(Point::getY));

        /**
         * 중앙부근에서 최근접 쌍을 찾기 위해 라인 스위핑을 수행합니다.
         */
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && strip.get(j).getY() - strip.get(i).getY() < minDist; j++) {
                /**
                 * 라인 스위핑 중 y 좌표 차이가 최근접 쌍 거리보다 작은 점들의 사이의 거리를 계산합니다.
                 */
                double dist = euclideanDistance(strip.get(i), strip.get(j));
                /**
                 * 최근접 쌍의 거리를 갱신합니다.
                 */
                minDist = Math.min(minDist, dist);
            }
        }

        /**
         * 최단거리를 반환합니다.
         */
        return minDist;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(5, 5));
        points.add(new Point(9, 3));
        points.add(new Point(4, 6));
        points.add(new Point(8, 7));
        points.add(new Point(2, 10));

        double closestDistance = closestPair(points);
        System.out.println(closestDistance);
    }
}
