import java.util.Objects;

class Data{
    private int id;
    private String name;
    private double per;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", per=" + per +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id && Double.compare(data.per, per) == 0 && name.equals(data.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, per);
    }
}
public class EncapsulationJAVA {
    public static void main(String[] args) {
        Data d1 = new Data();
        d1.setId(1);
        d1.setName("java");
        d1.setPer(34.5);
        System.out.println(d1);
        Data d2 = new Data();
        d2.setId(1);
        d2.setName("java");
        d2.setPer(34.5);
        System.out.println(d1.equals(d2));
    }
}
