package core.saucedemo.actions.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import static core.saucedemo.actions.commons.GlobalConstants.PROJECT_PATH;

public class UserDataMapper {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    public static UserDataMapper getUserData(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(PROJECT_PATH + "/src/test/resources/account.json"), UserDataMapper.class);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
