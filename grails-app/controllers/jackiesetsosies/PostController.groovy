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
        def hasError = ""
        //def user = session.getId();

        def newPost = new Post(date: datePost, message: message)
        // A enlever et faire avec session
        user = Membre.findByMail("lodo@gmail.com")
        if (user == null)
            user = new Membre(nom: "lodo", prenom: "bene", ville: "toulouse", sexe: "F", isSosie: false, mail: "lodo@gmail.com", mdp: "lodo")

        if (membreService.addPostToMembre(user, newPost)?.hasErrors()) {
            hasError = "Votre post n'a pas pu être publié";
        }
        println hasError
        if (hasError)
            render(view: "news", controller:"wall", model: [error: hasError, posts: posts])
        else {
            params.message = "";
            posts = user.getPosts()
            redirect(action: "news", controller:"wall")
        }
    }
}
