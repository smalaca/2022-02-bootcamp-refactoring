package com.smalaca.taskmanager.team.command;

import com.smalaca.taskamanager.dto.TeamDto;
import com.smalaca.taskamanager.model.entities.Team;
import com.smalaca.taskamanager.repository.TeamRepository;

import java.util.Optional;

public class TeamCommands {
    private final TeamRepository teamRepository;

    public TeamCommands(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Optional<Long> create(TeamDto teamDto) {
        Optional<Team> found = teamRepository.findByName(teamDto.getName());

        if (found.isEmpty()) {
            Team team = new Team();
            team.setName(teamDto.getName());
            Team saved = teamRepository.save(team);
            return Optional.of(saved.getId());
        } else {
            return Optional.empty();
        }
    }
}
