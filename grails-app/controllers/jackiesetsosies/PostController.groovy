package jackiesetsosies

/**
 * Created by lgaleron on 10/10/2015.
 */
class PostController {

    def membreService
    def user
    def posts

    def post() {
        render view: "post"
    }

    def sharedPost() {
        def message = params.message
        def datePost = new Date()
        Membre user = session.getAttribute("user")

        def newPost = new Post(date: datePost, message: message)
        posts = user?.getPosts()

        if (newPost.hasErrors()) {
            def hasError = "Votre post n'a pas pu être publié"
            render(view: "news", controller: "wall", model: [error: hasError, posts: posts])
        } else {
            membreService.addPostToMembre(user, newPost)
            params.message = ""
            redirect(action: "news", controller:"wall")
        }
    }
}
