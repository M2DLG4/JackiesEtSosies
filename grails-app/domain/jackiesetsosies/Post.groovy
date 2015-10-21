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
    static belongsTo = [membre: Membre]

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
                ", membre=" + membre +
                '}';
    }
}
