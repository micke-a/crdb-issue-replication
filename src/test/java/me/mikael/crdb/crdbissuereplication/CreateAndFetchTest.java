package me.mikael.crdb.crdbissuereplication;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

/**
 *
 */
public class CreateAndFetchTest {

    @Test
    public void createAndFetch(){
        var restTemplate = new RestTemplateBuilder().build();
        var createUrl = "http://localhost:8080/issue/create";
        var fetchUrl = "http://localhost:8080/issue/fetch/";
        for(int i=0; i< 10; i++){
            var createResponse = restTemplate.postForEntity(createUrl, null,  String.class);
            var createdId = createResponse.getBody();

            var fetchResponse = restTemplate.getForEntity(fetchUrl + createdId, String.class);

            if(fetchResponse.getBody().contains("Not Found")){
                System.out.printf("ERROR - Created entity with id %s , Not Found, message: %s %n", createdId, fetchResponse.getBody());
            }
            else{
                System.out.printf("SUCCESS - Entity with id %s found%n", createdId);
            }
        }
    }
}
