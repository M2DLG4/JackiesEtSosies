package jackiesetsosies

import org.springframework.web.context.request.RequestContextHolder
import spock.lang.Specification

/**
 *
 */
class PostControllerSpec extends Specification {

    void "test ajout d'un post"() {
        given:"une liste de parametre"
        def postController = new PostController();
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", Membre.findByMail("pat.perdu@wanadoo.net"));
        postController.request.parameters = [message: "Un message"];

        when: "on sauvegarde le message"
        postController.sharedPost()

        then: "le post a été crée"
        assert Post.findByMembre(Membre.findByMail("pat.perdu@wanadoo.net"))!= null
    }


    void "test suppression d'un post"() {
        given:"une liste de parametre"
        def postController = new PostController();
        Membre membre = Membre.findByMail("pat.perdu@wanadoo.net");
        Post post = new Post(message: "Un message", membre: membre, date: new Date(), nbLikes: 0).save();
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", membre);
        def idMessage = post.getId();
        postController.request.parameters = [id: idMessage + ""];

        when: "on supprime le message"
        postController.supprimer()

        then: "le post a été supprimée"
        assert Post.findById(idMessage) == null
    }

    void "test suppression d'un post qui n'existe pas"() {
        given:"une liste de parametre"
        def postController = new PostController();
        Membre membre = Membre.findByMail("pat.perdu@wanadoo.net");
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", membre);
        postController.request.parameters = [id: 16666 + ""];

        when: "on supprime le message qui n'existe pas"
        postController.supprimer()

        then: "le post n'a pas été supprimée"
        postController.flash.error == postController.SUPPRESSIONPOST_NOK
    }


    void "test affichage mur"() {
        given:"pour un utilisateur connecté"
        def postController = new PostController();
        Membre membre = Membre.findByMail("pat.perdu@wanadoo.net");
        RequestContextHolder.currentRequestAttributes().session.setAttribute("user", membre);

        when: "on affiche le mur de news"
        postController.news()

        then: "la bonne vue est retournée"
        postController.modelAndView.viewName == "/post/news"
    }

}
