package exampledem;

abstract class TwoDShape {
    private double width;
    private double height;
    private String name;

    TwoDShape(){
        width = height = 0.0;
        name = "none";
    }

    TwoDShape(double w, double h, String n){
        width = w;
        height = h;
        name = n;
    }

    TwoDShape(double x, String n){
        width = height = x;
        name = n;
    }

    TwoDShape(TwoDShape ob){
        width = ob.width;
        height = ob.height;
        name = ob.name;
    }

    double getWidth(){
        return width;
    }
    void setWidth(double w){
        width = w;
    }
    double getHeight(){
        return height;
    }
    void setHeight(double h){
        height = h;
    }

    String getName(){
        return name;
    }

    void showDim(){
        System.out.println("Width and height: " + width + " " + height);
    }

    abstract double area();
}

class Triangle extends TwoDShape{
    private String style;

    Triangle(){
        super();
        style = "indefinite";
    }

    Triangle(String s, double w, double h){
        super(w, h, "triangle");
        style = s;
    }

    Triangle(double x){
        super(x, "triangle");
        style = "full";
    }

    Triangle(Triangle ob){
        super(ob);
        style = ob.style;
    }

    double area(){
        return getWidth() * getHeight() / 2;
    }

    void showStyle(){
        System.out.println("Triangle is " + style);
    }
}

class Rectangle extends TwoDShape{
    Rectangle(){
        super();
    }

    Rectangle(double w, double h){
        super(w, h, "rectangle");
    }

    Rectangle(double x){
        super(x, "rectangle");
    }

    Rectangle(Rectangle ob){
        super(ob);
    }

    boolean isSquare(){
        if (getWidth() == getHeight()) return true;
        return false;
    }

    double area(){
        return getWidth() * getHeight();
    }
}

class DynShapes{
    public static void main(String[] args) {
        TwoDShape shapes[] = new TwoDShape[4];

        shapes[0] = new Triangle("empty", 8.0, 12.0);
        shapes[1] = new Rectangle(10);
        shapes[2] = new Rectangle(10, 4);
        shapes[3] = new Triangle(7.0);
        //shapes[4] = new TwoDShape(10, 20, "general");

        for (int i = 0; i<shapes.length; i++){
            System.out.println("Type objects: " + shapes[i].getName());
            System.out.println("Area is: " + shapes[i].area());
            System.out.println();
        }

    }
}