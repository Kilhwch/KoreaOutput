
package Items;

public class StatsHistory {

    private long memorized = 0;
    private long reviewed = 0;
    
    public StatsHistory() {
    }
    
    public long getMemorized() {
        return memorized;
    }

    public long getReviewed() {
        return reviewed;
    }

    public void setMemorized(long memorized) {
        this.memorized = memorized;
    }

    public void setReviewed(long reviewed) {
        this.reviewed = reviewed;
    }
}
