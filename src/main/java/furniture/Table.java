package furniture;

public class Table extends Item {
    private String shape;

    public Table(String name, double area, String shape) {
        super(name, area);
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
