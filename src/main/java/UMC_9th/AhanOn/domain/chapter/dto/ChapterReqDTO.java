package UMC_9th.AhanOn.domain.chapter.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ChapterReqDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetChapterByDateReqDTO {
        private Long id;
        private LocalDate date;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateChapterDTO{

        @NonNull
        private Long bookId;

        @NonNull
        private String title;

        @NonNull
        private String content;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateChapterDTO{

        @NonNull
        private Long chapterId;

        @NonNull
        private String content;
    }
}
