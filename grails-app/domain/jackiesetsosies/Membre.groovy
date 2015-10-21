package jackiesetsosies
/*
    Modele du Membre
 */
class Membre {
    String nom;
    String prenom;
    String mail;
    String mdp;
    String ville;
    String sexe;
    boolean isSosie;
    Star idStar;
    String urlPhoto;
    static hasMany = [posts:Post]

    static constraints = {
        nom blank: false
        prenom blank: false
        mail email: true, unique: true
        mdp blank: false
        ville blank: false
        sexe inList: ["F", "H"]
        idStar nullable: true
        urlPhoto nullable: true
    }

    static mapping = {
        isSosie defaultValue: false
        id column: 'member_id'
        posts fetch: 'join', cascade: 'all'
    }

    @Override
    public String toString() {
        return "Membre{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", mdp='" + mdp + '\'' +
                ", ville='" + ville + '\'' +
                ", sexe='" + sexe + '\'' +
                ", isSosie=" + isSosie +
                ", idStar=" + idStar +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Membre membre = (Membre) o

        if (mail != membre.mail) return false

        return true
    }

    int hashCode() {
        return mail.hashCode()
    }
}
