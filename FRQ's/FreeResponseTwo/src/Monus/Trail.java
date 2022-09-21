package Monus;

public class Trail {
    /**
     * Representation of the trail. The number of markers on the trail is markers.length.
     */
    private int[] markers = null;

    public Trail(int[] theArray) {
        markers = theArray;
    }

    /**
     * Determines if a trail segment is level. A trail segment is defined by a starting marker,
     * an ending marker, and all markers between those two markers.
     * A trail segment is level if it has a difference between the maximum elevation
     * and minimum elevation that is less than or equal to 10 meters.
     *
     * @param start the index of the starting marker
     * @param end   the index of the ending marker
     *              Precondition: 0 <= start < end <= markers.length - 1
     * @return true if the difference between the maximum and minimum
     * elevation on this segment of the trail is less than or equal to 10 meters;
     * false otherwise.
     */
    public boolean isLevelTrailSegment(int start, int end) {
        int maxElevation = Integer.MIN_VALUE;
        int minElevation = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (markers[i] > maxElevation) {
                maxElevation = markers[i];
            }
            else if (markers[i] > minElevation) {
                minElevation = markers[i];
            }
        }
        return maxElevation - minElevation <= 10;
    }

    /**
     * Determines if this trail is rated difficult. A trail is rated by counting the number of changes in
     * elevation that are at least 30 meters (up or down) between two consecutive markers. A trail
     * with 3 or more such changes is rated difficult.
     *
     * @return true if the trail is rated difficult; false otherwise.
     */
    public boolean isDifficult() {
        int largeElevationChanges = 0; //changes which are >= 30 m
        int previousElevation = markers[0];
        int currentElevation;
        for (int i = 1; i < markers.length; i++) {
            int elevationChange = 0;
            currentElevation = markers[i];
            elevationChange += Math.abs(currentElevation - previousElevation);
            previousElevation = markers[i];
            if (elevationChange >= 30) {
                largeElevationChanges++;
            }
        }
       return largeElevationChanges >= 3;
    }

    public static void main(String[] args) {
        int[] markers1 = {100, 150, 105, 120, 90, 80, 50, 75, 75, 70, 80, 90, 100};
        Trail trail = new Trail(markers1);
        boolean r1 = trail.isLevelTrailSegment(7, 10);
        System.out.println("the trail between marker 7 and 10 should be level (true) and you got " + r1);
        r1 = trail.isLevelTrailSegment(2, 12);
        System.out.println("the trail between marker 2 and 12 should not be level (false) and you got " + r1);
        r1 = trail.isDifficult();
        System.out.println("the trail should be difficult (true) and you got " + r1);
        int[] markers2 = {100, 150, 160, 140, 120};
        trail = new Trail(markers2);
        r1 = trail.isDifficult();
        System.out.println("the trail should be not be difficult (false) and you got " + r1);
    }

}
