package UMC_9th.AhanOn.domain.chapter.controller;

import UMC_9th.AhanOn.domain.chapter.code.ChapterSuccessCode;
import UMC_9th.AhanOn.domain.chapter.dto.ChapterReqDTO;
import UMC_9th.AhanOn.domain.chapter.service.ChapterService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chapters")
@Slf4j
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;

    @PostMapping
    public ApiResponse<Long> createChapter (@RequestBody ChapterReqDTO.CreateChapterDTO dto){
        return ApiResponse.onSuccess(ChapterSuccessCode.CREATE_CHAPTER_SUCCESS, chapterService.createChapter(dto));
    }


    ///  이 밑에 다 안씀!
//    @DeleteMapping("/{chapter_id}")
    public ApiResponse<Boolean> deleteChapter(@PathVariable("chapter_id") Long chapterId){
        // hardDelete
        return ApiResponse.onSuccess(ChapterSuccessCode.DELETE_CHAPTER_SUCCESS, chapterService.deleteChapter(chapterId));
    }

//    @PatchMapping
    public ApiResponse<Boolean> updateChapter(@RequestBody ChapterReqDTO.UpdateChapterDTO dto){
        return ApiResponse.onSuccess(ChapterSuccessCode.DELETE_CHAPTER_SUCCESS, chapterService.updateChapter(dto));
    }
}