package UMC_9th.AhanOn.domain.chapter.service;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.chapter.dto.ChapterReqDTO;
import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import UMC_9th.AhanOn.domain.chapter.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChapterService {

    private final ChapterRepository chapterRepository;

    public Long createChapter (ChapterReqDTO.CreateChapterDTO dto){
        Chapter chapter = Chapter.builder()
                .book(new Book())
                .title(dto.getTitle())
                .content(dto.getContent())
                .comments(null)
                .build();

        Chapter saved = chapterRepository.save(chapter);
        return saved.getId();
    }

    public Boolean deleteChapter(Long chapterId){
        return null;
    }

    public Boolean updateChapter(Long chapterId){
        return null;
    }
}
