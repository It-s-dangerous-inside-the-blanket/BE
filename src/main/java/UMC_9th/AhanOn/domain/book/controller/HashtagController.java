package UMC_9th.AhanOn.domain.book.controller;

import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.domain.book.entity.dto.HashtagDto;
import UMC_9th.AhanOn.domain.book.service.HashtagService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hashtags")
public class HashtagController {

    private final HashtagService hashtagService;

    @Operation(
            summary = "해시태그 생성",
            description = "책에 새로운 해시태그를 생성합니다."
    )
    @PostMapping("/create")
    public ApiResponse<Hashtag> createHashtag(@RequestBody HashtagDto.Request request) {
        Hashtag hashtag = hashtagService.createHashtag(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, hashtag);
    }

    @Operation(
            summary = "해시태그 삭제",
            description = "요청 정보에 해당하는 해시태그를 삭제합니다."
    )
    @DeleteMapping("delete")
    public ApiResponse<Void> deleteHashtag(@RequestBody HashtagDto.Request request) {
        hashtagService.deleteHashtag(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }
}
