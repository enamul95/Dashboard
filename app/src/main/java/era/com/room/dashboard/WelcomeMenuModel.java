package era.com.room.dashboard;

public class WelcomeMenuModel {
    private String menuName;
    private int imageId;
    private String softcode;

    public WelcomeMenuModel(String menuName, int imageId,String softcode){
        this.menuName = menuName;
        this.imageId = imageId;
        this.softcode = softcode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getSoftcode() {
        return softcode;
    }

    public void setSoftcode(String softcode) {
        this.softcode = softcode;
    }
}