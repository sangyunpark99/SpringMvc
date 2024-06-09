package hello.springmvc.requestmapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingClassController {

    @GetMapping("/mapping/users")
    public String user(){
        return "users";
    }

    @PostMapping("/mapping/users")
    public String addUser(){
        return "post user";
    }

    @GetMapping("/mapping/users/{userId}")
    public String findUser(@PathVariable String userId){
        return "get " + userId;
    }

    @PatchMapping("/mapping/users/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update " + userId;
    }

    @DeleteMapping("/mapping/users/{userId")
    public String deleteUser(@PathVariable String userId) {
        return "delete " + userId;
    }

}

