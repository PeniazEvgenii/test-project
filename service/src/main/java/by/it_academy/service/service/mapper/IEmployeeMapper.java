package by.it_academy.service.service.mapper;

import by.it_academy.data.repository.entity.Employee;
import by.it_academy.data.repository.entity.Position;
import by.it_academy.service.service.dto.EmployeeDto;
import by.it_academy.service.service.dto.EmployeeReadDto;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEmployeeMapper {

    @Mapping(target = "projectEmployees", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dtUpdate", ignore = true)
    @Mapping(target = "dtCreate", ignore = true)
    @Mapping(target = "position", source = "position")
    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    Employee toEnity(EmployeeDto employeeDto, Position position);


    EmployeeReadDto toDto(Employee employee);
}
