package jackiesetsosies
/*
    Modele du Star
 */
class Star {
    String nom;
    String prenom;
    String urlPhoto;

    static constraints = {
        nom blank: false
        prenom blank: false
        urlPhoto blank: false
    }

    @Override
    public String toString() {
        return "Star{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Star star = (Star) o

        if (nom != star.nom) return false
        if (prenom != star.prenom) return false
        if (urlPhoto != star.urlPhoto) return false

        return true
    }

    int hashCode() {
        int result
        result = nom.hashCode()
        result = 31 * result + prenom.hashCode()
        result = 31 * result + urlPhoto.hashCode()
        return result
    }
}
