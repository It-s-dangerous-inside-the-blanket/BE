package UMC_9th.AhanOn.domain.chapter.controller;

import UMC_9th.AhanOn.domain.chapter.code.ChapterSuccessCode;
import UMC_9th.AhanOn.domain.chapter.dto.ChapterReqDTO;
import UMC_9th.AhanOn.domain.chapter.dto.ChapterRespDTO;
import UMC_9th.AhanOn.domain.chapter.service.ChapterService;
import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapters")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "챕터 API", description = "책 내 챕터 API (챕터 생성)")
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping("/{book_id}/list")
    @Operation(summary = "챕터 리스트 조회", description = "bookID를 기반으로 책을 찾은 후, 생성일 created_at 과 실 내용 content를 리스트로 반환합니다.")
    public ApiResponse<List<ChapterRespDTO.GetChapterDTO>> getChapterList(@PathVariable("book_id") Long bookId){
        return ApiResponse.onSuccess(ChapterSuccessCode.GET_CHAPTER_SUCCESS, chapterService.getChaterList(bookId));
    }

     @GetMapping("/{chapter_id}")
     @Operation(summary = "챕터 단일 조회", description = " 생성일 created_at 과 실 내용 content, AI 한미디 comment를 반환합니다.")
     public ApiResponse<ChapterRespDTO.GetChapterInfoDTO> getChapter (@PathVariable ("chapter_id") Long chapterId){
        return ApiResponse.onSuccess(ChapterSuccessCode.GET_CHAPTER_SUCCESS, chapterService.getChapter(chapterId));
     }

    @PostMapping
    @Operation(summary = "챕터 생성", description = "bookID를 기반으로 책을 찾은 후, title과 content로 챕터를 만든 후 저장합니다. 동시에 ChatGPT 연결로 해당 챕터에 대한 일일 코멘트를 연결합니다.")
    public ApiResponse<ChapterRespDTO.CreateChapterDTO> createChapter (@RequestBody ChapterReqDTO.CreateChapterDTO dto){
        return ApiResponse.onSuccess(ChapterSuccessCode.CREATE_CHAPTER_SUCCESS, ChapterRespDTO.CreateChapterDTO.builder().id(chapterService.createChapter(dto)).build());
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