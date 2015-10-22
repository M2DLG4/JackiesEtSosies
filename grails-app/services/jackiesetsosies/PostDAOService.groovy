package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class PostDAOService {

    Membre addPost(Membre membre, Post post) {
        post.save(flush: true)
        membre.addToPosts(post)
        return membre.save(flush: true)
    }

    List<Post> searchPosts(Membre membre) {
        return Post.findAllByMembre(membre, ["sort": "date", "order": "desc"]);
    }
}
