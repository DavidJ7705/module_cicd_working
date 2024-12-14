package ie.atu.pro_test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="person-service", url = "http://localhost:8083/person")
public interface PersonClient {
    @GetMapping("/{userId}")
    default Person getPerson(@PathVariable String userId) {
        Person person = getPersonInternal(userId);
        System.out.println("Feign client fetching person with userId: " + person);
        return person;
    }


    @GetMapping("/{userId}")
    Person getPersonInternal(@PathVariable String userId);


    @PostMapping("/add")
    void addPerson(@RequestBody Person person);

}
