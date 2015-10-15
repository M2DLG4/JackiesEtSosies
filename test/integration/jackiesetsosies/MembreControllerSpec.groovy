package jackiesetsosies



import spock.lang.*

/**
 *
 */
class MembreControllerSpec extends Specification {

    def setup() {

    }
    void "test inscription d'un membre"() {
        given:"une liste de parametre"
        def membreController = new MembreController();
        membreController.request.parameters = [nom: "UnNom", prenom: "UnPrenom", ville: "UneVille",
                                               sexe: "F", isSosie: "false", mail: "uneadresse@email.fr", mdp: "1234"];

        when: "on inscrit le membre"
        membreController.inscription()

        then: "la méthode pour créer un membre est appelée"
        assert Membre.findByMail("uneadresse@email.fr")!= null
    }


}
