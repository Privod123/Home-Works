package dao;

public class Article {
    static int countArticle = 0;
    int id;
    String title;
    int idUser;

    public Article() {
        this.id = countArticle++;
    }

    public Article(String title, int idUser) {
        this.id = countArticle++;
        this.title = title;
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}
