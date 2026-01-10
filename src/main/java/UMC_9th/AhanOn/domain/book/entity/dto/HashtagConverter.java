package UMC_9th.AhanOn.domain.book.entity.dto;

import UMC_9th.AhanOn.domain.book.entity.Hashtag;

public class HashtagConverter {

    public static HashtagDto.HashtagResponse toResponse(Hashtag hashtag) {
        return HashtagDto.HashtagResponse.builder()
                .hashtag(hashtag.getHashtag())
                .id(hashtag.getId())
                .bookId(hashtag.getId())
                .bookTitle(hashtag.getBook().getTitle())
                .build();
    }
}
