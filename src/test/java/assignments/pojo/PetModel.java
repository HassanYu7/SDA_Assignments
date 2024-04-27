package assignments.pojo;
import java.util.List;

public class PetModel {
    private long id;
    private PetCategoryModel category;
    private String name;
    private List<String> photoUrls;
    private List<PetTagsModel> tags;
    private String status;

    public PetModel() {
    }

    public PetModel(long id, PetCategoryModel category, String name, List<String> photoUrls, List<PetTagsModel> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public PetCategoryModel getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<PetTagsModel> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategory(PetCategoryModel category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetModel{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
