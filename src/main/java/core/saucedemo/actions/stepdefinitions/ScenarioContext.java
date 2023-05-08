package core.saucedemo.actions.stepdefinitions;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(DataContext key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(DataContext key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(DataContext key){
        return scenarioContext.containsKey(key.toString());
    }

}
