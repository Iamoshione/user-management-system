package banking.clients.service.service;


import banking.clients.service.model.User;
import banking.clients.service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
           return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user , Integer id){
        User userObject = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));


        userObject.setFullName(user.getFullName());
        userObject.setAddress(user.getAddress());
        userObject.setPhone(user.getPhone());
        userObject.setEmail(user.getEmail());

        userRepository.save(userObject);
    }



}
