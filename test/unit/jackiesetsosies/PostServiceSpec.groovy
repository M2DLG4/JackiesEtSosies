package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PostService)
class PostServiceSpec extends Specification {

    def setup() {
        service.membreDAOService = Mock(MembreDAOService)
        service.postDAOService = Mock(PostDAOService)
    }

    @Override
    def cleanup() {
    }


    void "test ajouter un post"() {
        given: "Un utilisateur désirant ajouter un post"
        Membre m = Mock(Membre);
        m.hasErrors() >> false
        service.membreDAOService.searchMembre(_) >> m
        service.postDAOService.addPost(_, _) >> m
        m.getId() >> 1
        def text = "Lorem lipsum"

        when: "on enregistre le post"
        Membre res = service.addPostToMembre(m, text);

        then: "Le post est ajouté"
        res == m
    }
}
