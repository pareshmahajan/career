package support;

import java.util.ArrayList;
import java.util.List;

public class ScenarioData {

    private List<String> positionList = new ArrayList<>();

    public void addPosition(String position) {
        positionList.add(position);
    }

    public List<String> getPositionList() {
        return positionList;
    }
}
