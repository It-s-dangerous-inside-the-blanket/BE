package UMC_9th.AhanOn.domain.chapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ChapterRespDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChapterDTO {
        private String content;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetChapterDTO {
        private Long id;
        private LocalDateTime createdAt;
        private String content;
    }

}
