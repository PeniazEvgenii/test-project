package by.it_academy.service.service.mapper;

import by.it_academy.data.repository.entity.Position;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IPositionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dtUpdate", ignore = true)
    @Mapping(target = "dtCreate", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    Position toEntity(String name);

}
