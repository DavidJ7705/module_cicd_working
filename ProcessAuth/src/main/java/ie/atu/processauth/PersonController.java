package ie.atu.processauth;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final List<Person> personList = new ArrayList<>();

@GetMapping("/{userId}")
public Person getPerson(@PathVariable String userId) {
    System.out.println("Child Service Fetching Person with userId: " + userId);
    return personList.stream()
                .filter(person -> person.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }


    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) {
        personList.add(person);
        return "Person added successfully!";
    }}
