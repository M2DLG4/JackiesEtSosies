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
    boolean isSosie = false;
    Star idStar;
    Photo idPhoto;

    static constraints = {
        nom blank: false
        prenom blank: false
        mail email: true
        mail unique: true
        mdp blank: false
        ville blank: false
        sexe inList: ["F", "H"]
        idStar nullable: true
    }

    static mapping = {
        isSosie defaultValue: false
        idPhoto defaultValue: new Photo(urlPhoto: "/JackiesEtSosies/static/images/placeholder-membre.png")
    }
}
