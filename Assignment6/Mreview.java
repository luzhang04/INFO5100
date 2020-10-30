package Assignment6;

import java.util.ArrayList;

public class Mreview implements Comparable<Mreview> {
    private String title;
    private ArrayList<Integer> ratings;

    public Mreview() {
        title = "";
        ratings = new ArrayList<>();
    }
    //Sets title to "" and creates an empty ArrayList to ratings.
    public Mreview(String ttl) {
        title = ttl;
        ratings = new ArrayList<>();
    }
   // Sets title to the parameter string and creates an empty ArrayList to ratings.
   public Mreview(String ttl, int firstRating) {
        title = ttl;
        ratings = new ArrayList<>(1);
        ratings.add(firstRating);
   }
   // Sets title to the parameter string and
    // creates a ratings list whose size() is one,
    // having the parameter int as the (only/first) element.
    public String getTitle() {
        return title;
    }
    public void addRating(int r) {
        ratings.add(r);
    }
    public double avaRating() {
        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }
        return (double) sum / ratings.size();
    }
    public int numRatings() {
        return ratings.size();
    }

    @Override
    public int compareTo(Mreview o) {
        return title.compareTo(o.title);
    }
    @Override
    public boolean equals(Object o) {
        return getTitle().equals(((Mreview) o).getTitle());
    }
    public String toString() {
        return getTitle() + ", average " + avaRating() + " out of " + numRatings() + " ratings";

    }
}
