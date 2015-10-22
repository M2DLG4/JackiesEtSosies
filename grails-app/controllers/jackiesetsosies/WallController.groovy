package jackiesetsosies

class WallController {

    def postService

    def news() {
        Membre user = session.getAttribute("user");
        def posts = postService.getPosts(user);
        render(view: "news", model: [posts: posts])
    }


}
