package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class MembreDAOService {

    Membre addMembre(Membre membre) {
        return membre.save()
    }

    Membre searchMembre(String mail) {
        return Membre.findByMail(mail)
    }

    Membre editerMembre(Membre membre) {
        return membre.save()
    }

    Membre searchMembre(int id) {
        return Membre.findById(id)
    }
}
