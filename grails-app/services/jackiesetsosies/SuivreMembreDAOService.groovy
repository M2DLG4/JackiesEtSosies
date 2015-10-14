package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class SuivreMembreDAOService {

    SuivreMembre saveSuivreMembre(SuivreMembre sm) {
        return sm.save()
    }
}
