package jackiesetsosies

class PostService {

    def postDAOService
    def membreDAOService

    Post addPostToMembre(Membre membreSession, String message) {
        def datePost = new Date()
        Membre membre = membreDAOService.searchMembre(membreSession.getId())
        def newPost = new Post(date: datePost, message: message, membre: membre)

        return postDAOService.addPost(newPost);
    }


    List<Post> getPosts(Membre membre) {
        return postDAOService.searchPosts(membre);
    }

    Boolean supprimer(Membre user, Long idMessage) {
        return postDAOService.supprimer(user, idMessage);
    }
}
