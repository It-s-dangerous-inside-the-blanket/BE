package UMC_9th.AhanOn.domain.chapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ChapterReqDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateChapterDTO{
        private Long bookId;
        private String title;
        private String content;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateChapterDTO{
        private Long chapterId;
        private String content;
    }
}
