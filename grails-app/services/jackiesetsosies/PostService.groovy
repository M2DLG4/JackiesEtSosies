package jackiesetsosies

class PostService {

    def postDAOService
    def membreDAOService

    Membre addPostToMembre(Membre membreSession, String message) {
        def datePost = new Date()
        Membre membre = membreDAOService.searchMembre(membreSession.id)
        def newPost = new Post(date: datePost, message: message, idMembre: membre.getId())

        return postDAOService.addPost(membre, newPost);
    }


    List<Post> getPosts(Membre membre) {
        return postDAOService.searchPosts(membre.getId());
    }
}
