import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Park {

    private String name;

    private String operatingMode;

    private List<Attraction> attractionList = new ArrayList<>();

    public Park(String name, String operatingMode) {

        this.name = name;
        this.operatingMode = operatingMode;
    }


    public void addAttraction(Attraction attraction) {

        if (attractionList.contains(attraction)) {

            throw new RuntimeException("You already have attraction");
        } else {

            attractionList.add(attraction);
        }
    }
}
