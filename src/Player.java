import java.io.Serializable;

public class Player implements Serializable {  // чтобы серилизовать объект, в него нужно проимплементить интерфейс Serial

    private static final long serialVersionUID = 2;    // если класс будет меняться, то чтобы была возможность его читать и далее нужно добавить эту строку

    private float health;                          // модификаторы на серилизация/десериализация не влияют

    public String name;

    public int armor;

    public int level;


    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }
}
