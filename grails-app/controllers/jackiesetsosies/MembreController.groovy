package jackiesetsosies

class MembreController {

    def membreService

    def index() {
    }

    def inscription() {
        def prenom = params.prenom
        def nom = params.nom
        def mail = params.mail
        def ville = params.ville
        Boolean isSosie = params.boolean("isSosie")
        def mdp = params.mdp
        def sexe = params.sexe
        //def star = params["star"]
        //def photo = params["photo"]

        String validationInscription;

        if (membreService.inscriptionMembre(prenom, nom, sexe, mail, ville, isSosie, mdp) == null) {
            validationInscription = "Inscription terminée ! Vous pouvez maintenant vous connecter.";
        } else {
            validationInscription = "Inscription impossible ! Veuillez réessayer.";
        }

        render(view: "index", model: [validation:validationInscription])
    }

    def connexion() {
        def mail = params.mail
        def mdp = params.mdp

        membreService.connexionMembre(mail, mdp)

        render(view: "index")
    }


}
