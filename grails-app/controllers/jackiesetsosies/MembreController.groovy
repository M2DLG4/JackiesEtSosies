package jackiesetsosies

class MembreController {

    public static
    final String INSCRIPTION_OK = "Inscription terminée ! Vous pouvez maintenant vous connecter."
    final String INSCRIPTION_NOK = "Inscription impossible ! Veuillez réessayer."
    def membreService

    @Override
    def index() {
    }

    def inscription() {
        if (params.isSosie)
            params.isSosie = params.boolean("isSosie")
        else
            params.isSosie = false;
        Membre membre = new Membre(nom: params.nom, prenom: params.prenom, ville: params.ville,
                sexe: params.sexe, isSosie: params.isSosie, mail: params.mail, mdp: params.mdp);

        String validationInscription;

        if (!membreService.inscriptionMembre(membre)?.hasErrors()) {
            validationInscription = INSCRIPTION_OK;
        } else {
            validationInscription = INSCRIPTION_NOK;
        }

        render(view: "index", model: [validation:validationInscription])
    }

    def connexion() {
        def mail = params.mail
        def mdp = params.mdp

        session.setAttribute("user", membreService.connexionMembre(mail, mdp))

        System.out.println(session.getAttribute("user"))
        render(view: "index")
    }


}
