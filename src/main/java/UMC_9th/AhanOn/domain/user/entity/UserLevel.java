package UMC_9th.AhanOn.domain.user.entity;

import lombok.Getter;

@Getter
public enum UserLevel {

    SMALL_SOBOK("작은 소복 작가", 0, 10),
    SOBOK_STORYTELLER("소복한 이야기꾼", 11, 30),
    BESTSELLER("베스트셀러 작가", 31, 100);

    private final String displayName;
    private final int minCount;
    private final int maxCount;

    UserLevel(String displayName, int minCount, int maxCount) {
        this.displayName = displayName;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }
}
