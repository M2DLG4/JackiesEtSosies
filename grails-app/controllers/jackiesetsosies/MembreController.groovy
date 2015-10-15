package jackiesetsosies

class MembreController {

    public static
    final String INSCRIPTION_OK = "Inscription terminée ! Vous pouvez maintenant vous connecter."
    final String INSCRIPTION_NOK = "Inscription impossible ! Veuillez réessayer."
    final String CONNEXION_OK = "Vous êtes maintenant connecté."
    final String CONNEXION_NOK = "Mail ou mot de passe erroné."
    final String EDITION_OK = "La mise à jour du profil a été réalisé."
    final String EDITION_NOK = "Mise à jour du profil impossible."
    final String PROFIL_NOK = "<img src='http://www.oyez-perigord.fr/Oyez_Perigord/de_linsolite_au_rigolo/Entrees/2014/8/1_Johnny_Depp,_cest_lui_files/shapeimage_3.png' /><h3>Le membre n'existe pas</h3>"
    final String SUIVRE_OK = "Vous suivez maintenant cet utilisateur."
    final String SUIVRE_NOK = "Impossible de suivre l'utilisateur."

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

        Membre membreinscrit = membreService.inscriptionMembre(membre)

        if (membreinscrit != null && !membreinscrit.hasErrors()) {
            flash.message = INSCRIPTION_OK
        } else {
            flash.error = INSCRIPTION_NOK
        }

        render(view: "index")
    }

    def connexion() {
        def mail = params.mail
        def mdp = params.mdp

        Membre membre = membreService.connexionMembre(mail, mdp)

        if (membre == null) {
            render(view: "index")
            flash.error = CONNEXION_NOK
        } else {
            flash.message = CONNEXION_OK
            session.setAttribute("user", membre)
            redirect(action: "profil", id: membre.getId())
        }
    }

    def deconnexion() {
        session.removeAttribute("user")
        session.removeAttribute("mail")
        redirect action: "index"
    }

    def actus() {
        render(view: "actus")
    }

    def profil() {
        Membre membre = membreService.getMembre(Integer.parseInt(params.get("id")))
        Boolean isFollowing = false

        if (membre != null) {
            isFollowing = membreService.isFollowingMembre(session.getAttribute("user").getId(), membre.id)
            System.out.println("Relation de suivi : "+isFollowing)
            render(view: "profil", model: [membre: membre, suivi: isFollowing])
        } else {
            render(layout: "main", text: PROFIL_NOK)
        }
    }

    def edit() {
        render(view: "edit")
    }

    def edition() {
        if (params.isSosie)
            params.isSosie = params.boolean("isSosie")
        else
            params.isSosie = false

        if (membreService.editionMembre(session.getAttribute("user"), params)) {
            session.setAttribute("user", membreService.getMembre(session.getAttribute("user").id));
            flash.message = EDITION_OK
        } else {
            flash.error = EDITION_NOK
        }

        redirect(action: "profil", id: session.getAttribute("user").getId())
    }

    def add() {
        SuivreMembre sm = null

        System.out.println("Id cible = "+params.getLong("id")+" - Id session = "+session.getAttribute("user").getId())
        if (params.getLong("id") != session.getAttribute("user").getId()) {
            sm = membreService.addSuivreMembre(session.getAttribute("user").getId(), params.getLong("id"))
        }

        if (sm == null) {
            flash.error = SUIVRE_NOK
        } else {
            flash.message = SUIVRE_OK
        }

        redirect(action: "profil", id: params.get("id"))
    }
}