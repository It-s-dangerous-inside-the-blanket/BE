package UMC_9th.AhanOn.domain.book.entity.dto;

import lombok.*;

import java.util.List;

public class HashtagDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Long bookId;
        private String hashtag;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class HashtagResponse {
        private Long id;
        private Long bookId;
        private String bookTitle;
        private String hashtag;
    }

    @Getter
    @AllArgsConstructor
    public static class HashtagListResponse {
        private Long bookId;
        private List<HashtagResponse> hashtags;
    }
}
