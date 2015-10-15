package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(RechercheService)
class RechercheServiceSpec extends Specification {

    def setup() {
        service.membreDAOService = Mock(MembreDAOService)
    }

    void "test recherche de membre(s)"() {
        given: "Une recherche sur le site"
        def membreList = new ArrayList<Membre>();
        membreList.add(Mock(Membre));
        service.membreDAOService.searchMembreByTexte(_) >> membreList;

        when: "on effectue la requete de connexion avec les bonnes informations"
        List<Membre> res = service.getMembres("Jeannes !");

        then: "La connexion est validée"
        membreList.equals(res)
    }
}
