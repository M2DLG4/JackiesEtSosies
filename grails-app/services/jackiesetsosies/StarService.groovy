package jackiesetsosies

class StarService {

    def starDAOService

    Star getStar(int id) {
        Star s = starDAOService.searchStar(id)
        return s
    }

    List<Star> getStars() {
        return starDAOService.getStars();
    }
}
