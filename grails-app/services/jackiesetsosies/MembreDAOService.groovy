package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class MembreDAOService {

    Membre addMembre(Membre membre) {
        return membre.save()
    }

    Membre addPost(Membre membreSession, Membre membre, Post post) {
        post.save(flush: true)
        membreSession.addToPosts(post)
        membre = membre.merge(membreSession)
        return membre.save(flush: true)
    }

    Membre update(Membre membre) {
        return membre.save()
    }

    Membre searchMembre(String mail) {
        return Membre.findByMail(mail)
    }
}
