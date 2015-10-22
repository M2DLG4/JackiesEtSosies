package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class PostDAOService {

    Post addPost(Post post) {
        return post.save(flush: true)
    }

    List<Post> searchPosts(Membre membre) {
        return Post.findAllByMembre(membre, ["sort": "date", "order": "desc"]);
    }

    Boolean supprimer(Membre user, Long idMessage) {
        Post post = Post.findById(idMessage)

        if (post?.getMembre()?.getId() == user.getId()) {
            return !post.delete();
        } else {
            return false;
        }
    }

    List<Post> searchFollowedPosts(Membre membre) {
        List<Membre> followedMembres = SuivreMembre.findAllByMembre(membre).membreSuivi.toList()
        followedMembres.add(membre)
        return Post.findAllByMembreInList(followedMembres, ["sort": "date", "order": "desc"]);
    }
}
