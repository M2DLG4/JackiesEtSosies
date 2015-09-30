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
    Photo idPhoto;

    static constraints = {
        nom blank: false
        prenom blank: false
        mail email: true
        mail unique: true
        mdp blank: false
        ville blank: false
        sexe inList: ["F", "H"]
        isSosie nullable: false
        idStar nullable: true
        idPhoto nullable: true
    }
}
