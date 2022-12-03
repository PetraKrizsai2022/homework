package tests.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pojo.UserDto;
import service.ApiService;
import validation.ValidateApiTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Test
public class ApiTest {
    private final ApiService apiService = new ApiService();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ValidateApiTest validation = new ValidateApiTest();
    Logger logger = LogManager.getLogger(ApiTest.class.getName());

    @Test
    public void emailListTest() throws IOException {
        HttpResponse response = apiService.getUsers();
        String responseBody = apiService.getResponseBody(response);

        UserDto[] userDto = objectMapper.readValue(responseBody, UserDto[].class);
        List<UserDto> userDtoList = Arrays.stream(userDto).collect(Collectors.toList());
        userDtoList.forEach(user -> logger.info(user.getName() + " : " + user.getEmail()));

        List<String> emailList = userDtoList.stream().map(UserDto::getEmail).collect(Collectors.toList());

        validation.validateEmailList(emailList);
    }
}
