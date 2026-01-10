package UMC_9th.AhanOn.domain.book.controller;

import UMC_9th.AhanOn.domain.book.entity.Hashtag;
import UMC_9th.AhanOn.domain.book.entity.dto.HashtagDto;
import UMC_9th.AhanOn.domain.book.service.HashtagService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import UMC_9th.AhanOn.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hashtags")
public class HashtagController {

    private final HashtagService hashtagService;

    @PostMapping("/create")
    public ApiResponse<Hashtag> createHashtag(@RequestBody HashtagDto.Request request) {
        Hashtag hashtag = hashtagService.createHashtag(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, hashtag);
    }

    @DeleteMapping("delete")
    public ApiResponse<Void> deleteHashtag(@RequestBody HashtagDto.Request request) {
        hashtagService.deleteHashtag(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }
}
