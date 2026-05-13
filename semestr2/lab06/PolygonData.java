import java.util.ArrayList;


class PolygonData extends ShapeData {
    private ArrayList<Double> points;

    public PolygonData(ArrayList<Double> p){
        points = new ArrayList<Double>();
        for (Double point : p) {
            points.add(point);
        }
    }

    public ArrayList<Double> getPoints(){
        return points;
    }
}