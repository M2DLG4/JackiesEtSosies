package jackiesetsosies



import spock.lang.*
import org.springframework.web.context.request.RequestContextHolder
/**
 *
 */
class MembreControllerSpec extends Specification {

    void "test inscription d'un membre"() {
        given:"une liste de parametre"
        def membreController = new MembreController();
        membreController.request.parameters = [nom: "UnNom", prenom: "UnPrenom", ville: "UneVille",
                                               sexe: "F", isSosie: "true", mail: "uneadresse@email.fr", star: "1", mdp: "1234"];

        when: "on inscrit le membre"
        membreController.inscription()

        then: "le membre a été crée"
        assert Membre.findByMail("uneadresse@email.fr")!= null
    }

    void "test connexion d'un membre"() {
        given:"une liste de parametre"
        def membreController = new MembreController();
        membreController.request.parameters = [mail: "pat.perdu@wanadoo.net", mdp: "1234"];

        when: "on inscrit le membre"
        membreController.connexion()

        then: "la session est bien initiaialsisielsieielsie"
        membreController.flash.message == membreController.CONNEXION_OK
    }

    void "test edition d'un membre"() {
        given:"une liste de parametre"
        def membreController = new MembreController();
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", Membre.findByMail("pat.perdu@wanadoo.net"));

        when: "on affiche le membre"
        membreController.edition()

        then:
        membreController.flash.message == membreController.EDITION_OK
    }

    void "test rechercher un membre"() {
        given:"une liste de parametre"
        def rechercheController = new RechercheController();
        rechercheController.request.parameters = [text: "Dark"];

        when: "on affiche le membre"
        rechercheController.index()

        then:
        1==1
    }

    void "test suppression d'un membre"() {
        given:"une liste de parametre"
        def membreController = new MembreController();
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", Membre.findByMail("pat.perdu@wanadoo.net"));

        when: "on le supprime"
        membreController.suppression()

        then:
        membreController.flash.message == membreController.SUPRESSION_OK
    }


    void "test add d'un membre vers un autre"() {
        given:"une liste de parametre"
        def membreController = new MembreController();
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", Membre.findByMail("pat.perdu@wanadoo.net"));
        membreController.request.parameters = [id: Membre.findByMail("dark@vador.fr").id + ""];

        when: "on ajouter le lien d'amitié"
        membreController.add()

        then:
        membreController.flash.message == membreController.SUIVRE_OK
    }




    void "test echec supprimer lien amitie d'un membre vers un autre"() {
        given:"une liste de parametre"
        def membreController = new MembreController();
        Membre m1 = Membre.findByMail("pat.perdu@wanadoo.net");
        Membre m2 = Membre.findByMail("dark@vador.fr");
        new SuivreMembre(membre: m1, membreSuivi: m2).save();
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", m1);
        membreController.request.parameters = [id: m2.id + ""];

        when: "on supprime le lien d'amitié"
        membreController.remove()

        then:
        membreController.flash.message == membreController.REMOVE_OK
    }

    void "test affichage profil"() {
        given:"une liste de parametre"
        def membreController = new MembreController();
        Membre m1 = Membre.findByMail("pat.perdu@wanadoo.net");
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", m1);
        membreController.request.parameters = [id: m1.id + ""];

        when: "on affiche le profil"
        membreController.profil()

        then:
        membreController.modelAndView.viewName == "/membre/profil"
    }


}
