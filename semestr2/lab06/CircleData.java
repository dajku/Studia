class CircleData extends ShapeData {
    private double radius;
    private double centerX;
    private double centerY;

    public CircleData(double x, double y, double r) {
        radius = r;
        centerX = x;
        centerY = y;
    }

    public double getRadius(){
        return radius;
    }

    public double getCenterX(){
        return centerX;
    }
    
    public double getCenterY(){
        return centerY;
    }
    
}
