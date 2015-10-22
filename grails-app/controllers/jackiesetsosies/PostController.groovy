package jackiesetsosies

/**
 * Created by lgaleron on 10/10/2015.
 */
class PostController {

    def postService


    def sharedPost() {
        def message = params.message

        Membre user = session.getAttribute("user")
        user = postService.addPostToMembre(user, message)
        if (user) {
            flash.message = "OK"
        } else {
            flash.message = "NOK"
        }
        session.setAttribute("user", user)

        redirect(action: "news", controller:"wall")
    }
}
