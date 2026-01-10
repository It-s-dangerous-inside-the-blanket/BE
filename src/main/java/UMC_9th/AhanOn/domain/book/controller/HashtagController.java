package UMC_9th.AhanOn.domain.book.controller;

import UMC_9th.AhanOn.domain.book.entity.dto.HashtagDto;
import UMC_9th.AhanOn.domain.book.service.HashtagService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hashtags")
public class HashtagController {

    private final HashtagService hashtagService;

    @PostMapping("/create")
    public ApiResponse<HashtagService> createHashtag(@RequestBody HashtagDto.CreateRequest request) {
        hashtagService.createHashtag(request);
    }
}
