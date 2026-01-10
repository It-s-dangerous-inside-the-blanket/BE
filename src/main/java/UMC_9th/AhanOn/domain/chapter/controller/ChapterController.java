package UMC_9th.AhanOn.domain.chapter.controller;

import UMC_9th.AhanOn.global.apiPayload.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chapters")
@Slf4j
public class ChapterController {

    @PostMapping("/create")
    public ApiResponse<Boolean> createChapter (){
        return null;
    }

    @DeleteMapping("/{chapter_id}")
    public ApiResponse<Boolean> deleteChapter(@PathVariable("chapter_id") Long chapterId){
        return null;
    }

    @PatchMapping("/{chapter_id}")
    public ApiResponse<Boolean> updateChapter(@PathVariable("chapter_id") Long chapterId){
        return null;
    }
}