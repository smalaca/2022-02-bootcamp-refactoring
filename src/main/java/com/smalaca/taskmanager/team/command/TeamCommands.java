package com.smalaca.taskmanager.team.command;

import com.smalaca.taskamanager.dto.TeamDto;
import com.smalaca.taskamanager.model.embedded.Codename;
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

    public Optional<TeamDto> update(Long id, TeamDto teamDto) {
        Optional<Team> found = teamRepository.findById(id);
        Optional<TeamDto> updated = Optional.empty();
        if (found.isPresent()) {
            Team team = found.get();

            if (teamDto.getName() != null) {
                team.setName(teamDto.getName());
            }

            if (teamDto.getCodenameShort() != null && teamDto.getCodenameFull() != null) {
                Codename codename = new Codename(teamDto.getCodenameShort(), teamDto.getCodenameFull());
                team.setCodename(codename);
            }

            if (teamDto.getDescription() != null) {
                team.setDescription(teamDto.getDescription());
            }

            updated = Optional.of(teamRepository.save(team).asDto());
        }
        return updated;
    }
}
