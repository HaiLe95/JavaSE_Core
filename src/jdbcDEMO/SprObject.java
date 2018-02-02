package jdbcDEMO;

public class SprObject {

    private int id;
    private String name_en;
    private String name_ru;

    public SprObject(int id, String name_en, String name_ru) {
        this.id = id;
        this.name_en = name_en;
        this.name_ru = name_ru;
    }

    public SprObject() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }
}
