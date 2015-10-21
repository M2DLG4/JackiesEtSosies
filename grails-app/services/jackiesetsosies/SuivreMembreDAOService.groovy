package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class SuivreMembreDAOService {

    SuivreMembre saveSuivreMembre(SuivreMembre sm) {
        return sm.save()
    }

    Boolean supprimerSuivreMembre(SuivreMembre suivreMembre) {
        return suivreMembre.delete();
    }

    Boolean searchSuivreMembre(Membre membre, Membre membreSuivi) {
        return SuivreMembre.findByMembreAndMembreSuivi(membre, membreSuivi)
    }

    SuivreMembre getSuivreMembre(Membre membre, Membre membreSuivi) {
        return SuivreMembre.findByMembreAndMembreSuivi(membre, membreSuivi)
    }
}
