package assignments.pojo;

public class PetTagsModel {
    private int id;
    private String name;

    public PetTagsModel() {
    }

    public PetTagsModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PetTagsModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}