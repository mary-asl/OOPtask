public class Lamp {
    double light;

    public Lamp(double light) {
        this.light = light;
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    @Override
    public String toString() {
        return "lamp " + light + " lk ";
    }
}
