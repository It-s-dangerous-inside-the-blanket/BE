package UMC_9th.AhanOn.domain.book.entity.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class BookDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        @NonNull
        private String title;
        @NonNull
        private boolean existComment;

        private List<String> hashtags; // ["#힐링", "감성"] 등
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class UpdateRequest {
        private String title;
        private Boolean isEnd;
        private Boolean existComment;

        // 해시태그를 통째로 교체하는 방식(원하면 add/remove 방식도 가능)
        private List<String> hashtags;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class Response {
        private String title;
        private String bookSummary;
        private boolean isEnd;
        private boolean existComment;
        private List<String> hashtags;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class detailResponse {
        private Long bookId;
        private String title;
        private List<String> tags;
        private LocalDateTime createdAt;
        private Long daysSinceCreated;
    }
}
