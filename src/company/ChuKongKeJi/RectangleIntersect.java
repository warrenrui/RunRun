package company.ChuKongKeJi;

// 两个矩形都是平行于X,Y轴，判断是否相交。两种方法，都需要检查特殊情况。
public class RectangleIntersect {
    // 方法一：矩阵在X,Y轴上的投影都在另一矩形投影的一侧，则矩阵必定无交集；否则，有交集。
    boolean isRectIntersect(Rectangle a, Rectangle b) {
        // 需要排除特殊情况：一个矩形在另一个矩形内
        if ((a.top < b.top && a.bottom > b.bottom && a.right < b.right && a.left > b.left)
                || (b.top < a.top && b.bottom > a.bottom && b.right < a.right && b.left > a.left)) {
            return false;
        }
        if ((a.top < b.bottom && a.right < b.left) || (a.bottom > b.top && a.left > b.right)) {
            return false;
        }
        return true;
    }

    // 方法二：若两矩形的中心满足一定的条件，则必定相交
    boolean isRectIntersect2(Rectangle a, Rectangle b) {
        float aCenterX = (a.left + a.right) / 2;
        float aCenterY = (a.bottom + a.top) / 2;
        float bCenterX = (b.left + b.right) / 2;
        float bCenterY = (b.bottom + b.top) / 2;
        float radiusX = (a.right - a.left) / 2 + (b.right - b.left) / 2;
        float radiusY = (a.top - a.bottom) / 2 + (b.top - b.bottom) / 2;
        // 需要排除特殊情况：一个矩形在另一个矩形内
        if ((a.top < b.top && a.bottom > b.bottom && a.right < b.right && a.left > b.left)
                || (b.top < a.top && b.bottom > a.bottom && b.right < a.right && b.left > a.left)) {
            return false;
        }
        if ((Math.abs(aCenterX - bCenterX) < radiusX) || (Math.abs(aCenterY - bCenterY) < radiusY)) {
            return true;
        }
        return false;
    }

    // 若两矩形相交，相交区域必定有：top = min(top),bottom = max(bottom),right =
    // min(right),left = max(left)
    float intersectArea(Rectangle a, Rectangle b) {
        if (isRectIntersect(a, b)) {
            return (Math.min(a.top, b.top) - Math.max(a.bottom, b.bottom)) * (Math.min(a.right, b.right) - Math.max(a.left, b.left));
        }
        return 0;
    }

    public static void main(String[] args) {
        Rectangle ra = new Rectangle(0, 3, 0, 6);
        Rectangle rb = new Rectangle(2, 4, 2, 4);
        RectangleIntersect r = new RectangleIntersect();
        if (r.isRectIntersect(ra, rb)) {
            System.out.println("两矩阵相交");
        } else {
            System.out.println("两矩形不相交");
        }
        if (r.isRectIntersect2(ra, rb)) {
            System.out.println("两矩阵相交");
        } else {
            System.out.println("两矩形不相交");
        }

        System.out.println("相交区域面积： " + r.intersectArea(ra, rb));
    }
}

class Rectangle {
    // 分别表示最上下左右上的坐标
    float left;
    float right;
    float bottom;
    float top;

    Rectangle(float left, float right, float bottom, float top) {
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
