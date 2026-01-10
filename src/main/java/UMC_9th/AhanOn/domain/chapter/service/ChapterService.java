package UMC_9th.AhanOn.domain.chapter.service;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.chapter.code.ChapterErrorCode;
import UMC_9th.AhanOn.domain.chapter.dto.ChapterReqDTO;
import UMC_9th.AhanOn.domain.chapter.dto.ChatRequest;
import UMC_9th.AhanOn.domain.chapter.dto.ChatResponse;
import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import UMC_9th.AhanOn.domain.chapter.exception.ChapterException;
import UMC_9th.AhanOn.domain.chapter.repository.ChapterRepository;
import UMC_9th.AhanOn.domain.dailyComment.entity.DailyComment;
import UMC_9th.AhanOn.domain.dailyComment.repository.DailyCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final DailyCommentRepository dailyCommentRepository;

    private final WebClient webClient = WebClient.builder().build();

    @Value("${gemini.key}")
    private String apiKey;

    @Value("${openai.api.key}")
    private String openApiKey;

    /*public Long createChapter() {

        ChatRequest request = new ChatRequest(
                "gpt-4.1-mini",
                List.of(new ChatRequest.Message("user", "지금 사용자는 하루 불안하고 복잡한 현 상황과 미래를 일기로 기록하는 중. 다음 주는 읽기를 보고 분석한 다음, 사용자에게 위로 되는 문장을 던질 것 -> " + )),
                0.2
        );

        ChatResponse response = webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + openApiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .block();



        log.info("CHATGPT response! -> {}", response.getChoices().get(0).getMessage().getContent());

        return 1L;
    }*/

    public Long createChapter(ChapterReqDTO.CreateChapterDTO dto) {

        // AI 연결이 필요
        ChatRequest request = new ChatRequest(
                "gpt-4.1-mini",
                List.of(new ChatRequest.Message("user", "지금 사용자는 하루 불안하고 복잡한 현 상황과 미래를 일기로 기록하는 중. 다음 주는 읽기를 보고 분석한 다음, 사용자에게 위로 되는 문장을 던질 것 -> " + dto.getContent())),
                0.2
        );

        ChatResponse response = webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + openApiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .block();

        log.info("CHATGPT response! -> {}", response.getChoices().get(0).getMessage().getContent());
        String comment = response.getChoices().get(0).getMessage().getContent();
        if (comment == null) {
            throw new ChapterException(ChapterErrorCode.GEMINI_ERROR);
        }

        log.info("ChatGPT response! -> {}", response);

        Chapter chapter = Chapter.builder()
                .book(new Book())
                .title(dto.getTitle())
                .content(dto.getContent())
                .comments(null)
                .build();

        Chapter savedChapter = chapterRepository.save(chapter);

        DailyComment savedComment = dailyCommentRepository.save(DailyComment.builder()
                .chapter(savedChapter)
                .comment(comment)
                .build());

        chapter.addComment(savedComment);
        return savedChapter.getId();
    }

    public Boolean deleteChapter(Long chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId).orElseThrow(() -> new ChapterException(ChapterErrorCode.WRONG_CHAPTER));
        chapterRepository.delete(chapter);
        return true;
    }

    public Boolean updateChapter(ChapterReqDTO.UpdateChapterDTO dto) {
        Chapter chapter = chapterRepository.findById(dto.getChapterId()).orElseThrow(() -> new ChapterException(ChapterErrorCode.WRONG_CHAPTER));
        chapter.updateContent(dto.getContent());
        return true;
    }
}
