package UMC_9th.AhanOn.domain.book.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class HashtagDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private Long bookId;
        private String hashtag;
    }

    @Getter
    @AllArgsConstructor
    public static class HashtagResponse {
        private Long id;
        private Long bookId;
        private String hashtag;
    }

    @Getter
    @AllArgsConstructor
    public static class HashtagListResponse {
        private Long bookId;
        private List<HashtagResponse> hashtags;
    }
}
