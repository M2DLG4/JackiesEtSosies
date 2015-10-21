package jackiesetsosies

class WallController {

    def posts

    def news() {
        getPosts()
        render(view: "news", model: [posts: posts])
    }

    def getPosts() {
        Membre user = session.getAttribute("user")
        posts = user?.getPosts()
    }

}
