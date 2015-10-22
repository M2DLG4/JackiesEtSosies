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
        Post p = Mock(Post);
        m.hasErrors() >> false
        service.membreDAOService.searchMembre(_) >> m
        service.postDAOService.addPost(_) >> p
        m.getId() >> 1
        def text = "Lorem lipsum"

        when: "on enregistre le post"
        Post res = service.addPostToMembre(m, text);

        then: "Le post est ajouté"
        res == p
    }

    void "test récuperer les posts"() {
        given: "on récupère la liste des posts"
        Membre m = Mock(Membre);
        service.postDAOService.searchPosts(m) >> null

        when: "on enregistre le post"
        List<Post> res = service.getPosts(m)

        then: "Le post est ajouté"
        res == null
    }

    void "test supprimer un post"() {
        given: "Un utilisateur désirant supprimer un post"
        Membre m = Mock(Membre);
        service.postDAOService.supprimer(_, _) >> true

        when: "on enregistre le post"
        Boolean res = service.supprimer(m, 1);

        then: "Le post est ajouté"
        res == true
    }


}
