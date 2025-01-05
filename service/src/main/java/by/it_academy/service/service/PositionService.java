package by.it_academy.service.service;

import by.it_academy.data.repository.PositionRepository;
import by.it_academy.data.repository.entity.Position;
import by.it_academy.service.service.api.IPositionService;
import by.it_academy.service.service.mapper.IPositionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionService implements IPositionService {

    private final PositionRepository repository;
    private final IPositionMapper mapper;

    @Override
    public Position create(String name) {
        Position position = mapper.toEntity(name);
        return repository.saveAndFlush(position);
    }

    @Override
    public Optional<Position> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Position findOrCreate(String name) {
        return findByName(name)
                .orElseGet(() -> create(name));
    }
}
