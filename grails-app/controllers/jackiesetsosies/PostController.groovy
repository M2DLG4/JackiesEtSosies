package jackiesetsosies

/**
 * Created by lgaleron on 10/10/2015.
 */
class PostController {

    def postService

    public static
    final String AJOUTPOST_OK = "Message posté !"
    final String AJOUTPOST_NOK = "Une erreur est survenue lors de l'ajout du message !"
    final String SUPPRESSIONPOST_OK = "Message posté !"
    final String SUPPRESSIONPOST_NOK = "Une erreur est survenue lors de l'ajout du message !"

    def sharedPost() {
        def message = params.message

        Membre user = session.getAttribute("user")
        def post = postService.addPostToMembre(user, message)
        if (post) {
            flash.message = AJOUTPOST_OK
        } else {
            flash.error = AJOUTPOST_NOK
        }

        redirect(action: "news", controller:"post")
    }

    def supprimer() {
        Membre user = session.getAttribute("user")
        def res = postService.supprimer(user, params.getLong("idMessage"))
        if (res) {
            flash.message = SUPPRESSIONPOST_OK
        } else {
            flash.error = SUPPRESSIONPOST_NOK
        }
        redirect(action: "news", controller:"post")
    }

    def news() {
        Membre user = session.getAttribute("user");
        def posts = postService.getPosts(user);
        render(view: "news", model: [posts: posts])
    }
}
