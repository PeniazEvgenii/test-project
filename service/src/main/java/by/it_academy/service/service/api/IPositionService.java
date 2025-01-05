package by.it_academy.service.service.api;

import by.it_academy.data.repository.entity.Position;

import java.util.Optional;

public interface IPositionService {

    Position create(String name);

    Optional<Position> findByName(String name);

    Position findOrCreate(String positionName);
}
