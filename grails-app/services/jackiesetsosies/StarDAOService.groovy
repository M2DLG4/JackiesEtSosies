package jackiesetsosies

class StarDAOService {

    ArrayList<Star> retrieveStars() {
        def criteria = Star.createCriteria()
        def results = criteria.list {
            order("nom", "asc")
        }
        return results;
    }

    Star searchStar(int id) {
        return Star.findById(id)
    }

    Star searchStar(long id) {
        return Star.findById(id)
    }
}
