package assignments.pojo;

public class PetCategoryModel {
    private int id;
    private String name;

    public PetCategoryModel() {
    }

    public PetCategoryModel(int id, String name) {
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
        return "PetCategoryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
