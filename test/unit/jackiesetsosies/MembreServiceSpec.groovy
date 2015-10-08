package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MembreService)
class MembreServiceSpec extends Specification {

    def setup() {
        service.membreDAOService = Mock(MembreDAOService)
    }

    @Override
    def cleanup() {
    }

    void "test une inscription valide"() {
        given: "Un membre désirant s'inscrire"
        Membre membre = Mock(Membre)
        service.membreDAOService.addMembre(_) >> membre

        when: "on inscrit le membre"
        Membre res = service.inscriptionMembre(membre);

        then: "L'inscription est validée"
        res == membre
    }

    void "test une connexion valide"() {
        given: "Un utilisateur désirant se connecter"
        Membre m = Mock(Membre)
        service.membreDAOService.searchMembre(_) >> m

        when: "on effectue la requete de connexion avec les bonnes informations"
        Membre res = service.getMembre(m.mail, m.mdp);

        then: "La connexion est validée"
        res == m
    }

    void "test une connexion invalide"() {
        given: "Un utilisateur désirant se connecter"
        Membre m = Mock(Membre)
        service.membreDAOService.searchMembre(_) >> m

        when: "on effectue la requete de connexion avec le mauvais mot de passe"
        Membre res = service.getMembre(m.mail, "test");

        then: "La connexion est impossible"
        res == null
    }

    void "test une connexion inexistante"() {
        given: "Un utilisateur désirant se connecter avec un mail inexistant"
        service.membreDAOService.searchMembre(_) >> null

        when: "on effectue la requete de connexion"
        Membre res = service.getMembre("test@test", "test");

        then: "La connexion est impossible"
        res == null
    }



    void "test la modification d'un utilisateur"() {
        given: "Un utilisateur désirant modifier son profil"
        Membre m = Mock(Membre);
        m.hasErrors() >> false
        service.membreDAOService.editerMembre(_) >> m
        def params = new HashMap(nom: nom, prenom: prenom, mail: mail, mdp: mdp, sexe: sexe,
                ville:ville, isSosie: isSosie, idStar: Mock(Star), urlPhoto: urlPhoto);

        when: "on effectue la requete de modification"
        Boolean res = service.editionMembre(m, params);

        then: "La modification a été réalisée"
        res == true


        where: "avec le jeu de donnees suivant"
        nom     | prenom      | mail                         | mdp            | sexe | ville      | isSosie | urlPhoto
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | true    | "machin.png"
    }
}
