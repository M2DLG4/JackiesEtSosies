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

    Membre searchMembre(long id) {
        return Membre.findById(id)
    }

    ArrayList<Membre> searchMembreByTexte(String texte) {
        def criteria = Membre.createCriteria()
        def results = criteria.list {
            or {
                eq("mail", texte, [ignoreCase: true])
                ilike("prenom", "%" + texte + "%")
                ilike("nom", "%" + texte + "%")
            }
            maxResults(20)
            order("id", "desc")
        }
        return results;
    }

    Boolean supprimerMembre(Membre membre) {
        return membre.delete();
    }
}
