package core.saucedemo.actions.stepdefinitions;

public class TestContext {
    public ScenarioContext scenarioContext;
    public TestContext(){
        scenarioContext = new ScenarioContext();
    }
    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }
}
