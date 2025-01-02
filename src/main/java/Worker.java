public record Worker(String name) {


    public void fixAttraction(Attraction attraction) {

        if (attraction.getIsWork().equals(false)) {

            attraction.setIsWork(true);
        }
    }
}
