/**
 *  This is the a review entity class. This class contains all the get and set method about receipt.
 *
 * @author    Zhijie Li
 * @version   20/10/2019
 */
public class Review {
    private int hallQuality;
    private int hallDecoration;
    private String qualityOfCatering;
    private int userId;
    private int hallId;

    public int getUserId() {
        return userId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHallId() {
        return hallId;
    }
    public int getHallQuality() {
        return hallQuality;
    }

    public void setHallQuality(int hallQuality) {
        this.hallQuality = hallQuality;
    }

    public int getHallDecoration() {
        return hallDecoration;
    }

    public void setHallDecoration(int hallDecoration) {
        this.hallDecoration = hallDecoration;
    }

    public java.lang.String getQualityOfCatering() {
        return qualityOfCatering;
    }

    public void setQualityOfCatering(java.lang.String qualityOfCatering) {
        this.qualityOfCatering = qualityOfCatering;
    }
}
