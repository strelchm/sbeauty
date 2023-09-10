package ru.strelchm.sbrackets.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.strelchm.sbrackets.api.dto.CheckBracketsResponse;
import ru.strelchm.sbrackets.api.dto.CheckBracketsTextRequest;
import ru.strelchm.sbrackets.stack.BracketPairStackException;
import ru.strelchm.sbrackets.mapper.TextOperationsMapper;
import ru.strelchm.sbrackets.service.BracketsVerificationService;

import static ru.strelchm.sbrackets.api.TextOperationsController.ROOT_MAPPING_PATH;

@RestController
@Tag(name = "Text operations")
@RequestMapping(ROOT_MAPPING_PATH)
@Validated
@Slf4j
@RequiredArgsConstructor
public class TextOperationsController {
    public static final String ROOT_MAPPING_PATH = "/api";
    public static final String CHECK_BRACKETS_MAPPING_PATH = "/checkBrackets";

    private final BracketsVerificationService bracketsVerificationService;
    private final TextOperationsMapper textOperationsMapper;

    @PostMapping(CHECK_BRACKETS_MAPPING_PATH)
    @Operation(summary = "Check text for brackets correctness")
    public CheckBracketsResponse checkBrackets(@NotNull @Validated @RequestBody CheckBracketsTextRequest textRequestDto) {
        boolean verifyResult = bracketsVerificationService.verify(textRequestDto.getText());
        return textOperationsMapper.toCheckBracketsResponse(verifyResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public CheckBracketsResponse handleBadRequestExceptions(MethodArgumentNotValidException ex) {
        return getCheckBracketsResponse(ex);
    }

    private CheckBracketsResponse getCheckBracketsResponse(Exception ex) {
        log.error(ex.getMessage(), ex);
        return textOperationsMapper.toCheckBracketsResponse(Boolean.FALSE);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CheckBracketsResponse handleBadRequestExceptions(Exception ex) throws Exception {
        log.error(ex.getMessage(), ex);
        throw ex;
    }
}
