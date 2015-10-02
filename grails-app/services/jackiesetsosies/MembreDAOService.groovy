package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class MembreDAOService {

    @Override
    def serviceMethod() {

    }

    Membre addMembre(Membre membre) {
        return membre.save()
    }

    Membre searchMembre(String mail) {
        return Membre.findByMail(mail)
    }
}
