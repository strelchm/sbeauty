package ru.strelchm.sbrackets.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.strelchm.sbrackets.api.dto.CheckBracketsRequest;
import ru.strelchm.sbrackets.api.dto.CheckBracketsResponse;
import ru.strelchm.sbrackets.mapper.TextOperationsMapper;
import ru.strelchm.sbrackets.service.BracketsVerificationService;

import static ru.strelchm.sbrackets.api.TextOperationsController.ROOT_MAPPING_PATH;

@RestController
@Tag(name = "Text operations")
@RequestMapping(ROOT_MAPPING_PATH)
@Validated
@RequiredArgsConstructor
public class TextOperationsController {
    public static final String ROOT_MAPPING_PATH = "/api";
    public static final String CHECK_BRACKETS_MAPPING_PATH = "/checkBrackets";

    private final BracketsVerificationService bracketsVerificationService;
    private final TextOperationsMapper textOperationsMapper;

    @PostMapping(CHECK_BRACKETS_MAPPING_PATH)
    @Operation(summary = "Check text for brackets correctness")
    public CheckBracketsResponse checkBrackets(@NotNull @Validated @RequestBody CheckBracketsRequest textRequestDto) {
        boolean verifyResult = bracketsVerificationService.verify(textRequestDto.getText());
        return textOperationsMapper.toCheckBracketsResponse(verifyResult);
    }
}
