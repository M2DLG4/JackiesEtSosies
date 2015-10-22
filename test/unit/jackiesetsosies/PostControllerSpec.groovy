package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestFor(PostController)
class PostControllerSpec extends Specification {

    void setup() {
        //controller.membreService = Mock(MembreService)
        controller.postService = Mock(PostService)
    }

    void "test sharedPost avec un post valide"() {
        given: "un message"
        params.message = "le message"


        and: "un membre connecté"
        controller.postService.addPostToMembre(_, _) >> Mock(Post)

        when: "on execute sharedPost"
        controller.sharedPost()

        then: "on est redirigé vers la vue"
        flash.message == controller.AJOUTPOST_OK
        response.redirectedUrl == "/wall/news"
    }

    void "test sharedPost avec un post pas valide"() {
        given: "un message vide"
        params.message = ""

        and: "un membre connecté"
        controller.postService.addPostToMembre(_, _) >> null

        when: "on execute sharedPost"
        controller.sharedPost()

        then: "on est redirigé vers la vue"
        flash.error == controller.AJOUTPOST_NOK
        response.redirectedUrl == "/wall/news"
    }

    void "test supprimer un post"() {
        given: "un message vide"
        params.idMessage >> 2

        and: "un membre connecté"
        Membre membre = Mock(Membre)
        session.getAttribute("user") >> membre
        controller.postService.supprimer(_, _) >> true

        when: "on execute sharedPost"
        controller.supprimer()

        then: "on est redirigé vers la vue"
        flash.message == controller.SUPPRESSIONPOST_OK
    }
}
