public class Lamp {
    private int light;

    public Lamp(int light) {
        this.light = light;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    @Override
    public String toString() {
        return "lamp " + light + " lk ";
    }
}
