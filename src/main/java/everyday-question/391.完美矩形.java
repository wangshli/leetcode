/*
 * @lc app=leetcode.cn id=391 lang=java
 *
 * [391] 完美矩形
 */

// @lc code=start
/*class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int xmin = rectangles[0][0], ymin = rectangles[0][1] , xmax = rectangles[0][2], ymax = rectangles[0][3];
        for(int i = 0; i < rectangles.length; i++){
            xmin = Math.min(rectangles[i][0], xmin);
            ymin = Math.min(rectangles[i][1], ymin);
            xmax = Math.max(rectangles[i][2], xmax);
            ymax = Math.max(rectangles[i][3], ymax);
        }
        boolean[][] cover = new boolean[xmax - xmin][ymax - ymin];
        for(int i = 0; i < rectangles.length; i++){
            if(cover[rectangles[i][0] - xmin][rectangles[i][1] - ymin] || cover[rectangles[i][0] - xmin][rectangles[i][2] - ymin]
            || cover[rectangles[i][2] - xmin][rectangles[i][1] - ymin] || cover[rectangles[i][2] - xmin][rectangles[i][3] - ymin]){
                return false;
            }else{
                for(int j = rectangles[i][0]; j < rectangles[i][2]; j++){
                    Arrays.fill(cover[j - xmin], rectangles[i][1] - ymin, rectangles[i][3] - ymin, true);
                }
            }
        }
        for(int i = 0; i < cover.length; i++){
            for(int j = 0; j < cover[0].length; j++){
                if(!cover[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}*/
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        long area = 0;
        int minX = rectangles[0][0], minY = rectangles[0][1], maxX = rectangles[0][2], maxY = rectangles[0][3];
        Map<Point, Integer> cnt = new HashMap<Point, Integer>();
        for (int[] rect : rectangles) {
            int x = rect[0], y = rect[1], a = rect[2], b = rect[3];
            area += (long) (a - x) * (b - y);

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, a);
            maxY = Math.max(maxY, b);

            Point point1 = new Point(x, y);
            Point point2 = new Point(x, b);
            Point point3 = new Point(a, y);
            Point point4 = new Point(a, b);

            cnt.put(point1, cnt.getOrDefault(point1, 0) + 1);
            cnt.put(point2, cnt.getOrDefault(point2, 0) + 1);
            cnt.put(point3, cnt.getOrDefault(point3, 0) + 1);
            cnt.put(point4, cnt.getOrDefault(point4, 0) + 1);
        }

        Point pointMinMin = new Point(minX, minY);
        Point pointMinMax = new Point(minX, maxY);
        Point pointMaxMin = new Point(maxX, minY);
        Point pointMaxMax = new Point(maxX, maxY);
        if (area != (long) (maxX - minX) * (maxY - minY) || cnt.getOrDefault(pointMinMin, 0) != 1 || cnt.getOrDefault(pointMinMax, 0) != 1 || cnt.getOrDefault(pointMaxMin, 0) != 1 || cnt.getOrDefault(pointMaxMax, 0) != 1) {
            return false;
        }

        cnt.remove(pointMinMin);
        cnt.remove(pointMinMax);
        cnt.remove(pointMaxMin);
        cnt.remove(pointMaxMax);

        for (Map.Entry<Point, Integer> entry : cnt.entrySet()) {
            int value = entry.getValue();
            if (value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point2 = (Point) obj;
            return this.x == point2.x && this.y == point2.y;
        }
        return false;
    }
}
// @lc code=end

