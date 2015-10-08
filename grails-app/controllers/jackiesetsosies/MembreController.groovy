package jackiesetsosies

class MembreController {

    public static
    final String INSCRIPTION_OK = "Inscription terminée ! Vous pouvez maintenant vous connecter."
    final String INSCRIPTION_NOK = "Inscription impossible ! Veuillez réessayer."
    final String CONNEXION_OK = "Vous êtes maintenant connecté."
    final String CONNEXION_NOK = "Mail ou mot de passe erroné."
    final String EDITION_OK = "La mise à jour du profil a été réalisé."
    final String EDITION_NOK = "Mise à jour du profil impossible."

    def membreService

    @Override
    def index() {
        render view: "index"
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

        Membre membre = membreService.connexionMembre(mail, mdp)

        if (membre == null) {
            render(view: "index", model: [erreur: CONNEXION_NOK])
        } else {
            session.setAttribute("user", membre)
            redirect(action: "profil", id: membre.getId())
        }
    }

    def deconnexion() {
        session.removeAttribute("user")
        session.removeAttribute("mail")
    }

    def actus() {
        render(view: "actus")
    }

    def profil() {
        System.out.println("PASSE DANS PROFIL")
        Membre membre = membreService.getMembre(Integer.parseInt(params.get("id")))
        System.out.println("MEMBRE : "+membre)
        render(view: "profil", model: [membre:membre])
    }

    def edit() {
        render(view: "edit")
    }

    def edition() {
        if (params.isSosie)
            params.isSosie = params.boolean("isSosie")

        String validationEdition;
        if (membreService.editionMembre(session.getAttribute("user"), params)) {
            validationEdition = EDITION_OK;
        } else {
            validationEdition = EDITION_NOK;
        }
        render(controller: "Membre", view: "profil", model: [validation:validationEdition])
    }
}
