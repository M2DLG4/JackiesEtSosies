package jackiesetsosies

/**
 * Created by lgaleron on 08/10/2015.
 *
 * Model  Post
 */
class Post {
    Date date;
    String message;
    int nbLikes;
    Membre membre

    static constraints = {
        date blank: false
        message blank: false
    }

    static mapping = {
        nbLikes defaultValue: 0
    }

    @Override
    public String toString() {
        return "Post{" +
                " date=" + date +
                ", message='" + message + '\'' +
                ", nbLikes=" + nbLikes +
                ", membre=" + membre.getNom() + " " + membre.getPrenom() +
                '}';
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Post post = (Post) o

        if (id != post.id) return false

        return true
    }

}
