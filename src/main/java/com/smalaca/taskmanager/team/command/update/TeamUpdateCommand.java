package com.smalaca.taskmanager.team.command.update;

import com.smalaca.taskamanager.dto.TeamDto;
import com.smalaca.taskamanager.model.embedded.Codename;
import com.smalaca.taskamanager.model.entities.Team;
import com.smalaca.taskamanager.repository.TeamRepository;

import java.util.Optional;

public class TeamUpdateCommand {
    private final TeamRepository teamRepository;

    public TeamUpdateCommand(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
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
