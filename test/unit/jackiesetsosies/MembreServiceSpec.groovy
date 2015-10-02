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
}
