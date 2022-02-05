package com.smalaca.taskmanager.user.command;

import com.smalaca.taskamanager.dto.UserDto;
import com.smalaca.taskamanager.model.embedded.UserName;
import com.smalaca.taskamanager.model.entities.User;
import com.smalaca.taskamanager.model.enums.TeamRole;
import com.smalaca.taskamanager.repository.UserRepository;

import java.util.Optional;

public class UserCommands {
    private final UserRepository userRepository;

    public UserCommands(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Long> create(UserDto userDto) {
        Optional<User> found = userRepository.findByUserNameFirstNameAndUserNameLastName(userDto.getFirstName(), userDto.getLastName());

        if (found.isEmpty()) {
            User user = new User();
            user.setTeamRole(TeamRole.valueOf(userDto.getTeamRole()));
            UserName userName = new UserName(userDto.getFirstName(), userDto.getLastName());
            user.setUserName(userName);
            user.setLogin(userDto.getLogin());
            user.setPassword(userDto.getPassword());

            User saved = userRepository.save(user);
            return Optional.of(saved.getId());
        } else {
            return Optional.empty();
        }
    }
}
