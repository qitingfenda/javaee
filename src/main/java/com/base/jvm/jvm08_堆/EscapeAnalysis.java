package com.base.jvm.jvm08_堆;

/**
 * 逃逸分析
 * <p>
 * 如何快速的判断是否发生了逃逸分析，看new的对象实体是否有可能在方法外被调用
 *
 * @author yhc
 * @create 2021-04-18 14:37
 */
public class EscapeAnalysis {

    public EscapeAnalysis obj;

    /**
     * 方法返回EscapeAnalysis对象，发生逃逸
     */
    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }

    /**
     * 为成员属性复制，发生逃逸
     */
    public void setObj() {
        this.obj = new EscapeAnalysis();
    }

    // 思考：如果当前的obj声明为static的，还会发生逃逸吗？仍然会发生逃逸

    /**
     * 对象的作用域仅在当前方法中有效，没有发生逃逸
     */
    public void useEscapeAnalysis() {
        EscapeAnalysis e = new EscapeAnalysis();
    }

    /**
     * 引用成员变量的值，发生逃逸
     */
    public void useEscapeAnalysis1() {
        EscapeAnalysis e = getInstance();
    }

    public static void main(String[] args) {
        alloc();
    }

    private static void alloc() {
        Point point = new Point(1, 2);
        System.out.println("point.x=" + point.x + "; point.y=" + point.y);
    }

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
