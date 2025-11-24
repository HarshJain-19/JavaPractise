package encapsulation;

class Angle {

    private double angleInDegrees;

    private Angle(){}

    public static Angle angleFromDegrees(double degrees){
        Angle a = new Angle();
        a.angleInDegrees = degrees;
        return a;
    }

    public static Angle angleFromRadians(double radians){
        Angle a = new Angle();
        a.angleInDegrees = radians*180/Math.PI;
        return a;
    }

    public double getDegrees(){
        return angleInDegrees;
    }

    public double getRadians(){
        return angleInDegrees*Math.PI / 180;
    }

    public void setDegrees(double degrees){
        this.angleInDegrees = degrees;
    }

    public void setRadians(double radians){
        this.angleInDegrees = radians*180/Math.PI;
    }
}

public class EncapsulationPractise {
    public static void main(String[] args) {
        Angle a1 = Angle.angleFromDegrees(200);
        a1.setRadians(180);
        System.out.println(a1.getDegrees());
    }
}
