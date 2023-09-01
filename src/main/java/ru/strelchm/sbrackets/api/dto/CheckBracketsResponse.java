package ru.strelchm.sbrackets.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckBracketsResponse {
    @NotNull
    private Boolean isCorrect;
}
