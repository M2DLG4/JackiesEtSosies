package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class MembreDAOService {

    Membre saveMembre(Membre membre) {
        return membre.save()
    }

    Membre searchMembre(String mail) {
        return Membre.findByMail(mail)
    }

    Membre getMembre (int id) {
        return Membre.get(id);
    }

    Boolean supprimerMembre(Membre membre) {
        return membre.delete();
    }

    Membre searchMembre(int id) {
        return Membre.findById(id)
    }

    Membre searchMembre(long id) {
        return Membre.findById(id)
    }
}
