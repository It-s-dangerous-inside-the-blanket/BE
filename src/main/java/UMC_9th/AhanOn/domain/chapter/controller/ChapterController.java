package UMC_9th.AhanOn.domain.chapter.controller;

import UMC_9th.AhanOn.domain.chapter.code.ChapterSuccessCode;
import UMC_9th.AhanOn.domain.chapter.dto.ChapterReqDTO;
import UMC_9th.AhanOn.domain.chapter.service.ChapterService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chapters")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "챕터 API", description = "책 내 챕터 API (챕터 생성)")
public class ChapterController {

    private final ChapterService chapterService;

    @PostMapping
    @Operation(summary = "챕터 생성", description = "bookID를 기반으로 책을 찾은 후, title과 content로 챕터를 만든 후 저장합니다. 동시에 ChatGPT 연결로 해당 챕터에 대한 일일 코멘트를 연결합니다.")
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