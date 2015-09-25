package jackiesetsosies
/*
    Modele du Star
 */
class Star {
    String nom;
    String prenom;
    Photo urlPhoto;

    static constraints = {
        nom blank: false
        prenom blank: false
        urlPhoto blank: false
    }
}
