import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Player implements Serializable {  // чтобы серилизовать объект, в него нужно проимплементить интерфейс Serial

    private static final long serialVersionUID = 2;    // если класс будет меняться, то чтобы была возможность его читать и далее нужно добавить эту строку

    private float health;                          // модификаторы на серилизация/десериализация не влияют

    public String name;

    public int armor;

    public int level;

    public int age;

    public double test;


    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//        try {
//            ois.defaultReadObject();
//        } catch (Exception e) {
//            System.out.println("ERROR");
//        }
        // дальнейший код обычн пишется в catch для десериализации
        ObjectInputStream.GetField field = ois.readFields();
    }
}
