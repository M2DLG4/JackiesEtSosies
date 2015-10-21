package jackiesetsosies

/**
 * Created by lgaleron on 10/10/2015.
 */
class PostController {

    def membreService

    def post() {
        render view: "post"
    }

    def sharedPost() {
        def message = params.message
        def datePost = new Date()
        Membre user = session.getAttribute("user")

        def newPost = new Post(date: datePost, message: message, membre: user)

        user = membreService.addPostToMembre(user, newPost)

        session.setAttribute("user", user)

        params.message = ""
        redirect(action: "news", controller:"wall")
    }
}
