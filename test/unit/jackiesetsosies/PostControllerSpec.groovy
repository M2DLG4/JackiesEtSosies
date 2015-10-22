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
        response.redirectedUrl == "/post/news"
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
        response.redirectedUrl == "/post/news"
    }

    void "test supprimer un post existant"() {
        given: "l'id du post"
        params.idMessage = 2

        and: "un membre connecté"
        Membre membre = Mock(Membre)
        session.getAttribute("user") >> membre
        controller.postService.supprimer(_, _) >> true

        when: "on supprime le post"
        controller.supprimer()

        then: "on est redirigé vers la vue"
        flash.message == controller.SUPPRESSIONPOST_OK
    }

    void "test redirection news"() {
        given: "un utilisateur connecté"
        controller.postService.getPosts() >> null
        Membre membre = Mock(Membre)
        session.getAttribute("user") >> membre

        when: "on execute news"
        controller.news()

        then: "la vue est news"
        view.equals("/post/news")
    }

    void "test supprimer un post pas existant"() {
        given: "l'id du post"
        params.idMessage = 233

        and: "un membre connecté"
        Membre membre = Mock(Membre)
        session.getAttribute("user") >> membre
        controller.postService.supprimer(_, _) >> false

        when: "on supprime le post"
        controller.supprimer()

        then: "on est redirigé vers la vue"
        flash.error == controller.SUPPRESSIONPOST_NOK
    }
}
