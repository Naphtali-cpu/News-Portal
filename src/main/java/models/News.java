package models;

import java.util.Objects;

public class News {
    private int id;
    private String title;
    private String content;
    private Integer departmentId;
    private String type;
    private String type2;
    private String type3;
    private String type4;
    private String type5;
    private String type6;
    private String type7;
    private String type8;
    private String type9;
    private String type10;
    private String type11;
    private String type12;
    private String type13;
    private String type14;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                departmentId == news.departmentId &&
                title.equals(news.title) &&
                content.equals(news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, departmentId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public News(String title, String content, int departmentId) {
        this.title = title;
        this.content = content;
        this.departmentId = departmentId;
    }
    public News(String type, String type2, String type3, String type4, String type5, String type6, String type7, String type8, String type9, String type10, String type11, String type12, String type13, String type14){
        this.type = type;
        this.type2 = type2;
        this.type3 = type3;
        this.type4 = type4;
        this.type5 = type5;
        this.type6 = type6;
        this.type7 = type7;
        this.type8 = type8;
        this.type9 = type9;
        this.type10 = type10;
        this.type11 = type11;
        this.type12 = type12;
        this.type13 = type13;
        this.type14 = type14;
    }

    public String getType() {
        return type;
    }

    public String getType2() {
        return type2;
    }

    public String getType3() {
        return type3;
    }

    public String getType4() {
        return type4;
    }

    public String getType5() {
        return type5;
    }

    public String getType6() {
        return type6;
    }
    public String getType7() {
        return type7;
    }
    public String getType8() {
        return type8;
    }
    public String getType9() {
        return type9;
    }
    public String getType10() {
        return type10;
    }
    public String getType11() {
        return type11;
    }
    public String getType12() {
        return type12;
    }
    public String getType13() {
        return type13;
    }
    public String getType14() {
        return type14;
    }
}
