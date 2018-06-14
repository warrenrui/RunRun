package company.ChuKongKeJi;

public class RectangleIntoCircle {

    boolean isInteract(Rectangle2 r, Circle c) {
        // 不相交三种情况：
        // ①圆形小，在矩形中；
        // ②矩形小，在圆形中；
        // ③圆心在矩形top和bottom范围内，或者圆心在矩形left和right范围内，圆心到矩心距离大于rc+rr；否则圆心到矩心距离大于
        // rr + 矩形对角线一半。
        if ((r.right - c.x) > c.radius && (c.x - r.left) > c.radius && (r.top - c.y) > c.radius && (c.y - r.bottom) > c.radius) {
            return false;
        }
        if (true) {

        }
        return true;
    }
}

class Rectangle2 {
    // 分别表示最上下左右上的坐标，矩形与X,Y轴平行
    float left;
    float right;
    float bottom;
    float top;

    Rectangle2(float left, float right, float bottom, float top) {
        if (left >= right || top <= bottom) {
            System.out.println("矩形坐标初始化错误！");
            return;
        }
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }
}

class Circle {
    // 圆心半径
    float x;
    float y;
    float radius;

    Circle(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}