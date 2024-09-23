package ru.strelchm.sbrackets.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.strelchm.sbrackets.api.dto.CheckBracketsResponse;

@Mapper(componentModel = "spring")
public interface TextOperationsMapper {
    @Mapping(target = "isCorrect", source = "isCorrect")
    CheckBracketsResponse toCheckBracketsResponse(Boolean isCorrect);
}
